package com.ocean.demo;

import com.ocean.eduservice.entity.EduTeacher;
import com.ocean.eduservice.mapper.EduTeacherMapper;
import com.ocean.eduservice.service.EduTeacherService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName: testMain
 * @Description: testMainClass
 * @author: ocean
 * @date: 2022/10/12 15:37
 */

public class testMain {

    @Autowired
//    public EduTeacherMapper eduTeacherMapper;
    public EduTeacherService eduTeacherService;

    @Test
    public void findAll(){
//        System.out.println(eduTeacherMapper.selectList(null));
        List<EduTeacher> list = eduTeacherService.list(null);
        System.out.println(list);
    }
}
