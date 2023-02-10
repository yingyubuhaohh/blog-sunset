package com.jin.blog.sunset.system.controller;

import com.jin.blog.sunset.base.response.R;
import com.jin.blog.sunset.core.vo.InfoVo;
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
     * @Param loginVo
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
     * @Date  2023/2/7 11:54:25
     * @Param infoVo
     * @return R
     **/
    @PostMapping("/info")
    @ApiOperation("获取用户信息")
    public R info(@RequestBody InfoVo infoVo){
        System.out.println(infoVo.toString());
        return targetService.info(infoVo);
    }


}
