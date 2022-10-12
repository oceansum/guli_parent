package com.ocean.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName: EduApplication
 * @Description: initiate class
 * @author: ocean
 * @date: 2022/10/12 15:24
 */
@SpringBootApplication
@ComponentScan("com.ocean")
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }
}
