package com.jin.blog.sunset.base.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.CaseFormat;
import com.jin.blog.sunset.base.service.SunsetService;
import com.jin.blog.sunset.base.vo.PageVo;
import com.jin.blog.sunset.core.entity.BlogSunsetArticle;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 通用服务层方法实现类
 * @ClassName: SunsetServiceImpl
 * @author: jinzelei
 * @date: 2023/2/14 9:08
 **/
public class SunsetServiceImpl<M extends BaseMapper<T>,T> extends ServiceImpl<M,T> implements SunsetService<T> {

    /**
     * @Author jinzelei
     * @Description  通用搜索方法
     * @Date  2023/2/14 14:31:15
     * @Param T 实体参数
     * @return List 结果链表
     **/
    @Override
    public List<T> searchObjs(T entity) throws IllegalAccessException {
        // 将对象转化为map
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if(field.get(entity) != null){
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
        return this.getBaseMapper().selectList(queryWrapper);
    }

    @Override
    public Page<T> page(PageVo pageVo) {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("id");
        getBaseMapper().selectObjs(queryWrapper);
        return getBaseMapper().selectPage(new Page<>(pageVo.getPageNum(), pageVo.getPageSize()), queryWrapper);

    }


}
