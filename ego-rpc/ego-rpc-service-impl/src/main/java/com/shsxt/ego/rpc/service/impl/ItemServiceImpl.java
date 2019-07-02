package com.shsxt.ego.rpc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.rpc.mapper.db.dao.TbItemMapper;
import com.shsxt.ego.rpc.pojo.TbItem;
import com.shsxt.ego.rpc.query.ItemQuery;
import com.shsxt.ego.rpc.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 10170 on 2019/7/2.
 */
@Service
public class ItemServiceImpl implements IItemService {

    @Autowired
    private TbItemMapper tbItemMapper;
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

}
