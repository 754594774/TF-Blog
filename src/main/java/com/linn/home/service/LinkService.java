package com.linn.home.service;

import com.linn.home.entity.Link;

import java.util.List;

/**
 * 友链service层
 */
public interface LinkService {

    /**
     * 查找最新的通知
     * @return 实体
     * @throws Exception
     */
    List<Link> findLinkList() throws Exception;
}