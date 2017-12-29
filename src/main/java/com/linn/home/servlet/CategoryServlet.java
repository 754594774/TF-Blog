package com.linn.home.servlet;

import com.linn.frame.controller.BaseController;
import com.linn.home.service.CategoryServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
		String vue = request.getParameter("vue");
		logger.info(vue);


	/*	if(oper.equals("getCategoryList")){
			toCategoryList(request,response);
		}*/
	}
	
	/**
	 * 跳转到分类列表页面
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void toCategoryList(HttpServletRequest request, HttpServletResponse response) throws IOException{
			
		ServletContext sc = getServletContext(); 
		RequestDispatcher rd = sc.getRequestDispatcher("/index.jsp");
		try {
			rd.forward(request, response);
		} catch (Exception e) {
			logger.error("跳转到分类列表页面",e);
		}
	}

}
