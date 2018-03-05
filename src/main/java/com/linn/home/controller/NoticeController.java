package com.linn.home.controller;

import com.alibaba.fastjson.JSON;
import com.linn.frame.controller.BaseController;
import com.linn.frame.entity.ResultBean;
import com.linn.frame.util.SysContent;
import com.linn.home.entity.Notice;
import com.linn.home.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 2018/1/15.
 */
@Controller
public class NoticeController extends BaseController {

    @Resource
    private NoticeService noticeService;

    @ResponseBody
    @RequestMapping("/toNoticeDetail")
    private Notice toNoticeDetail() throws Exception {

        Notice notice = noticeService.findActiveNotice();
        return notice;
    }

    @ResponseBody
    @RequestMapping("/toNoticeList")
    private List<Notice> toNoticeList() throws Exception {

        List<Notice> noticeList = noticeService.toNoticeList();
        return noticeList;
    }

    @ResponseBody
    @RequestMapping("/addNotice")
    private ResultBean addNotice(Notice notice) throws Exception {

        noticeService.addNotice(notice);
        return new ResultBean(SysContent.SUCCESS,"删除成功");
    }


}
