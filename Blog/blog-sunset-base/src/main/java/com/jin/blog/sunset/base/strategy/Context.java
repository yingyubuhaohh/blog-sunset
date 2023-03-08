package com.jin.blog.sunset.base.strategy;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 一个放策略的map
 * @ClassName: Context
 * @author: jinzelei
 * @date: 2023/3/7 11:37
 **/
@Component
public class Context {

    @Autowired
    private Map<String,Strategy> map;

    // 初始化map对象
    /*static{
        map.put("eq",new EqConcreteStrategy());
        map.put("like",new LikeConcreteStrategy());
        map.put("desc",new DescConcreteStrategy());
        map.put("asc",new AscConcreteStrategy());
    }*/

    public void useStrategy(String[] strings, String value, QueryWrapper queryWrapper){
        if (strings.length == 1){
            map.get("eq").strategyMethod(strings[0],value,queryWrapper);
            return;
        }

        // 进行map遍历，找到对应策略
        for(String key : map.keySet()){
            if(key.equalsIgnoreCase(strings[1])){
                map.get(key).strategyMethod(strings[0],value,queryWrapper);
            }
        }

    }

}
