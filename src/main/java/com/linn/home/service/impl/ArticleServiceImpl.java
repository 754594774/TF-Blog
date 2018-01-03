package com.linn.home.service.impl;

import com.linn.frame.util.MyBatisUtils;
import com.linn.home.dao.ArticleMapper;
import com.linn.home.entity.Archive;
import com.linn.home.entity.Article;
import com.linn.home.service.ArticleService;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    @Override
    public List<Article> selectArticleByCategoryId(int categoryId) throws IOException {
        SqlSession session =  MyBatisUtils.getSqlSession();

        ArticleMapper mapper = session.getMapper(ArticleMapper.class);
        List<Article> articleList = mapper.selectArticleByCategoryId(categoryId);
        session.close();
        return articleList;
    }

    @Override
    public Article selectArticleById(int articleId) throws Exception {
        SqlSession session =  MyBatisUtils.getSqlSession();

        ArticleMapper mapper = session.getMapper(ArticleMapper.class);
        Article article = mapper.selectArticleById(articleId);
        session.close();
        return article;
    }

    @Override
    public List<Archive> selectAllArchive() throws Exception {
        SqlSession session =  MyBatisUtils.getSqlSession();

        ArticleMapper mapper = session.getMapper(ArticleMapper.class);
        List<Archive> archiveList = mapper.selectAllArchive();
        session.close();
        return archiveList;
    }

//    public static void main(String[] args) throws Exception {
//        ArticleServiceImpl  articleService = new ArticleServiceImpl();
//        List<Archive> archiveList = articleService.selectAllArchive();
//        System.out.println(archiveList);
//    }
}