package com.shsxt.ego.rpc.service;

import com.shsxt.ego.common.model.EgoResult;
import com.shsxt.ego.common.model.PageResult;

import com.shsxt.ego.rpc.pojo.TbItem;
import com.shsxt.ego.rpc.pojo.TbItemDesc;
import com.shsxt.ego.rpc.pojo.TbItemParam;
import com.shsxt.ego.rpc.pojo.TbItemParamItem;
import com.shsxt.ego.rpc.query.ItemParamQuery;
import com.shsxt.ego.rpc.query.ItemQuery;

import javax.print.attribute.standard.PageRanges;

/**
 * Created by 10170 on 2019/7/1.
 */
public interface IItemService {


    //商品的分页查询
    public PageResult<TbItem> queryItemsListByParams(ItemQuery itemQuery);


    /**
     * 商品状态更新 上架  下架
     * @param ids   待更新商品id
     * @param type  更新类型
     * @return
     */
    public EgoResult updataupdateItemStatusBatch(Long[] ids,int type);

    //删除商品
    public EgoResult deleteItemBatch(Long[] ids);

    //商品的添加
      public EgoResult saveItem(TbItem tbItem, TbItemDesc tbItemDesc, TbItemParamItem itemParamItem);

    //更新商品
    public EgoResult updateItem(TbItem tbItem, TbItemDesc tbItemDesc);

}
