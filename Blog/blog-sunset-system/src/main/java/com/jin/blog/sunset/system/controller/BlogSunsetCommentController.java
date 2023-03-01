package com.jin.blog.sunset.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jin.blog.sunset.base.response.R;
import com.jin.blog.sunset.base.vo.PageVo;
import com.jin.blog.sunset.core.entity.BlogSunsetArticle;
import com.jin.blog.sunset.core.entity.BlogSunsetComment;
import com.jin.blog.sunset.core.entity.BlogSunsetTool;
import com.jin.blog.sunset.system.service.BlogSunsetCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@Api(value = "文章评论接口",tags = {"文章评论接口"})
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
     * @Description  新增
     * @Date  2023-02-03 15:49:41
     * @Param
     * @return R
     **/
    @PostMapping("/save")
    @ApiOperation("新增")
    public R save(@RequestBody BlogSunsetComment blogSunsetComment) {
        if(targetService.save(blogSunsetComment)){
            return R.ok();
        }else{
            return R.error();
        }
    }

    /**
     * @Author jinzelei
     * @Description  修改
     * @Date  2023/2/14 16:42:50
     * @Param BlogSunsetComment 实体参数
     * @return R
     **/
    @PostMapping("/update")
    @ApiOperation("修改")
    public R update(@RequestBody BlogSunsetComment blogSunsetComment) {
        if(targetService.update(blogSunsetComment,new QueryWrapper<BlogSunsetComment>().eq("id",blogSunsetComment.getId()))){
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
    @GetMapping("/remove/{id}")
    @ApiOperation("逻辑删除")
    public R remove(@PathVariable Long id){
        if(targetService.updateById(new BlogSunsetComment().setId(id).setIsDelete(1))){
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
    @PostMapping("/page")
    @ApiOperation("分页查询")
    public R findPage(@RequestBody PageVo<BlogSunsetComment> pageVo) {
        return R.ok(targetService.page(pageVo));
    }

    /**
     * @Author jinzelei
     * @Description
     * @Date  2023/2/15 11:57:26
     * @Param PageVo type
     * @return R
     **/
    @PostMapping("/page/{type}")
    @ApiOperation("type分页查询")
    public R page(@RequestBody PageVo<BlogSunsetComment> pageVo,@PathVariable String type){
        return R.ok(targetService.typePage(pageVo,type));
    }

}

