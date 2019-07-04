package com.shsxt.ego.rpc.service.impl;

import com.shsxt.ego.rpc.mapper.db.dao.TbItemDescMapper;
import com.shsxt.ego.rpc.pojo.TbItemDesc;
import com.shsxt.ego.rpc.service.IItemDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 10170 on 2019/7/3.
 */
@Service
public class ItemDescServiceImpl implements IItemDescService {
    @Autowired
    private TbItemDescMapper tbItemDescMapper;
    //回显描述信息
    @Override
    public TbItemDesc queryItemDescByItemId(Long itemId) {
        return tbItemDescMapper.selectByPrimaryKey(itemId);
    }
}
