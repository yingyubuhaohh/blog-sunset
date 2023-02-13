package com.jin.blog.sunset.system.impl;

import com.jin.blog.sunset.base.cache.RedisService;
import com.jin.blog.sunset.base.cache.RedisUserKey;
import com.jin.blog.sunset.base.response.R;
import com.jin.blog.sunset.core.entity.BlogSunsetUser;
import com.jin.blog.sunset.core.mapper.BlogSunsetUserMapper;
import com.jin.blog.sunset.core.vo.InfoVo;
import com.jin.blog.sunset.core.vo.LoginVo;
import com.jin.blog.sunset.system.service.BlogSunsetUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jin.blog.sunset.system.utils.JwtTokenUtil;
import com.jin.blog.sunset.system.utils.LoginUser;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

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


    @Autowired
    RedisService redisService;

    /**
     * @Author jinzelei
     * @Description  登录接口实现类
     * @Date  2023/2/6 14:24:36
     * @Param username 用户名 password 密码
     * @return R
     **/
    @Override
    public R login(LoginVo loginVo) {
        //进行认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginVo.getUsername(),loginVo.getPassword());
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
        //获得对应的Key
        String key = RedisUserKey.getUserId(userid);
        //存入redis中
        redisService.setCache(key,loginUser);

        return new R(200,"登陆成功",map);
    }

    /**
     * @Author songhengyu
     * @Description  登出实现类
     * @Date  2023/2/6 14:24:36
     **/
    public R logout(String token){
        Claims claims = JwtTokenUtil.checkJWT(token);
        String id = claims.getId();
        String key = RedisUserKey.getUserId(id);
        Boolean cache = redisService.removeCache(key);
        if (cache){
            return new R(200,"登陆成功",null);
        }else {
            return new R(200,"网络错误",null);
        }
    }

    @Override
    public R info(String token) {
        //获取SecurityContextHolder中的用户id
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Collection<? extends GrantedAuthority> authorities = loginUser.getAuthorities();
        String avatar = loginUser.getUser().getUserPortrait();
        String name = loginUser.getUser().getUserName();
        Long id = loginUser.getUser().getId();
        InfoVo infoVo = new InfoVo();
        infoVo.setId(id);
        infoVo.setName(name);
        infoVo.setAvatar(avatar);
        infoVo.setRoles(loginUser.getPermissions());
        //TODO 从redis获取id，查询数据库获取用户信息

        return new R(200,"登陆成功",infoVo);
    }
}
