package com.jin.blog.sunset.portal.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jin.blog.sunset.base.response.R;
import com.jin.blog.sunset.base.vo.PageVo;
import com.jin.blog.sunset.core.entity.BlogSunsetArticle;
import com.jin.blog.sunset.portal.service.BlogSunsetArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 博客-文章 前端控制器
 * </p>
 *
 * @author jinzelei
 * @since 2023-02-03 15:49:41
 */
@RestController
@RequestMapping("/blogSunsetArticle")
@Api(value = "博客文章接口",tags = {"博客文章接口"})
@CrossOrigin
public class BlogSunsetArticleController {

    @Autowired
    private BlogSunsetArticleService targetService;

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
        // 文章访问量＋1
        try {
            BlogSunsetArticle article = targetService.getById(id);
            targetService.updateById(article.setClickNum(article.getClickNum() + 1));
        }catch (Exception e){
            e.printStackTrace();
            System.err.println("增加点击量失败！！");
        }
        return R.ok(targetService.getById(id));
    }

    /**
     * @Author jinzelei
     * @Description  分页查询
     * @Date  2023/2/22 16:05:26
     * @Param pageVo 分页参数
     * @return R
     **/
    @PostMapping("/page")
    @ApiOperation("分页查询")
    public R findPage(@RequestBody PageVo<BlogSunsetArticle> pageVo){
        QueryWrapper<BlogSunsetArticle> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time");
        queryWrapper.eq("is_delete",0);
        return R.ok(targetService.getBaseMapper().selectPage(new Page<>(pageVo.getPageNum(), pageVo.getPageSize()), queryWrapper));
    }

}

