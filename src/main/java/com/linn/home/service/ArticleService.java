package com.linn.home.service;

import com.linn.home.entity.Article;
import com.linn.home.entity.Category;

import java.io.IOException;
import java.util.List;

public interface ArticleService {

    List<Article> selectArticleByCategoryId(int categoryId) throws Exception;

    Article selectArticleById(int articleId) throws Exception;
}