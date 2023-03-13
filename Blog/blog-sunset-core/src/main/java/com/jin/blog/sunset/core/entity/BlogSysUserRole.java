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
 * 博客-用户角色表
 * </p>
 *
 * @author jinzelei
 * @since 2023-03-08 14:53:56
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("blog_sys_user_role")
@ApiModel(value = "BlogSysUserRole对象", description = "博客-用户角色表")
public class BlogSysUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("用户id")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty("角色id")
    @TableField("role_id")
    private String roleId;


}
