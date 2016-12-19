package com.ytkl.mzwwz.criteria;

import com.ytkl.mzwwz.base.Criteria;

public class CityWeatherCriteria extends Criteria {

	private static final long serialVersionUID = 1L;
	
	private int cityWeatherId;

	public CityWeatherCriteria() {
	}

	public int getCityWeatherId() {
		return cityWeatherId;
	}

	public void setCityWeatherId(int cityWeatherId) {
		this.cityWeatherId = cityWeatherId;
	}

}
