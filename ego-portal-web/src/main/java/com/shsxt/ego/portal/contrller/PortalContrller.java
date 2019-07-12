package com.shsxt.ego.portal.contrller;

import com.shsxt.ego.common.utils.JsonUtils;
import com.shsxt.ego.portal.service.IPortalContentService;
import com.shsxt.ego.portal.service.IportalItemCatService;
import com.shsxt.ego.portal.service.impl.PortalContentServiceImpl;
import com.shsxt.ego.portal.service.impl.PortalItemServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by 10170 on 2019/7/5.
 */
@Controller
public class PortalContrller {
    @Resource
    private IportalItemCatService portalItemService;

    @Resource
    private IPortalContentService portalContentService;


    @RequestMapping(value = "item/cat",produces= MediaType.TEXT_HTML_VALUE+";charset=UTF-8")//解决json对象转字符串前台接收乱码
    @ResponseBody
    public String getAllCats(){
        Map<String,Object> map=portalItemService.getAllItemCats();
        return JsonUtils.objectToJson(map);
    }

    @RequestMapping(value = "content/index/list",produces= MediaType.TEXT_HTML_VALUE+";charset=UTF-8")
    @ResponseBody
    public String queryContentsByCategoryId(Long catgoryId){
        return JsonUtils.objectToJson(portalContentService.queryContentsByCategoryId(catgoryId));
    }
}
