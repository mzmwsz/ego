package com.shsxt.ego.rpc.dto;

import java.io.Serializable;

/**
 * Created by 10170 on 2019/7/2.
 */
public class TreeDto implements Serializable {
    private Long id;
    private String text;
    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
