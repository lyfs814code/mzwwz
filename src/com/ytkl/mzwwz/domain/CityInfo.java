package com.ytkl.mzwwz.domain;

import java.io.Serializable;

/**
 * @author LiYafei
 * @date   2016年12月10日
 */
public class CityInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int cityInfoId;// 系统ID
	private String cityCode;// 城市编码
	private String provinceName;// 省份名称
	private String cityName;// 城市名称
	private String countyName;// 区县名称
	
	public CityInfo() {
	}

	public int getCityInfoId() {
		return cityInfoId;
	}

	public void setCityInfoId(int cityInfoId) {
		this.cityInfoId = cityInfoId;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}
	
	
	
}
