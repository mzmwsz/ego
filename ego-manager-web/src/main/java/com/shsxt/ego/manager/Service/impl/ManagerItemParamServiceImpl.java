package com.shsxt.ego.manager.Service.impl;

import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.manager.Service.IManagerItemParamService;
import com.shsxt.ego.rpc.pojo.TbItemParam;
import com.shsxt.ego.rpc.query.ItemParamQuery;
import com.shsxt.ego.rpc.service.IItemParamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 10170 on 2019/7/4.
 */
@Service
public class ManagerItemParamServiceImpl implements IManagerItemParamService{


    @Resource
    private IItemParamService itemParamServiceProxy;

    //商品规格列表分页查询
    @Override
    public PageResult<TbItemParam> itemParamList(ItemParamQuery itemParamQuery) {
        return itemParamServiceProxy.queryItemsParamListByparams(itemParamQuery);
    }
}
