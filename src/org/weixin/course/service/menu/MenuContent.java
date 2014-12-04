package org.weixin.course.service.menu;

public class MenuContent {

	/**
	 * zhangtianming的主菜单
	 * 
	 * @return
	 */
	public static String getMainMenu() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("您好，我是聪明的熊大，请回复数字选择服务：").append("\n\n");
		buffer.append("1  天气预报").append("\n");
		buffer.append("2  公交查询").append("\n");
		buffer.append("3  彩票查询").append("\n");
		buffer.append("4  体育彩票").append("\n");
		buffer.append("<a href=\"http://wzcx.runsky.com\">5 违章查询</a>").append("\n");
		buffer.append("6 历史上的今天").append("\n");
		buffer.append("7  人脸识别").append("\n");
		buffer.append("8  聊天唠嗑").append("\n");
		buffer.append("<a href=\"http://120.27.33.23/demo/index.jsp\">9 熊大的网页</a>").append("\n\n");
		buffer.append("回复“?”显示此帮助菜单");
		return buffer.toString();
	}
}
