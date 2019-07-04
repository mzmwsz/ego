package com.shsxt.ego.manager.Service;

import com.shsxt.ego.common.model.PictureResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by 10170 on 2019/7/3.
 */
public interface IManagerFileService {
    public PictureResult uploadFile(MultipartFile mf);
}
