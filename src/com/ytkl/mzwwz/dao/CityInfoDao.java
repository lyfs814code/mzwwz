package com.ytkl.mzwwz.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.dao.DataAccessException;

import com.ytkl.mzwwz.criteria.CityInfoCriteria;
import com.ytkl.mzwwz.domain.CityInfo;

public interface CityInfoDao {

	int insert(CityInfo cityInfo) throws DataAccessException;

	int update(CityInfo cityInfo) throws DataAccessException;
	
	int updateSelective(CityInfo cityInfo) throws DataAccessException;

	int delete(int cityInfoId) throws DataAccessException;

	CityInfo select(int cityInfoId) throws DataAccessException;

	List<CityInfo> list(CityInfoCriteria cityInfoCriteria) throws DataAccessException;
	
	List<CityInfo> listOnPage(CityInfoCriteria cityInfoCriteria,RowBounds bounds) throws DataAccessException;
	
	int count(CityInfoCriteria cityInfoCriteria) throws DataAccessException;

}
