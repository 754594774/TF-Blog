package com.linn.home.service.impl;

import com.linn.home.dao.NoticeDao;
import com.linn.home.entity.Notice;
import com.linn.home.service.NoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

    @Resource
    private NoticeDao noticeDao;

    @Override
    public Notice findActiveNotice() throws Exception {

        return noticeDao.findActiveNotice();
    }

    @Override
    public List<Notice> toNoticeList() throws Exception {
        return noticeDao.findNoticeList();
    }

    @Override
    public int addNotice(Notice notice) throws Exception {
        return noticeDao.addNotice(notice);
    }

    @Override
    public int updateNotice(Notice notice) throws Exception {
        return noticeDao.updateNoticeById(notice);
    }

    @Override
    public int deleteNoticeById(int id) throws Exception {
        return noticeDao.deleteNoticeById(id);
    }
}