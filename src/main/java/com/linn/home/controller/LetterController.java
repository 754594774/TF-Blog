package com.linn.home.controller;

import com.linn.frame.controller.BaseController;
import com.linn.frame.entity.ResultBean;
import com.linn.frame.util.SysContent;
import com.linn.home.entity.Letter;
import com.linn.home.entity.Link;
import com.linn.home.service.LetterService;
import com.linn.home.service.LinkService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 站内信controller层
 * Created by admin on 2018/1/15.
 */
@Controller
public class LetterController extends BaseController{

    @Resource
    private LetterService letterService;

    @ResponseBody
    @RequestMapping("/toLetterList")
    private List<Letter> toLetterList() throws Exception {

        List<Letter> letters = letterService.findLetterList();
        return letters;
    }

    @ResponseBody
    @RequestMapping("/addLetter")
    public ResultBean addLetter(Letter letter) throws Exception {

        letter.setGmtCreate(new Date());
        letter.setGmtModified(new Date());
        int ret = letterService.addLetter(letter);

        return new ResultBean(SysContent.SUCCESS,"操作成功");
    }

    @ResponseBody
    @RequestMapping("/delLetter")
    public ResultBean delLetter(int[] ids) throws Exception {

        if(ids!=null && ids.length > 0){
            for (int id: ids) {
                int ret = letterService.deleteLetterById(id);
            }
        }
        return new ResultBean(SysContent.SUCCESS,"删除成功");
    }

    @ResponseBody
    @RequestMapping("/changeViewStatus")
    public ResultBean changeViewStatus(int[] ids) throws Exception{
        Letter letter = new Letter();
        if(ids!=null && ids.length > 0){
            for (int id: ids) {
                letter.setId(id);
                letter.setViewStatus(SysContent.HASREAD);
                int ret = letterService.updateStatusById(letter);
            }
        }
        return new ResultBean(SysContent.SUCCESS,"更新成功");
    }

    @ResponseBody
    @RequestMapping("/findCountByStatus")
    public ResultBean findCountByStatus() throws Exception{
        //查看未读信件的书来那个
        int unReadCount = letterService.findCountByStatus(SysContent.UNREAD);
        return new ResultBean(SysContent.SUCCESS,"未读站内信数量",unReadCount);
    }
}
