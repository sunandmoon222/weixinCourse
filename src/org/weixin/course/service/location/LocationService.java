package org.weixin.course.service.location;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.weixin.course.message.resp.Article;

import sun.misc.BASE64Decoder;


public class LocationService {


	public static List<Article> getLocationInfor(String location,String beforeLocation_x,String beforeLocation_y) {
		
		String[] locationTemp = location.split("\\|");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		StringBuffer buff = new StringBuffer();
		buff.append("经过熊大的测算，亲附近有：\n")
			.append("1个加油站2台ATM3家电影院4个超市\n5家火锅店6家烧烤店7家洗浴8家KTV\n9家旅店真是十全十美啊"+ emoji(0X1F37A)+ emoji(0X1F3A4)+ emoji(0X1F366)+ emoji(0X1F498))
			.append("\n\n")
			.append("快快点我查看详情"+ emoji(0X1F449))
			.append("\n")
			.append("祝亲玩的愉快~~"+ emoji(0X1F37B));
		
		buff.append("\n\n\n");
		buff.append("变换前坐标:"+ "x:"+beforeLocation_x + "\n");
		buff.append("变换前坐标:"+ "y:"+beforeLocation_y + "\n");
		buff.append("变换后坐标:"+ "x:"+locationTemp[0] + "\n");
		buff.append("变换后坐标:"+ "y:"+locationTemp[1] + "\n");
		
		List<Article> list = new ArrayList<Article>(1);

		Article article = new Article();
		article.setTitle("谢谢亲的配合哦~~");
		article.setDescription(buff.toString());
		article.setPicUrl("");
		article.setUrl("http://www.xutian-technology.com:8080/weixinCourse_sp/place/init.do?location_x="+locationTemp[0]+"&location_y="+locationTemp[1]);

		list.add(article);
		return list;
	}

	public static String getBaiDuLocationXY(String x, String y) {
		String result = "";
        String url = "http://api.map.baidu.com/ag/coord/convert?from=2&to=4&x=" + x + "&y=" + y + "";
        String response = httpRequest(url);
        if (StringUtils.isNotBlank(response)) {
        	
        	JSONObject json = JSONObject.fromObject(response);
        	
        	if (json != null) {
				try {
					byte[] xbuff = new BASE64Decoder().decodeBuffer(String.valueOf(json.get("x")));
					byte[] ybuff = new BASE64Decoder().decodeBuffer(String.valueOf(json.get("y")));
					result = new String(xbuff) + "|" + new String(ybuff);        		
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        }
        return result;
	}
	
	public static String httpRequest(String requestUrl) {
		StringBuffer buffer = null;

		try {
			// 建立连接
			URL url = new URL(requestUrl);
			HttpURLConnection httpUrlConn = (HttpURLConnection) url
					.openConnection();
			httpUrlConn.setDoInput(true);
			httpUrlConn.setRequestMethod("GET");

			// 获取输入流
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);

			// 读取返回结果
			buffer = new StringBuffer();
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}

			// 释放资源
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			httpUrlConn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}
	
    /** 
     * emoji表情转换(hex -> utf-16) 
     *  
     * @param hexEmoji 
     * @return 
     */  
    public static String emoji(int hexEmoji) {  
        return String.valueOf(Character.toChars(hexEmoji));  
    } 
}
