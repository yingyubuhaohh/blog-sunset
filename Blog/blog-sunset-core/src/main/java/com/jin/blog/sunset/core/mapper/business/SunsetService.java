package com.jin.blog.sunset.core.mapper.business;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jin.blog.sunset.base.vo.BaseVo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @Description 通用服务层方法接口
 * @ClassName: SunsetService
 * @author: jinzelei
 * @date: 2023/2/13 17:49
 **/
public interface SunsetService<T> extends IService<T>{

   List<T> searchObjs(T baseVo) throws IllegalAccessException;

}
