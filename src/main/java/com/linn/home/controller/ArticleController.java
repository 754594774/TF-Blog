package com.linn.home.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.linn.frame.controller.BaseController;
import com.linn.frame.util.DateUtils;
import com.linn.home.entity.Archive;
import com.linn.home.entity.Article;
import com.linn.home.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/1/14.
 */
@Controller
public class ArticleController extends BaseController {

    @Resource
    private ArticleService articleService;

    /**
     * 跳转到文章列表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("toArticleList")
    public List<Article> toArticleList(@RequestBody Map<String, String> map) throws Exception {
        List<Article> articles = null;
        if(map.containsKey("categoryId") && !StringUtils.isEmpty(map.get("categoryId"))){
            Integer categoryId = Integer.parseInt(map.get("categoryId"));
            articles = articleService.selectArticleByCategoryId(categoryId);
        }
        if(map.containsKey("date") && !StringUtils.isEmpty(map.get("date")) ){
            String date = map.get("date");
            Date firstDay = DateUtils.firstDayByMonth(date);
            Date lastDay = DateUtils.lastDayByMonth(date);
            HashMap<String, Date> hashMap = new HashMap<String, Date>();
            hashMap.put("firstDay", firstDay);
            hashMap.put("lastDay", lastDay);
            articles = articleService.selectArticleByArchiveDate(hashMap);
        }else {
            //failed
        }
        return articles;
    }

    @ResponseBody
    @RequestMapping("toArticleDetail")
    private Article toArticleDetail(@RequestBody Article article) throws Exception {

        if(article != null) {
            article = articleService.selectArticleById(article.getId());
        }
        return article;

    }

    @ResponseBody
    @RequestMapping("getArchiveList")
    private List<Archive> getArchiveList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Archive> archives = null;

        archives = articleService.selectAllArchive();

        return archives;
    }
}
