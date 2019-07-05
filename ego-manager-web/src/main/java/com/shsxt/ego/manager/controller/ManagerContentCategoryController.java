package com.shsxt.ego.manager.controller;

import com.shsxt.ego.common.model.EgoResult;
import com.shsxt.ego.manager.Service.IManagerContentCategoryService;
import com.shsxt.ego.rpc.dto.TreeDto;
import com.shsxt.ego.rpc.pojo.TbContentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 10170 on 2019/7/4.
 */
@Controller
public class ManagerContentCategoryController {
    @Resource
    private IManagerContentCategoryService managerContentCategoryService;

    //类容分类管理tree型数据查询展示
    @RequestMapping("content/category/list")
    @ResponseBody
    public List<TreeDto> queryContentCategoryListByParentId(@RequestParam(defaultValue = "0") Long id){
        return managerContentCategoryService.queryContentCategoryListByParentId(id);
    }

    //类容分类管理节点的添加
    @RequestMapping("content/category/create")
    @ResponseBody
    public EgoResult save(TbContentCategory contentCategory){
        return managerContentCategoryService.save(contentCategory);
    }

    @RequestMapping("content/category/update")
    @ResponseBody
    public EgoResult update(TbContentCategory contentCategory){
        return  managerContentCategoryService.update(contentCategory);
    }

    @RequestMapping("content/category/delete")
    @ResponseBody
    public EgoResult delete(Long id){
        return managerContentCategoryService.delete(id);
    }
}
