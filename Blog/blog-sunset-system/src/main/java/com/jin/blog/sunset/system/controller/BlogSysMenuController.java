package com.jin.blog.sunset.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jin.blog.sunset.base.response.R;
import com.jin.blog.sunset.base.vo.PageVo;
import com.jin.blog.sunset.core.entity.BlogSunsetTool;
import com.jin.blog.sunset.core.entity.BlogSysMenu;
import com.jin.blog.sunset.core.entity.BlogSysRole;
import com.jin.blog.sunset.system.service.BlogSysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 博客-权限表 前端控制器
 * </p>
 *
 * @author jinzelei
 * @since 2023-02-03 15:49:41
 */
@RestController
@RequestMapping("/blogSysMenu")
@Api(value = "菜单权限接口",tags = {"菜单权限接口"})
@CrossOrigin
public class BlogSysMenuController {

    @Autowired
    private BlogSysMenuService targetService;

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
    public R save(@RequestBody BlogSysMenu blogSysMenu) {
        if(targetService.save(blogSysMenu)){
            return R.ok();
        }else{
            return R.error();
        }
    }

    /**
     * @Author jinzelei
     * @Description  修改
     * @Date  2023/2/14 16:42:50
     * @Param BlogSysMenu 实体参数
     * @return R
     **/
    @PostMapping("/update")
    @ApiOperation("修改")
    public R update(@RequestBody BlogSysMenu blogSysMenu) {
        if(targetService.update(blogSysMenu,new QueryWrapper<BlogSysMenu>().eq("id",blogSysMenu.getId()))){
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
    /*@PostMapping("/remove/{id}")
    @ApiOperation("逻辑删除")
    public R remove(@PathVariable Long id){
        if(targetService.updateById(new BlogSysMenu().setId(id).setIsDelete(true))){
            return R.ok();
        }else{
            return R.error();
        }
    }*/

    /**
     * @Author jinzelei
     * @Description  多项逻辑删除
     * @Date  2023-02-03 15:49:41
     * @Param
     * @return R
     **/
    /*@PostMapping("/remove/batch")
    @ApiOperation("批量逻辑删除")
    public R removeBatch(@RequestBody List<Integer> ids) {
        if(targetService.updateBatchById(targetService.listByIds(ids).stream().peek(e ->e.setIsDelete(true)).collect(Collectors.toList()))){
            return R.ok();
        }else{
            return R.error();
        }
    }*/

    /**
     * @Author jinzelei
     * @Description  分页查询
     * @Date  2023-02-03 15:49:41
     * @Param
     * @return R
     **/
    @PostMapping("/page")
    @ApiOperation("分页查询")
    public R findPage(@RequestBody PageVo<BlogSysMenu> pageVo) {
        return R.ok(targetService.page(pageVo));
    }

    /**
     * @Author jinzelei
     * @Description 搜索接口
     * @Date  2023/2/16 09:35:31
     * @Param [blogSysMenu] 实体参数
     * @return com.jin.blog.sunset.base.response.R
     **/
    @PostMapping("/search")
    @ApiOperation("搜索接口")
    public R search(@RequestBody BlogSysMenu blogSysMenu) throws IllegalAccessException {
        return R.ok();
    }
}

