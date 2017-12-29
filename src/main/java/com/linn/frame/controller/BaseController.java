package com.linn.frame.controller;


import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 基础的Controller,所有的Controller必须继承此类
 *
 * @Author:LNN 2017-12-28 下午 1:52
 */
public class BaseController
{
    private static Logger logger = LoggerFactory.getLogger(BaseController.class);
    /**
     * 返回json格式字符串数据
     *
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
