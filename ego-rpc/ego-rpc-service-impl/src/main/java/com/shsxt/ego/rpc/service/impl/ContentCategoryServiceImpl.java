package com.shsxt.ego.rpc.service.impl;

import com.shsxt.ego.common.model.EgoResult;
import com.shsxt.ego.rpc.dto.TreeDto;
import com.shsxt.ego.rpc.mapper.db.dao.TbContentCategoryMapper;
import com.shsxt.ego.rpc.pojo.TbContentCategory;
import com.shsxt.ego.rpc.service.IContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by 10170 on 2019/7/4.
 */
@Service
public class ContentCategoryServiceImpl implements IContentCategoryService {

    @Autowired
    private TbContentCategoryMapper contentCategoryMapper;
    @Override
    public List<TreeDto> queryContentCategoryListByParentId(Long id) {
        return contentCategoryMapper.queryContentCategoryListByParentId(id);
    }

    @Override
    public EgoResult save(TbContentCategory contentCategory) {
        // 查询parentId对应节点  如果该节点下不存在节点 设置is_parent=1
        // 查询parent_id 下是否存在子节点
        int count=contentCategoryMapper.countContentCategoryByParentId(contentCategory.getParentId());
        if(count==0){
            //更新父节点is_parent
            TbContentCategory contentCategory1=new TbContentCategory();
            contentCategory1.setId(contentCategory.getParentId());
            contentCategory1.setIsParent(true);
            contentCategory1.setUpdated(new Date());
            contentCategoryMapper.updateByPrimaryKeySelective(contentCategory1);
        }
        contentCategoryMapper.insertSelective(contentCategory);
        return new EgoResult();
    }

    @Override
    public EgoResult update(TbContentCategory contentCategory) {
        contentCategoryMapper.updateByPrimaryKeySelective(contentCategory);
        return new EgoResult();
    }

    @Override
    public EgoResult delete(Long id) {
        /**
         * 1.查询待删除的节点是否为父节点  如果为父节点 不可删除
         * 2.删除当前节点后
         *    父节点不存在子节点  父节点is_parent=0
         */
        EgoResult result = null;
        TbContentCategory contentCategory=contentCategoryMapper.selectByPrimaryKey(id);
        if(contentCategory.getIsParent()){
            result.setStatus(500);
            result.setMsg("当前节点为父节点，不可直接删除");
            return result;
        }
        contentCategory.setUpdated(new Date());
        contentCategory.setStatus(2);//假删除，改状态
        contentCategoryMapper.updateByPrimaryKeySelective(contentCategory);//删除当前节点
        //删除后查询是否存在子节点
        int count=contentCategoryMapper.countContentCategoryByParentId(contentCategory.getParentId());
        if(count==0){
            //父节点is_parent=0
            TbContentCategory contentCategory1 = new TbContentCategory();
            contentCategory1.setParentId(contentCategory.getParentId());
            contentCategory1.setUpdated(new Date());
            contentCategory1.setIsParent(false);
            contentCategoryMapper.updateByPrimaryKeySelective(contentCategory1);
        }
        return new EgoResult();
    }
}
