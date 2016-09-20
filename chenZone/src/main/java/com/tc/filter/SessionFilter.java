package com.tc.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.tc.util.Constants;

public class SessionFilter extends HttpServlet implements Filter {
	/**
	 * 
	 */
	@Override
	public void doFilter(ServletRequest servleRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpServletRequest request = (HttpServletRequest) servleRequest;
		boolean flag = false;
		String url = request.getRequestURI();
		for (String s : Constants.IGNORE_URI) {
			if (url.contains(s)||url.equals("/")||url.equals("")||url.equals("/DearDealWith/")) {//首页被拦截了
				flag = true;
				break;
			}
		}
		if (!flag) {
			HttpSession session = request.getSession();
			String loginFlag = (String) session.getAttribute("loginFlag");
//			Enumeration<String> attrs = session.getAttributeNames();
//			if(attrs.hasMoreElements()){
//			  key : attrs.nextElement();
//			  value : session.getAttribute(attrs.nextElement());
//			}
			if(loginFlag==null||Constants.LOGINFAILURE.equals(loginFlag)){
        		request.setAttribute("msg","SessionFilter:未登录，无权向访问"+url+",请转到登录页！");
				request.getRequestDispatcher("/resources/html/main/tologin.jsp").forward(request, response); 
				return;
        	}
        	else{
//        		SessionStaff sessionStaff = new SessionStaff();
//        		sessionStaff = (SessionStaff) session.getAttribute(Constants.SESSIONSTAFF);
        		}
        	}
		// 已通过验证，用户访问继续
		filterChain.doFilter(servleRequest, servletResponse);
		return;
	}

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

}
