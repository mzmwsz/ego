package com.shsxt.ego.rpc.service.impl;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.shsxt.ego.common.model.EgoResult;
import com.shsxt.ego.rpc.service.ISmsService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by 10170 on 2019/7/11.
 */
@Service
public class SmsServiceImpl implements ISmsService{
    @Resource
    RedisTemplate<String,Object> template;

    @Override
    public EgoResult sendSmsToPhone(String phone, Integer type) {
        /**
         * 参数校验
         *    手机号合法正则  11   13x  15X   16X 17X  18X  19X
         * type
         *       1000：注册
         *       2000:登录
         *       3000:找回密码
         *
         *
         */
        EgoResult result =new EgoResult();
        if(type.equals(100)){
            //注册成功通知信息，无需验证码（code）
            doSendSms(phone,"SMS_168725412",null);
        }else if(type.equals(200)){
            //登录信息 需要验证码（code 随机获得）
            String code = randomCode();//随机获得
            doSendSms(phone,"SMS_168725412",code);
            //将短信验证码存入redis缓存中并设置失效时间（单位是秒）
            String key = "sms::phone:;"+phone+"::type::sms::_168725412";
            template.opsForValue().set(key,code,300, TimeUnit.SECONDS);//5分钟失效时间
        }else if(type.equals(300)){
            //找回密码短信
            String code = randomCode();//随机获得
            doSendSms(phone,"SMS_168725412",code);
            //将短信验证码存入redis缓存中并设置失效时间（单位是秒）
            String key = "sms::phone:;"+phone+"::type::sms::_168725412";
            template.opsForValue().set(key,code,300, TimeUnit.SECONDS);//5分钟失效时间

        }else{
            System.out.println("短信类型非法！");
            result.setMsg("短信类型非法！");
            result.setStatus(500);
        }

        return result;
    }

    //生成随机的验证码
    private String randomCode() {
        int max=1000000;
        int min = 1;
        int ran = (int) (Math.random()*(max-min)+min);
        String code=String.valueOf(ran);
        return code;
    }


    //短信发送模板
    private void doSendSms(String phone, String templateCode, String code) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou",
                "LTAIftPLNzhgsHmx", "VgLO26MfrjUiEohAZVJ5YfLsjl8p3J");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "ego商城");
        request.putQueryParameter("TemplateCode", templateCode);
        if(!StringUtils.isEmpty(code)){
            request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");
        }
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

}
