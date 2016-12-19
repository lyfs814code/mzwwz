package com.ytkl.mzwwz.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.dao.DataAccessException;

import com.ytkl.mzwwz.criteria.CityWeatherCriteria;
import com.ytkl.mzwwz.domain.CityWeather;

public interface CityWeatherDao {

	int insert(CityWeather cityWeather) throws DataAccessException;

	int update(CityWeather cityWeather) throws DataAccessException;
	
	int updateSelective(CityWeather cityWeather) throws DataAccessException;

	int delete(int cityWeatherId) throws DataAccessException;

	CityWeather select(int cityWeatherId) throws DataAccessException;

	List<CityWeather> list(CityWeatherCriteria cityWeatherCriteria) throws DataAccessException;
	
	List<CityWeather> listOnPage(CityWeatherCriteria cityWeatherCriteria,RowBounds bounds) throws DataAccessException;
	
	int count(CityWeatherCriteria cityWeatherCriteria) throws DataAccessException;

}
