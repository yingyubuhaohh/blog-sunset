package com.jin.blog.sunset.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jin.blog.sunset.base.vo.PageVo;
import com.jin.blog.sunset.core.entity.BlogSunsetComment;
import com.jin.blog.sunset.base.impl.SunsetServiceImpl;
import com.jin.blog.sunset.core.mapper.BlogSunsetCommentMapper;
import com.jin.blog.sunset.system.service.BlogSunsetCommentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 博客-评论表 服务实现类
 * </p>
 *
 * @author jinzelei
 * @since 2023-02-02 10:02:23
 */
@Service
public class BlogSunsetCommentServiceImpl extends SunsetServiceImpl<BlogSunsetCommentMapper, BlogSunsetComment> implements BlogSunsetCommentService {

    @Override
    public Page<BlogSunsetComment> typePage(PageVo pageVo, String type) {
        QueryWrapper<BlogSunsetComment> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("id");
        queryWrapper.eq("type",type);
        queryWrapper.eq("is_delete",0);
        return getBaseMapper().selectPage(new Page<>(pageVo.getPageNum(),pageVo.getPageSize()),queryWrapper);
    }
}
