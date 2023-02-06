package com.jin.blog.sunset.system.controller;

import com.jin.blog.sunset.base.response.R;
import com.jin.blog.sunset.core.entity.BlogSunsetUser;
import com.jin.blog.sunset.system.service.BlogSunsetUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description 用户登录
 * @ClassName: LoginController
 * @author: jinzelei
 * @date: 2023/2/6 10:09
 **/
@RestController
@RequestMapping("/admin/user")
@Api(value = "用户登录接口",tags = {"用户登录接口"})
public class LoginController {

    @Autowired
    private BlogSunsetUserService targetService;

    /**
     * @Author jinzelei
     * @Description  登录
     * @Date  2023/2/6 14:20:15
     * @Param username 用户名 password 密码
     * @return R
     **/
    @PostMapping("/login")
    @ApiOperation("用户登录")
    public R login(@RequestParam String username,@RequestParam String password){
        return targetService.login(username,password);
    }

}
