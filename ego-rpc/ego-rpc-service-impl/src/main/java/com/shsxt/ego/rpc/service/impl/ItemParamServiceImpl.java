package com.shsxt.ego.rpc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.rpc.mapper.db.dao.TbItemParamMapper;
import com.shsxt.ego.rpc.pojo.TbItemParam;
import com.shsxt.ego.rpc.query.ItemParamQuery;
import com.shsxt.ego.rpc.service.IItemParamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 10170 on 2019/7/4.
 */
@Service
public class ItemParamServiceImpl implements IItemParamService{

    @Resource
    private TbItemParamMapper itemParamMapper;
    //商品规格列表分页查询
    @Override
    public PageResult<TbItemParam> queryItemsParamListByparams(ItemParamQuery itemParamQuery) {
        //启动分页
        PageHelper.startPage(itemParamQuery.getPage(),itemParamQuery.getRows());
        List<TbItemParam> itemParamList=itemParamMapper.queryItemsParamListByparams(itemParamQuery);
        PageInfo<TbItemParam> pageInfo = new PageInfo<>(itemParamList);
        PageResult<TbItemParam> pageResult=new PageResult<>();
        pageResult.setTotal(pageInfo.getTotal());
        pageResult.setRows(pageInfo.getList());
        return pageResult;
    }
}
