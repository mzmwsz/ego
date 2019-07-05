package com.shsxt.ego.rpc.service;

import com.shsxt.ego.common.model.EgoResult;
import com.shsxt.ego.rpc.dto.TreeDto;
import com.shsxt.ego.rpc.pojo.TbContentCategory;

import java.util.List;

/**网站类容管理
 * Created by 10170 on 2019/7/4.
 */
public interface IContentCategoryService {
    //类容分类管理tree型数据查询展示
    public List<TreeDto> queryContentCategoryListByParentId(Long id);

    EgoResult save(TbContentCategory contentCategory);

    EgoResult update(TbContentCategory contentCategory);


    EgoResult delete(Long id);
}
