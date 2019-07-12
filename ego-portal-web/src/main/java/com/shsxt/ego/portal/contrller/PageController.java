package com.shsxt.ego.portal.contrller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 10170 on 2019/7/5.
 */
@Controller
public class PageController {
    @RequestMapping("/{page}")
    public String index(@PathVariable String page){
        System.out.println("转发页面-->"+page);
        return page;
    }
}
