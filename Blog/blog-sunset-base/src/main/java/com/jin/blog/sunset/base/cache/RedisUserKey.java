package com.jin.blog.sunset.base.cache;

/**
 * @Author songhengyu
 * @Date 2023 02 10 17 13
 * 用户相关Redis的Key静态名称
 **/
public class RedisUserKey {
    public static final String getUserId(String id){
         return String.format("UserId-%s",id);
    }
}
