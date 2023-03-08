package com.jin.blog.sunset.base.strategy;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.io.Serializable;

/**
 * @Description 策略模式 策略接口
 * @ClassName: Strategy
 * @author: jinzelei
 * @date: 2023/3/7 11:24
 **/
public interface Strategy {

    // 策略方法
    void strategyMethod(String key, String value, QueryWrapper queryWrapper);

}
