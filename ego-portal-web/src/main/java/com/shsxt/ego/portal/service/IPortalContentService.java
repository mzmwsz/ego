package com.shsxt.ego.portal.service;

import com.shsxt.ego.common.model.BigPicture;

import java.util.List;

/**
 * Created by 10170 on 2019/7/5.
 */
public interface IPortalContentService {
    public List<BigPicture> queryContentsByCategoryId(Long id);
}
