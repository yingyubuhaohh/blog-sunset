package com.jin.blog.sunset.core.vo;

import lombok.Data;

/**
 * @Description 登录成功返回用户信息Vo
 * @ClassName: InfoVo
 * @author: jinzelei
 * @date: 2023/2/7 11:25
 **/
@Data
public class InfoVo {
    private String token;
    private String avatar;
    private String name;
}
