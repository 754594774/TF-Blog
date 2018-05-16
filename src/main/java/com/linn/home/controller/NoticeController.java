package com.linn.home.controller;

import com.linn.frame.controller.BaseController;
import com.linn.frame.entity.ResultBean;
import com.linn.frame.util.SysContent;
import com.linn.home.entity.Notice;
import com.linn.home.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
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
    private List<Notice> toNoticeDetail() throws Exception {

        List<Notice> noticeList = noticeService.findActiveNotice();
        return noticeList;
    }

    @ResponseBody
    @RequestMapping("/toNoticeList")
    private List<Notice> toNoticeList() throws Exception {

        List<Notice> noticeList = noticeService.findNoticeList();
        return noticeList;
    }

    @ResponseBody
    @RequestMapping("/addNotice")
    private ResultBean addNotice(Notice notice) throws Exception {

        noticeService.addNotice(notice);
        return new ResultBean(SysContent.SUCCESS,"删除成功");
    }

    @ResponseBody
    @RequestMapping("addOrUpdateNotice")
    public ResultBean addOrUpdateNotice(Notice notice) throws Exception {
        if(StringUtils.isEmpty(notice.getId())) {
            //添加
            notice.setGmtCreate(new Date());
            notice.setGmtModified(new Date());
            int ret = noticeService.addNotice(notice);
        }else {
            //更新
            notice.setGmtModified(new Date());
            int ret = noticeService.updateNotice(notice);
        }

        return new ResultBean(SysContent.SUCCESS,"操作成功");
    }

    @ResponseBody
    @RequestMapping("delNotice")
    public ResultBean delNotice(int[] ids) throws Exception {

        if(ids!=null && ids.length > 0){
            for (int id: ids) {
                int ret = noticeService.deleteNoticeById(id);
            }
        }
        return new ResultBean(SysContent.SUCCESS,"删除成功");
    }

}
