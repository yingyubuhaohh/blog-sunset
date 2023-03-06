package com.jin.blog.sunset.portal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jin.blog.sunset.base.service.SunsetService;
import com.jin.blog.sunset.base.vo.CommentVo;
import com.jin.blog.sunset.core.entity.BlogSunsetComment;

import java.util.List;

/**
 * <p>
 * 博客-评论表 服务类
 * </p>
 *
 * @author jinzelei
 * @since 2023-02-02 10:02:06
 */
public interface BlogSunsetCommentService extends SunsetService<BlogSunsetComment> {
    /**
     * @Author jinzelei
     * @Description  根据文章ID查询评论
     * @Date  2023/3/1 15:45:40
     * @Param id 文章id
     * @return list 评论列表
     **/
    List<CommentVo> findArticleComment(Integer id);
}
