package com.shsxt.ego.sso.service.impl;

import com.shsxt.ego.rpc.service.ISmsService;

import javax.annotation.Resource;

/**
 * Created by 10170 on 2019/7/11.
 */
public class SmsListener {
    @Resource
   private ISmsService smsServiceProxy;

    public void listen(String msg){//msg是从rabbitMq监听到的消息
        String mg[] =msg.split("&");
        String phone =mg[0];
        Integer type = Integer.parseInt(mg[1]);
        /**
         * 发送短信
         */
        smsServiceProxy.sendSmsToPhone(phone,type);
    }

}
