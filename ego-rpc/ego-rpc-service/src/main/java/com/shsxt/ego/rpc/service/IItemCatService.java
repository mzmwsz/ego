package com.shsxt.ego.rpc.service;

import com.shsxt.ego.rpc.dto.TreeDto;
import com.shsxt.ego.rpc.pojo.TbItemCat;

import java.util.List;

/**
 * Created by 10170 on 2019/7/2.
 */
public interface IItemCatService {
    public List<TreeDto> queryItemCatsByParentId(Long id);

    //网页门户的三级目录展示-json格式
    public List<TbItemCat> queryAllItemCats();
}
