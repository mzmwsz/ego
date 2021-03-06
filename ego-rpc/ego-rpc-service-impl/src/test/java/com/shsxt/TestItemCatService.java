package com.shsxt;


import com.shsxt.ego.rpc.pojo.TbItemCat;
import com.shsxt.ego.rpc.service.IItemCatService;
import com.shsxt.ego.rpc.service.IItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:spring/applicationContext-dao.xml",
        "classpath:spring/applicationContext-service.xml",
        "classpath:spring/applicationContext-tx.xml",
        "classpath:spring/applicationContext-redis.xml"} )
public class TestItemCatService {

    @Resource
    private IItemCatService itemCatService;

    @Test
    public  void test01(){
        List<TbItemCat> itemCatList= itemCatService.queryAllItemCats();
        itemCatList.forEach(i->{
            System.out.println(i);
        });
    }

}
