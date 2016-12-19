package com.ytkl.mzwwz.service;

import java.util.List;

import com.ytkl.mzwwz.criteria.CityInfoCriteria;
import com.ytkl.mzwwz.domain.CityInfo;

public interface CityInfoService {

	int insert(CityInfo cityInfo);

	int update(CityInfo cityInfo);
	
	int updateSelective(CityInfo cityInfo);

	int delete(int cityInfoId);
	
	CityInfo select(int cityInfoId);

	List<CityInfo> list(CityInfoCriteria cityInfoCriteria);

	List<CityInfo> listOnPage(CityInfoCriteria cityInfoCriteria);

}
