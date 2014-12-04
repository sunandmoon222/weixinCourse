package org.weixin.course.service.weather;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.weixin.course.message.resp.Article;
import org.weixin.course.service.weather.bean.ForecastBeanC;
import org.weixin.course.service.weather.bean.ForecastBeanF;
import org.weixin.course.service.weather.bean.IndexBean;

import sun.misc.BASE64Encoder;

public class WeatherService {

	private final static String AppId = "76f661f7c047ddd7";
	private final static String IndexType = "index_v";
	private final static String ForecastType = "forecast_v";
	private final static String Private_Key = "425b8d_SmartWeatherAPI_0cf95c4";
	private final static String DateFormat = "yyyyMMddHHmm";
	private String releaseTime = "";
	private ForecastBeanC forecastBeanC = new ForecastBeanC();
	private List<ForecastBeanF> listForecastF = new ArrayList<ForecastBeanF>();
	private List<IndexBean> listIndex = new ArrayList<IndexBean>();
	
	public static void main(String[] args) {  
		
		WeatherService weatherService = new WeatherService();
		weatherService.getWeatherInfo("101070202");
		
//		return null;
	}
	
	private String getWeatherInfo(String areaId) {
		DateFormat format = new SimpleDateFormat(DateFormat);
		String date = format.format(new Date());

		//常规预报数据
		makeJsonDataForecast(areaId,date);
		//指数数据
		makeJsonDataIndex(areaId,date);
		
		return makeDataInfo();
	}
	
	private String makeDataInfo() {
		List<Article> articleList = new ArrayList<Article>();
		
        Article article1 = new Article();  
        article1.setTitle("微信公众帐号开发教程\n引言");  
        article1.setDescription("");  
        article1.setPicUrl("");  
        article1.setUrl("http://blog.csdn.net/lyq8479/article/details/8937622");  

        Article article2 = new Article();  
        article2.setTitle("第2篇\n微信公众帐号的类型");  
        article2.setDescription("");  
        article2.setPicUrl("");  
        article2.setUrl("http://blog.csdn.net/lyq8479/article/details/8941577");  

        Article article3 = new Article();  
        article3.setTitle("第3篇\n开发模式启用及接口配置");  
        article3.setDescription("");  
        article3.setPicUrl("");  
        article3.setUrl("http://blog.csdn.net/lyq8479/article/details/8944988");  

        articleList.add(article1);  
        articleList.add(article2);  
        articleList.add(article3); 
        
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private void makeJsonDataIndex(String areaId,String date) {
		
		String respData = returnResponseData(areaId, IndexType, date);

		JSONObject json = JSONObject.fromObject(respData); 
		Iterator<String> iter=json.keys();
		String key = "";
		
		while(iter.hasNext()){ 
			key = iter.next();
			JSONArray jArray = (JSONArray)json.get(key);
			for (int i = 0; i < jArray.size(); i++) {
				
				JSONObject json1 = (JSONObject)jArray.get(i);
				IndexBean indexBean = new IndexBean();
				indexBean.setName_en(json1.getString("i1"));
				indexBean.setName_cn(json1.getString("i2"));
				indexBean.setName_alias(json1.getString("i3"));
				indexBean.setLevel(json1.getString("i4"));
				indexBean.setContent(json1.getString("i5"));
				
				listIndex.add(indexBean);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private void makeJsonDataForecast(String areaId,String date) {
		
		String respData = returnResponseData(areaId, ForecastType, date);

		JSONObject json = JSONObject.fromObject(respData); 
		Iterator<String> iter=json.keys();
		String key = "";
		
		while(iter.hasNext()){ 
			key = iter.next();
			if (key.equals("c")) {
				JSONObject json1 = (JSONObject)json.get(key);
				forecastBeanC.setAreaId(json1.getString("c1"));
				forecastBeanC.setCity_en(json1.getString("c2"));
				forecastBeanC.setCity_cn(json1.getString("c3"));
				forecastBeanC.setCityBelongCity_en(json1.getString("c4"));
				forecastBeanC.setCityBelongCity_cn(json1.getString("c5"));
				forecastBeanC.setCityBelongDepartment_en(json1.getString("c6"));
				forecastBeanC.setCityBelongDepartment_cn(json1.getString("c7"));
				forecastBeanC.setCityBelongContry_en(json1.getString("c8"));
				forecastBeanC.setCityBelongContry_cn(json1.getString("c9"));
				forecastBeanC.setCityLevel(json1.getString("c10"));
				forecastBeanC.setCityCode(json1.getString("c11"));
				forecastBeanC.setCityZip(json1.getString("c12"));
				forecastBeanC.setLongitude(json1.getString("c13"));
				forecastBeanC.setLatitude(json1.getString("c14"));
				forecastBeanC.setHeight(json1.getString("c15"));
				forecastBeanC.setRadarNum(json1.getString("c16"));
			} else {
				JSONObject json2 = (JSONObject)json.get(key);
				Iterator<String> iter2=json2.keys();
				while(iter2.hasNext()){ 
					key = iter2.next();
					if (key.equals("f0")) {
						releaseTime = json2.get(key).toString();
					} else if (key.equals("f1")) {
						JSONArray jArray = (JSONArray)json2.get(key);
						
						for (int i = 0; i < jArray.size(); i++) {
							
							JSONObject json3 = (JSONObject)jArray.get(i);
							
							ForecastBeanF forecastBeanF = new ForecastBeanF();
							
							forecastBeanF.setForecast_day(json3.getString("fa"));
							forecastBeanF.setForecast_night(json3.getString("fb"));
							forecastBeanF.setTemperature_day(json3.getString("fc"));
							forecastBeanF.setTemperature_night(json3.getString("fd"));
							forecastBeanF.setWindDirection_day(json3.getString("fe"));
							forecastBeanF.setWindDirection_night(json3.getString("ff"));
							forecastBeanF.setWindPower_day(json3.getString("fg"));
							forecastBeanF.setWindPower_night(json3.getString("fh"));
							forecastBeanF.setSunriseAndSunsetTime(json3.getString("fi"));
							
							listForecastF.add(forecastBeanF);
						}
					}
				}
			}
		}
	}
	
	
	private String returnResponseData(String areaId,String type,String date) {
		
		//编辑加密字符串
		String encodeUrl = "http://open.weather.com.cn/data/?areaid="+areaId+"&type="+type+"&date="+date+"&appid="+AppId;
		//加密
		String encoder = standardURLEncoder(encodeUrl);
		//请求URL
		String requestUrl = "http://open.weather.com.cn/data/?areaid="+areaId+"&type="+type+"&date="+date+"&appid="+AppId.substring(0, 6)+"&key="+encoder; 
		String respData = httpRequest(requestUrl);
		
		return respData;
	}
	
	private String httpRequest(String requestUrl) {
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
	
    private String standardURLEncoder(String data) {  
        byte[] byteHMAC = null;  
        String urlEncoder = "" ;
        try {
            Mac mac = Mac.getInstance("HmacSHA1");  
            SecretKeySpec spec = new SecretKeySpec(Private_Key.getBytes(), "HmacSHA1");  
            mac.init(spec);  
            byteHMAC = mac.doFinal(data.getBytes());
            if(byteHMAC != null){
	            String oauth = new BASE64Encoder().encode(byteHMAC);
	            if(StringUtils.isNotBlank(oauth)){
	            	urlEncoder = URLEncoder.encode( oauth , "utf8"); 
	            }
            }
        } catch (InvalidKeyException e1) {  
            e1.printStackTrace();  
        } catch (Exception e2) {  
        	e2.printStackTrace();
        }
        return urlEncoder;
    } 
}
