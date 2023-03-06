package com.jin.blog.sunset.base.vo;

import com.jin.blog.sunset.core.entity.BlogSunsetComment;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description 文章评论Vo
 * @ClassName: CommentVo
 * @author: jinzelei
 * @date: 2023/3/1 15:49
 **/
@Data
public class CommentVo implements Serializable {
    BlogSunsetComment comment;
    List<BlogSunsetComment> childComments;
}
