package com.jin.blog.sunset.system.handler;

import com.alibaba.fastjson.JSON;
import com.jin.blog.sunset.base.response.R;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author jinzelei
 * @Description  认证失败处理器
 * @Date  2023/2/6 14:28:56
 **/
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        //处理异常
        R result = new R(HttpStatus.UNAUTHORIZED.value(),"用户认证失败",null);
        String str = JSON.toJSONString(result);
        try {
            httpServletResponse.setStatus(200);
            httpServletResponse.setContentType("application/json");
            httpServletResponse.setCharacterEncoding("utf-8");
            httpServletResponse.getWriter().print(str);
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }
}
