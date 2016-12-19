package com.ytkl.mzwwz.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.dao.DataAccessException;

import com.ytkl.mzwwz.criteria.SysCodeTypeCriteria;
import com.ytkl.mzwwz.domain.SysCodeType;

public interface SysCodeTypeDao {

	int insert(SysCodeType sysCodeType) throws DataAccessException;

	int update(SysCodeType sysCodeType) throws DataAccessException;
	
	int updateSelective(SysCodeType sysCodeType) throws DataAccessException;

	int delete(String codeType) throws DataAccessException;

	SysCodeType select(String codeType) throws DataAccessException;

	List<SysCodeType> list(SysCodeTypeCriteria sysCodeTypeCriteria) throws DataAccessException;
	
	List<SysCodeType> listOnPage(SysCodeTypeCriteria sysCodeTypeCriteria,RowBounds bounds) throws DataAccessException;
	
	int count(SysCodeTypeCriteria sysCodeTypeCriteria) throws DataAccessException;

}
