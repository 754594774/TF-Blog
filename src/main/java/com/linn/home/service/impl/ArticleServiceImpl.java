package com.linn.home.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.linn.home.dao.ArticleDao;
import com.linn.home.entity.Archive;
import com.linn.home.entity.Article;
import com.linn.home.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleDao articleDao;

    @Override
    public PageInfo selectArticleByCategoryId(int categoryId,PageInfo page) throws Exception {

        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        //紧跟着的第一个select方法会被分页
        List<Article> articles = articleDao.selectArticleByCategoryId(categoryId);
        //用PageInfo对结果进行包装
        page = new PageInfo(articles);
        return page;
    }

    @Override
    public PageInfo selectArticleByArchiveDate(HashMap<String,Date> hashMap,PageInfo page) throws Exception {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<Article> articles = articleDao.selectArticleByArchiveDate(hashMap);
        //用PageInfo对结果进行包装
        page = new PageInfo(articles);
        return page;
    }

    @Override
    public Article selectArticleById(int articleId) throws Exception {

        return articleDao.selectArticleById(articleId);
    }

    @Override
    public List<Archive> selectAllArchive() throws Exception {

        return articleDao.selectAllArchive();
    }

    @Override
    public List<Article> findArticleListAdmin() throws Exception {
        return articleDao.findArticleListAdmin();
    }

    @Override
    public int addArticle(Article article) throws Exception {
        return articleDao.addArticle(article);
    }

    @Override
    public int delArticle(int id) throws Exception {
        return articleDao.deleteArticleById(id);
    }

    @Override
    public int updateArticle(Article article) throws Exception {
        return articleDao.updateArticle(article);
    }

    @Override
    public PageInfo selectArticleBySearch(String searchContent,PageInfo pageInfo) throws Exception {
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
        List<Article>  articles= articleDao.selectArticleBySearch(searchContent);
        //用PageInfo对结果进行包装
        pageInfo = new PageInfo(articles);
        return pageInfo;
    }
}