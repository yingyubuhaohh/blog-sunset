package com.jin.blog.sunset.system.impl.business;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jin.blog.sunset.base.response.R;
import com.jin.blog.sunset.base.vo.IndexVo;
import com.jin.blog.sunset.core.entity.BlogSunsetArticle;
import com.jin.blog.sunset.core.entity.BlogSunsetComment;
import com.jin.blog.sunset.core.entity.BlogSunsetUser;
import com.jin.blog.sunset.system.service.BlogSunsetArticleService;
import com.jin.blog.sunset.system.service.BlogSunsetCommentService;
import com.jin.blog.sunset.system.service.BlogSunsetUserService;
import com.jin.blog.sunset.system.service.business.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description 后台首页 - 业务实现类
 * @ClassName: IndexServiceImpl
 * @author: jinzelei
 * @date: 2023/2/20 9:14
 **/
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private BlogSunsetArticleService blogSunsetArticleService;

    @Autowired
    private BlogSunsetCommentService blogSunsetCommentService;

    @Autowired
    private BlogSunsetUserService blogSunsetUserService;

    /**
     * @Author jinzelei
     * @Description  博客数 评论数 浏览量 用户数
     * @Date  2023/2/20 09:38:18
     * @Param
     * @return java.util.List<java.lang.Integer>
     **/
    @Override
    public R count() {
        IndexVo indexVo = new IndexVo();
        // SQL语句 SELECT   SUM(click_num) as browse_num,COUNT(*) as blog_num   FROM blog_sunset_article
        QueryWrapper<BlogSunsetArticle> blogWrapper = new QueryWrapper();
        blogWrapper.select("SUM(click_num) as browseNum , COUNT(*) as blogNum");
        Map<String, Object> map = blogSunsetArticleService.getMap(blogWrapper);
        // 赋值 博客数 浏览量
        BigDecimal browseNum = (BigDecimal)map.get("browseNum");
        indexVo.setBrowseNum(browseNum.longValue());
        indexVo.setBlogNum((Long)map.get("blogNum"));

        // SELECT   COUNT(*) as comment_num   FROM blog_sunset_comment
        QueryWrapper<BlogSunsetComment> commentWrapper = new QueryWrapper();
        commentWrapper.select("COUNT(*) as commentNum");
        Map<String, Object> commentNum = blogSunsetCommentService.getMap(commentWrapper);
        // 赋值 评论数
        indexVo.setCommentNum((Long) commentNum.get("commentNum"));

        // SELECT   COUNT(*) as userNum   FROM blog_sunset_user
        QueryWrapper<BlogSunsetUser> userWrapper = new QueryWrapper();
        userWrapper.select("COUNT(*) as userNum");
        Map<String, Object> userNum = blogSunsetUserService.getMap(userWrapper);
        // 赋值 用户数
        indexVo.setUserNum((Long)userNum.get("userNum"));

        return R.ok(indexVo);
    }
}
