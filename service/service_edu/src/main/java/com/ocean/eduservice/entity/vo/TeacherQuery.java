package com.ocean.eduservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: TeacherQuery
 * @Description: 讲师查询条件
 * @author: ocean
 * @date: 2022/10/18 21:58
 */

@Data
public class TeacherQuery {

    @ApiModelProperty(value = "教师名称，模糊查询")
    public String name;

    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    public Integer level;

    @ApiModelProperty(value = "查询开始时间",example = "2019-01-01 10:10:10")
    public String begin; //注意，这里使用的是String类型，前端传过来的数据无需进行转换

    @ApiModelProperty(value = "查询结束时间",example = "2019-01-01 10:10:10")
    public String end;

}
