package com.linn.home.dao;

import com.linn.home.entity.Archive;
import com.linn.home.entity.Article;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.security.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Repository("articleDao")
public interface ArticleDao {
    /**
     * 根据分类id查找文章
     * @return
     */
    List<Article> selectArticleByCategoryId(int categoryId) throws Exception;

    /**
     * 根据日期范围查找文章
     * @param hashMap
     * @return
     */
    List<Article> selectArticleByArchiveDate(HashMap<String,Date> hashMap) throws Exception;

    /**
     * 根据id查询文章信息
     * @param articleId
     * @return
     */
    Article selectArticleById(int articleId) throws Exception;

    /**
     * 查找文章归档
     * @return
     */
    List<Archive> selectAllArchive() throws Exception;

    /**
     * 查找文章归档
     * @return
     */
    List<Article> findArticleListAdmin() throws Exception;

    /**
     * 添加文章
     * @param article
     * @return
     * @throws Exception
     */
    int addArticle(Article article) throws Exception;

    /**
     * 删除文章
     * @param id
     * @return
     * @throws Exception
     */
    int deleteArticleById(int id) throws Exception;

    /**
     * 更新文章
     * @param article
     * @return
     * @throws Exception
     */
    int updateArticle(Article article) throws Exception;

    /**
     * 搜索
     * @param searchContent
     * @return
     */
    List<Article> selectArticleBySearch(String searchContent);
}
