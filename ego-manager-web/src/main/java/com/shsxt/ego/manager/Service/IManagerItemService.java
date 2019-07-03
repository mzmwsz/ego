package com.shsxt.ego.manager.Service;

import com.shsxt.ego.common.model.EgoResult;
import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.rpc.pojo.TbItem;
import com.shsxt.ego.rpc.query.ItemQuery;

/**
 * Created by 10170 on 2019/7/2.
 */
public interface IManagerItemService {
    public PageResult<TbItem> itemList(ItemQuery itemQuery);

    //商品上架
    public EgoResult reshelf(Long[] ids);
    //商品下架
    public EgoResult instock(Long[] ids);

    //删除商品
    public EgoResult deleteItemBatch(Long[] ids);
}
