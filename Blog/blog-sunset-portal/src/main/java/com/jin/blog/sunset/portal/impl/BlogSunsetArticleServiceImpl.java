package com.jin.blog.sunset.portal.impl;

import com.jin.blog.sunset.base.impl.SunsetServiceImpl;
import com.jin.blog.sunset.core.entity.BlogSunsetArticle;
import com.jin.blog.sunset.core.mapper.BlogSunsetArticleMapper;
import com.jin.blog.sunset.portal.service.BlogSunsetArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客-文章 服务实现类
 * </p>
 *
 * @author jinzelei
 * @since 2023-02-02 10:02:06
 */
@Service
public class BlogSunsetArticleServiceImpl extends SunsetServiceImpl<BlogSunsetArticleMapper, BlogSunsetArticle> implements BlogSunsetArticleService {

}
