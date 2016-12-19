package com.ytkl.mzwwz.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.dao.DataAccessException;

import com.ytkl.mzwwz.criteria.SysCodeValueCriteria;
import com.ytkl.mzwwz.domain.SysCodeValue;

public interface SysCodeValueDao {

	int insert(SysCodeValue sysCodeValue) throws DataAccessException;

	int update(SysCodeValue sysCodeValue) throws DataAccessException;
	
	int updateSelective(SysCodeValue sysCodeValue) throws DataAccessException;

	int delete(int id) throws DataAccessException;

	SysCodeValue select(int id) throws DataAccessException;

	List<SysCodeValue> list(SysCodeValueCriteria sysCodeValueCriteria) throws DataAccessException;
	
	List<SysCodeValue> listOnPage(SysCodeValueCriteria sysCodeValueCriteria,RowBounds bounds) throws DataAccessException;
	
	int count(SysCodeValueCriteria sysCodeValueCriteria) throws DataAccessException;

}
