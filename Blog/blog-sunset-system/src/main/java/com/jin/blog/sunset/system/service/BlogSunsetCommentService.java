package com.jin.blog.sunset.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jin.blog.sunset.base.vo.PageVo;
import com.jin.blog.sunset.core.entity.BlogSunsetComment;
import com.jin.blog.sunset.base.service.SunsetService;

/**
 * <p>
 * 博客-评论表 服务类
 * </p>
 *
 * @author jinzelei
 * @since 2023-02-02 10:02:23
 */
public interface BlogSunsetCommentService extends SunsetService<BlogSunsetComment> {

    Page<BlogSunsetComment> typePage(PageVo pageVo , String type);

}
