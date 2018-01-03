package com.linn.home.service.impl;

import com.linn.frame.util.MyBatisUtils;
import com.linn.home.dao.ArticleMapper;
import com.linn.home.dao.CategoryMapper;
import com.linn.home.entity.Article;
import com.linn.home.entity.Category;
import com.linn.home.service.ArticleService;
import com.linn.home.service.CategoryService;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    @Override
    public List<Article> selectArticleByCategoryId(int categoryId) throws IOException {
        SqlSession session =  MyBatisUtils.getSqlSession();

        ArticleMapper mapper = session.getMapper(ArticleMapper.class);
        List<Article> articles = mapper.selectArticleByCategoryId(categoryId);
        session.close();
        return articles;
    }
}