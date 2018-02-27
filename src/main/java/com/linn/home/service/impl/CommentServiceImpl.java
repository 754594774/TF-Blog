package com.linn.home.service.impl;

import com.linn.home.dao.ArticleDao;
import com.linn.home.dao.CommentDao;
import com.linn.home.entity.Article;
import com.linn.home.entity.Comment;
import com.linn.home.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018-02-23.
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService{

    @Resource
    private CommentDao commentDao;

    @Override
    public List<Comment> findCommentListByArticleId(Integer articleId) throws Exception {
        return commentDao.findCommentListByArticleId(articleId);
    }

    @Override
    public List<Comment> findCommentListByPid(Integer pid) throws Exception {

        return commentDao.findCommentListByPid(pid);
    }

    @Override
    public int addComment(Comment comment) throws Exception {
        return commentDao.addComment(comment);
    }

    @Override
    public int updateCommentById(Comment comment) throws Exception {
        return commentDao.updateCommentById(comment);
    }
}
