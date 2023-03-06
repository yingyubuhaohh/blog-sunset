package com.jin.blog.sunset.portal;

import com.jin.blog.sunset.base.config.UpdateBeanNameGenerator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description 前台门户启动类
 * @ClassName: SunsetPortalApplication
 * @author: jinzelei
 * @date: 2023/2/2 17:17
 **/
@SpringBootApplication
@ComponentScan(value = "com.jin.blog.sunset",nameGenerator = UpdateBeanNameGenerator.class)
@MapperScan("com.jin.blog.sunset.core")
@EnableCaching
public class SunsetPortalApplication {
    public static void main(String[] args) {
        SpringApplication.run(SunsetPortalApplication.class);
    }
}
