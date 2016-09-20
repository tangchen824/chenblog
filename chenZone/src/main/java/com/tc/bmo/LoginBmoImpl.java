package com.tc.bmo;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tc.dao.LoginDao;
import com.tc.model.User;
import com.tc.util.ResultCode;

@Service("com.tc.bmo.LoginBmo")
public class LoginBmoImpl implements LoginBmo{
	private Logger logger = LoggerFactory.getLogger(this.getClass()); 
    @Resource(name = "com.tc.dao.LoginDao")
	private LoginDao loginDao;
    
	public JSONObject loginCheck(Map<String,Object> param,String optFlowNum) {
		JSONObject result = new JSONObject();
		try {
			User user = this.loginDao.queryUser(param);
			String i = user.getUserid();
//			if(i>0){
//				result.put("resultCode", ResultCode.R_REMARK);
//				result.put("resultMsg", "帐号密码验证成功！");
//			}else{
//				result.put("resultCode", ResultCode.R_FAILURE);
//				result.put("resultMsg", "密码不正确！");
//			}	
		} catch (Exception e) {
			logger.error("错误信息："+e);
			e.printStackTrace();
		}
		return result;
	}
}
