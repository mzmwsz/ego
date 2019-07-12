package com.shsxt.ego.rpc.service;

import com.shsxt.ego.common.model.EgoResult;
import com.shsxt.ego.rpc.pojo.TbUser;

/**
 * Created by 10170 on 2019/7/1.
 */
public interface IUserService {
    public TbUser queryUserByUserId(Long userId);

    EgoResult userCheck(String param,Integer type);

    EgoResult saveUser(TbUser user);

    public TbUser queryUserByUserName(String userName);
}
