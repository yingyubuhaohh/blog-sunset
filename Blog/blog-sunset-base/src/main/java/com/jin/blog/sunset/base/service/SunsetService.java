package com.jin.blog.sunset.base.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jin.blog.sunset.base.vo.PageVo;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description 通用服务层方法接口
 * @ClassName: SunsetService
 * @author: jinzelei
 * @date: 2023/2/13 17:49
 **/
public interface SunsetService<T> extends IService<T>{

   @Transactional
   Page<T> searchObjs(T baseVo,PageVo pageVo) throws IllegalAccessException;

   @Transactional
   Page<T> page(PageVo pageVo);

}
