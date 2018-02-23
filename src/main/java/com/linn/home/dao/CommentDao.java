package com.linn.home.dao;

import com.linn.home.entity.Article;
import com.linn.home.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 评论列表dao层
 * Created by Administrator on 2018-02-23.
 */
@Repository("commentDao")
public interface CommentDao {
    /**
     * 查找文章下的所有评论
     * @param articleId
     * @return
     */
    List<Comment> findCommentListByArticleId(Integer articleId) throws Exception;

    /**
     * 根据父id查找评论
     * @param pid
     * @return
     */
    List<Comment> findCommentListByPid(Integer pid);
}
