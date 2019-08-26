package org.bigjava.util;

import javax.servlet.http.HttpServletRequest;

public class MessageUtil {
	
	public static void REQ_INFO_SETTING(HttpServletRequest req, String key, String globalMsg) {
		req.setAttribute(key, globalMsg);
	}
	
	public static void SES_INFO_SETTING(HttpServletRequest req, String key, String globalMsg) {
		req.getSession().setAttribute(key, globalMsg);
	}
	
	public static void APP_INFO_SETTING(HttpServletRequest req, String key, String globalMsg) {
		req.getServletContext().setAttribute(key, globalMsg);
	}

}
