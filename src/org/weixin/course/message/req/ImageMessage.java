package org.weixin.course.message.req;

/**
 * 文本消息
 * 
 * @author zhangtianming
 * @date 2014-11-24
 */
public class ImageMessage extends BaseMessage {
	// 图片链接  
    private String PicUrl;  
  
    public String getPicUrl() {  
        return PicUrl;  
    }  
  
    public void setPicUrl(String picUrl) {  
        PicUrl = picUrl;  
    }  
}
