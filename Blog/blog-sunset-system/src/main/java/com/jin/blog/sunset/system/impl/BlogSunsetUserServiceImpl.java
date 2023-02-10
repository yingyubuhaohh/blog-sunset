package com.jin.blog.sunset.system.impl;

import com.jin.blog.sunset.base.response.R;
import com.jin.blog.sunset.core.entity.BlogSunsetUser;
import com.jin.blog.sunset.core.mapper.BlogSunsetUserMapper;
import com.jin.blog.sunset.core.vo.InfoVo;
import com.jin.blog.sunset.core.vo.LoginVo;
import com.jin.blog.sunset.system.service.BlogSunsetUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jin.blog.sunset.system.utils.JwtTokenUtil;
import com.jin.blog.sunset.system.utils.LoginUser;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * 博客-用户表 服务实现类
 * </p>
 *
 * @author jinzelei
 * @since 2023-02-02 10:02:23
 */
@Service
public class BlogSunsetUserServiceImpl extends ServiceImpl<BlogSunsetUserMapper, BlogSunsetUser> implements BlogSunsetUserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * @Author jinzelei
     * @Description  登录接口实现类
     * @Date  2023/2/6 14:24:36
     * @Param username 用户名 password 密码
     * @return R
     **/
    @Override
    public R login(LoginVo loginVo) {
        //进行认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginVo.getUsername(),loginVo.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //未通过处理情况
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("登录失败");
        }
        //通过后生成Token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userid = loginUser.getUser().getId().toString();
        String token = JwtTokenUtil.createToken(userid,null);
        Map<String,String> map = new HashMap<>();
        map.put("token",token);
        //TODO 存入redis
        redisTemplate.opsForValue().set("user"+userid,loginUser);
        return new R(200,"登陆成功",map);
    }

    @Override
    public R info(InfoVo infoVo) {
        // 从redis中取得用户
        // 1、解析Token获得key
        Claims claims = JwtTokenUtil.checkJWT(infoVo.getToken());
        String userid = claims.get("username",String.class);
        System.out.println("**********" + claims + "**********" + userid);
        try{
            // 2、从redis获取用户
            LoginUser loginUser = (LoginUser) redisTemplate.opsForValue().get("user" + userid);

            // TODO 正式部署时修改为动态获取
            // 3、返回用户信息
            // infoVo.setAvatar(loginUser.getUser().getUserPortrait());
            // infoVo.setName(loginUser.getUser().getUserDisplayName());
            infoVo.setAvatar("http://localhost:8080/file/158bb9b19a604df5b2c750d214b7a084.jpeg");
            infoVo.setName("管理员");
            System.out.println("***********"+infoVo.toString());
            return R.ok(infoVo);
        }catch (Exception e){
            e.printStackTrace();
        }
        // TODO 通过认证方式获取用户

        // TODO 通过token中name获取用户

        return R.ok("没有用户信息");
    }
}
