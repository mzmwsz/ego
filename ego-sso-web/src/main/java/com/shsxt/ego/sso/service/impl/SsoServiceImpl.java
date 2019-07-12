package com.shsxt.ego.sso.service.impl;

import com.shsxt.ego.common.model.EgoResult;

import com.shsxt.ego.common.utils.JsonUtils;
import com.shsxt.ego.rpc.pojo.TbUser;
import com.shsxt.ego.rpc.service.IUserService;
import com.shsxt.ego.sso.service.ISsoService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

/**
 * Created by 10170 on 2019/7/8.
 */
@Service
public class SsoServiceImpl implements ISsoService{

    @Resource
    private IUserService userServiceProxy;
    @Resource
    private AmqpTemplate template;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public EgoResult userCheck(String param, Integer type) {
        return userServiceProxy.userCheck(param,type);
    }

    @Override
    public EgoResult saveUser(TbUser user) {
        user.setCreated(new Date());
        user.setUpdated(new Date());
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        userServiceProxy.saveUser(user);
        /**
         * 调用短信服务发送通知短信
         */
        /// sms.sendSmsToPhone("123123223",1);
        template.convertAndSend(user.getPhone()+"&"+200);
        return new EgoResult();

    }

    @Override
    public EgoResult loginCheck(String userName, String password, HttpServletRequest request, HttpServletResponse response) {
        EgoResult result = new EgoResult();
        TbUser user= userServiceProxy.queryUserByUserName(userName);
        if(null == user){
            result.setStatus(500);
            result.setMsg("该用户不存在");
            return result;
        }
        password=DigestUtils.md5DigestAsHex(password.getBytes());
        if(!password.equals(user.getPassword())){
            result.setStatus(500);
            result.setMsg("密码不正确");
            return result;
        }
        /**
         *  用户信息保存
         *    使用redis 存储
         *      key 方式
         *         userId  不安全
         *         随机唯一的字符串  uuid  token(令牌机制)  jwt(生成token 令牌)
         */
        String token = UUID.randomUUID().toString();//随机生成唯一的redis的key
        redisTemplate.opsForValue().set(token, JsonUtils.objectToJson(user));
        /**
         * 将token 响应给客户端
         */
        result.setMsg("用户登录成功！");
        result.setData(token);//将令牌给页面
        return result;
    }

    @Override
    public EgoResult userInfo(String token) {
        TbUser user=JsonUtils.jsonToPojo((String)redisTemplate.opsForValue().get(token),TbUser.class);
        EgoResult result =new EgoResult();
        result.setData(user);
        return result;
    }

    //退出删除redi缓存和cookie的缓存
    @Override
    public EgoResult userLogout(String token, HttpServletRequest request, HttpServletResponse response) {
        redisTemplate.delete(token);
        return new EgoResult();
    }

}
