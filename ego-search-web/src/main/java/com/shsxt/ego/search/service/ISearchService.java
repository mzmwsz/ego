package com.shsxt.ego.search.service;

import com.shsxt.ego.search.entity.GoodsVo;
import org.springframework.data.domain.Page;

/**
 * Created by 10170 on 2019/7/11.
 */
public interface ISearchService {
    public Page<GoodsVo> queryGoodsByKey(String key,Integer page);

}
