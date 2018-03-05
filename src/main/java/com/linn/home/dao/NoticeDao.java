package com.linn.home.dao;

import com.linn.home.entity.Link;
import com.linn.home.entity.Notice;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 通知dao层
 * Created by Administrator on 2018-02-28.
 */
@Repository("noticeDao")
public interface NoticeDao {

    /**
     * 查找通知
     * @return
     * @throws Exception
     */
    Notice findActiveNotice() throws Exception;

    /**
     * 查找通知列表
     * @param
     * @return
     */
    List<Notice> findNoticeList() throws Exception;

    /**
     * 添加通知
     * @param notice
     * @return
     * @throws Exception
     */
    int addNotice(Notice notice) throws  Exception;

    /**
     * 更新通知
     * @param notice
     * @return
     * @throws Exception
     */
    int updateNoticeById(Notice notice) throws Exception;

    /**
     * 删除通知
     * @param id
     * @return
     * @throws Exception
     */
    int deleteNoticeById(int id) throws Exception;
}
