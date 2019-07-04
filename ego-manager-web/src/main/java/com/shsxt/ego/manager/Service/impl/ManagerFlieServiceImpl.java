package com.shsxt.ego.manager.Service.impl;

import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.shsxt.ego.common.model.PictureResult;
import com.shsxt.ego.manager.Service.IManagerFileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.qiniu.storage.Configuration;

/**
 * Created by 10170 on 2019/7/3.
 */
@Service
public class ManagerFlieServiceImpl implements IManagerFileService {
    //这是李老师上传七牛云图片的路径和密钥
    private String ak = "3K77OJ214syThkwIbX8skAMHcEYmZJuqGcTSEEW1";
    private String sk = "DpQoXLAfJWJJblp-kdBm4t573Tzf_cEmq6xLoFW3";
    private String bucket = "20190701";
    private String basePath="http://pty9die0h.bkt.clouddn.com/";
    @Override
    public PictureResult uploadFile(MultipartFile mf) {
        PictureResult result = new PictureResult();
        try {
            if(null != mf && mf.getSize()>0){
                Configuration cfg = new Configuration(Zone.zone0());
                UploadManager uploadManager = new UploadManager(cfg);
                String fileName = mf.getOriginalFilename();
                String ext = fileName.substring(fileName.lastIndexOf("."));// 文件后缀
                String key = System.currentTimeMillis() + ext;
                Auth auth = Auth.create(ak, sk);
                String upToken = auth.uploadToken(bucket);
                Response response = uploadManager.put(mf.getInputStream(), key, upToken, null, null);
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                result.setError(0);
                result.setMessage("ok");
                result.setUrl(basePath+key);
            }else{
                result.setError(1);
                result.setMessage("error");
                result.setUrl("");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setError(1);
            result.setMessage("error");
            result.setUrl("");
        }
        return result;
    }
}
