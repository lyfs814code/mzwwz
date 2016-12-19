package com.ytkl.mzwwz.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.dao.DataAccessException;

import com.ytkl.mzwwz.criteria.SysUserCriteria;
import com.ytkl.mzwwz.domain.SysUser;

public interface SysUserDao {

	int insert(SysUser sysUser) throws DataAccessException;

	int update(SysUser sysUser) throws DataAccessException;
	
	int updateSelective(SysUser sysUser) throws DataAccessException;

	int delete(String userid) throws DataAccessException;

	SysUser select(String userid) throws DataAccessException;

	List<SysUser> list(SysUserCriteria sysUserCriteria) throws DataAccessException;
	
	List<SysUser> listOnPage(SysUserCriteria sysUserCriteria,RowBounds bounds) throws DataAccessException;
	
	int count(SysUserCriteria sysUserCriteria) throws DataAccessException;

}
