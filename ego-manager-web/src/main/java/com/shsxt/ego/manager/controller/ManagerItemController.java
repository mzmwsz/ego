package com.shsxt.ego.manager.controller;

import com.shsxt.ego.common.model.EgoResult;
import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.manager.Service.IManagerItemService;
import com.shsxt.ego.manager.Service.impl.ManagerItemServiceImpl;
import com.shsxt.ego.rpc.pojo.TbItem;
import com.shsxt.ego.rpc.query.ItemQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 10170 on 2019/7/2.
 */
@Controller
public class ManagerItemController {
    @Autowired
    private IManagerItemService managerItemService;

    @RequestMapping("item/list")
    @ResponseBody
    public PageResult<TbItem> itmeList(ItemQuery itemQuery){

        return managerItemService.itemList(itemQuery);
    }

    //商品上架
    @RequestMapping("item/reshelf")
    @ResponseBody
    public EgoResult reshelf(Long[] ids){
        return managerItemService.reshelf(ids);
    }

    //商品下架
    @RequestMapping("item/instock")
    @ResponseBody
    public EgoResult instock(Long[] ids){
        return managerItemService.instock(ids);
    }

    //删除商品
    @RequestMapping("item/delete")
    @ResponseBody
    public EgoResult delete(Long[] ids){
       return managerItemService.deleteItemBatch(ids);
    }

}
