package com.tc.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tc.bmo.LoginBmo;
import com.tc.util.Constants;

/**
 * Description: 登录Controller
 * 
 * @author tc
 * @date 2015-03-12
 * @version v1.0
 */
@Controller
@RequestMapping("login")
public class LoginController {	
	@Resource(name = "com.tc.bmo.LoginBmo")
	private LoginBmo loginBmo;
	
    /**
     * 进入登录页面
     */ 
	@RequestMapping(value = "/page")
	public String page(Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		String loginFlag = (String) session.getAttribute("loginFlag");
		if(loginFlag!=null&&Constants.LOGINSUCCESS.equals(loginFlag)){
			return "redirect:/login/home";
		}else{
			return "redirect:/login/login";
		}
	}
	
    /**
     * 登录验证接口
     */ 
	@ResponseBody 
	@RequestMapping(value = "/loginCheck")
	public JSONObject page(@RequestBody String jsonString,HttpServletRequest request) {

		JSONObject jsonOsbject = JSONObject.parseObject(jsonString);
		Map<String, Object> map = jsonOsbject;
		JSONObject result = loginBmo.loginCheck(map,null);
		return result;
	}
}