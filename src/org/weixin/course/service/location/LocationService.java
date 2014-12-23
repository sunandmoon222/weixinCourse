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


	public static List<Article> getLocationInfor(String location) {
		
		String[] locationTemp = location.split("\\|");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		
		List<Article> list = new ArrayList<Article>(1);

		Article article = new Article();
		article.setTitle("地理位置");
		article.setDescription("想看看你周围有哪儿些好吃的，好玩的么，快快点我把~~~");
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
}
