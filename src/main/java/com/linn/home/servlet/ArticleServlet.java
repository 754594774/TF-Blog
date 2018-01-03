package com.linn.home.servlet;

import com.alibaba.fastjson.JSON;
import com.linn.home.entity.Article;
import com.linn.home.entity.Category;
import com.linn.home.service.impl.ArticleServiceImpl;
import com.linn.home.service.impl.CategoryServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ArticleServlet extends HttpServlet {
	private static Logger logger = LoggerFactory.getLogger(ArticleServlet.class);
	private ArticleServiceImpl articleService = null;

	@Override
	public void init() throws ServletException {
		super.init();
		articleService = new ArticleServiceImpl();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		List<Article> articles = null;
		try {
			String categoryId = request.getParameter("categoryId");
			articles = articleService.selectArticleByCategoryId(Integer.parseInt(categoryId));
		}catch (Exception e){
			logger.error(e.getMessage(),e);
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(articles));
		out.flush();
		out.close();
	}
}
