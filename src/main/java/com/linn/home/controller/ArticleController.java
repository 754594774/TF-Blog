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
    public List<Article> toArticleList(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Article> articles = null;
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

        return articles;
    }

    @ResponseBody
    @RequestMapping("toArticleDetail")
    private Article toArticleDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String articleId = request.getParameter("articleId");
        Article article = articleService.selectArticleById(Integer.parseInt(articleId));
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
