package org.bigjava.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;

/**
 * Servlet Filter implementation class CharacterEncodingFilter
 */
public class CharacterEncodingFilter implements Filter {

	String globalEncoding = null;

    /**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("初始化");
		globalEncoding = fConfig.getInitParameter("globalEncoding");
		
	}
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("进入处理编码");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		System.out.println("处理编码中");
		if(this.globalEncoding != null) {
			req.setCharacterEncoding(globalEncoding);
			resp.setCharacterEncoding(globalEncoding);
		}
		System.out.println("处理编码完");
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		System.out.println("已发送");
	}
	
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("销毁");
	}

	

	
}
