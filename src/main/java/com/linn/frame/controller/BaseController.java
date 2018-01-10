package com.linn.frame.controller;


import com.alibaba.fastjson.JSON;
import com.linn.home.service.NoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 基础的Controller,所有的Controller必须继承此类
 *
 * @Author:LNN 2017-12-28 下午 1:52
 */
public class BaseController extends HttpServlet
{
    private static Logger logger = LoggerFactory.getLogger(BaseController.class);

    protected ApplicationContext applicationContext;

    @Override
    public void init() throws ServletException {
        applicationContext = new ClassPathXmlApplicationContext("beans.xml");
    }

    /**
     * 返回json格式字符串数据
     * 字符编码：text/html;charset=utf-8
     * @param response
     * @param obj
     */
    protected void responseJson(HttpServletResponse response, Object obj)
    {
        String content = JSON.toJSONString(obj);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
        }
        out.write(content);
        out.flush();
        out.close();
    }


}
