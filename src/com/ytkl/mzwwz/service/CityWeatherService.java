package com.ytkl.mzwwz.service;

import java.util.List;

import com.ytkl.mzwwz.criteria.CityWeatherCriteria;
import com.ytkl.mzwwz.domain.CityWeather;

public interface CityWeatherService {

	int insert(CityWeather cityWeather);

	int update(CityWeather cityWeather);
	
	int updateSelective(CityWeather cityWeather);

	int delete(int cityWeatherId);
	
	CityWeather select(int cityWeatherId);

	List<CityWeather> list(CityWeatherCriteria cityWeatherCriteria);

	List<CityWeather> listOnPage(CityWeatherCriteria cityWeatherCriteria);

}
