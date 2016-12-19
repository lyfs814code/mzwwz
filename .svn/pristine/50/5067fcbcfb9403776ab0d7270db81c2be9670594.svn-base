package com.ytkl.mzwwz.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.dao.DataAccessException;

import com.ytkl.mzwwz.criteria.LinkInfoCriteria;
import com.ytkl.mzwwz.domain.LinkInfo;

public interface LinkInfoDao {

	int insert(LinkInfo linkInfo) throws DataAccessException;

	int update(LinkInfo linkInfo) throws DataAccessException;
	
	int updateSelective(LinkInfo linkInfo) throws DataAccessException;

	int delete(int id) throws DataAccessException;

	LinkInfo select(int id) throws DataAccessException;

	List<LinkInfo> list(LinkInfoCriteria linkInfoCriteria) throws DataAccessException;
	
	List<LinkInfo> listOnPage(LinkInfoCriteria linkInfoCriteria,RowBounds bounds) throws DataAccessException;
	
	int count(LinkInfoCriteria linkInfoCriteria) throws DataAccessException;

}
