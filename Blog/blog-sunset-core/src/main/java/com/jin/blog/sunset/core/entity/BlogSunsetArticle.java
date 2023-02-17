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
 * 博客-文章
 * </p>
 *
 * @author jinzelei
 * @since 2023-02-17 11:01:55
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("blog_sunset_article")
@ApiModel(value = "BlogSunsetArticle对象", description = "博客-文章")
public class BlogSunsetArticle implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("用户id，外键")
    @TableField("user")
    private Integer user;

    @TableField("catalog")
    private Integer catalog;

    @ApiModelProperty("标题")
    @TableField("title")
    private String title;

    @ApiModelProperty("关键字")
    @TableField("keywords")
    private String keywords;

    @ApiModelProperty("描述")
    @TableField("description")
    private String description;

    @ApiModelProperty("内容")
    @TableField("content")
    private String content;

    @ApiModelProperty("点击量")
    @TableField("click_num")
    private Integer clickNum;

    @ApiModelProperty("点赞数")
    @TableField("like_num")
    private Integer likeNum;

    @ApiModelProperty("文章分类id")
    @TableField("category_id")
    private Integer categoryId;

    @ApiModelProperty("发表日期")
    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("是否删除")
    @TableField("is_delete")
    private Integer isDelete;

    @ApiModelProperty("是否置顶")
    @TableField("is_top")
    private Integer isTop;


}
