package com.linn.home.service.impl;

import com.linn.home.dao.LinkDao;
import com.linn.home.entity.Link;
import com.linn.home.entity.Notice;
import com.linn.home.service.LinkService;
import com.linn.home.service.NoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("linkService")
public class LinkServiceImpl implements LinkService {
    @Resource
    private LinkDao linkDao;

    @Override
    public List<Link> findLinkList() throws Exception {
        return linkDao.findLinkList();
    }

    @Override
    public int addLink(Link link) throws Exception {
        return linkDao.addLink(link);
    }

    @Override
    public int updateLink(Link link) throws Exception {
        return linkDao.updateLink(link);
    }

    @Override
    public int deleteLink(int id) throws Exception {
        return linkDao.deleteLink(id);
    }
}