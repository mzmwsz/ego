package com.shsxt.ego.rpc.query;

import java.io.Serializable;

/**
 * Created by 10170 on 2019/7/4.
 */
public class ContentQuery extends BaseQuery implements Serializable {
    private Long categoryId;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
