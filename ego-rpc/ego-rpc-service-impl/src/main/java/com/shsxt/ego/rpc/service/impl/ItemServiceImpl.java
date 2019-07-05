package com.shsxt.ego.rpc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.ego.common.model.EgoResult;
import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.rpc.mapper.db.dao.TbItemDescMapper;
import com.shsxt.ego.rpc.mapper.db.dao.TbItemMapper;
import com.shsxt.ego.rpc.mapper.db.dao.TbItemParamItemMapper;

import com.shsxt.ego.rpc.pojo.TbItem;
import com.shsxt.ego.rpc.pojo.TbItemDesc;
import com.shsxt.ego.rpc.pojo.TbItemParamItem;
import com.shsxt.ego.rpc.query.ItemQuery;
import com.shsxt.ego.rpc.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 10170 on 2019/7/2.
 */
@Service
public class ItemServiceImpl implements IItemService {

    @Autowired
    private TbItemMapper tbItemMapper;

    @Autowired
    private TbItemDescMapper itemDescMapper;

    @Autowired
    private TbItemParamItemMapper itemParamItemMapper;


    //商品的分页查询
    @Override
    public PageResult<TbItem> queryItemsListByParams(ItemQuery itemQuery) {
        //启动分页
        PageHelper.startPage(itemQuery.getPage(),itemQuery.getRows());
        List<TbItem> itemList=tbItemMapper.queryItemsByParams(itemQuery);
        PageInfo<TbItem> pageinfo = new PageInfo<>(itemList);
        PageResult<TbItem> pageResult=new PageResult<>();
        pageResult.setRows(pageinfo.getList());
        pageResult.setTotal(pageinfo.getTotal());
        return pageResult;
    }

    @Override
    public EgoResult updataupdateItemStatusBatch(Long[] ids, int type) {
        Map<String,Object> param=new HashMap<>();
        param.put("ids",ids);
        param.put("type",type);
        tbItemMapper.updateItemStatusBatch(param);
        return new EgoResult();
    }
    /**
     * 删除商品
     * 涉及表
     *   tb_item
     *   tb_item_desc
     *   tb_item_param_item
     */
    @Override
    public EgoResult deleteItemBatch(Long[] ids) {
        Map<String,Object> param = new HashMap<>();
        param.put("ids",ids);
        tbItemMapper.deleteItemBatch(param);//将status状态改成3
        //删除商品描述记录
        itemDescMapper.deleteItemDescBatch(param);
        //删除商品规格记录
        itemParamItemMapper.deleteItemParamItemBatch(param);
        return new EgoResult();
    }

    //商品添加
    @Override
    public EgoResult saveItem(TbItem tbItem, TbItemDesc tbItemDesc, TbItemParamItem itemParamItem){
        tbItemMapper.insertSelective(tbItem);
        itemDescMapper.insertSelective(tbItemDesc);
        itemParamItemMapper.insertSelective(itemParamItem);
        return new EgoResult();
    }

    //更新商品
    @Override
    public EgoResult updateItem(TbItem tbItem, TbItemDesc tbItemDesc) {
        tbItemMapper.updateByPrimaryKeySelective(tbItem);
        itemDescMapper.updateByPrimaryKeySelective(tbItemDesc);
        return new EgoResult();
    }


}
