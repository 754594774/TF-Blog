package com.linn.home.dao;

import com.linn.home.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 友链dao层
 * Created by Administrator on 2018-02-28.
 */
@Repository("linkDao")
public interface LinkDao {
    /**
     * 查找文章下的所有评论
     * @param
     * @return
     */
    List<Link> findLinkList() throws Exception;

    /**
     * 添加友链
     * @param link
     * @return
     * @throws Exception
     */
    int addLink(Link link) throws  Exception;

    /**
     * 更新友链
     * @param link
     * @return
     * @throws Exception
     */
    int updateLinkById(Link link) throws Exception;

    /**
     * 删除友链
     * @param id
     * @return
     * @throws Exception
     */
    int deleteLinkById(int id) throws Exception;
}
