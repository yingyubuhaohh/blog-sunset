package com.jin.blog.sunset.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 博客-分类表
 * </p>
 *
 * @author jinzelei
 * @since 2023-02-17 11:01:55
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("blog_sunset_category")
@ApiModel(value = "BlogSunsetCategory对象", description = "博客-分类表")
public class BlogSunsetCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("分类名称")
    @TableField("category_name")
    private String categoryName;

    @ApiModelProperty("描述")
    @TableField("category_describe")
    private String categoryDescribe;

    @ApiModelProperty("逻辑删除")
    @TableField("is_delete")
    private Integer isDelete;


}
