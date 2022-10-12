package com.ocean.eduservice.controller;


import com.google.gson.stream.JsonToken;
import com.ocean.eduservice.entity.EduTeacher;
import com.ocean.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-10-12
 */

@Api(description = "讲师管理")
@RestController
@RequestMapping("/eduService/edu-teacher")
public class EduTeacherController {

    //把service注入
    @Autowired
    public EduTeacherService eduTeacherService;

    //1 查询讲师表所有的数据
    //rest风格
    @ApiOperation(value = "所有讲师列表")
    @GetMapping("findAll")
    public List<EduTeacher> findAllTeacher() {
        //使用service的方法实现查询所有的操作
        List<EduTeacher> list = eduTeacherService.list(null);
        System.out.println(list);
        return list;
    }

    //2 逻辑删除讲师的数据
//    @DeleteMapping("delete")
//    public boolean deleteTeacher() {
//        //使用service的方法实现查询所有的操作
//        boolean b = eduTeacherService.removeById("1");
//        System.out.println(b);
//        return b;
//    }
    @ApiOperation(value = "逻辑删除讲师")
    @DeleteMapping("{id}")
    public boolean removeTeacher(@ApiParam(name = "id",value = "讲师ID",required = true)
            @PathVariable String id){
        boolean b = eduTeacherService.removeById(id);
        return b;
    }
}

