package com.jin.blog.sunset.system.impl;

import com.jin.blog.sunset.core.entity.BlogSunsetTool;
import com.jin.blog.sunset.core.impl.business.SunsetServiceImpl;
import com.jin.blog.sunset.core.mapper.BlogSunsetToolMapper;
import com.jin.blog.sunset.system.service.BlogSunsetToolService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客-工具表 服务实现类
 * </p>
 *
 * @author jinzelei
 * @since 2023-02-02 10:02:23
 */
@Service
public class BlogSunsetToolServiceImpl extends SunsetServiceImpl<BlogSunsetToolMapper, BlogSunsetTool> implements BlogSunsetToolService {

}
