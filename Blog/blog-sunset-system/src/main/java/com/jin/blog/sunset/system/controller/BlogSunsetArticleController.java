package com.jin.blog.sunset.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jin.blog.sunset.base.response.R;
import com.jin.blog.sunset.core.entity.BlogSunsetArticle;
import com.jin.blog.sunset.system.service.BlogSunsetArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
@Api(value = "文章详情接口",tags = {"文章详情接口"})
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
        return R.ok(targetService.getById(id));
    }

    /**
     * @Author jinzelei
     * @Description  新增或更新
     * @Date  2023-02-03 15:49:41
     * @Param
     * @return R
     **/
    @PostMapping
    @ApiOperation("新增或修改")
    public R save(@RequestBody BlogSunsetArticle blogSunsetArticle) {
        if(targetService.save(blogSunsetArticle)){
            return R.ok();
        }else{
            return R.error();
        }
    }

    /**
     * @Author jinzelei
     * @Description  删除
     * @Date  2023-02-03 15:49:41
     * @Param
     * @return R
     **/
    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public R delete(@PathVariable Integer id) {
        if(targetService.removeById(id)){
            return R.ok();
        }else{
            return R.error();
        }
    }

    /**
     * @Author jinzelei
     * @Description  多项删除
     * @Date  2023-02-03 15:49:41
     * @Param
     * @return R
     **/
    @PostMapping("/del/batch")
    @ApiOperation("批量删除")
    public R deleteBatch(@RequestBody List<Integer> ids) {
        if(targetService.removeByIds(ids)){
            return R.ok();
        }else{
            return R.error();
        }
    }

    /**
     * @Author jinzelei
     * @Description  逻辑删除
     * @Date  2023-02-03 15:49:41
     * @Param id 删除文章id
     * @return R
     **/
    @PostMapping("/remove/{id}")
    @ApiOperation("逻辑删除")
    public R remove(@PathVariable Long id){
        if(targetService.updateById(new BlogSunsetArticle().setId(id).setIsDelete(1))){
            return R.ok();
        }else{
            return R.error();
        }
    }

    /**
     * @Author jinzelei
     * @Description  多项逻辑删除
     * @Date  2023-02-03 15:49:41
     * @Param
     * @return R
     **/
    @PostMapping("/remove/batch")
    @ApiOperation("批量逻辑删除")
    public R removeBatch(@RequestBody List<Integer> ids) {
        if(targetService.updateBatchById(targetService.listByIds(ids).stream().peek(e ->e.setIsDelete(1)).collect(Collectors.toList()))){
            return R.ok();
        }else{
            return R.error();
        }
    }

    /**
     * @Author jinzelei
     * @Description  分页查询
     * @Date  2023-02-03 15:49:41
     * @Param
     * @return R
     **/
    @GetMapping("/page")
    @ApiOperation("分页查询")
    public R findPage(@RequestParam Integer pageNum,
    @RequestParam Integer pageSize) {
        QueryWrapper<BlogSunsetArticle> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return R.ok(targetService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }
}

