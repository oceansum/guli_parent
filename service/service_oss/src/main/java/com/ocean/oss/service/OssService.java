package com.ocean.oss.service;


import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName: OssService
 * @Description:
 * @author: ocean
 * @date: 2022/11/23 17:15
 */
public interface OssService {
    String uploadFileAvatar(MultipartFile file);
}
