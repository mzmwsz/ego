package com.shsxt.ego.manager.Service;

import com.github.pagehelper.Page;
import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.rpc.pojo.TbContent;
import com.shsxt.ego.rpc.query.ContentQuery;

/**
 * Created by 10170 on 2019/7/4.
 */
public interface IManagerContentService {
    PageResult<TbContent> queryContentsByParams(ContentQuery contentQuery);
}
