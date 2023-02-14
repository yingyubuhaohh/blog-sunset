package com.jin.blog.sunset.system.service;

import com.jin.blog.sunset.base.response.R;
import com.jin.blog.sunset.core.entity.BlogSunsetUser;
import com.jin.blog.sunset.base.vo.LoginVo;
import com.jin.blog.sunset.base.service.SunsetService;

/**
 * <p>
 * 博客-用户表 服务类
 * </p>
 *
 * @author jinzelei
 * @since 2023-02-02 10:02:23
 */
public interface BlogSunsetUserService extends SunsetService<BlogSunsetUser> {

    R login(LoginVo loginVo);

    R info(String token);

    R logout(String token);

}
