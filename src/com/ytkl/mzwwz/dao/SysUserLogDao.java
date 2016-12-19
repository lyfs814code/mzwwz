package com.ytkl.mzwwz.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.dao.DataAccessException;

import com.ytkl.mzwwz.criteria.SysUserLogCriteria;
import com.ytkl.mzwwz.domain.SysUserLog;

public interface SysUserLogDao {

	int insert(SysUserLog sysUserLog) throws DataAccessException;

	int update(SysUserLog sysUserLog) throws DataAccessException;
	
	int updateSelective(SysUserLog sysUserLog) throws DataAccessException;

	int delete(int id) throws DataAccessException;

	SysUserLog select(int id) throws DataAccessException;

	List<SysUserLog> list(SysUserLogCriteria sysUserLogCriteria) throws DataAccessException;
	
	List<SysUserLog> listOnPage(SysUserLogCriteria sysUserLogCriteria,RowBounds bounds) throws DataAccessException;
	
	int count(SysUserLogCriteria sysUserLogCriteria) throws DataAccessException;

}
