package com.shsxt.ego.manager.Service;

import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.rpc.pojo.TbItemParam;
import com.shsxt.ego.rpc.query.ItemParamQuery;

/**
 * Created by 10170 on 2019/7/4.
 */
public interface IManagerItemParamService {
    ////商品规格列表分页查询
    public PageResult<TbItemParam> itemParamList(ItemParamQuery itemParamQuery);

}
