package com.jin.blog.sunset.system.handler;

import com.alibaba.fastjson.JSON;
import com.jin.blog.sunset.base.response.R;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author jinzelei
 * @Description  注销成功处理器
 * @Date  2023/2/6 14:28:15
 **/
@Component
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //注销成功处理
        R result = new R(20000,"注销成功",null);
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
