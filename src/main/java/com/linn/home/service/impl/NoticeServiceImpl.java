package com.linn.home.service.impl;

import com.linn.home.entity.Notice;
import com.linn.home.service.NoticeService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

    @Override
    public Notice findLastNotice() throws Exception {
        Notice notice = new Notice();
        notice.setId(1);
        notice.setGmtCreate(new Date());
        notice.setTitle("bootStrap");
        notice.setAuthor("lnn");
        notice.setContent("这是一个通知!");
        notice.setGmtModified(new Date());
        return notice;
    }
}