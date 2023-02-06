package com.jin.blog.sunset.system.handler;

import com.alibaba.fastjson.JSON;
import com.jin.blog.sunset.base.response.R;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author jinzelei
 * @Description  权限不足处理器
 * @Date  2023/2/6 14:29:24
 **/
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        //处理异常
        R result = new R(HttpStatus.FORBIDDEN.value(),"权限不足",null);
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
