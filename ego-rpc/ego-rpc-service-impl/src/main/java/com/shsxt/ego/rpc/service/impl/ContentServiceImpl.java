package com.shsxt.ego.rpc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.ego.common.model.BigPicture;
import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.rpc.mapper.db.dao.TbContentMapper;
import com.shsxt.ego.rpc.pojo.TbContent;
import com.shsxt.ego.rpc.query.ContentQuery;
import com.shsxt.ego.rpc.service.IContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10170 on 2019/7/4.
 */
@Service
public class ContentServiceImpl implements IContentService {
    @Autowired
    private TbContentMapper contentMapper;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Resource(name = "redisTemplate")
    private ValueOperations<String,Object> valueOperations;

    @Override
    public PageResult<TbContent> queryContentByParams(ContentQuery contentQuery) {
        PageHelper.startPage(contentQuery.getPage(),contentQuery.getRows());
        String key = "content::queryContentByParams::cid::"+contentQuery.getCategoryId()
                +"::page::"+contentQuery.getPage()+"::rows::"+contentQuery.getRows();
        List<TbContent> contentList=null;
        if(redisTemplate.hasKey(key)){
            contentList = (List<TbContent>) valueOperations.get(key);
        }else{
            contentList=contentMapper.queryConetentByParams(contentQuery);
        }
        PageInfo<TbContent> pageInfo=new PageInfo<>(contentList);
        PageResult<TbContent> result=new PageResult<>();
        result.setRows(pageInfo.getList());
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public List<BigPicture> queryContentsByCategoryId(Long cid) {
        List<BigPicture> pictures=null;
        List<TbContent> contents=null;
        String key = "content::queryContentsByCategoryId::cid::"+cid;
        if(redisTemplate.hasKey(key)){//判断缓存是否有key，有就村缓存中取数据
            contents=(List<TbContent>)valueOperations.get(key);
        }else{
            contents=contentMapper.queryContentsByCategoryId(cid);
            if(null!=contents&&contents.size()>0){
                valueOperations.set(key,contents);
            }
        }
        if(null!=contents&&contents.size()>0){
            pictures=new ArrayList<BigPicture>();
            List<BigPicture> finalPictures = pictures;
            contents.forEach(c->{
                BigPicture bigPicture = new BigPicture();
                bigPicture.setAlt("ego商城");
                bigPicture.setHref(c.getUrl());
                bigPicture.setSrcb(c.getPic2());
                bigPicture.setSrc(c.getPic());
                finalPictures.add(bigPicture);
            });
        }
        return pictures;
    }
}
