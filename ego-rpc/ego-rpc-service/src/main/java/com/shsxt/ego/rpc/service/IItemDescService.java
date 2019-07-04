package com.shsxt.ego.rpc.service;

import com.shsxt.ego.common.model.EgoResult;
import com.shsxt.ego.rpc.pojo.TbItemDesc;

/**回显描述信息
 * Created by 10170 on 2019/7/3.
 */
public interface IItemDescService {
    public TbItemDesc queryItemDescByItemId(Long itemId);
}
