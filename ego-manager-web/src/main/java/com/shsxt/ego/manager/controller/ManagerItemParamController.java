package com.shsxt.ego.manager.controller;

import com.shsxt.ego.common.model.EgoResult;
import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.manager.Service.IManagerItemParamService;
import com.shsxt.ego.rpc.pojo.TbItemParam;
import com.shsxt.ego.rpc.query.ItemParamQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by 10170 on 2019/7/4.
 */
@Controller
public class ManagerItemParamController {
   @Resource
   private IManagerItemParamService managerItemParamService;

    //商品规格列表分页查询
    @RequestMapping("item/param/list")
    @ResponseBody
    public PageResult<TbItemParam> itemParamList(ItemParamQuery itemParamQuery){
        return managerItemParamService.itemParamList(itemParamQuery);
    };


}
