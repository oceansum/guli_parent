package com.ocean.oss.controller;

import com.ocean.commonutils.R;
import com.ocean.oss.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName: OssController
 * @Description:
 * @author: ocean
 * @date: 2022/11/23 17:12
 */
@RestController
@RequestMapping("/eduOss/fileOss")
public class OssController {

    @Autowired
    private OssService ossService;

    //上传头像的方法
    @PostMapping
    public R uploadOssFile(MultipartFile file){
        //获取上传文件  MultipartFile

        String url = ossService.uploadFileAvatar(file);
        return R.ok().data("url",url);
    }
}
