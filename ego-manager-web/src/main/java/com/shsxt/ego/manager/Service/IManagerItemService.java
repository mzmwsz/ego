package com.shsxt.ego.manager.Service;

import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.rpc.pojo.TbItem;
import com.shsxt.ego.rpc.query.ItemQuery;

/**
 * Created by 10170 on 2019/7/2.
 */
public interface IManagerItemService {
    public PageResult<TbItem> itemList(ItemQuery itemQuery);

}
