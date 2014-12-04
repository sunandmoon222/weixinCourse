package org.weixin.course.service.weather.bean;

import java.util.HashMap;
import java.util.Map;

public class WeatherCode {

	private static WeatherCode weatherConstant = new WeatherCode();

	private WeatherCode() {
	}

	// 风力
	private static Map<String, String> windPowerMap = new HashMap<String, String>();
	// 风向
	private static Map<String, String> windDirectorMap = new HashMap<String, String>();
	// 天气现象
	private static Map<String, String> weatherSceneMap = new HashMap<String, String>();

	//初始化map
	public static void init() {
		weatherConstant.setwindPowerMap();
		weatherConstant.setWindDirectorMap();
		weatherConstant.setWeatherSceneMap();
	}

	public static String getwindPowerMap(String key) {
			return key==null||key==""?key:windPowerMap.get(key);
	}
	
	public static String getWindDirectorMap(String key) {
		return key==null||key==""?key:windDirectorMap.get(key);
	}
	public static String getWeatherSceneMap(String key) {
		return key==null||key==""?key:weatherSceneMap.get(key);
	}
	
	// 风力编码
	private void setwindPowerMap() {

		if (windPowerMap.isEmpty()) {
			windPowerMap.put("0", "无持续风向");
			windPowerMap.put("1", "东北风");
			windPowerMap.put("2", "东风");
			windPowerMap.put("3", "东南风");
			windPowerMap.put("4", "南风");
			windPowerMap.put("5", "西南风");
			windPowerMap.put("6", "西风");
			windPowerMap.put("7", "西北风 ");
			windPowerMap.put("8", "北风");
			windPowerMap.put("9", "旋转风 ");
		}
	}

	// 风向编码
	private void setWindDirectorMap() {

		if (windDirectorMap.isEmpty()) {
			windDirectorMap.put("00", "微风");
			windDirectorMap.put("01", "3-4 级");
			windDirectorMap.put("02", "4-5 级");
			windDirectorMap.put("03", "5-6 级");
			windDirectorMap.put("04", "6-7 级");
			windDirectorMap.put("05", "7-8 级");
			windDirectorMap.put("06", "8-9 级");
			windDirectorMap.put("07", "9-10 级");
			windDirectorMap.put("08", "10-11 级");
			windDirectorMap.put("09", "11-12 级");
		}
	}

	// 天气现象编码
	private void setWeatherSceneMap() {

		if (weatherSceneMap.isEmpty()) {
			weatherSceneMap.put("00", "晴");
			weatherSceneMap.put("01", "多云");
			weatherSceneMap.put("02", "阴");
			weatherSceneMap.put("03", "阵雨");
			weatherSceneMap.put("04", "雷阵雨");
			weatherSceneMap.put("05", "雷阵雨伴有冰雹");
			weatherSceneMap.put("06", "雨夹雪");
			weatherSceneMap.put("07", "小雨");
			weatherSceneMap.put("08", "中雨");
			weatherSceneMap.put("09", "大雨");
			weatherSceneMap.put("10", "暴雨");
			weatherSceneMap.put("11", "大暴雨");
			weatherSceneMap.put("12", "特大暴雨");
			weatherSceneMap.put("13", "阵雪");
			weatherSceneMap.put("14", "小雪");
			weatherSceneMap.put("15", "中雪");
			weatherSceneMap.put("16", "大雪");
			weatherSceneMap.put("17", "暴雪");
			weatherSceneMap.put("18", "雾");
			weatherSceneMap.put("19", "冻雨");
			weatherSceneMap.put("20", "沙尘暴");
			weatherSceneMap.put("21", "小到中雨");
			weatherSceneMap.put("22", "中到大雨");
			weatherSceneMap.put("23", "大到暴雨");
			weatherSceneMap.put("24", "暴雨到大暴雨");
			weatherSceneMap.put("25", "大暴雨到特大暴雨");
			weatherSceneMap.put("26", "小到中雪");
			weatherSceneMap.put("27", "中到大雪");
			weatherSceneMap.put("28", "大到暴雪");
			weatherSceneMap.put("29", "浮尘");
			weatherSceneMap.put("30", "扬沙");
			weatherSceneMap.put("31", "强沙尘暴");
			weatherSceneMap.put("53", "霾");
		}
	}
}
