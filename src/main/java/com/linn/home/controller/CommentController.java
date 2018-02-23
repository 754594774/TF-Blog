package com.linn.home.controller;

import com.linn.frame.controller.BaseController;
import com.linn.frame.util.SysContent;
import com.linn.home.entity.Article;
import com.linn.home.entity.Comment;
import com.linn.home.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018-02-23.
 */
@Controller
public class CommentController extends BaseController {

    @Resource
    private CommentService commentService;

    /**
     * 查找文章下所有评论
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("toCommentList")
    public List<Comment> toCommentList(String  articleId) throws Exception {

        List<Comment> commentList;

        commentList = commentService.findCommentListByArticleId(Integer.parseInt(articleId));
        for (Comment comment:commentList) {
            if(comment.getIsleaf().equals(SysContent.YES)) {
                //不是叶子节点
                findChildComment(comment);
            }
        }
        return commentList;
    }


    private void findChildComment(Comment comment) throws Exception {

        List<Comment> childCommentList;
        childCommentList = commentService.findCommentListByPid(comment.getId());
        if( childCommentList != null &&  childCommentList.size() > 0) {

            comment.setChildCommentList( childCommentList);

            for (Comment childComment :  childCommentList) {
                if(childComment.getIsleaf().equals(SysContent.YES)) {
                    //不是叶子节点
                    findChildComment(childComment);
                }
            }
        }
    }

}
