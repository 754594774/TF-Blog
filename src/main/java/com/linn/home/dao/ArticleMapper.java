package com.linn.home.dao;

import com.linn.home.entity.Article;
import com.linn.home.entity.Category;

import java.util.List;

public interface ArticleMapper {
    /**
     * 根据分类id查找文章
     * @return
     */
    List<Article> selectArticleByCategoryId(int categoryId);
}
