package com.jin.blog.sunset.system.impl;

import com.jin.blog.sunset.core.entity.BlogSunsetUser;
import com.jin.blog.sunset.core.mapper.business.BlogSunsetLoginMapper;
import com.jin.blog.sunset.system.utils.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @Author jinzelei
 * @Description  权限认证用户服务接口
 * @Date  2023/2/6 09:48:40
 **/
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private BlogSunsetLoginMapper blogSunsetLoginMapper;

    /**
     * @Author jinzelei
     * @Description  根据用户名查询用户
     * @Date  2023/2/6 10:50:10
     * @Param
     * @return
     **/
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //查询响应的用户
        BlogSunsetUser blogUser = blogSunsetLoginMapper.selectUserByUsername(s);
        if(Objects.isNull(blogUser)){
            throw new RuntimeException("用户名或密码错误");
        }
        //TODO 查询用户的权限
        //List<String> list = new ArrayList<>(Arrays.asList("test","admin"));
        List<String> list = blogSunsetLoginMapper.selectPermsByUserId(blogUser.getId());
        //封装UserDetails对象
        return new LoginUser(blogUser,list);
    }

}
