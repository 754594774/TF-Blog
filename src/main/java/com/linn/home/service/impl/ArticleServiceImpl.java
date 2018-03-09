package com.linn.home.service.impl;

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
    public List<Article> selectArticleByCategoryId(int categoryId) throws Exception {

        return articleDao.selectArticleByCategoryId(categoryId);
    }

    @Override
    public List<Article> selectArticleByArchiveDate(HashMap<String,Date> hashMap) throws Exception {

        return articleDao.selectArticleByArchiveDate(hashMap);
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
}