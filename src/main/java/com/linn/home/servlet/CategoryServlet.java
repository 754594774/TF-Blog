package com.linn.home.servlet;

import com.alibaba.fastjson.JSON;
import com.linn.frame.controller.BaseController;
import com.linn.home.entity.Category;
import com.linn.home.service.CategoryServiceImpl;
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
	private BaseController baseController = null;

	@Override
	public void init() throws ServletException {
		super.init();
		categoryService = new CategoryServiceImpl();
		baseController= new BaseController();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		logger.info("id：" + id);

		Category c1 = new Category();
		c1.setName("java");
		c1.setDescription("后端编程语言");
		Category c2 = new Category();
		c2.setName("php");
		c2.setDescription("最好的语言");
		Category c3 = new Category();
		c3.setName("pathon");
		c3.setDescription("新兴编程语言");
		List<Category> categorys = new ArrayList<Category>();
		categorys.add(c1);
		categorys.add(c2);
		categorys.add(c3);

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(categorys));
		out.flush();
		out.close();
	}
}
