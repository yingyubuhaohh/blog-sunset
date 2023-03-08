package com.jin.blog.sunset.base.strategy;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.io.Serializable;

/**
 * @Description 降序
 * @ClassName: DescConcreteStrategy
 * @author: jinzelei
 * @date: 2023/3/7 11:42
 **/
public class DescConcreteStrategy implements Strategy{

    @Override
    public void strategyMethod(String key, String value, QueryWrapper queryWrapper) {
        queryWrapper.orderByDesc(key);
    }
}
