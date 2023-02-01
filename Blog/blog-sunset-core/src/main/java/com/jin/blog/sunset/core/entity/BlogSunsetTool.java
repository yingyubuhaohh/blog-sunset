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
 * 博客-工具表
 * </p>
 *
 * @author jinzelei
 * @since 2023-02-01 17:02:59
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("blog_sunset_tool")
@ApiModel(value = "BlogSunsetTool对象", description = "博客-工具表")
public class BlogSunsetTool implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("tool_id")
    private Integer toolId;

    @ApiModelProperty("工具图标")
    @TableField("tool_icon")
    private String toolIcon;

    @ApiModelProperty("工具名称")
    @TableField("tool_name")
    private String toolName;

    @ApiModelProperty("排序")
    @TableField("tool_sort")
    private Integer toolSort;

    @ApiModelProperty("打开方式")
    @TableField("tool_target")
    private String toolTarget;

    @ApiModelProperty("工具路径")
    @TableField("tool_url")
    private String toolUrl;

    @ApiModelProperty("逻辑删除")
    @TableField("is_delete")
    private Boolean delete;


}
