package com.ytkl.mzwwz.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ytkl.mzwwz.criteria.CityInfoCriteria;
import com.ytkl.mzwwz.dao.CityInfoDao;
import com.ytkl.mzwwz.domain.CityInfo;
import com.ytkl.mzwwz.service.CityInfoService;
import com.ytkl.mzwwz.util.Paging;

@Service
public class CityInfoServiceImpl implements CityInfoService {
	
	@Autowired
	private CityInfoDao cityInfoDao;

	public int insert(CityInfo cityInfo) {
		return cityInfoDao.insert(cityInfo);
	}

	public int update(CityInfo cityInfo) {
		int actualRowsAffected = 0;
		
		int id = cityInfo.getCityInfoId();

		CityInfo _oldCityInfo = cityInfoDao.select(id);
		
		if (_oldCityInfo != null) {
			actualRowsAffected = cityInfoDao.update(cityInfo);
		}
		
		return actualRowsAffected;
	}
	
	public int updateSelective(CityInfo cityInfo) {
		int actualRowsAffected = 0;
		
		int id = cityInfo.getCityInfoId();

		CityInfo _oldCityInfo = cityInfoDao.select(id);
		
		if (_oldCityInfo != null) {
			actualRowsAffected = cityInfoDao.update(cityInfo);
		}
		
		return actualRowsAffected;
	}
	
	public int delete(int id) {
		int actualRowsAffected = 0;
		
		CityInfo _oldCityInfo = cityInfoDao.select(id);
		
		if (_oldCityInfo != null) {
			actualRowsAffected = cityInfoDao.delete(id);
		}
		
		return actualRowsAffected;
	}
	
	public CityInfo select(int id) {
		return cityInfoDao.select(id);
	}

	public List<CityInfo> list(CityInfoCriteria cityInfoCriteria) {
		return cityInfoDao.list(cityInfoCriteria);
	}
	
	public List<CityInfo> listOnPage(CityInfoCriteria cityInfoCriteria) {
		int totalResults = cityInfoDao.count(cityInfoCriteria);
		Paging paging = cityInfoCriteria.getPaging();
		paging.setTotalResults(totalResults);
		
		return cityInfoDao.listOnPage(cityInfoCriteria,new RowBounds(paging.getFirstResult(),paging.getMaxResults()));
	}

}
