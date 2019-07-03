package com.shsxt.ego.manager.Service.impl;

import com.shsxt.ego.common.model.EgoResult;
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
    @Resource
    private IItemService itemServiceproxy;

    @Override
    public PageResult<TbItem> itemList(ItemQuery itemQuery) {
        return itemServiceproxy.queryItemsListByParams(itemQuery);
    }

    //商品上架
    @Override
    public EgoResult reshelf(Long[] ids) {
        return itemServiceproxy.updataupdateItemStatusBatch(ids,1);
    }

    //商品下架
    @Override
    public EgoResult instock(Long[] ids) {
        return itemServiceproxy.updataupdateItemStatusBatch(ids,2);
    }

    //删除商品
    @Override
    public EgoResult deleteItemBatch(Long[] ids) {
        return itemServiceproxy.deleteItemBatch(ids);
    }
}
