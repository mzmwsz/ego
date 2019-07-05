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

    //根据itemCatId查询规格模板值和商品添加规格参数模板是一个
    @RequestMapping("item/param/query/{itemCatId}")
    @ResponseBody
    public EgoResult queryItemParamByItemCatId(@PathVariable Long itemCatId){
        return managerItemParamService.queryItemParamByItemCatId(itemCatId);
    }
    @RequestMapping("item/param/query/itemcatid/{itemCatId}")
    @ResponseBody
    public EgoResult queryItemParamByItemCatId02(@PathVariable Long itemCatId){
        return managerItemParamService.queryItemParamByItemCatId(itemCatId);
    }

    //添加具体的商品规格模板
    @RequestMapping("item/param/save/{itemCatId}")
    @ResponseBody
    public EgoResult saveItemParam(@PathVariable Long itemCatId,String paramData){//paramData是前台穿的json字符串
        return managerItemParamService.saveItemParam(itemCatId,paramData);
    }

    //删除
    @RequestMapping("item/param/delete")
    @ResponseBody
    public EgoResult deleteItemParam(Long[] ids){
        return managerItemParamService.deleteItemParamBatch(ids);
    }
}
