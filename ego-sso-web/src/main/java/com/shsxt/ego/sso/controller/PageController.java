package com.shsxt.ego.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 10170 on 2019/7/8.
 */
@Controller
public class PageController {
    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        return page;
    }
}
