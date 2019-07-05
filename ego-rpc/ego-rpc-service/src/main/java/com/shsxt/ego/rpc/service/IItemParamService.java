package com.shsxt.ego.rpc.service;

import com.shsxt.ego.common.model.EgoResult;
import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.rpc.pojo.TbItemParam;
import com.shsxt.ego.rpc.query.ItemParamQuery;

/**规格参数
 * Created by 10170 on 2019/7/4.
 */
public interface IItemParamService {
    //商品规格列表分页查询
    public PageResult<TbItemParam> queryItemsParamListByparams(ItemParamQuery itemParamQuery);

    //根据itemCatId查询规格模板值
    TbItemParam queryItemParamByItemCatId(Long itemCatId);

    //添加具体的商品规格模板
    EgoResult saveItemParam(TbItemParam itemParam);

    //规格参数模板删除
    EgoResult deleteItemParamBatch(Long[] ids);
}
