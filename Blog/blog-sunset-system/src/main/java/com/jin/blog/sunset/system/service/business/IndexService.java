package com.jin.blog.sunset.system.service.business;

import com.jin.blog.sunset.base.response.R;

import java.util.List;

/**
 * @Description 后台首页服务类
 * @ClassName: IndexService
 * @author: jinzelei
 * @date: 2023/2/20 9:12
 **/
public interface IndexService {
    // 博客数 评论数 浏览量 用户数
    R count();
}
