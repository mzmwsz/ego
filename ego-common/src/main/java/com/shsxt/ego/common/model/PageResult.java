package com.shsxt.ego.common.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 10170 on 2019/7/1.
 */
public class PageResult<T> implements Serializable{
    private Long total;
    private List<T> rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
