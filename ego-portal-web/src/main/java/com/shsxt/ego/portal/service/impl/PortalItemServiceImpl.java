package com.shsxt.ego.portal.service.impl;

import com.shsxt.ego.common.model.CatNode;
import com.shsxt.ego.portal.service.IportalItemCatService;
import com.shsxt.ego.rpc.pojo.TbItemCat;
import com.shsxt.ego.rpc.service.IItemCatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 10170 on 2019/7/5.
 */
@Service
public class PortalItemServiceImpl implements IportalItemCatService{
    @Resource
    private IItemCatService itemCatServiceProxy;
    @Override
    public Map<String, Object> getAllItemCats() {
        List<TbItemCat> list = itemCatServiceProxy.queryAllItemCats();
        /*
        * 分类数据处理
        * */
        List result =getChildren(0L,list);
        Map<String,Object> map = new HashMap<>();
        map.put("data",result);
        return map;
    }

    private List getChildren(long parentId, List<TbItemCat> list) {
        List result = new ArrayList();
        for(TbItemCat itemCat:list){
            if(itemCat.getParentId().equals(parentId)){
                if(itemCat.getIsParent()){
                    /*
                * 一级目录或二级目录L
                * */
                    CatNode catNode =new CatNode();
                    if(itemCat.getParentId().equals(0L)){
                        /*
                        * 一级分类
                        * */
                        catNode.setName("<a href='/products/"+itemCat.getId()+".html'>"+itemCat.getName()+"</a>");
                    }else{
                        /*
                        * 二级分类
                        * */
                        catNode.setName(itemCat.getName());
                    }
                    catNode.setUrl("/products/"+ itemCat.getId()+".html");
                    catNode.setList(getChildren(itemCat.getId(),list));//递归
                    result.add(catNode);
                }else{
                    //三级节点
                    result.add("/products/"+itemCat.getId()+".html|"+itemCat.getName());
                }

            }
        }
        return result;
    }
}
