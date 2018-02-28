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

    /**
     * 添加友链
     * @param link
     * @return
     * @throws Exception
     */
    int addLink(Link link) throws Exception;

    /**
     * 修改友链
     * @param link
     * @return
     * @throws Exception
     */
    int updateLink(Link link) throws Exception;

    /**
     * 删除友链
     * @param id
     * @return
     * @throws Exception
     */
    int deleteLink(int id) throws Exception;
}