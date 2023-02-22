package com.jin.blog.sunset.core.mapper.business;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jin.blog.sunset.core.entity.BlogSunsetUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description 用户登录dao层
 * @ClassName: BlogSunsetLoginMapper
 * @author: jinzelei
 * @date: 2023/2/6 10:42
 **/
@Mapper
public interface BlogSunsetLoginMapper extends BaseMapper<BlogSunsetUser> {

    @Select("select * from blog_sunset_user where user_name = #{username}")
    BlogSunsetUser selectUserByUsername(String username);

    @Select("SELECT\n" +
            "\trole_name \n" +
            "FROM\n" +
            "\tblog_sys_user_role ur\n" +
            "\tLEFT JOIN blog_sys_role r ON ur.role_id = r.id \n" +
            "WHERE\n" +
            "\tuser_id = #{id}")
    List<String> selectPermsByUserId(Long id);

}
