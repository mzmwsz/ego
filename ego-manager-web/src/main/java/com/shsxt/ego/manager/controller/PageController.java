package com.shsxt.ego.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 10170 on 2019/7/1.
 */
@Controller
public class PageController {

    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        System.out.println("转发页面--》"+page);
        return page;
    }
}
