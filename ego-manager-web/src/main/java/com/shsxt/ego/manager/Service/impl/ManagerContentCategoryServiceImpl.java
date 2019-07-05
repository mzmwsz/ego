package com.shsxt.ego.manager.Service.impl;

import com.shsxt.ego.common.model.EgoResult;
import com.shsxt.ego.manager.Service.IManagerContentCategoryService;
import com.shsxt.ego.rpc.dto.TreeDto;
import com.shsxt.ego.rpc.pojo.TbContentCategory;
import com.shsxt.ego.rpc.service.IContentCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by 10170 on 2019/7/4.
 */
@Service
public class ManagerContentCategoryServiceImpl implements IManagerContentCategoryService{
    @Resource
    private IContentCategoryService contentCategoryServiceProxy;
    @Override
    public List<TreeDto> queryContentCategoryListByParentId(Long id) {
        return contentCategoryServiceProxy.queryContentCategoryListByParentId(id);
    }

    @Override
    public EgoResult save(TbContentCategory contentCategory) {
        contentCategory.setCreated(new Date());
        contentCategory.setUpdated(new Date());
        contentCategory.setIsParent(false);//叶子节点
        contentCategory.setSortOrder(1);
        return contentCategoryServiceProxy.save(contentCategory);
    }

    @Override
    public EgoResult update(TbContentCategory contentCategory) {
        return contentCategoryServiceProxy.update(contentCategory);
    }

    @Override
    public EgoResult delete(Long id) {
        return contentCategoryServiceProxy.delete(id);
    }
}
