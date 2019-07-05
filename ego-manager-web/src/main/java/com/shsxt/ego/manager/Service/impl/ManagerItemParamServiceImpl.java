package com.shsxt.ego.manager.Service.impl;

import com.shsxt.ego.common.model.EgoResult;
import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.manager.Service.IManagerItemParamService;
import com.shsxt.ego.rpc.pojo.TbItem;
import com.shsxt.ego.rpc.pojo.TbItemParam;
import com.shsxt.ego.rpc.query.ItemParamQuery;
import com.shsxt.ego.rpc.service.IItemParamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

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

    //根据itemCatId查询规格模板值
    @Override
    public EgoResult queryItemParamByItemCatId( Long itemCatId){
        TbItemParam tbItemParam = itemParamServiceProxy.queryItemParamByItemCatId(itemCatId);
        EgoResult result = new EgoResult();
        if(null!=tbItemParam){
            result.setData(tbItemParam);
            result.setMsg("该模板已存在");
        }
        return result;
    }

    //添加具体的商品规格模板
    @Override
    public EgoResult saveItemParam(Long itemCatId, String paramData) {
        TbItemParam itemParam = new TbItemParam();
        itemParam.setItemCatId(itemCatId);
        itemParam.setParamData(paramData);
        itemParam.setCreated(new Date());
        itemParam.setUpdated(new Date());
        return itemParamServiceProxy.saveItemParam(itemParam);
    }

    @Override
    public EgoResult deleteItemParamBatch(Long[] ids) {
        return itemParamServiceProxy.deleteItemParamBatch(ids);
    }

    ;


}
