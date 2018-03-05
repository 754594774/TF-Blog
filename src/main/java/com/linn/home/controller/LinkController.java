package com.linn.home.controller;

import com.alibaba.fastjson.JSON;
import com.linn.frame.controller.BaseController;
import com.linn.frame.entity.ResultBean;
import com.linn.frame.util.SysContent;
import com.linn.home.entity.Link;
import com.linn.home.service.LinkService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
    private List<Link> toLinkList() throws Exception {

        List<Link> links = linkService.findLinkList();
        return links;
    }

    @ResponseBody
    @RequestMapping("addOrUpdateLink")
    public ResultBean addOrUpdateCatg(Link link) throws Exception {
        if(StringUtils.isEmpty(link.getId())) {
            //添加
            link.setGmtCreate(new Date());
            link.setGmtModified(new Date());
            int ret = linkService.addLink(link);
        }else {
            //更新
            link.setGmtModified(new Date());
            int ret = linkService.updateLinkById(link);
        }
        return new ResultBean(SysContent.SUCCESS,"操作成功");
    }

    @ResponseBody
    @RequestMapping("delLink")
    public ResultBean delLink(int[] ids) throws Exception {

        if(ids!=null && ids.length > 0){
            for (int id: ids) {
                int ret = linkService.deleteLinkById(id);
            }
        }
        return new ResultBean(SysContent.SUCCESS,"删除成功");
    }
}
