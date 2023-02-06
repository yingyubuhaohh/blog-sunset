package com.jin.blog.sunset.system.impl;

import com.jin.blog.sunset.base.response.R;
import com.jin.blog.sunset.core.entity.BlogSunsetUser;
import com.jin.blog.sunset.core.mapper.BlogSunsetUserMapper;
import com.jin.blog.sunset.system.service.BlogSunsetUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jin.blog.sunset.system.utils.JwtTokenUtil;
import com.jin.blog.sunset.system.utils.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * 博客-用户表 服务实现类
 * </p>
 *
 * @author jinzelei
 * @since 2023-02-02 10:02:23
 */
@Service
public class BlogSunsetUserServiceImpl extends ServiceImpl<BlogSunsetUserMapper, BlogSunsetUser> implements BlogSunsetUserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * @Author jinzelei
     * @Description  登录接口实现类
     * @Date  2023/2/6 14:24:36
     * @Param username 用户名 password 密码
     * @return R
     **/
    @Override
    public R login(String username, String password) {
        //进行认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //未通过处理情况
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("登录失败");
        }
        //通过后生成Token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userid = loginUser.getUser().getId().toString();
        String token = JwtTokenUtil.createToken(userid,null);
        Map<String,String> map = new HashMap<>();
        map.put("token",token);
        //TODO 存入redis
        //redisTemplate.opsForValue().set("user"+userid,loginUser);
        return new R(200,"登陆成功",map);
    }
}
