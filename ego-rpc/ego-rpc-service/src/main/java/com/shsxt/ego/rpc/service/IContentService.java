package com.shsxt.ego.rpc.service;

import com.shsxt.ego.common.model.BigPicture;
import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.rpc.pojo.TbContent;
import com.shsxt.ego.rpc.query.ContentQuery;

import java.util.List;

/**类容管理
 * Created by 10170 on 2019/7/4.
 */
public interface IContentService {
    PageResult<TbContent> queryContentByParams(ContentQuery contentQuery);

    List<BigPicture> queryContentsByCategoryId(Long id);
}
