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
 * 博客-角色权限表
 * </p>
 *
 * @author jinzelei
 * @since 2023-02-01 17:02:59
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("blog_sys_role_menu")
@ApiModel(value = "BlogSysRoleMenu对象", description = "博客-角色权限表")
public class BlogSysRoleMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("角色id")
    @TableField("role_id")
    private String roleId;

    @ApiModelProperty("权限id")
    @TableField("menu_id")
    private String menuId;


}
