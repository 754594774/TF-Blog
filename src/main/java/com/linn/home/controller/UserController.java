package com.linn.home.controller;

import com.linn.frame.entity.ResultBean;
import com.linn.frame.util.SysContent;
import com.linn.home.entity.Link;
import com.linn.home.entity.User;
import com.linn.home.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

        List<User> users = userService.findUserList();
        return users;
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

    @ResponseBody
    @RequestMapping("/changePwd")
    public ResultBean changePwd(@RequestBody Map<String, String> map) throws Exception {

        User user = new User();
        //用户名
        if(map.containsKey("userName") && !StringUtils.isEmpty(map.get("userName"))){
            String userName = map.get("userName").trim();
            user.setUserName(userName);
        }
        //老密码
        if(map.containsKey("passWord") && !StringUtils.isEmpty(map.get("passWord"))){
            String passWord = map.get("passWord").trim();
            user.setPassWord(passWord);
        }

        user = userService.findUserByNameAndPwd(user);
        if(user == null){
            return new ResultBean(SysContent.ERROR,"用户名或密码不正确!");
        }

        //新密码
        if(map.containsKey("newPwd") && !StringUtils.isEmpty(map.get("newPwd"))){
            if(StringUtils.isEmpty(map.get("newPwd"))){
                return new ResultBean(SysContent.ERROR,"新密码不能为空!");
            }
            String newPwd = map.get("newPwd").trim();
            user.setPassWord(newPwd);
        }
        //更新
        user.setGmtModified(new Date());
        int ret = userService.updateUserByUserName(user);
        return new ResultBean(SysContent.SUCCESS,"修改成功");
    }

}
