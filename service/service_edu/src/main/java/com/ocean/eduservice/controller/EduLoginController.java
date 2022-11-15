package com.ocean.eduservice.controller;

import com.ocean.commonutils.R;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: EduLoginController
 * @Description: 登录处理
 * @author: ocean
 * @date: 2022/11/3 15:50
 */

@RestController
@RequestMapping("eduService/user")
@CrossOrigin // 解决跨域
public class EduLoginController {

    @PostMapping("/login")
    public R login(){
        return R.ok().data("token","admin");
    }

    @GetMapping("info")
    public R info(){
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","https://ts4.cn.mm.bing.net/th?id=OIP-C.kB-Ovasi0GW67-rmwnAcwAHaEo&w=316&h=197&c=8&rs=1&qlt=90&o=6&dpr=2&pid=3.1&rm=2");
    }
}
