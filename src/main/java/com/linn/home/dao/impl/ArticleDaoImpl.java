package com.linn.home.dao.impl;

import com.linn.frame.util.MyBatisUtils;
import com.linn.home.dao.ArticleDao;
import com.linn.home.entity.Archive;
import com.linn.home.entity.Article;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by admin on 2018/1/13.
 */
@Repository("articleDao")
public class ArticleDaoImpl implements ArticleDao {
    @Override
    public List<Article> selectArticleByCategoryId(int categoryId) throws IOException {
        SqlSession session =  MyBatisUtils.getSqlSession();

        ArticleDao mapper = session.getMapper(ArticleDao.class);
        List<Article> articleList = mapper.selectArticleByCategoryId(categoryId);
        session.close();
        return articleList;
    }

    @Override
    public List<Article> selectArticleByArchiveDate(HashMap<String,Date> hashMap) throws Exception {
        SqlSession session =  MyBatisUtils.getSqlSession();

        ArticleDao mapper = session.getMapper(ArticleDao.class);
        List<Article> articleList = mapper.selectArticleByArchiveDate(hashMap);
        session.close();
        return articleList;
    }

    @Override
    public Article selectArticleById(int articleId) throws Exception {
        SqlSession session =  MyBatisUtils.getSqlSession();

        ArticleDao mapper = session.getMapper(ArticleDao.class);
        Article article = mapper.selectArticleById(articleId);
        session.close();
        return article;
    }

    @Override
    public List<Archive> selectAllArchive() throws Exception {
        SqlSession session =  MyBatisUtils.getSqlSession();

        ArticleDao mapper = session.getMapper(ArticleDao.class);
        List<Archive> archiveList = mapper.selectAllArchive();
        session.close();
        return archiveList;
    }
}
