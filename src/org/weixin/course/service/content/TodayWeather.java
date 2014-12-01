package org.weixin.course.service.content;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TodayWeather {

	/**
	 * 发起http get请求获取网页源代码
	 * 
	 * @param requestUrl
	 * @return
	 */
	private static String httpRequest(String requestUrl) {
		StringBuffer buffer = null;

		try {
			// 建立连接
			URL url = new URL(requestUrl);
			HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
			httpUrlConn.setDoInput(true);
			httpUrlConn.setRequestMethod("GET");

			// 获取输入流
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

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
	 * 解析气象信息
	 * 
	 * @param json
	 * @return
	 */
	private static String extract(String strData) {
		
		JSONArray jsonArray = JSONObject.fromObject(strData).getJSONArray("face"); 
		
		return null;
	}

	/**
	 * 封装历史上的今天查询方法，供外部调用
	 * 
	 * @return
	 */
	public static String getTodayWeatherInfo() {
		// 获取气象网中
		String strData = httpRequest("http://m.weather.com.cn/mzs/101010100.shtml?flag=ct");
		
		//当前温度数据
		http://www.weather.com.cn/data/sk/101070201.html
		
		
		//当前空气质量 
//		http://m.weather.com.cn/maqi/101070201.shtml
		
		//当前穿衣指数
//		http://m.weather.com.cn/mzs/101010100.shtml?flag=ct
		
		//15天气数据
//		String strData = httpRequest("http://m.weather.com.cn/mweather15d/101070201.shtml");
		
		// 解析气象信息
//		String result = extract(strData);
		

		return strData;
	}

	/**
	 * 通过main在本地测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String info = getTodayWeatherInfo();
		System.out.println(info);
	}
}
