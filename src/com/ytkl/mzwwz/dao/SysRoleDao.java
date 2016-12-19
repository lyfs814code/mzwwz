package com.ytkl.mzwwz.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.dao.DataAccessException;

import com.ytkl.mzwwz.criteria.SysRoleCriteria;
import com.ytkl.mzwwz.domain.SysRole;

public interface SysRoleDao {

	int insert(SysRole sysRole) throws DataAccessException;

	int update(SysRole sysRole) throws DataAccessException;
	
	int updateSelective(SysRole sysRole) throws DataAccessException;

	int delete(int roleId) throws DataAccessException;

	SysRole select(int roleId) throws DataAccessException;

	List<SysRole> list(SysRoleCriteria sysRoleCriteria) throws DataAccessException;
	
	List<SysRole> listOnPage(SysRoleCriteria sysRoleCriteria,RowBounds bounds) throws DataAccessException;
	
	int count(SysRoleCriteria sysRoleCriteria) throws DataAccessException;

}
