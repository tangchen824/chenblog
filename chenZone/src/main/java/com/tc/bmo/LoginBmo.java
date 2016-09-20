package com.tc.bmo;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;
public interface LoginBmo {
	/**
	 * 验证帐号密码，返回check结果
	 * loginType为区别管理员和用户登录 ，1为用户，0为管理员
	 */
	public JSONObject loginCheck(Map<String,Object> param,String optFlowNum);
}
