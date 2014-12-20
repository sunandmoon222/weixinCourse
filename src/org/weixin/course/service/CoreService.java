package org.weixin.course.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.weixin.course.message.ntil.MessageUtil;
import org.weixin.course.message.resp.Article;
import org.weixin.course.message.resp.NewsMessage;
import org.weixin.course.message.resp.TextMessage;
import org.weixin.course.service.caipiao.CaipiaoService;
import org.weixin.course.service.history.TodayInHistoryService;
import org.weixin.course.service.humorous.HumorousService;
import org.weixin.course.service.menu.MenuContent;
import org.weixin.course.service.tax.TaxService;
import org.weixin.course.service.weather.WeatherService;
import org.weixin.course.servlet.SignUtil;
/**
 * 核心服务类
 * 
 * @author zhangtianming
 * @date 2014-11-24
 */
public class CoreService {
	
	private static final Log LOGGER = LogFactory.getLog(CoreService.class);
	
	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 */
	public static String processRequest(HttpServletRequest request) {
		String respMessage = null;
		
		try {

			// 微信加密签名
			String msg_signature = request.getParameter("msg_signature");
			// 时间戳
			String timestamp = request.getParameter("timestamp");
			// 随机数
			String nonce = request.getParameter("nonce");
			// 加密明文类型
//			String encrypt_type = request.getParameter("encrypt_type");
			//解密后的明文字符串
			String dcryptStr = SignUtil.decrypt(msg_signature, MessageUtil.parseXmlToString(request), nonce, timestamp);
			
			// 默认返回的文本消息内容
			String respContent = "请求处理异常，请稍候尝试！";

			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(dcryptStr);

			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");
			// 消息内容
			String reqContent = requestMap.get("Content");

			// 回复文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);

			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				
				if (reqContent.equals("？") || reqContent.equals("?")) { 
					respContent = MenuContent.getMainMenu();

				// 天气查询
				} else if (reqContent.equals("1")) {
					
					respContent = "\ue04a天气预报使用指南\n\n回复：天气+城市名称\n例如：天气大连\n或者：大连天气\n\n回复“?”显示主菜单";
					
				} else if (reqContent.contains("天气")) {
					
					List<Article> articleList = WeatherService.getWeatherInfo(reqContent.replaceAll("\\s*", "").replace("天气", ""));
					
					if (articleList == null) {
						respContent = "看不懂，大侠，请按照规定重新输入\n\n回复：天气+城市名称\n例如：天气大连\n或者：大连天气\n\n回复“?”显示主菜单";
					} else {
						// 创建图文消息  
		                NewsMessage newsMessage = new NewsMessage();
		                
		                newsMessage.setToUserName(fromUserName);  
		                newsMessage.setFromUserName(toUserName);  
		                newsMessage.setCreateTime(new Date().getTime());  
		                newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);  
		                newsMessage.setFuncFlag(0);
		                
		                 
	                    newsMessage.setArticleCount(articleList.size());  
	                    newsMessage.setArticles(articleList);  
	                    
	                    respMessage = SignUtil.encryptMsg(MessageUtil.newsMessageToXml(newsMessage), nonce, timestamp);
	                    
	                    return respMessage;						
					}
				// 福利彩票查询
				} else if (reqContent.equals("3")) {
					
		            List<Article> articleList = CaipiaoService.getFuLiCaipiaoInfo();

		            NewsMessage newsMessage = new NewsMessage();

		            newsMessage.setToUserName(fromUserName);
		            newsMessage.setFromUserName(toUserName);
		            newsMessage.setCreateTime(new Date().getTime());
		            newsMessage.setMsgType("news");
		            newsMessage.setFuncFlag(0);

		            newsMessage.setArticleCount(articleList.size());
		            newsMessage.setArticles(articleList);

		            return SignUtil.encryptMsg(MessageUtil.newsMessageToXml(newsMessage), nonce, timestamp);
		            
				//体育彩票查询 
				} else  if (reqContent.equals("4")) {
		            List<Article> articleList = CaipiaoService.getSportsCaipiaoInfo();

		            NewsMessage newsMessage = new NewsMessage();

		            newsMessage.setToUserName(fromUserName);
		            newsMessage.setFromUserName(toUserName);
		            newsMessage.setCreateTime(new Date().getTime());
		            newsMessage.setMsgType("news");
		            newsMessage.setFuncFlag(0);

		            newsMessage.setArticleCount(articleList.size());
		            newsMessage.setArticles(articleList);

		            return SignUtil.encryptMsg(MessageUtil.newsMessageToXml(newsMessage), nonce, timestamp);
				//历史上的今天
				} else if (reqContent.equals("6")) {
					respContent = TodayInHistoryService.getTodayInHistoryInfo();
				//大连地区发票中奖查询
				} else if (reqContent.equals("8")) { 
				
		            List<Article> articleList = TaxService.getTaxInfo();
		            
		            NewsMessage newsMessage = new NewsMessage();

		            newsMessage.setToUserName(fromUserName);
		            newsMessage.setFromUserName(toUserName);
		            newsMessage.setCreateTime(new Date().getTime());
		            newsMessage.setMsgType("news");
		            newsMessage.setFuncFlag(0);

		            newsMessage.setArticleCount(articleList.size());
		            newsMessage.setArticles(articleList);

		            return SignUtil.encryptMsg(MessageUtil.newsMessageToXml(newsMessage), nonce, timestamp);
				
				} else if (reqContent.equals("9")) {
					respContent = HumorousService.getHumorousInfor();
				} else {
					respContent = "您发送的是文本消息！";
				}
			}
			// 图片消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "您发送的是图片消息！";
			}
			// 地理位置消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "您发送的是地理位置消息！";
			}
			// 链接消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "您发送的是链接消息！";
			}
			// 音频消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "您发送的是音频消息！";
			}
			// 事件推送
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				// 订阅
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					respContent = "谢谢您的关注！";
				}
				// 取消订阅
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
				}
				// 自定义菜单点击事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// TODO 自定义菜单权没有开放，暂不处理该类消息
				}
			}

			textMessage.setContent(respContent);
			respMessage = SignUtil.encryptMsg(MessageUtil.textMessageToXml(textMessage), nonce, timestamp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return respMessage;
	}
}