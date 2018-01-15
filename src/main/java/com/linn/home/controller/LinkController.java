package com.linn.home.controller;

import com.alibaba.fastjson.JSON;
import com.linn.frame.controller.BaseController;
import com.linn.home.entity.Link;
import com.linn.home.service.LinkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/1/15.
 */
@Controller
public class LinkController extends BaseController{

    @Resource
    private LinkService linkService;

    @ResponseBody
    @RequestMapping("toLinkList")
    private String toLinkList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Link> links = new ArrayList<Link>();
        try {
            links = linkService.findLinkList();
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }

        return JSON.toJSONString(links);
    }
}
