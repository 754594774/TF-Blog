package com.linn.home.service.impl;

import com.linn.frame.util.MyBatisUtils;
import com.linn.home.dao.ArticleDao;
import com.linn.home.dao.CategoryDao;
import com.linn.home.entity.Archive;
import com.linn.home.entity.Article;
import com.linn.home.service.ArticleService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleDao articleDao;

    @Override
    public List<Article> selectArticleByCategoryId(int categoryId) throws IOException {

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

}