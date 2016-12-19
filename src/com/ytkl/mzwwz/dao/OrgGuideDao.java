package com.ytkl.mzwwz.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.dao.DataAccessException;

import com.ytkl.mzwwz.criteria.OrgGuideCriteria;
import com.ytkl.mzwwz.domain.OrgGuide;

public interface OrgGuideDao {

	int insert(OrgGuide orgGuide) throws DataAccessException;

	int update(OrgGuide orgGuide) throws DataAccessException;
	
	int updateSelective(OrgGuide orgGuide) throws DataAccessException;

	int delete(int id) throws DataAccessException;

	OrgGuide select(int id) throws DataAccessException;

	List<OrgGuide> list(OrgGuideCriteria orgGuideCriteria) throws DataAccessException;
	
	List<OrgGuide> listOnPage(OrgGuideCriteria orgGuideCriteria,RowBounds bounds) throws DataAccessException;
	
	int count(OrgGuideCriteria orgGuideCriteria) throws DataAccessException;

}
