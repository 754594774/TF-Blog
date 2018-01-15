package com.linn.home.controller;

import com.alibaba.fastjson.JSON;
import com.linn.frame.controller.BaseController;
import com.linn.frame.util.DateUtils;
import com.linn.home.entity.Archive;
import com.linn.home.entity.Article;
import com.linn.home.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("toArticleList")
    public String toArticleList(HttpServletRequest request, HttpServletResponse response) {
        List<Article> articles = null;
        try {
            String categoryId = request.getParameter("categoryId");
            String archiveDate = request.getParameter("archiveDate");
            if (categoryId != null && !categoryId.equals("")) {
                articles = articleService.selectArticleByCategoryId(Integer.parseInt(categoryId));
            } else if (archiveDate != null && !archiveDate.equals("")) {
                Date firstDay = DateUtils.firstDayByMonth(archiveDate);
                Date lastDay = DateUtils.lastDayByMonth(archiveDate);
                HashMap<String, Date> hashMap = new HashMap<String, Date>();
                hashMap.put("firstDay", firstDay);
                hashMap.put("lastDay", lastDay);
                articles = articleService.selectArticleByArchiveDate(hashMap);
            } else {
                //failed
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return JSON.toJSONString(articles);
    }

    @ResponseBody
    @RequestMapping("toArticleDetail")
    private String toArticleDetail(HttpServletRequest request, HttpServletResponse response) {
        String articleId = request.getParameter("articleId");
        Article article = null;
        try {
            article = articleService.selectArticleById(Integer.parseInt(articleId));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return JSON.toJSONString(article);

    }

    @ResponseBody
    @RequestMapping("getArchiveList")
    private String getArchiveList(HttpServletRequest request, HttpServletResponse response) {
        List<Archive> archives = null;
        try {
            archives = articleService.selectAllArchive();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return JSON.toJSONString(archives);
    }
}
