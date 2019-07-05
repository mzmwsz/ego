package com.shsxt.ego.manager.controller;

import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.manager.Service.IManagerContentService;
import com.shsxt.ego.manager.Service.impl.ManagerContentServiceImpl;
import com.shsxt.ego.rpc.pojo.TbContent;
import com.shsxt.ego.rpc.query.ContentQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 10170 on 2019/7/4.
 */
@Controller
public class ManagerContentController {
    @Autowired
    private IManagerContentService managerContentService;

    @RequestMapping("content/query/list")
    @ResponseBody
    public PageResult<TbContent> queryContentsByParams(ContentQuery contentQuery){
        return managerContentService.queryContentsByParams(contentQuery);
    }
}
