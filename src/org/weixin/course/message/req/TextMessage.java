package org.weixin.course.message.req;

/**
 * 文本消息
 * 
 * @author zhangtianming
 * @date 2014-11-24
 */
public class TextMessage extends BaseMessage {
	// 消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}
