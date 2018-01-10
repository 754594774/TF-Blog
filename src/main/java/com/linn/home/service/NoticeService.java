package com.linn.home.service;

import com.linn.home.entity.Notice;

/**
 * 通知service层
 */
public interface NoticeService {

    /**
     * 查找最新的通知
     * @return 实体
     * @throws Exception
     */
    Notice findLastNotice() throws Exception;
}