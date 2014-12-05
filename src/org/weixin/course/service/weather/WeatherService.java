package org.weixin.course.service.weather;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
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
import org.weixin.course.service.weather.bean.WeatherCode;

import sun.misc.BASE64Encoder;

public class WeatherService {

	private static WeatherService weatherService = new WeatherService();
	private WeatherService() {
		
	}
	
	private final static String AppId = "76f661f7c047ddd7";
	private final static String IndexType = "index_v";
	private final static String ForecastType = "forecast_v";
	private final static String Private_Key = "425b8d_SmartWeatherAPI_0cf95c4";
	private final static String DateFormat = "yyyyMMddHHmm";
	private final static String DateFormat_1 = "MM月dd日";
	private String releaseTime = "";
	private ForecastBeanC forecastBeanC = null;
	private List<ForecastBeanF> listForecastF = null;
	private List<IndexBean> listIndex = null;
	
	public static List<Article> getWeatherInfo(String area) {
		DateFormat format = new SimpleDateFormat(DateFormat);
		String date = format.format(new Date());
		
		//data初始化
		WeatherCode.init();
		String areaId = WeatherCode.getCityMapValue(area);
		if (areaId == null || areaId.equals("")) return null;
		//常规预报数据
		weatherService.makeJsonDataForecast(areaId,date);
		//指数数据
		weatherService.makeJsonDataIndex(areaId,date);
		
		return weatherService.makeDataInfo(areaId);
	}
	
	private String makeRealeseDate() {
		String temp = releaseTime.substring(8, 10);
		String message = "";
		
		if (temp.equals("08")) {
			message = "上午09:00";
		} else if (temp.equals("11")) {
			message = "上午11:00";
		} else if (temp.equals("18")) {
			message = "下午18:00";
		}
		
		return message;
	}
	
	private String getWeatherScene(String day,String night) {
		String weatherSceneInfo = "";
		if (day.equals(night)) {
			weatherSceneInfo = WeatherCode.getWeatherSceneMapValue(day);
		} else {
			weatherSceneInfo = WeatherCode.getWeatherSceneMapValue(day) + "转" + WeatherCode.getWeatherSceneMapValue(night);
		}
		
		return weatherSceneInfo;
	}
	
	private String getWindInfo(String windDirection_day,
								String windDirection_night,
								String WindPower_day,
								String windPower_night) {
		String windInfo = "";
		
		if (windDirection_day.equals(windDirection_night)) {
			windInfo = WeatherCode.getWindDirectorMapValue(windDirection_day) + 
					WeatherCode.getwindPowerMapValue(WindPower_day) + "转" + 
					WeatherCode.getwindPowerMapValue(windPower_night);
		} else {
			windInfo = WeatherCode.getWindDirectorMapValue(windDirection_day) + 
					WeatherCode.getwindPowerMapValue(WindPower_day) + "转" + 
					WeatherCode.getWindDirectorMapValue(windDirection_night) +
					WeatherCode.getwindPowerMapValue(windPower_night);
		}
		return windInfo;
	}
	
	private List<Article> makeDataInfo(String areaId) {
		List<Article> articleList = new ArrayList<Article>();
		DateFormat format = new SimpleDateFormat(DateFormat);
		DateFormat format1 = new SimpleDateFormat(DateFormat_1);
		Calendar caleander = Calendar.getInstance();
		caleander.setTime(new Date());
		
		String date = "今天";
		try {
			date = format1.format(format.parse(releaseTime));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Article article1 = new Article();  
        article1.setTitle(forecastBeanC.getCity_cn() + "   中国气象局发布时间:" + makeRealeseDate());  
        article1.setDescription("");  
        article1.setPicUrl("http://a2.qpic.cn/psb?/V14Tfb4s4TxSWi/NRCcRVMeqUjc*b7DfTvC0UkPGMQ4C66hyqNp1uAL22c!/b/dBn18KamLQAA&bo=gQJBAQAAAAADAOY!&rf=viewer_4");  
        article1.setUrl("http://m.weather.com.cn/mweather/" + areaId +".shtml?data=7d");
        
        articleList.add(article1);
        
		for (int i = 0; i < listForecastF.size(); i++) {
			ForecastBeanF forecastBeanF = listForecastF.get(i);
			Article article = new Article();  
			String weatherScene = getWeatherScene(forecastBeanF.getForecast_day(),forecastBeanF.getForecast_night());
			String temprature = " " + forecastBeanF.getTemperature_day()+"℃" + forecastBeanF.getTemperature_night()+"℃,";
			String windInfo = getWindInfo(forecastBeanF.getWindDirection_day(),
										   forecastBeanF.getWindDirection_night(),
										   forecastBeanF.getWindPower_day(),
										   forecastBeanF.getWindPower_night());
			
			StringBuffer buffer = new StringBuffer();
			

			if (i == 0) {
				buffer.append("【" + date +"】 ")
				  	  .append(weatherScene)
				      .append(temprature)
				      .append(windInfo);
				article.setTitle(buffer.toString());  				
			} else if (i == 1) {
				buffer.append("【明天】 ")
			  	  .append(weatherScene)
			      .append(temprature)
			      .append(windInfo);
				article.setTitle(buffer.toString());  
			} else if (i == 2) {
				buffer.append("【后天】 ")
			  	  .append(weatherScene)
			      .append(temprature)
			      .append(windInfo);
				article.setTitle(buffer.toString());  
			}

			article.setDescription("");  
			article.setPicUrl(caleander.get(Calendar.HOUR_OF_DAY) > 14?getUrl(forecastBeanF.getForecast_night()):getUrl(forecastBeanF.getForecast_day()));  
			article.setUrl("http://m.weather.com.cn/mweather/" + areaId +".shtml?data=7d");
			
			articleList.add(article);
		}
        
		return articleList;
	}
	
	private String getUrl(String code) {
		String url = "";
		if (code != null) {
			if (code.equals("00")) {
				url = "http://a2.qpic.cn/psb?/V14Tfb4s4TxSWi/Y6*lhdEbATRDIX3wA5XEx*9BCOTNUdIB3lBmYY.yrgg!/b/dDbX6qZSLQAA&bo=UABQAAAAAAADACU!&rf=viewer_4";
			} else {
				
				String[] arr1 = {"01","02","18","29","30","31","53"};
				String[] arr2 = {"03","04","05","06","07","08","09","10","11","12","19","20","21","22","23","24","25"};
				String[] arr3 = {"13","14","15","16","17","26","27","28"};
				
				List<String> list1 = Arrays.asList(arr1);
				List<String> list2 = Arrays.asList(arr2);
				List<String> list3 = Arrays.asList(arr3);
				
				if (list1.contains(code)) {
					url = "http://a2.qpic.cn/psb?/V14Tfb4s4TxSWi/u*Az3RTkrOl4.44P4*GqxGqH69LGZ5O4Q9*rEC.mV0I!/b/dKdG6abpLAAA&bo=UABQAAAAAAADByI!&rf=viewer_4";
				} else if (list2.contains(code)) {
					url = "http://a2.qpic.cn/psb?/V14Tfb4s4TxSWi/t4oV8pNDUDN7OJC5an5Qsdh3kf3aZUFiPnRl4tKqbGc!/b/dJY55qYqLgAA&bo=UABQAAAAAAADACU!&rf=viewer_4";
				} else if (list3.contains(code)) {
					url = "http://a2.qpic.cn/psb?/V14Tfb4s4TxSWi/kGIo0QLPOo5iZqLEVXBX3e5QK01DcLT2MrZ6cjjhTfQ!/b/dP*R8KZ2KAAA&bo=UABQAAAAAAADACU!&rf=viewer_4";					
				}
			}
		}
		return url;
	}
	
	@SuppressWarnings("unchecked")
	private void makeJsonDataIndex(String areaId,String date) {
		
		listIndex = new ArrayList<IndexBean>();
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
		
		listForecastF = new ArrayList<ForecastBeanF>();
		forecastBeanC = new ForecastBeanC();
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
    
	public static void main(String[] args) throws ParseException {
		String reqContent = "大连天气";
		getWeatherInfo(reqContent.replaceAll("\\s*", "").replace("天气", ""));
	}
}
