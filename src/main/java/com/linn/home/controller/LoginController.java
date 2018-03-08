package com.linn.home.controller;

import com.linn.frame.entity.ResultBean;
import com.linn.frame.util.SysContent;
import com.linn.home.entity.User;
import com.linn.home.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

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
    private ResultBean toAdminIndex(@RequestBody Map<String, String> map,
                                    HttpSession session,
                                    HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
        User user = new User();
        if(map.containsKey("userName") && !StringUtils.isEmpty(map.get("userName"))){
            String userName = map.get("userName");
            user.setUserName(userName);
        }else{
            return new ResultBean(SysContent.ERROR,"用户名不能为空!");
        }
        if(map.containsKey("passWord") && !StringUtils.isEmpty(map.get("passWord"))){
            String passWord = map.get("passWord");
            user.setPassWord(passWord);
        }else{
            return new ResultBean(SysContent.ERROR,"密码不能为空!");
        }
        user = userService.findUserByNameAndPwd(user);

        if(user == null){
            return new ResultBean(SysContent.ERROR,"用户名或密码不正确!");
        }

        session.setMaxInactiveInterval(10*60);//过期时间-10分钟
        session.setAttribute("user",user);

        if(map.containsKey("rememberMe") && !StringUtils.isEmpty(map.get("rememberMe"))){
            Object rememberMe = map.get("rememberMe");
            if(rememberMe.equals("true")){//记住我
                //添加cookie
                Cookie cookie = new Cookie("user",user.getUserName() + "_" + user.getPassWord());
                cookie.setMaxAge(60*60);//一小时
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }

        return new ResultBean(SysContent.SUCCESS,"登陆成功!");
    }

    @ResponseBody
    @RequestMapping("/findLoginUser")
    private User findLoginUser(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = new User();
        //获取cookie
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies) {
            if(cookie.getName().equals("user")){
                String nameAndPwd = cookie.getValue();
                user.setUserName(nameAndPwd.split("_")[0]);
                user.setPassWord(nameAndPwd.split("_")[1]);
                return user;
            }
        }
        //获取Session
        user = (User)request.getSession().getAttribute("user");
        if(user != null){
            return user;
        }
        return null;
    }
}