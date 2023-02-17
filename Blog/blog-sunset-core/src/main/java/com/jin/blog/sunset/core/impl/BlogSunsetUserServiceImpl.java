package com.jin.blog.sunset.core.impl;

import com.jin.blog.sunset.core.entity.BlogSunsetUser;
import com.jin.blog.sunset.core.mapper.BlogSunsetUserMapper;
import com.jin.blog.sunset.core.service.BlogSunsetUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客-用户表 服务实现类
 * </p>
 *
 * @author jinzelei
 * @since 2023-02-17 11:01:56
 */
@Service
public class BlogSunsetUserServiceImpl extends ServiceImpl<BlogSunsetUserMapper, BlogSunsetUser> implements BlogSunsetUserService {

}
