package com.jin.blog.sunset.core.vo;

import lombok.Data;

/**
 * @Description 登录Vo
 * @ClassName: LoginVo
 * @author: jinzelei
 * @date: 2023/2/7 11:08
 **/
@Data
public class LoginVo {
    private String username;
    private String password;
    private String captcha;
}
