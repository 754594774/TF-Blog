package com.linn.home.dao;

import com.linn.home.entity.Letter;
import com.linn.home.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 站内信dao层
 * Created by Administrator on 2018-02-28.
 */
@Repository("letterDao")
public interface LetterDao {
    /**
     * 查找所有站内信
     * @param
     * @return
     */
    List<Letter> findLetterList() throws Exception;

    /**
     * 添加站内信
     * @param letter
     * @return
     * @throws Exception
     */
    int addLetter(Letter letter) throws  Exception;

    /**
     * 删除站内信
     * @param id
     * @return
     * @throws Exception
     */
    int deleteLetterById(int id) throws Exception;
}
