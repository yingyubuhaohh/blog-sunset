package com.jin.blog.sunset.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apiguardian.api.API;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @ClassName: SystemHelloController
 * @author: jinzelei
 * @date: 2023/2/1 9:12
 **/
@RestController
@RequestMapping("/system")
@Api(value = "后台系统接口",tags = {"后台系统接口"})
@CrossOrigin
public class SystemHelloController {

    /**
     * @Author jinzelei
     * @Description  测试接口
     * @Date  2023/2/2 10:02:39
     * @Param
     * @return
     **/
    @ApiOperation("测试接口")
    @GetMapping("/hello")
    public String hello(){
        return "hello system";
    }

}
