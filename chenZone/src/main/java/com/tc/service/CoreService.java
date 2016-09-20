package com.tc.service;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
//import com.tc.message.resp.TextRespMessage;
import com.tc.util.Constants;
//import com.tc.util.MessageUtil;

/**
 * 核心服务类
 * 
 * @author tc
 * @date 2015-01-23
 */
public class CoreService {
	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 */

	public static String processRequest(HttpServletRequest request) {
		String respMessage = null;
//		try {
//			// 默认返回的文本消息内容
//			String respContent = "请求处理异常，请稍候尝试！";
//			// xml请求解析
//			Map<String, String> requestMap = MessageUtil.parseXml(request);
//			// 发送方帐号（open_id）
//			String fromUserName = requestMap.get("FromUserName");
//			// 公众帐号
//			String toUserName = requestMap.get("ToUserName");
//			// 消息类型
//			String msgType = requestMap.get("MsgType");
//			// 回复文本消息
//			TextRespMessage TextRespMessage = new TextRespMessage();
//			TextRespMessage.setToUserName(fromUserName);
//			TextRespMessage.setFromUserName(toUserName);
//			TextRespMessage.setCreateTime(new Date().getTime());
//			TextRespMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
//			TextRespMessage.setFuncFlag(0);
//			// 文本消息
//			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
//				// respContent =
//				// "<a href=\"http://deardealwith.sinaapp.com/StaffServlet\">Home</a>";
//				// respContent =
//				//respContent = "<a href=\""+Constants.HOME_URL+"\""+">Home</a>";
//				respContent = "<a href=\""+Constants.GET_CODE_URL+"\">纪保机器人¬_¬</a>";
//			}
//			// 图片消息
//			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
//				respContent = "您发送的是图片消息！";
//			}
//			// 地理位置消息
//			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
//				respContent = "您发送的是地理位置消息！";
//			}
//			// 链接消息
//			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
//				respContent = "您发送的是链接消息！";
//			}
//			// 音频消息
//			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
//				respContent = "您发送的是音频消息！";
//			}
//			// 事件推送
//			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
//				// 事件类型
//				String eventType = requestMap.get("Event");
//				// 订阅
//				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
//					respContent = "欢迎加入大纪保！<a href=\""+Constants.GET_CODE_URL+"\">纪保机器人¬_¬</a>";
//				}
//				// 取消订阅
//				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
//					// 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
//				}
//				// 自定义菜单点击事件
//				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
//					//  自定义菜单权没有开放，暂不处理该类消息
//				}
//			}
//			TextRespMessage.setContent(respContent);
//			respMessage = MessageUtil.TextRespMessageToXml(TextRespMessage);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return respMessage;
	}
}
