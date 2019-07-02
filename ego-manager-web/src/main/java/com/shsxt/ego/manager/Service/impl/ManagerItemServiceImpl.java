package com.shsxt.ego.manager.Service.impl;

import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.manager.Service.IManagerItemService;
import com.shsxt.ego.rpc.pojo.TbItem;
import com.shsxt.ego.rpc.query.ItemQuery;
import com.shsxt.ego.rpc.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 10170 on 2019/7/2.
 */
@Service
public class ManagerItemServiceImpl implements IManagerItemService {
    @Autowired
    private IItemService itemServiceproxy;

    @Override
    public PageResult<TbItem> itemList(ItemQuery itemQuery) {
        return itemServiceproxy.queryItemsListByParams(itemQuery);
    }
}
