package com.shsxt.ego.manager.Service.impl;

import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.manager.Service.IManagerContentService;
import com.shsxt.ego.rpc.pojo.TbContent;
import com.shsxt.ego.rpc.query.ContentQuery;
import com.shsxt.ego.rpc.service.IContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by 10170 on 2019/7/4.
 */
@Controller
public class ManagerContentServiceImpl implements IManagerContentService {
    @Resource
    private IContentService contentServiceProxy;
    @Override
    public PageResult<TbContent> queryContentsByParams(ContentQuery contentQuery) {
        return contentServiceProxy.queryContentByParams(contentQuery);
    }
}
