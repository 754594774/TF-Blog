package com.linn.home.service;

import com.github.pagehelper.PageInfo;
import com.linn.home.entity.Archive;
import com.linn.home.entity.Article;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface ArticleService {

    PageInfo selectArticleByCategoryId(int categoryId,PageInfo page) throws Exception;

    PageInfo selectArticleByArchiveDate(HashMap<String,Date> hashMap,PageInfo page) throws Exception;

    Article selectArticleById(int articleId) throws Exception;

    List<Archive> selectAllArchive() throws Exception;

    List<Article> findArticleListAdmin() throws Exception;

    int addArticle(Article article) throws Exception;

    int delArticle(int id) throws Exception;

    int updateArticle(Article article) throws Exception;

    PageInfo selectArticleBySearch(String searchContent,PageInfo page) throws Exception;
}