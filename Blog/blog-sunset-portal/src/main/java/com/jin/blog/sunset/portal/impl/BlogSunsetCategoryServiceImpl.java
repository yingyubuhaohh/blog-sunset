package com.jin.blog.sunset.portal.impl;

import com.jin.blog.sunset.base.impl.SunsetServiceImpl;
import com.jin.blog.sunset.core.entity.BlogSunsetCategory;
import com.jin.blog.sunset.core.mapper.BlogSunsetCategoryMapper;
import com.jin.blog.sunset.portal.service.BlogSunsetCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客-分类表 服务实现类
 * </p>
 *
 * @author jinzelei
 * @since 2023-02-02 10:02:06
 */
@Service
public class BlogSunsetCategoryServiceImpl extends SunsetServiceImpl<BlogSunsetCategoryMapper, BlogSunsetCategory> implements BlogSunsetCategoryService {

}
