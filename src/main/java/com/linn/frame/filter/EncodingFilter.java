package com.linn.frame.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 乱码过滤
 * Created by admin on 2018/1/6.
 */
public class EncodingFilter implements Filter {
    private static Logger logger = LoggerFactory.getLogger(EncodingFilter.class);
    private String charset;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        charset = filterConfig.getInitParameter("charset");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("EncodingFilter..." + charset);
        servletRequest.setCharacterEncoding(charset);
        servletResponse.setContentType("text/html;charset=" + charset);
        filterChain.doFilter(new HttpServletRequestWrapper((HttpServletRequest) servletRequest) {
            @Override
            public String getParameter(String name) {
                String value = super.getParameter(name);
                if (super.getMethod().equalsIgnoreCase("GET")) {

                    if (value != null) {
                        try {
                            value = new String(value.getBytes("iso8859-1"), charset);
                        } catch (UnsupportedEncodingException e) {
                            logger.error(e.getMessage(),e);
                        }
                    }
                }
                return value;
            }
        },servletResponse);
    }

    @Override
    public void destroy() {
        charset = null;
    }
}
