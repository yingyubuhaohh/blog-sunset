package com.jin.blog.sunset.base.strategy;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @Description 比较
 * @ClassName: EqConcreteStrategy
 * @author: jinzelei
 * @date: 2023/3/8 9:18
 **/
@Component("eq")
public class EqConcreteStrategy implements Strategy{
    @Override
    public void strategyMethod(String key, String value, QueryWrapper queryWrapper) {
        queryWrapper.eq(key,value);
    }
}
