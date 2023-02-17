package com.jin.blog.sunset.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 博客-评论表
 * </p>
 *
 * @author jinzelei
 * @since 2023-02-17 11:01:56
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("blog_sunset_comment")
@ApiModel(value = "BlogSunsetComment对象", description = "博客-评论表")
public class BlogSunsetComment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("主键id")
    @TableField("cmtid")
    private Integer cmtid;

    @ApiModelProperty("评论用户id 关联oauth_user表的id")
    @TableField("ouid")
    private Integer ouid;

    @ApiModelProperty("1：文章评论 2：留言")
    @TableField("type")
    private Integer type;

    @ApiModelProperty("父级id")
    @TableField("pid")
    private Integer pid;

    @ApiModelProperty("文章id")
    @TableField("aid")
    private Integer aid;

    @ApiModelProperty("内容")
    @TableField("content")
    private String content;

    @ApiModelProperty("评论日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @TableField("date")
    private Date date;

    @ApiModelProperty("1:已审核 0：未审核")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("是否删除")
    @TableField("is_delete")
    private Integer isDelete;

    @ApiModelProperty("点赞数")
    @TableField("like_num")
    private Integer likeNum;

    @ApiModelProperty("讨厌数")
    @TableField("dislike_num")
    private Integer dislikeNum;


}
