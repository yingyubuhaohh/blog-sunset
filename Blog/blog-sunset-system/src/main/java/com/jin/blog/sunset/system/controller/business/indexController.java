package com.jin.blog.sunset.system.controller.business;

import com.jin.blog.sunset.base.response.R;
import com.jin.blog.sunset.system.service.business.IndexService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 后台首页 - 控制器
 * @ClassName: indexController
 * @author: jinzelei
 * @date: 2023/2/20 9:09
 **/
@RestController
@RequestMapping("/admin/index")
@Api(value = "首页数据接口",tags = {"首页数据接口"})
@CrossOrigin
public class indexController {

    @Autowired
    private IndexService targetService;

    /**
     * @Author jinzelei
     * @Description  博客数 评论数 浏览量 用户数
     * @Date  2023/2/20 09:41:18
     * @Param
     * @return R
     **/
    @GetMapping("/count")
    @ApiOperation("博客数 评论数 浏览量 用户数")
    public R count(){
        return R.ok(targetService.count());
    }

}
