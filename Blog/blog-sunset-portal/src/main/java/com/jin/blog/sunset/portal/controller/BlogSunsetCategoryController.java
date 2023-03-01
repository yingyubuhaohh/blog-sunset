package com.jin.blog.sunset.portal.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jin.blog.sunset.base.response.R;
import com.jin.blog.sunset.base.vo.PageVo;
import com.jin.blog.sunset.core.entity.BlogSunsetCategory;
import com.jin.blog.sunset.portal.service.BlogSunsetCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 博客-分类表 前端控制器
 * </p>
 *
 * @author jinzelei
 * @since 2023-02-03 15:49:41
 */
@RestController
@RequestMapping("/blogSunsetCategory")
@Api(value = "博客分类接口",tags = {"博客分类接口"})
@CrossOrigin
public class BlogSunsetCategoryController {

    @Autowired
    private BlogSunsetCategoryService targetService;

    /**
     * @Author jinzelei
     * @Description  查询所有数据
     * @Date  2023-02-03 15:49:41
     * @Param
     * @return R
     **/
    @GetMapping
    @ApiOperation("查询所有数据")
    public R findAll() {
        return R.ok(targetService.list());
    }

    /**
     * @Author jinzelei
     * @Description  根据id查询
     * @Date  2023-02-03 15:49:41
     * @Param
     * @return R
     **/
    @GetMapping("/{id}")
    @ApiOperation("根据id查询")
    public R findOne(@PathVariable Integer id) {
        return R.ok(targetService.getById(id));
    }

    /**
     * @Author jinzelei
     * @Description  分页查询
     * @Date  2023-02-22 15:49:41
     * @Param
     * @return R
     **/
    @PostMapping("/page")
    @ApiOperation("分页查询")
    public R findPage(@RequestBody PageVo<BlogSunsetCategory> pageVo) {
        return R.ok(targetService.page(pageVo));
    }

}

