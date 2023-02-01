package com.jin.blog.sunset.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description 后台系统启动类
 * @ClassName: SunsetSystemApplication
 * @author: jinzelei
 * @date: 2023/1/13 17:01
 **/
@SpringBootApplication
@ComponentScan("com.jin.blog.sunset")
@MapperScan("com.jin.blog.sunset.core")
public class SunsetSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SunsetSystemApplication.class);
    }
}
