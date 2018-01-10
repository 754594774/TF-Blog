package com.linn.home.service.impl;

import com.linn.home.entity.Link;
import com.linn.home.entity.Notice;
import com.linn.home.service.LinkService;
import com.linn.home.service.NoticeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("linkService")
public class LinkServiceImpl implements LinkService {

    @Override
    public List<Link> findLinkList() throws Exception {
        List<Link> links = new ArrayList<Link>();
        Link link;
        for(int i=1;i<6;i++) {
            link = new Link();
            link.setId(i);
            link.setTitle("链接" + i);
            link.setUrl("http://www.runoob.com");
            links.add(link);
        }
        return links;
    }
}