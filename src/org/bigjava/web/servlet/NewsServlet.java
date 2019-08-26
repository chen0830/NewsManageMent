package org.bigjava.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bigjava.bean.News;
import org.bigjava.constans.*;
import org.bigjava.service.NewsService;
import org.bigjava.service.impl.NewsServiceImpl;
import org.bigjava.util.*;
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
			int fk_topic = Integer.valueOf(req.getParameter("topic"));
			
			System.out.println("提交1");
			News aNews = new News(title, content, fk_topic);
			System.out.println("提交2");
			newsService.addNews(aNews);//提交新闻
			
			// 设置返回信息提醒
			if (newsService.addNews(aNews)) {
				MessageUtil.REQ_INFO_SETTING(req, Constants.MSG_REQ_KEY, Constants.MSG_REQ_ADD_NEWS_SUCCESS);
				} else {
					MessageUtil.REQ_INFO_SETTING(req, Constants.MSG_REQ_KEY, Constants.MSG_REQ_ADD_NEWS_FAILURE);
					}
			req.getRequestDispatcher("/admin/addNews.jsp").forward(req, resp);

			
		}else if(Constants.EDIT_NEWS.equalsIgnoreCase(method)) {
			// 修改新闻
			int nid = Integer.valueOf(req.getParameter("id"));
			News editNews = newsService.getNewsById(nid);
			req.setAttribute("editNews", editNews);
			req.getRequestDispatcher("/admin/editNews.jsp").forward(req, resp);
		
		}else if (Constants.EDIT_NEWS_SBT.equals(method)) {
			// 修改新闻提交
			int nid = Integer.valueOf(req.getParameter("id"));
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			int fk_topic = Integer.valueOf(req.getParameter("topic"));
			News aNews = new News(title, content, fk_topic);
			aNews.setId(nid);
			
			newsService.updateNewsById(aNews);
			req.getRequestDispatcher("/admin/NewsServlet?method=show_all_news").forward(req, resp);
			
		}else if(Constants.DEL_NEWS.equalsIgnoreCase(method)) {
			// 通过id删除新闻
			int nid = Integer.valueOf(req.getParameter("id"));
			newsService.deleteNewsById(nid);
			req.getRequestDispatcher("/admin/NewsServlet?method=show_all_news").forward(req, resp);
		}else if (Constants.SHOW_NEWS.equalsIgnoreCase(method)) {
			
			// 查询所有新闻
			List<News> newsList = newsService.findAllNews();
			req.setAttribute("newsList", newsList);
			req.getRequestDispatcher("/admin/newsList.jsp").forward(req, resp);

		}else {
			System.out.println("找不到合适的“method”");
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
