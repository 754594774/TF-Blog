package com.linn.home.servlet;

import com.linn.frame.controller.BaseController;
import com.linn.home.entity.Category;
import com.linn.home.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CategoryServlet extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(CategoryServlet.class);
	private CategoryService categoryService = null;

	@Override
	public void init() throws ServletException {
		super.init();
		categoryService = applicationContext.getBean("categoryService",CategoryService.class);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Category> categorys = null;
		try {
			categorys = categoryService.findCategoryList();
		}catch (Exception e){
			logger.error(e.getMessage(),e);
		}
		responseJson(response,categorys);
	}
}
