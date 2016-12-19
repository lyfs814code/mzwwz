package com.ytkl.mzwwz.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ytkl.mzwwz.criteria.CityWeatherCriteria;
import com.ytkl.mzwwz.dao.CityWeatherDao;
import com.ytkl.mzwwz.domain.CityWeather;
import com.ytkl.mzwwz.service.CityWeatherService;
import com.ytkl.mzwwz.util.Paging;

@Service
public class CityWeatherServiceImpl implements CityWeatherService {
	
	@Autowired
	private CityWeatherDao cityWeatherDao;

	public int insert(CityWeather cityWeather) {
		return cityWeatherDao.insert(cityWeather);
	}

	public int update(CityWeather cityWeather) {
		int actualRowsAffected = 0;
		
		int id = cityWeather.getCityWeatherId();

		CityWeather _oldCityWeather = cityWeatherDao.select(id);
		
		if (_oldCityWeather != null) {
			actualRowsAffected = cityWeatherDao.update(cityWeather);
		}
		
		return actualRowsAffected;
	}
	
	public int updateSelective(CityWeather cityWeather) {
		int actualRowsAffected = 0;
		
		int id = cityWeather.getCityWeatherId();

		CityWeather _oldCityWeather = cityWeatherDao.select(id);
		
		if (_oldCityWeather != null) {
			actualRowsAffected = cityWeatherDao.update(cityWeather);
		}
		
		return actualRowsAffected;
	}
	
	public int delete(int id) {
		int actualRowsAffected = 0;
		
		CityWeather _oldCityWeather = cityWeatherDao.select(id);
		
		if (_oldCityWeather != null) {
			actualRowsAffected = cityWeatherDao.delete(id);
		}
		
		return actualRowsAffected;
	}
	
	public CityWeather select(int id) {
		return cityWeatherDao.select(id);
	}

	public List<CityWeather> list(CityWeatherCriteria cityWeatherCriteria) {
		return cityWeatherDao.list(cityWeatherCriteria);
	}
	
	public List<CityWeather> listOnPage(CityWeatherCriteria cityWeatherCriteria) {
		int totalResults = cityWeatherDao.count(cityWeatherCriteria);
		Paging paging = cityWeatherCriteria.getPaging();
		paging.setTotalResults(totalResults);
		
		return cityWeatherDao.listOnPage(cityWeatherCriteria,new RowBounds(paging.getFirstResult(),paging.getMaxResults()));
	}

}
