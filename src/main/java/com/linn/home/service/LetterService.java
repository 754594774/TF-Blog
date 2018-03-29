package com.linn.home.service;

import com.linn.home.entity.Letter;
import com.linn.home.entity.Link;

import java.util.List;

/**
 * 站内信ervice层
 */
public interface LetterService {

    /**
     * 查看不同状态的信件数量
     * @param status
     * @return
     * @throws Exception
     */
    int findCountByStatus(int status) throws Exception;

    /**
     * 更新信件查询状态
     * @param letter
     * @return
     * @throws Exception
     */
    int updateStatusById(Letter letter) throws Exception;

    /**
     * 查找所有站内信
     * @return 实体
     * @throws Exception
     */
    List<Letter> findLetterList() throws Exception;

    /**
     * 添加站内信
     * @param letter
     * @return
     * @throws Exception
     */
    int addLetter(Letter letter) throws Exception;

    /**
     * 删除站内信
     * @param id
     * @return
     * @throws Exception
     */
    int deleteLetterById(int id) throws Exception;
}