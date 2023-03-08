package com.jin.blog.sunset.base.strategy;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Description 升序
 * @ClassName: AscConcreteStrategy
 * @author: jinzelei
 * @date: 2023/3/7 11:41
 **/
@Component("asc")
public class AscConcreteStrategy implements Strategy{
    @Override
    public void strategyMethod(String key, String value, QueryWrapper queryWrapper) {
        queryWrapper.orderByAsc(key);
    }
}
