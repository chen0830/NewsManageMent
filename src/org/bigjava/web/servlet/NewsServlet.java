package org.bigjava.web.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bigjava.bean.News;
import org.bigjava.constans.*;
import org.bigjava.service.NewsService;
import org.bigjava.service.impl.NewsServiceImpl;
public class NewsServlet extends HttpServlet {

	private NewsService newsService = new NewsServiceImpl();	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = req.getParameter("method");
		
		if(Constants.ADD_NEWS.equalsIgnoreCase(method)) {
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			int fk_topic_id = Integer.valueOf(req.getParameter("topic"));
			News aNews = new News(title, content, fk_topic_id);
			
			newsService.addNews(aNews);//提交新闻
			
			
		}else if(Constants.EDIT_NEWS.equalsIgnoreCase(method)) {
			
		}else if(Constants.DEL_NEWS.equalsIgnoreCase(method)) {
			
		}else {
			System.out.println("");
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}

	
}
