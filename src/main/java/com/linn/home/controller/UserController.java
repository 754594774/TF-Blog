package com.linn.home.controller;

import com.linn.frame.entity.ResultBean;
import com.linn.frame.util.SysContent;
import com.linn.home.entity.Link;
import com.linn.home.entity.User;
import com.linn.home.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 用户
 * Created by Administrator on 2018-03-08.
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping("/toUserList")
    private List<User> toUserList() throws Exception {

        List<User> links = userService.findUserList();
        return links;
    }

    @ResponseBody
    @RequestMapping("/addOrUpdateUser")
    public ResultBean addOrUpdateUser(User user) throws Exception {
        if(StringUtils.isEmpty(user.getId())) {
            if(userService.findUserByName(user)!=null) {
                return new ResultBean(SysContent.ERROR,"用户名不能重复！");
            }
                //添加
            user.setGmtCreate(new Date());
            user.setGmtModified(new Date());
            int ret = userService.addUser(user);
        }else {
            //更新
            user.setGmtModified(new Date());
            int ret = userService.updateUserByUserName(user);
        }
        return new ResultBean(SysContent.SUCCESS,"操作成功");
    }

    @ResponseBody
    @RequestMapping("/delUser")
    public ResultBean delUser(int[] ids) throws Exception {
        if(ids!=null && ids.length > 0){
            for (int id: ids) {
                int ret = userService.deleteUserById(id);
            }
        }
        return new ResultBean(SysContent.SUCCESS,"删除成功");
    }

}
