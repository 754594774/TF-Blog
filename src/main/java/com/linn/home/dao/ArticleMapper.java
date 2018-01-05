package com.linn.home.dao;

import com.linn.home.entity.Archive;
import com.linn.home.entity.Article;

import java.security.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface ArticleMapper {
    /**
     * 根据分类id查找文章
     * @return
     */
    List<Article> selectArticleByCategoryId(int categoryId);

    /**
     * 根据日期范围查找文章
     * @param hashMap
     * @return
     */
    List<Article> selectArticleByArchiveDate(HashMap<String,Date> hashMap);

    /**
     * 根据id查询文章信息
     * @param articleId
     * @return
     */
    Article selectArticleById(int articleId);

    /**
     * 查找文章归档
     * @return
     */
    List<Archive> selectAllArchive();


}
