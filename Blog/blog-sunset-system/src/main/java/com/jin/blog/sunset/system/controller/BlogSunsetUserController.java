package com.jin.blog.sunset.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jin.blog.sunset.base.response.R;
import com.jin.blog.sunset.base.vo.PageVo;
import com.jin.blog.sunset.core.entity.BlogSunsetTool;
import com.jin.blog.sunset.core.entity.BlogSunsetUser;
import com.jin.blog.sunset.core.entity.BlogSysMenu;
import com.jin.blog.sunset.system.service.BlogSunsetUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 博客-用户表 前端控制器
 * </p>
 *
 * @author jinzelei
 * @since 2023-02-03 15:49:41
 */
@RestController
@RequestMapping("/blogSunsetUser")
@Api(value = "博客用户接口",tags = {"博客用户接口"})
@CrossOrigin
public class BlogSunsetUserController {

    @Autowired
    private BlogSunsetUserService targetService;

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
    public R save(@RequestBody BlogSunsetUser blogSunsetUser) {
        if(targetService.save(blogSunsetUser)){
            return R.ok();
        }else{
            return R.error();
        }
    }

    /**
     * @Author jinzelei
     * @Description  修改
     * @Date  2023/2/14 16:42:50
     * @Param BlogSunsetUser 实体参数
     * @return R
     **/
    @PostMapping("/update")
    @ApiOperation("修改")
    public R update(@RequestBody BlogSunsetUser blogSunsetUser) {
        if(targetService.update(blogSunsetUser,new QueryWrapper<BlogSunsetUser>().eq("id",blogSunsetUser.getId()))){
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
        if(targetService.updateById(new BlogSunsetUser().setId(id).setIsDelete(1))){
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
    public R findPage(@RequestBody PageVo<BlogSunsetUser> pageVo) {
        return R.ok(targetService.page(pageVo));
    }

    /**
     * @Author jinzelei
     * @Description 搜索接口
     * @Date  2023/2/16 09:34:34
     * @Param [blogSunsetUser] 实体参数
     * @return com.jin.blog.sunset.base.response.R
     **/
    @PostMapping("/search")
    @ApiOperation("搜索接口")
    public R search(@RequestBody BlogSunsetUser blogSunsetUser) throws IllegalAccessException {
        return R.ok();
    }
}

