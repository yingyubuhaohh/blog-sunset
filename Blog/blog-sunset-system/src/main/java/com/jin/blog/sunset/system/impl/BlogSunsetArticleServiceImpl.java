package com.jin.blog.sunset.system.impl;

import com.jin.blog.sunset.core.entity.BlogSunsetArticle;
import com.jin.blog.sunset.core.impl.business.SunsetServiceImpl;
import com.jin.blog.sunset.core.mapper.BlogSunsetArticleMapper;
import com.jin.blog.sunset.system.service.BlogSunsetArticleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客-文章 服务实现类
 * </p>
 *
 * @author jinzelei
 * @since 2023-02-02 10:02:23
 */
@Service
public class BlogSunsetArticleServiceImpl extends SunsetServiceImpl<BlogSunsetArticleMapper, BlogSunsetArticle> implements BlogSunsetArticleService {

}
