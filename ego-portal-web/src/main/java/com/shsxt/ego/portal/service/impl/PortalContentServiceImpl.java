package com.shsxt.ego.portal.service.impl;

import com.shsxt.ego.common.model.BigPicture;
import com.shsxt.ego.portal.service.IPortalContentService;
import com.shsxt.ego.rpc.service.IContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 10170 on 2019/7/5.
 */
@Service
public class PortalContentServiceImpl implements IPortalContentService{
    @Resource
    private IContentService contentServiceProxy;
    @Override
    public List<BigPicture> queryContentsByCategoryId(Long id) {
        return contentServiceProxy.queryContentsByCategoryId(id);
    }
}
