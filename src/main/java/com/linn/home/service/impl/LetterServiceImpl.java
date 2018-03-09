package com.linn.home.service.impl;

import com.linn.home.dao.LetterDao;
import com.linn.home.entity.Letter;
import com.linn.home.entity.Link;
import com.linn.home.service.LetterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 站内信service层
 * Created by Administrator on 2018-03-09.
 */
@Service("letterService")
public class LetterServiceImpl implements LetterService {

    @Resource
    private LetterDao letterDao;

    @Override
    public List<Letter> findLetterList() throws Exception {
        return letterDao.findLetterList();
    }

    @Override
    public int addLetter(Letter letter) throws Exception {
        return letterDao.addLetter(letter);
    }

    @Override
    public int deleteLetterById(int id) throws Exception {
        return letterDao.deleteLetterById(id);
    }
}
