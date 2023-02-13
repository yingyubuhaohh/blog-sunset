package com.jin.blog.sunset.system.controller.business;

import com.jin.blog.sunset.base.response.R;
import com.jin.blog.sunset.core.entity.BlogSunsetUser;
import com.jin.blog.sunset.core.vo.LoginVo;
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
@CrossOrigin
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
    public R login(@RequestBody LoginVo loginVo){
        return targetService.login(loginVo);
    }

    /**
     * @Author jinzelei
     * @Description  获取用户信息
     * @Date  2023/2/13 09:13:24
     * @Param token
     * @return R
     **/
    @PostMapping("/info")
    @ApiOperation("获取用户信息")
    public R info(@RequestBody String token){
        return targetService.info(token);
    }

    @PostMapping("/logout")
    @ApiOperation("登出")
    public R logout(@RequestBody String token){
        return targetService.logout(token);
    }

}
