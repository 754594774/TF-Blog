package com.linn.home.servlet;

import com.linn.frame.controller.BaseController;
import com.linn.home.entity.Notice;
import com.linn.home.service.NoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NoticeServlet extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(NoticeServlet.class);

	private NoticeService noticeService;

	@Override
	public void init() throws ServletException {
		super.init();
	    noticeService = applicationContext.getBean("noticeService",NoticeService.class);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("findNotice")){
			findNotice(request,response);
		}
	}

	private void findNotice(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Notice notice = null;
		try {
			notice = noticeService.findLastNotice();
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		responseJson(response,notice);
	}
}
