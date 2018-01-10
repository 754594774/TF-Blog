package com.linn.home.servlet;

import com.linn.frame.controller.BaseController;
import com.linn.home.entity.Link;
import com.linn.home.entity.Notice;
import com.linn.home.service.LinkService;
import com.linn.home.service.NoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LinkServlet extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(LinkServlet.class);

	private LinkService linkService;

	@Override
	public void init() throws ServletException {
		super.init();
		linkService = applicationContext.getBean("linkService",LinkService.class);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("findLinkList")){
			findLinkList(request,response);
		}
	}

	private void findLinkList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Link> links = new ArrayList<Link>();
		try {
			links = linkService.findLinkList();
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		responseJson(response,links);
	}
}
