package com.ytkl.mzwwz.domain;

import java.io.Serializable;
import java.sql.Date;

public class CityWeather implements Serializable {

	private static final long serialVersionUID = 1L;

	private int cityWeatherId;// 系统ID
	private String forecastDate;// 预报日期
	private String cityCode;// 城市编码
	private String weatherInfo;// 天气信息
	private String temperature;// 温度信息
	private String windDirection;// 风向风力
	private Date UpdateTime;// 更新时间
	
	public CityWeather() {
	}

	public int getCityWeatherId() {
		return cityWeatherId;
	}

	public void setCityWeatherId(int cityWeatherId) {
		this.cityWeatherId = cityWeatherId;
	}

	public String getForecastDate() {
		return forecastDate;
	}

	public void setForecastDate(String forecastDate) {
		this.forecastDate = forecastDate;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getWeatherInfo() {
		return weatherInfo;
	}

	public void setWeatherInfo(String weatherInfo) {
		this.weatherInfo = weatherInfo;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}

	public Date getUpdateTime() {
		return UpdateTime;
	}

	public void setUpdateTime(Date updateTime) {
		UpdateTime = updateTime;
	}
	
}
