package com.shsxt.ego.manager.Service;

import com.shsxt.ego.common.model.EgoResult;
import com.shsxt.ego.rpc.dto.TreeDto;
import com.shsxt.ego.rpc.pojo.TbContentCategory;

import java.util.List;

/**
 * Created by 10170 on 2019/7/4.
 */
public interface IManagerContentCategoryService {
    public List<TreeDto> queryContentCategoryListByParentId(Long id);

    EgoResult save(TbContentCategory contentCategory);

    EgoResult update(TbContentCategory contentCategory);

    EgoResult delete(Long id);
}
