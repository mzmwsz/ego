package com.shsxt.ego.manager.Service.impl;

import com.shsxt.ego.common.model.EgoResult;
import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.common.utlis.IDUtlis;
import com.shsxt.ego.manager.Service.IManagerItemService;
import com.shsxt.ego.rpc.pojo.TbItem;
import com.shsxt.ego.rpc.pojo.TbItemDesc;
import com.shsxt.ego.rpc.pojo.TbItemParam;
import com.shsxt.ego.rpc.query.ItemParamQuery;
import com.shsxt.ego.rpc.query.ItemQuery;
import com.shsxt.ego.rpc.service.IItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by 10170 on 2019/7/2.
 */
@Service
public class ManagerItemServiceImpl implements IManagerItemService {


   @Resource
   private IItemService itemServiceProxy;



    //商品的分页查询
    @Override
    public PageResult<TbItem> itemList(ItemQuery itemQuery) {
        return itemServiceProxy.queryItemsListByParams(itemQuery);
    }

    //商品上架
    @Override
    public EgoResult reshelf(Long[] ids) {
        return itemServiceProxy.updataupdateItemStatusBatch(ids, 1);
    }

    //商品下架
    @Override
    public EgoResult instock(Long[] ids) {
        return itemServiceProxy.updataupdateItemStatusBatch(ids, 2);
    }

    //删除商品
    @Override
    public EgoResult deleteItemBatch(Long[] ids) {
        return itemServiceProxy.deleteItemBatch(ids);
    }

    //商品添加
    @Override
    public EgoResult saveItem(TbItem tbItem, String desc) {
        //设置商品的id uuid
        Long itemId = IDUtlis.genItemId();
        Date date = new Date();
        tbItem.setId(itemId);
        tbItem.setCreated(date);
        tbItem.setUpdated(date);
        tbItem.setStatus((byte) 1);

        TbItemDesc itemDesc = new TbItemDesc();
        itemDesc.setItemId(itemId);
        itemDesc.setCreated(date);
        itemDesc.setUpdated(date);
        itemDesc.setItemDesc(desc);

        /**
         * 商品规格记录 待实现
         */
        return itemServiceProxy.saveItem(tbItem, itemDesc);
    }

    //更新商品
    @Override
    public EgoResult updatItem(TbItem tbItem, String desc) {
        Date date = new Date();
        tbItem.setUpdated(date);

        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setUpdated(date);
        tbItemDesc.setItemId(tbItem.getId());
        return itemServiceProxy.updateItem(tbItem, tbItemDesc);
    }
}
