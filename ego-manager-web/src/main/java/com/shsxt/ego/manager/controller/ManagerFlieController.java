package com.shsxt.ego.manager.controller;

import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.common.model.PictureResult;
import com.shsxt.ego.manager.Service.IManagerFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 10170 on 2019/7/3.
 */
@Controller
public class ManagerFlieController {
    @Autowired
    private IManagerFileService managerFileService;

    @RequestMapping("pic/upload")
    @ResponseBody
    public PictureResult uploadFile(HttpServletRequest request){
        MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) request;
        MultipartFile mf  = mhsr.getFile("uploadFile");
        return managerFileService.uploadFile(mf);
    }

}
