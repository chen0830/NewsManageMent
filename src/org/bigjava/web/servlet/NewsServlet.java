package org.bigjava.web.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class NewsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		System.out.println("处理请求时,doGet()方法被调用。");
//        String initParam = getInitParameter("initParam");
//        System.out.println(initParam);
//        String contextParam =this.getServletContext().getInitParameter("contextParam");	
//		System.out.println("系统初始化参数" + contextParam);
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String password = req.getParameter("password");
	
		if("root".equals(username)&&"123456".equals(password)) {
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			req.getRequestDispatcher("welcome.jsp").forward(req,resp);
		}else {
			resp.sendRedirect("login.jsp");
		}
	}

//	@Override
//	public void destroy() {
//		// TODO Auto-generated method stub
//		super.destroy();
//	}
//
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		// TODO Auto-generated method stub
//		super.init(config);
//	}

	
}
