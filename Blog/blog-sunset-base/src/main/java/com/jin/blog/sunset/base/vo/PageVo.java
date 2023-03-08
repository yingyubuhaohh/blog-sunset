package com.jin.blog.sunset.base.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @Description 封装分页参数vo
 * @ClassName: PageVo
 * @author: jinzelei
 * @date: 2023/2/13 14:29
 **/
@Data
public class PageVo<T> implements Serializable {
    private Integer pageNum;
    private Integer pageSize;
    private HashMap<String,Object> params;
}
