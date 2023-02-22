package com.jin.blog.sunset.base.vo;

import lombok.Data;

/**
 * @Description 博客数 评论数 浏览量 用户数
 * @ClassName: IndexVo
 * @author: jinzelei
 * @date: 2023/2/20 10:11
 **/
@Data
public class IndexVo {
    // 博客数
    private Long blogNum;
    // 评论数
    private Long commentNum;
    // 浏览量
    private Long browseNum;
    // 用户数
    private Long userNum;
}
