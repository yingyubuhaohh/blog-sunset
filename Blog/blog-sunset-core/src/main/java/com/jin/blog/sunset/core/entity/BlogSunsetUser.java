package com.jin.blog.sunset.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 博客-用户表
 * </p>
 *
 * @author jinzelei
 * @since 2023-02-03 17:57:15
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("blog_sunset_user")
@ApiModel(value = "BlogSunsetUser对象", description = "博客-用户表")
public class BlogSunsetUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("用户名")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty("密码")
    @TableField("user_pwd")
    private String userPwd;

    @ApiModelProperty("是否禁用登录")
    @TableField("login_enable")
    private String loginEnable;

    @ApiModelProperty("登录失败次数")
    @TableField("login_error")
    private Integer loginError;

    @ApiModelProperty("最后登录时间")
    @TableField("login_last_time")
    private LocalDateTime loginLastTime;

    @ApiModelProperty("头像")
    @TableField("user_portrait")
    private String userPortrait;

    @ApiModelProperty("说明")
    @TableField("user_explain")
    private String userExplain;

    @ApiModelProperty("显示名称")
    @TableField("user_display_name")
    private String userDisplayName;

    @ApiModelProperty("邮箱")
    @TableField("user_email")
    private String userEmail;

    @ApiModelProperty("逻辑删除")
    @TableField("is_delete")
    private Integer isDelete;


}
