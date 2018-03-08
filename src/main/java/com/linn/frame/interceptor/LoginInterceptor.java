package com.linn.frame.interceptor;

import com.linn.home.entity.User;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登陆拦截器
 * Created by Administrator on 2018-03-07.
 */
public class LoginInterceptor implements HandlerInterceptor{
    /**
     * Handler执行之前调用这个方法
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("preHandle...");
        //获取cookie
        Cookie[] cookies = request.getCookies();
        if(cookies!=null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    return true;
                }
            }
        }
        //获取Session
        User user = (User)request.getSession().getAttribute("user");
        if(user != null){
            return true;
        }
        //不符合条件的，跳转到登录界面

        ServletContext ctx = request.getSession().getServletContext();
        System.out.println(request.getRequestURI());
        response.sendRedirect("/admin/login");
        return false;
    }
    /**
     * Handler执行之后，ModelAndView返回之前调用这个方法
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

        System.out.println("postHandle...");
    }

    /**
     * Handler执行完成之后调用这个方法
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion...");
    }
}
