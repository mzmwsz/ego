package com.shsxt.ego.rpc.service;

import com.shsxt.ego.common.model.EgoResult;
import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.rpc.pojo.TbItem;
import com.shsxt.ego.rpc.query.ItemQuery;

import javax.print.attribute.standard.PageRanges;

/**
 * Created by 10170 on 2019/7/1.
 */
public interface IItemService {
    public PageResult<TbItem> queryItemsListByParams(ItemQuery itemQuery);


    /**
     * 商品状态更新
     * @param ids   待更新商品id
     * @param type  更新类型
     * @return
     */
    public EgoResult updataupdateItemStatusBatch(Long[] ids,int type);

    //删除商品
    public EgoResult deleteItemBatch(Long[] ids);

}
