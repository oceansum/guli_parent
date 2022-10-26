package com.ocean.commonutils;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: R
 * @Description: 统一返回结构
 * @author: ocean
 * @date: 2022/10/14 14:06
 */
@Data
public class R {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "是否成功")
    private Integer code;

    @ApiModelProperty(value = "是否成功")
    private String message;

    @ApiModelProperty(value = "是否成功")
    private Map<String, Object> data = new HashMap<>();

    //把构造方法私有化
    private R(){}

    //链式编程

    //成功静态方法
    public static R ok(){
        R r = new R();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功");
        return r;
    }

    //失败静态方法
    public static R error(){
        R r = new R();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("失败");
        return r;
    }

    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public R code(Integer code){
        this.setCode(code);
        return this;
    }

    public R message(String message){
        this.setMessage(message);
        return this;
    }

    public R data(String key,Object value){
        this.data.put(key,value);
        return this;
    }
    public R data(Map data){
        this.setData(data);
        return this;
    }
}
