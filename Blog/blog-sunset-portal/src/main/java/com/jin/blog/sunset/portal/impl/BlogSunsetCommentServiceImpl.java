package com.jin.blog.sunset.portal.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jin.blog.sunset.base.impl.SunsetServiceImpl;
import com.jin.blog.sunset.base.vo.CommentVo;
import com.jin.blog.sunset.core.entity.BlogSunsetComment;
import com.jin.blog.sunset.core.mapper.BlogSunsetCommentMapper;
import com.jin.blog.sunset.portal.service.BlogSunsetCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 博客-评论表 服务实现类
 * </p>
 *
 * @author jinzelei
 * @since 2023-02-02 10:02:06
 */
@Service
public class BlogSunsetCommentServiceImpl extends SunsetServiceImpl<BlogSunsetCommentMapper, BlogSunsetComment> implements BlogSunsetCommentService {

    @Override
    public List<CommentVo> findArticleComment(Integer id) {
        QueryWrapper<BlogSunsetComment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("aid",id);
        queryWrapper.orderByDesc("date");
        // 数据库查询的所有评论
        List<BlogSunsetComment> blogSunsetComments = getBaseMapper().selectList(queryWrapper);
        // 返回前端的所有评论
        List<CommentVo> commentVos = blogSunsetComments.stream()
                // 设置所有有子节点的评论
                .map(comment->{
                    CommentVo commentVo = new CommentVo();
                    // 设置父节点
                    commentVo.setComment(comment);
                    commentVo.setChildComments(new ArrayList<>());
                    // 寻找子节点
                    blogSunsetComments.forEach((c)->{
                        // 寻找子评论并生成树
                        if(comment.getId() == c.getPid().longValue()){
                            // 设置子节点
                            commentVo.getChildComments().add(c);
                        }
                    });
                    return commentVo;
                })
                // 过滤不需要的结点
                .filter(vo-> vo.getComment() != null && vo.getComment().getPid() == 0)
                .collect(Collectors.toList());
        return commentVos;
    }
}
