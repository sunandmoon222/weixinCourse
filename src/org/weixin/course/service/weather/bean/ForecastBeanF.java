package org.weixin.course.service.weather.bean;

public class ForecastBeanF {

	//预报发布时间
	private String releaseTime = "";
	//白天天气现象编号
	private String Forecast_day = "";
	//晚上天气现象编号
	private String Forecast_night = "";
	//白天天气温度(摄氏度)
	private String temperature_day = "";
	//晚上天气温度(摄氏度)
	private String temperature_night = "";
	//白天风向编号
	private String windDirection_day = "";
	//晚上风向编号
	private String windDirection_night  = "";
	//白天风力编号
	private String windPower_day = "";
	//晚上风力编号
	private String windPower_night = "";
	//日出日落时间(中间用|分割)
	private String sunriseAndSunsetTime = "";
	/**
	 * @return the releaseTime
	 */
	public String getReleaseTime() {
		return releaseTime;
	}
	/**
	 * @param releaseTime the releaseTime to set
	 */
	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}
	/**
	 * @return the forecast_day
	 */
	public String getForecast_day() {
		return Forecast_day;
	}
	/**
	 * @param forecast_day the forecast_day to set
	 */
	public void setForecast_day(String forecast_day) {
		Forecast_day = forecast_day;
	}
	/**
	 * @return the forecast_night
	 */
	public String getForecast_night() {
		return Forecast_night;
	}
	/**
	 * @param forecast_night the forecast_night to set
	 */
	public void setForecast_night(String forecast_night) {
		Forecast_night = forecast_night;
	}
	/**
	 * @return the temperature_day
	 */
	public String getTemperature_day() {
		return temperature_day;
	}
	/**
	 * @param temperature_day the temperature_day to set
	 */
	public void setTemperature_day(String temperature_day) {
		this.temperature_day = temperature_day;
	}
	/**
	 * @return the temperature_night
	 */
	public String getTemperature_night() {
		return temperature_night;
	}
	/**
	 * @param temperature_night the temperature_night to set
	 */
	public void setTemperature_night(String temperature_night) {
		this.temperature_night = temperature_night;
	}
	/**
	 * @return the windDirection_day
	 */
	public String getWindDirection_day() {
		return windDirection_day;
	}
	/**
	 * @param windDirection_day the windDirection_day to set
	 */
	public void setWindDirection_day(String windDirection_day) {
		this.windDirection_day = windDirection_day;
	}
	/**
	 * @return the windDirection_night
	 */
	public String getWindDirection_night() {
		return windDirection_night;
	}
	/**
	 * @param windDirection_night the windDirection_night to set
	 */
	public void setWindDirection_night(String windDirection_night) {
		this.windDirection_night = windDirection_night;
	}
	/**
	 * @return the windPower_day
	 */
	public String getWindPower_day() {
		return windPower_day;
	}
	/**
	 * @param windPower_day the windPower_day to set
	 */
	public void setWindPower_day(String windPower_day) {
		this.windPower_day = windPower_day;
	}
	/**
	 * @return the windPower_night
	 */
	public String getWindPower_night() {
		return windPower_night;
	}
	/**
	 * @param windPower_night the windPower_night to set
	 */
	public void setWindPower_night(String windPower_night) {
		this.windPower_night = windPower_night;
	}
	/**
	 * @return the sunriseAndSunsetTime
	 */
	public String getSunriseAndSunsetTime() {
		return sunriseAndSunsetTime;
	}
	/**
	 * @param sunriseAndSunsetTime the sunriseAndSunsetTime to set
	 */
	public void setSunriseAndSunsetTime(String sunriseAndSunsetTime) {
		this.sunriseAndSunsetTime = sunriseAndSunsetTime;
	}
}
