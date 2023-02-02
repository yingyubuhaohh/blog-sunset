package com.jin.blog.sunset.system;

import com.jin.blog.sunset.base.config.UpdateBeanNameGenerator;
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
@ComponentScan(value = "com.jin.blog.sunset",nameGenerator = UpdateBeanNameGenerator.class)
@MapperScan("com.jin.blog.sunset.core")
public class SunsetSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SunsetSystemApplication.class);
    }
}
