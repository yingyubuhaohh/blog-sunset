package com.jin.blog.sunset.portal.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jin.blog.sunset.base.response.R;
import com.jin.blog.sunset.base.vo.PageVo;
import com.jin.blog.sunset.core.entity.BlogSunsetComment;
import com.jin.blog.sunset.portal.service.BlogSunsetCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 博客-评论表 前端控制器
 * </p>
 *
 * @author jinzelei
 * @since 2023-02-03 15:49:41
 */
@RestController
@RequestMapping("/blogSunsetComment")
@Api(value = "博客评论接口",tags = {"博客评论接口"})
@CrossOrigin
public class BlogSunsetCommentController {

    @Autowired
    private BlogSunsetCommentService targetService;

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
    public R findPage(@RequestBody PageVo<BlogSunsetComment> pageVo) {
        return R.ok(targetService.page(pageVo));
    }

    /**
     * @Author jinzelei
     * @Description  根据文章id查询评论
     * @Date  2023/3/1 17:04:23
     * @Param [id]
     * @return com.jin.blog.sunset.base.response.R
     **/
    @GetMapping("/findComment/{id}")
    @ApiOperation("根据文章id查询评论")
    public R findArticleComment(@PathVariable Integer id){
        return R.ok(targetService.findArticleComment(id));
    }


    /**
     * @Author jinzelei
     * @Description
     * @Date  2023/3/6 16:47:36
     * @Param [blogSunsetComment]
     * @return com.jin.blog.sunset.base.response.R
     **/
    @PostMapping("/save")
    @ApiOperation("新增")
    public R save(@RequestBody BlogSunsetComment blogSunsetComment) {
        LocalDateTime time1 = LocalDateTime.now();
        if(targetService.save(blogSunsetComment.setDate(Date.from(time1.atZone(ZoneId.systemDefault()).toInstant())))){
            return R.ok();
        }else{
            return R.error();
        }
    }

}

