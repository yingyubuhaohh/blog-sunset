package com.jin.blog.sunset.base.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.CaseFormat;
import com.jin.blog.sunset.base.service.SunsetService;
import com.jin.blog.sunset.base.strategy.Context;
import com.jin.blog.sunset.base.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 通用服务层方法实现类
 * @ClassName: SunsetServiceImpl
 * @author: jinzelei
 * @date: 2023/2/14 9:08
 **/
public class SunsetServiceImpl<M extends BaseMapper<T>,T> extends ServiceImpl<M,T> implements SunsetService<T> {

    @Autowired
    private Context context;

    /**
     * @Author jinzelei
     * @Description  通用搜索方法
     * @Date  2023/2/14 14:31:15
     * @Param T 实体参数
     * @return List 结果链表
     **/
    @Override
    public Page<T> searchObjs(T entity,PageVo pageVo) throws IllegalAccessException {
        // 将对象转化为map
        Map<String, Object> map = new HashMap<>();
        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            // 去除value为空的键值对
            if(ObjectUtils.isNotEmpty(field.get(entity))){
                map.put(field.getName(), field.get(entity));
            }
        }
        // 创建wrapper
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        for(String key: map.keySet()){
            if(!"serialVersionUID".equals(key)){
                // 字符串驼峰转下划线
                String column = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, key);
                queryWrapper.like(column,map.get(key));
            }
        }
        return this.getBaseMapper().selectPage(new Page<>(pageVo.getPageNum(), pageVo.getPageSize()),queryWrapper);
    }


    /**
     * @Author jinzelei
     * @Description  分页搜索功能
     * @Date  2023/2/16 10:39:05
     * @Param [pageVo]
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<T>
     **/
    @Override
    public Page<T> page(PageVo pageVo) {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_delete",0);
        // 将对象转化为map
        Map<String, Object> map = pageVo.getParams();
        /*Field[] fields = pageVo.getParams().getClass().getFields();
        for (Field field : fields) {
            field.setAccessible(true);
            // 去除value为空的键值对
            try {
                if(ObjectUtils.isNotEmpty(field.get(pageVo.getParams()))){
                    map.put(field.getName(), field.get(pageVo.getParams()));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }*/
        // 创建wrapper
        for(String key: map.keySet()){
            // 排除serialVersionUID属性
            if(!"serialVersionUID".equals(key)){
                // 将字符串分割
                String[] strings = key.split("_");
                // 字符串驼峰转下划线
                strings[0] = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, strings[0]);
                // 判断后缀
                // 方式一 if else
                /*if(strings.length == 1){
                    queryWrapper.eq(column,map.get(key));
                }else if("like".equalsIgnoreCase(strings[1])){
                    queryWrapper.like(column,map.get(key));
                }else if("asc".equalsIgnoreCase(strings[1])){
                    queryWrapper.orderByAsc(column);
                }else if("desc".equalsIgnoreCase(strings[1])){
                    queryWrapper.orderByDesc(column);
                }*/
                // 方式二 策略模式
                context.useStrategy(strings,map.get(key).toString(),queryWrapper);
            }
        }
        return getBaseMapper().selectPage(new Page<>(pageVo.getPageNum(), pageVo.getPageSize()), queryWrapper);
    }


}
