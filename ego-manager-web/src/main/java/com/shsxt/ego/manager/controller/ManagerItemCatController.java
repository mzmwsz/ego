package com.shsxt.ego.manager.controller;

import com.shsxt.ego.rpc.dto.TreeDto;
import com.shsxt.ego.rpc.service.IItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 10170 on 2019/7/2.
 */
@Controller
public class ManagerItemCatController {
    @Resource
    private IItemCatService iItemCatServiceProxy;

    @RequestMapping("item/cat/list")
    @ResponseBody
    public List<TreeDto> queryItemCatsByparentId(@RequestParam(defaultValue = "0") Long id){
        return iItemCatServiceProxy.queryItemCatsByParentId(id);
    }
}
