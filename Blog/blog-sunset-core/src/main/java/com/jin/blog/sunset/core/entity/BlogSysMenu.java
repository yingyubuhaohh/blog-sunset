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
 * 博客-权限表
 * </p>
 *
 * @author jinzelei
 * @since 2023-02-17 11:01:56
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("blog_sys_menu")
@ApiModel(value = "BlogSysMenu对象", description = "博客-权限表")
public class BlogSysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("权限名称")
    @TableField("menu_name")
    private String menuName;

    @ApiModelProperty("描述")
    @TableField("menu_describe")
    private String menuDescribe;


}
