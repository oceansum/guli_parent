package com.ocean.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.gson.stream.JsonToken;
import com.ocean.commonutils.R;
import com.ocean.eduservice.entity.EduTeacher;
import com.ocean.eduservice.entity.vo.TeacherQuery;
import com.ocean.eduservice.service.EduTeacherService;
import com.ocean.servicebase.exceptionhandler.GuliException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
//    public List<EduTeacher> findAllTeacher() {
//        //使用service的方法实现查询所有的操作
//        List<EduTeacher> list = eduTeacherService.list(null);
//        System.out.println(list);
//        return list;
//    }

    public R findAllTeacher() {
        //使用service的方法实现查询所有的操作
        List<EduTeacher> list = eduTeacherService.list(null);
        System.out.println(list);
        return R.ok().data("items", list);
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
//    public boolean removeTeacher(@ApiParam(name = "id",value = "讲师ID",required = true)
//            @PathVariable String id){
//        boolean b = eduTeacherService.removeById(id);
//        return b;
//    }
    public R removeTeacher(@ApiParam(name = "id", value = "讲师ID", required = true)
                           @PathVariable String id) {
        boolean b = eduTeacherService.removeById(id);
        if (b) {
            return R.ok();
        }
        return R.error();
    }

    //3  分页查询讲师的方法
    //current 当前页
    //limit 每页的记录数
    @ApiOperation(value = "分页查询讲师")
    @GetMapping("pageListTeacher/{cur}/{limit}")
    public R pageListTeacher(@ApiParam(name = "cur", value = "当前页", required = true)
                             @PathVariable int cur,
                             @ApiParam(name = "limit", value = "每页记录数", required = true)
                             @PathVariable int limit) {
        //创建page对象
        Page<EduTeacher> pageTeacher = new Page<>(cur, limit);
        //调用方法实现分页
        //调用方法的时候，底层封装，把分页所有数据封装到pageTeacher对象里面
        eduTeacherService.page(pageTeacher, null);

//        HashMap<String , Object> map = new HashMap<>();
//        map.put("total",pageTeacher.getTotal());//总记录数
//        map.put("rows",pageTeacher.getRecords());//数据list集合
//        return R.ok().data(map);

        return R.ok().data("total", pageTeacher.getTotal()).data("rows", pageTeacher.getRecords());
    }

    //4 条件查询带分页的方法
    @ApiOperation(value = "条件查询带分页")
    @PostMapping("pageTeacherCondition/{cur}/{limit}")
    public R pageTeacherCondition(@ApiParam(name = "cur", value = "当前页", required = true)
                                  @PathVariable int cur,
                                  @ApiParam(name = "limit", value = "每页记录数", required = true)
                                  @PathVariable int limit,
                                  @RequestBody(required = false) TeacherQuery teacherQuery) {// 使用@RequestBody 必须使用post提交

        Page<EduTeacher> pageTeacher = new Page<>(cur, limit);
        //构建条件
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        //多条件组合查询
        //mybatis学过 动态sql
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        //判断条件之是否为空，如果不为空拼接条件
        if (!StringUtils.isEmpty(name)) {
            wrapper.like("name", name);
        }
        if (!StringUtils.isEmpty(level)) {
            wrapper.eq("level", level);
        }
        if (!StringUtils.isEmpty(begin)) {
            wrapper.ge("gmt_create", begin);
        }
        if (!StringUtils.isEmpty(end)) {
            wrapper.le("gmt_modified", end);
        }

        eduTeacherService.page(pageTeacher, wrapper);

        return R.ok().data("total", pageTeacher.getTotal()).data("rows", pageTeacher.getRecords());
    }


    //5  添加讲师接口的方法
    @ApiOperation(value = "添加讲师")
    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean save = eduTeacherService.save(eduTeacher);
        if (save) {
            return R.ok();
        } else {
            return R.error();
        }
    }


    //6  根据讲师id进行查询
    @ApiOperation(value = "根据讲师id进行查询")
    @GetMapping("getTeacher/{id}")
    public R getTeacher(@PathVariable String id) {

//        try {
//            int i = 10/0;
//        } catch (Exception e) {
//            throw new GuliException(20001,"执行了自定义异常处理");
//        }

        EduTeacher byId = eduTeacherService.getById(id);
        return R.ok().data("teacher", byId);
    }

    //7  讲师修改功能
    @ApiOperation(value = "修改讲师")
    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher){
        boolean b = eduTeacherService.updateById(eduTeacher);
        if (b) {
            return R.ok();
        } else {
            return R.error();
        }
    }
}

