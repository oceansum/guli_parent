package com.ocean.servicebase.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: GuliException
 * @Description: 自定义异常
 * @author: ocean
 * @date: 2022/10/24 16:51
 */

@Data
@AllArgsConstructor //生成有参数构造方法
@NoArgsConstructor  //生成无参数构造方法
public class GuliException extends RuntimeException{

    private Integer code; // 状态码
    private String msg; // 异常信息
}
