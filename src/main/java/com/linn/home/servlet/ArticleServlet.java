package com.linn.home.servlet;

import com.alibaba.fastjson.JSON;
import com.linn.frame.util.DateUtils;
import com.linn.home.entity.Article;
import com.linn.home.entity.Category;
import com.linn.home.service.ArticleService;
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
import java.util.Date;
import java.util.List;

public class ArticleServlet extends HttpServlet {
	private static Logger logger = LoggerFactory.getLogger(ArticleServlet.class);
	private ArticleService articleService = null;

	@Override
	public void init() throws ServletException {
		super.init();
		articleService = new ArticleServiceImpl();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");

		if (action.equals("toArticleListForcCid")){
			toArticleListForcCid(request,response);
		} else if(action.equals("toArticleDetail")) {
			toArticleDetail(request,response);
		}
	}

	private void toArticleDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String articleId = request.getParameter("articleId");
		Article article = null;
		try {
			article = articleService.selectArticleById(Integer.parseInt(articleId));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(article));
		out.flush();
		out.close();
	}

	private void toArticleListForcCid(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Article> articles = null;
		try {
			String categoryId = request.getParameter("categoryId");
			articles = articleService.selectArticleByCategoryId(Integer.parseInt(categoryId));
		} catch (Exception e){
			logger.error(e.getMessage(),e);
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(articles));
		out.flush();
		out.close();
	}
}
