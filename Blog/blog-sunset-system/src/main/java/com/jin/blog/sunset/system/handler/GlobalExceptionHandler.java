package com.jin.blog.sunset.system.handler;

import com.jin.blog.sunset.base.response.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author songhengyu
 * @Date 2023 02 16 14 22
 *
 * 全局异常处理
 *
 * 编写阶段可以先将下面注解注释，出现报错信息，方便定位到错误
 * @ControllerAdvice
 * @ResponseBody
 *
 * 项目上线在开启这两个注解
 *
 **/
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)  //针对全部异常
    public R exceptionHandler(HttpServletRequest request, Exception e){
        log.error("全局异常:"+e.getMessage());
        return R.error("服务端异常，请联系管理员");
    }

}
