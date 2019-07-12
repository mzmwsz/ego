package com.shsxt.ego.rpc.service;

import com.shsxt.ego.common.model.EgoResult;

/**
 * Created by 10170 on 2019/7/11.
 */
public interface ISmsService {
    public EgoResult sendSmsToPhone(String phone,Integer type);
}
