package com.jin.blog.sunset.base.strategy;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.io.Serializable;

/**
 * @Description like子句
 * @ClassName: LikeConcreteStrategy
 * @author: jinzelei
 * @date: 2023/3/7 11:40
 **/
public class LikeConcreteStrategy implements Strategy{
    @Override
    public void strategyMethod(String key, String value, QueryWrapper queryWrapper) {
        queryWrapper.like(key,value);
    }
}
