package com.jin.blog.sunset.system.filter;

import com.jin.blog.sunset.system.utils.JwtTokenUtil;
import com.jin.blog.sunset.system.utils.LoginUser;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * Jwt认证过滤器
 * OncePerRequestFilter只会经过一次
 */
@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        //获取Token
        String token = httpServletRequest.getHeader("token");
        if(!StringUtils.hasText(token)){
            filterChain.doFilter(httpServletRequest,httpServletResponse);
            return ;
        }
        // TODO token存入redis
        redisTemplate.opsForValue().set("username",JwtTokenUtil.getUsername(token));
        //解析Token
        Claims claims = JwtTokenUtil.checkJWT(token);
        String userid = claims.get("username",String.class);
        //TODO 将用户信息存入redis
        String redisKey = "user"+userid;
        LoginUser user = (LoginUser) redisTemplate.opsForValue().get(redisKey);
        if(Objects.isNull(user)){
            throw new RuntimeException("用户未登录");
        }
        //存入SecurityContextHolder
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //放行
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
