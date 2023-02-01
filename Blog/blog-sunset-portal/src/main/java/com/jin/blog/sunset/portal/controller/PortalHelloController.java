package com.jin.blog.sunset.portal.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @ClassName: PortalHelloController
 * @author: jinzelei
 * @date: 2023/1/31 15:14
 **/
@RestController
@RequestMapping("/portal")
@Api(value = "前台门户接口",tags = {"前台门户接口"})
public class PortalHelloController {

    @ApiOperation("测试接口")
    @GetMapping("/hello")
    public String hello(){
        return "hello portal";
    }

}
