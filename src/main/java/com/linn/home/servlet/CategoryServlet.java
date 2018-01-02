package com.linn.home.servlet;

import com.alibaba.fastjson.JSON;
import com.linn.frame.controller.BaseController;
import com.linn.home.entity.Category;
import com.linn.home.service.impl.CategoryServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CategoryServlet extends HttpServlet {
	private static Logger logger = LoggerFactory.getLogger(CategoryServlet.class);
	private CategoryServiceImpl categoryService = null;

	@Override
	public void init() throws ServletException {
		super.init();
		categoryService = new CategoryServiceImpl();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		List<Category> categorys = null;
		try {
			categorys = categoryService.findCategoryList();
		}catch (Exception e){
			logger.error(e.getMessage(),e);
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(categorys));
		out.flush();
		out.close();
	}
}
