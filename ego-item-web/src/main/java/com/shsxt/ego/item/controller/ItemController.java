package com.shsxt.ego.item.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 10170 on 2019/7/12.
 */
@Controller
public class ItemController {
    @RequestMapping("item/{itemId}")
    public String itemDetail(@PathVariable Long itemId){
        System.out.println("商品Id-->"+itemId);
        return "item";
    }
}
