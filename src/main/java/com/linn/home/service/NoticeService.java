package com.linn.home.service;

import com.linn.home.entity.Notice;

import java.util.List;

/**
 * 通知service层
 */
public interface NoticeService {

    /**
     * 查找最新的通知
     * @return 实体
     * @throws Exception
     */
    List<Notice> findActiveNotice() throws Exception;

    /**
     * 查找通知列表
     * @return
     * @throws Exception
     */
    List<Notice> findNoticeList() throws Exception;

    /**
     * 添加通知
     * @return
     * @throws Exception
     */
    int addNotice(Notice notice) throws Exception;

    /**
     * 更新通知
     * @return
     * @throws Exception
     */
    int updateNotice(Notice notice) throws Exception;

    /**
     * 删除通知
     * @param id
     * @return
     * @throws Exception
     */
    int deleteNoticeById(int id) throws Exception;
}