package com.shsxt.ego.manager.controller;

import com.shsxt.ego.common.model.EgoResult;
import com.shsxt.ego.rpc.pojo.TbItemDesc;
import com.shsxt.ego.rpc.service.IItemDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by 10170 on 2019/7/3.
 */
@Controller
public class MangerItemDescController {
    @Resource
    private IItemDescService itemDescServiceProxy;

    //加载商品描述，回显商品的描述信息
    @RequestMapping("item/desc/{itemId}")
    @ResponseBody
    public EgoResult queryItemDescByItemId(@PathVariable Long itemId){
        EgoResult result = new EgoResult();
        TbItemDesc itemDesc = itemDescServiceProxy.queryItemDescByItemId(itemId);
        if(null!=itemDesc){
            result.setData(itemDesc);
        }else{
            result.setStatus(500);
            result.setMsg("记录不存在");
        }
        return result;
    }
}
