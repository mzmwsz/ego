package com.shsxt.ego.rpc.service;

import com.shsxt.ego.rpc.dto.TreeDto;

import java.util.List;

/**
 * Created by 10170 on 2019/7/2.
 */
public interface IItemCatService {
    public List<TreeDto> queryItemCatsByParentId(Long id);
}
