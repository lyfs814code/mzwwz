package com.ytkl.mzwwz.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.dao.DataAccessException;

import com.ytkl.mzwwz.criteria.SysParaCriteria;
import com.ytkl.mzwwz.domain.SysPara;

public interface SysParaDao {

	int insert(SysPara sysPara) throws DataAccessException;

	int update(SysPara sysPara) throws DataAccessException;
	
	int updateSelective(SysPara sysPara) throws DataAccessException;

	int delete(int id) throws DataAccessException;

	SysPara select(int id) throws DataAccessException;

	List<SysPara> list(SysParaCriteria sysParaCriteria) throws DataAccessException;
	
	List<SysPara> listOnPage(SysParaCriteria sysParaCriteria,RowBounds bounds) throws DataAccessException;
	
	int count(SysParaCriteria sysParaCriteria) throws DataAccessException;

}
