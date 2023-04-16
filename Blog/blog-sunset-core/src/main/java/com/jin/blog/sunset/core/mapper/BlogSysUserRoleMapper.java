package com.jin.blog.sunset.core.mapper;

import com.jin.blog.sunset.core.entity.BlogSysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 博客-用户角色表 Mapper 接口
 * </p>
 *
 * @author jinzelei
 * @since 2023-03-08 14:53:56
 */
@Mapper
@CacheNamespace
public interface BlogSysUserRoleMapper extends BaseMapper<BlogSysUserRole> {

}
