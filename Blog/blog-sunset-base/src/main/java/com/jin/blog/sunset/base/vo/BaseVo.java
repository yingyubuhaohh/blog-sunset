package com.jin.blog.sunset.base.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description 通用实体类
 * @ClassName: BaseVo
 * @author: jinzelei
 * @date: 2023/2/13 17:56
 **/
@Data
public class BaseVo<T> implements Serializable {
    private T entity;
}
