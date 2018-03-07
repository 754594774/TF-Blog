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
    private String toAdmin(HttpSession session, HttpServletRequest request) throws Exception {
        User user = (User)session.getAttribute("user");
        if(user == null){
            return "admin/login";
        }
        return "admin/index";
    }

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    private ResultBean toLogin(HttpSession session, HttpServletRequest request) throws Exception {
        return login(session,request);
    }

    @ResponseBody
    @RequestMapping(value = "admin/login",method = RequestMethod.POST)
    private ResultBean toAdminLogin(HttpSession session, HttpServletRequest request) throws Exception {

       return login(session,request);
    }

    /**
     * 登录
     * @return
     */
    private ResultBean login( HttpSession session, HttpServletRequest request){
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

        if(rememberMe.equals("true")){//记住我
            session.setMaxInactiveInterval(2*60*60);//过期时间-2小时
            session.setAttribute("user",user);
        }
        return new ResultBean(SysContent.SUCCESS,"登陆成功!");
    }
}