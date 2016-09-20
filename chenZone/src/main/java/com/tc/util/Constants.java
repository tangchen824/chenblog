package com.tc.util;

public final class Constants {
	/** 各种IP配置 */
	public static final String IP ="http://deardealwith.sinaapp.com";
//	public static final String IP ="http://deardealwith.ngrok.com/DearDealWith";
//	public static final String IP ="http://localhost:8881/DearDealWith";
	/** 公众号的唯一标识 */
	public static final String APP_ID = "wx883dbff46a47c7fc";
//	public static final String APP_ID = "wxfad9978c7ea90a19";
	/** 公众号的appsecret */
	public static final String APPSECRET = "6117cb39f350cba2dcd44a604ea170cc";
//	public static final String APPSECRET = "7575ee03d6f6e9fd0fd5aaccdb8ff44c";
	/** 授权后重定向的回调链接地址 需urlencode对链接进行处理*/
//	public static final String REDIRECT_URL = "http://deardealwith.sinaapp.com/LoginServlet";
//	public static final String REDIRECT_URL = Constants.IP+"/LoginServlet";
	public static final String REDIRECT_URL = "http%3a%2f%2fdeardealwith.sinaapp.com%2fLoginServlet";
	/** STATE */
	public static final String STATE_1 = "1";
	/** 应用授权作用域-snsapi_userinfo */
	public static final String SCOPE_SNSAPI_USERINFO = "snsapi_userinfo";
	/** 应用授权作用域-snsapi_base */
	public static final String SCOPE_SNSAPI_BASE = "snsapi_base";
	/** 应用授权方式 */
	public static final String SCOPE_SNSAPI_TYPE = SCOPE_SNSAPI_USERINFO;
	/** 用户授权URL，获取code */
	public static final String GET_CODE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?" +
			"appid="+Constants.APP_ID+"&redirect_uri="+Constants.REDIRECT_URL+"&response_type=code&scope="
			+Constants.SCOPE_SNSAPI_TYPE+"&state="+Constants.STATE_1+"#wechat_redirect";
	//https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx883dbff46a47c7fc&redirect_uri=http%3a%2f%2fdeardealwith.sinaapp.com%2fLoginServlet&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect
	/** 通过code换取网页授权access_token */
	public static final String GET_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token?" +
			"appid="+Constants.APP_ID+"&secret="+Constants.APPSECRET+"&code=HTTPSERVLETRESPONSECODE&" +
			"grant_type=authorization_code";
	/** 通过ACCESS_TOKEN和OPENID换取用户信息*/
	public static final String GETUSERINFO = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";	
	/** 存在session中的SESSIONSTAFF的对应键值*/
	public static final String SESSIONSTAFF = "sessionStaff";
	/** 登录状态，存入session中loginFlag*/
	public static final String LOGINSUCCESS = "1";
	public static final String LOGINFAILURE = "0";
	/**模拟登录标识*/
	public static final String SIMULATELOGIN = "Y";
	/**Session登录过滤器中 Url中不被过滤的白名单*/
	public static final String[] IGNORE_URI = {
		"/login/addStaff",
		"/tologin.jsp",
		"/login/login",
		"/login/applogin",
		"/login/slogin",
		"/LoginServlet", 
		"/CoreServlet",
		"/resources/js/", 
		"/resources/img/", 
		"/resources/bootstrap/",
		"/resources/css",
		"staff/completeInfo",		
		"/test"
		};
	/**微信注册默认密码*/
	public static final String WEIXIN_PASSWORD = "123456";
	/**宿舍区名字*/
	public static final String JINHANLIN = "金翰林";
	public static final String QINHU = "琴湖";
	public static final String BEIYUAN = "北苑";
	public static final String NANYUAN = "南苑";
	public static final String BEIQING = "北青";
	public static final String ZHONGXING = "中兴";

}
