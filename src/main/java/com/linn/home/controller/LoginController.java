package com.linn.home.controller;

import com.linn.frame.entity.ResultBean;
import com.linn.frame.util.SysContent;
import com.linn.home.entity.User;
import com.linn.home.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登录controller
 * Created by Administrator on 2018-02-07.
 */
@Controller
public class LoginController {

    @Resource
    private UserService userService ;

    @RequestMapping("/admin")
    private String toAdmin() throws Exception {
        return "admin/index";
    }

    @RequestMapping("/admin/login")
    private String toAdminLogin() throws Exception {
        return "admin/login";
    }

    @ResponseBody
    @RequestMapping(value = "/admin/index",method = RequestMethod.POST)
    private ResultBean toAdminIndex(HttpSession session, HttpServletRequest request) throws Exception {

        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        String rememberMe = request.getParameter("rememberMe");
        if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(passWord)){
            return new ResultBean(SysContent.ERROR,"用户名或密码不能为空!");
        }
        User user = new User();
        user.setUserName(userName);
        user.setPassWord(passWord);
        user = userService.findUserByNameAndPwd(user);

        if(user == null){
            return new ResultBean(SysContent.ERROR,"用户名或密码不正确!");
        }

        session.setMaxInactiveInterval(2*60*60);//过期时间-2小时
        session.setAttribute("user",user);
//        if(rememberMe.equals("true")){//记住我
//添加cookie
//        }
        return new ResultBean(SysContent.SUCCESS,"登陆成功!");
    }

}