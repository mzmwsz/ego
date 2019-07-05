package com.shsxt.ego.rpc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.rpc.mapper.db.dao.TbContentMapper;
import com.shsxt.ego.rpc.pojo.TbContent;
import com.shsxt.ego.rpc.query.ContentQuery;
import com.shsxt.ego.rpc.service.IContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 10170 on 2019/7/4.
 */
@Service
public class ContentServiceImpl implements IContentService {
    @Autowired
    private TbContentMapper contentMapper;
    @Override
    public PageResult<TbContent> queryContentByParams(ContentQuery contentQuery) {
        PageHelper.startPage(contentQuery.getPage(),contentQuery.getRows());
        List<TbContent> contentList = contentMapper.queryConetentByParams(contentQuery);
        PageInfo<TbContent> pageInfo=new PageInfo<>(contentList);
        PageResult<TbContent> result=new PageResult<>();
        result.setRows(pageInfo.getList());
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
