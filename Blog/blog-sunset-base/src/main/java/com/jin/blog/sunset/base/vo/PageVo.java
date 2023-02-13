package com.jin.blog.sunset.base.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description 封装分页参数vo
 * @ClassName: PageVo
 * @author: jinzelei
 * @date: 2023/2/13 14:29
 **/
@Data
public class PageVo implements Serializable {
    private Integer pageNum;
    private Integer pageSize;
}
