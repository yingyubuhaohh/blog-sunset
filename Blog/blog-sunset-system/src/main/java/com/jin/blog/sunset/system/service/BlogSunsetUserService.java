package com.jin.blog.sunset.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jin.blog.sunset.base.response.R;
import com.jin.blog.sunset.core.entity.BlogSunsetUser;

/**
 * <p>
 * 博客-用户表 服务类
 * </p>
 *
 * @author jinzelei
 * @since 2023-02-02 10:02:23
 */
public interface BlogSunsetUserService extends IService<BlogSunsetUser> {

    R login(String username,String password);

}
