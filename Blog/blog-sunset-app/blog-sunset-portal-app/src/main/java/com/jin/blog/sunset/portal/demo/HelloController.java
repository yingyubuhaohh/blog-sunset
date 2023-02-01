package com.jin.blog.sunset.portal.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 测试
 * @ClassName: HelloController
 * @author: jinzelei
 * @date: 2023/1/13 17:00
 **/
//@RestController
public class HelloController {

    //@RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }

}
