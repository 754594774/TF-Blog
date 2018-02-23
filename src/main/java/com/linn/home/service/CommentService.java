package com.linn.home.service;

import com.linn.home.entity.Article;
import com.linn.home.entity.Comment;

import java.util.List;

/**
 * 评论service层
 * Created by Administrator on 2018-02-23.
 */
public interface CommentService {
    List<Comment> findCommentListByArticleId(Integer articleId) throws Exception;

    List<Comment> findCommentListByPid(Integer pid) throws Exception;

}
