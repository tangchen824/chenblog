package com.tc.common;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.tc.log.Log;
import com.tc.util.SessionStaff;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class InterfaceUtil {
	private static Log log = Log.getLog(InterfaceUtil.class);
	
	private static final String ENCODING = "UTF-8";

	// HTTP WEBSERVICE SIMULATE
	private static final String HTTP_WAY = "HTTP";
	private static final String WS_WAY = "WS";
	private static final String SIMULATE_WAY = "SIMULATE";

	private static final String JSON_CONTENT_TYPE = "application/json";

	/** 数据路由关键字，根据此标识读取不同数据源的配置数据 */
	public static final String DATABUS_DBKEYWORD = "dbKeyWord";

	private static HttpServletRequest request = null;

	// private static final String INVOKEWAY = HTTPWAY;

	// private static List<String> simulateList = new ArrayList<String>();
	//
	// @Autowired
	// PropertiesUtils propertiesUtils;
	//
	static {
		
	}

	@SuppressWarnings("unchecked")
	public static Map<String,Object> callHttp(Map<String, Object> dataBusMap, String serviceCode, String optFlowNum,SessionStaff sessionStaff) throws Exception{
		Map<String, Object> returnMap = new HashMap<String, Object>();
		// 开始调用
		request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String paramString = "";
		String retnJson = "";
		String intfUrl = "";
		String logSeqId = "";
		// 判断是否启用默认HTTP调用方式
		String invokeWay = HTTP_WAY;
		if ("HTTP".equals(invokeWay)) {
			invokeWay = HTTP_WAY;
		} else {
			// 未启用则从simulate配置文件中读取各接口对应的调用方式
			invokeWay = WS_WAY;
		}
		if (HTTP_WAY.equals(invokeWay)) {
			String contentType = JSON_CONTENT_TYPE;
			ResourceBundle prb  =null;
//			try {
//				 prb = ResourceBundle.getBundle("/config/httpClientConfig.properties");
//			} catch (Exception e) {
//				//"读取客户端配置文件异常";
//				log.error("读取客户端配置文件异常 config/httpClientConfig.properties:", e);
//			}
//			intfUrl = prb.getString("Url")+serviceCode;
			intfUrl = serviceCode;
			// 添加标识ID TODO
			logSeqId = "123";
			long beginTime = System.currentTimeMillis();
			paramString = JSONUtils.valueToString(dataBusMap);
			returnMap = httpCall(paramString, intfUrl, contentType, optFlowNum, sessionStaff,
					beginTime, logSeqId);
		} else if (WS_WAY.equals(invokeWay)) {

		} else if (SIMULATE_WAY.equals(invokeWay)) {
			// 模拟调用，从文件得到json格式返回值
			retnJson = "{'msg':'模拟返回报文'}";
			returnMap =  JSONObject.fromObject(retnJson);
		} else {

		}
		return returnMap;
	}
	
	@SuppressWarnings("unchecked")
	private static Map<String, Object> httpCall(String paramString, String reqUrl,
			String contentType, String optFlowNum, SessionStaff sessionStaff, long beginTime, String logSeqId)
					throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		long startTime = System.currentTimeMillis();
		String retnJson = "";
		HttpPost post = null;
		HttpEntity entity = null;
		try {
			// 调用http服务
			log.debug("reqUrl:{},paramString:{}", reqUrl, paramString);
			post = new HttpPost(reqUrl);
			post.addHeader("Content-Type", contentType);
			entity = new StringEntity(paramString, ENCODING);
			post.setEntity(entity);
			HttpResponse httpresponse = MyHttpclient.getInstance().getHttpclient().execute(post);
			entity = httpresponse.getEntity();
			retnJson = EntityUtils.toString(entity, ENCODING);
			log.debug("reqUrl:{},retnJson:{}", reqUrl, retnJson);
			// 返回成功
			if (httpresponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				returnMap =  JSONObject.fromObject(retnJson);
			} else {
				String msg = "HTTP调用失败(http code:" + httpresponse.getStatusLine().getStatusCode() + ")";
				log.error(msg + retnJson);
				msg = reqUrl + "\n" + msg + "\n" + retnJson;
				throw new Exception("http请求失败！"+msg);
			}
		} catch (IOException ioe) {
			log.error("HTTP调用异常", ioe);
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("paramString", paramString);
			if (ioe instanceof SocketTimeoutException) {
				String msg = ioe.getMessage();
				if ("Read timed out".equals(msg)) {
					msg = reqUrl + "\n" + msg;
					throw new Exception("http请求失败！"+msg);
				}
			} else if (ioe.getCause() != null) {
				String msg = ioe.getCause().getMessage();
				if ("Connection timed out: connect".equals(msg)) {
					msg = reqUrl + "\n" + msg + "\n" + ioe.getMessage();
					throw new Exception("http请求失败！"+msg);
				}
			}
			throw new Exception("http请求失败！");
		} catch (Exception ie) {
			throw ie;
		} finally {
			post.abort();// 连接停止，释放资源
			try {
				if (null != entity) {
					EntityUtils.consume(entity);
				}
			} catch (IOException e) {
				log.error("HTTP调用释放资源异常", e);
			}
		}
		long useTime = System.currentTimeMillis() - startTime;
		log.debug("http call use time {} ms", useTime);
		return returnMap;
	}
}
