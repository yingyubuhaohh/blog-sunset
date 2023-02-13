package com.jin.blog.sunset.base.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description 登录成功返回用户信息Vo
 * @ClassName: InfoVo
 * @author: jinzelei
 * @date: 2023/2/7 11:25
 **/
@Data
public class InfoVo implements Serializable {
    private Long id;
    private String token;
    private String avatar;
    private String name;
    private List<String> roles;
}
