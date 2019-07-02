package com.shsxt.ego.rpc.service.impl;

import com.shsxt.ego.rpc.mapper.db.dao.TbUserMapper;
import com.shsxt.ego.rpc.pojo.TbUser;
import com.shsxt.ego.rpc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 10170 on 2019/7/1.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private TbUserMapper tbUserMapper;
    @Override
    public TbUser queryUserByUserId(Long userId) {

        return tbUserMapper.selectByPrimaryKey(userId);
    }
}
