package com.tc.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.tc.model.*;
//import com.tc.service.LoginService;
import com.tc.util.Constants;
import com.tc.util.SessionStaff;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	LoginService loginService = new LoginService();
//	WeixinUserinfoDAO weixinUserinfoDAO = new WeixinUserinfoDAO();
//	StaffDAO staffDAO = new StaffDAO();
	private Logger log = LoggerFactory.getLogger(this.getClass()); 

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获取STATE
		String state = request.getParameter("state");
		// 获取CODE
		String code = request.getParameter("code");
		if (code != null) {
//			if (state.equals(Constants.STATE_1)) {
//				JSONObject demoJson = loginService.getAccess_token(code);
//				@SuppressWarnings("unchecked")
//				Map<String, Object> demo = demoJson;
//				if (demo != null && demo.get("errcode") == null) {
//					logger.debug(this.getClass().toString() + demoJson);
//					String access_token = (String) demo.get("access_token");
//					String openid = (String) demo.get("openid");
//					String refresh_token = (String) demo.get("refresh_token");
//					String scope = (String) demo.get("scope");
//					request.getSession().setAttribute("openid", openid);
//					request.getSession().setAttribute("access_token", access_token);
//					request.getSession().setAttribute("refresh_token", refresh_token);
//					request.getSession().setAttribute("scope", scope);
//					request.getSession().setAttribute("access_token",access_token);
//					request.getSession().setAttribute("openid", openid);
//					request.getSession().setAttribute("ifAdmin","0");
//					request.getSession().setAttribute("ifSimulateLogin","0");
//					if (Constants.SCOPE_SNSAPI_TYPE
//							.equals(Constants.SCOPE_SNSAPI_USERINFO)) {// 获取全部信息
//						JSONObject user_info = loginService.getUserinfo(
//								access_token, openid);
//						@SuppressWarnings("unchecked")
//						Map<String, Object> user_infoMap = user_info;
//						String nickname = (String) user_infoMap.get("nickname");
//						String sex = (String) "" + user_infoMap.get("sex");
//						String province = (String) user_infoMap.get("province");
//						String city = (String) user_infoMap.get("city");
//						String country = (String) user_infoMap.get("country");
//						String headimgurl = "";
//						if(user_infoMap.get("headimgurl")!=null)
//							headimgurl = (String) user_infoMap.get("headimgurl");
//						request.getSession().setAttribute("nickname", nickname);
//						request.getSession().setAttribute("sex", sex);
//						request.getSession().setAttribute("province", province);
//						request.getSession().setAttribute("city", city);
//						request.getSession().setAttribute("country", country);
//						request.getSession().setAttribute("headimgurl",headimgurl);
//						if (weixinUserinfoDAO.findByOpenid(openid).size() == 0) {
//							request.getRequestDispatcher("resources/html/staff/completeInfo.jsp").forward(request, response);
//							return;
//						
//						}
//						List<?> stafflist= staffDAO.findByOpenid(openid);
//						if(stafflist.size()!=0){
//							Staff staff = (Staff) stafflist.get(0);
//							SessionStaff SessionStff = SessionStaff.setStaffInfoFromStaff(staff);
//							request.getSession().setAttribute(Constants.SESSIONSTAFF, SessionStff);
//							request.getSession().setAttribute("staffId",staff.getStaffId()+"");
//							request.getSession().setAttribute("staffName",staff.getStaffName());
//							request.getSession().setAttribute("nickName",staff.getNickname());
//						}else{
//							request.getRequestDispatcher("resources/html/staff/completeInfo.jsp").forward(request, response);
//							return;
//						}
//						request.getSession().setAttribute("loginFlag",Constants.LOGINSUCCESS);
//					}
//					request.getRequestDispatcher("resources/html/staff/loginSuccess.jsp").forward(request, response);
//					return;
//				} else {
//					Object errcode = demo.get("errcode");
//					String errcode2 = errcode.toString();
//					logger.error(this.getClass().toString() + demoJson);
//					request.setAttribute("errcode", errcode2);
//					request.setAttribute("errmsg", demo.get("errmsg"));
//					request.setAttribute("code", code);
//					request.getRequestDispatcher("resources/html/staff/loginFailure.jsp").forward(request, response);
//					return;
//				}
//			}
		} else
			response.sendRedirect("resources/html/staff/failure.jsp");// 重定向
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
}
