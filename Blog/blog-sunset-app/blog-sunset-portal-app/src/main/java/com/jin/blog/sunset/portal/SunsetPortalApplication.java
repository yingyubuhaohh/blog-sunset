package com.jin.blog.sunset.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description 前台系统启动类
 * @ClassName: SunsetPortalApplication
 * @author: jinzelei
 * @date: 2023/1/13 17:00
 **/
@SpringBootApplication
@ComponentScan("com.jin.blog.sunset")
public class SunsetPortalApplication {
    public static void main(String[] args) {
        SpringApplication.run(SunsetPortalApplication.class);
    }
}
