package com.ytkl.mzwwz.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.dao.DataAccessException;

import com.ytkl.mzwwz.criteria.SysUserRoleCriteria;
import com.ytkl.mzwwz.domain.SysUserRole;

public interface SysUserRoleDao {

	int insert(SysUserRole sysUserRole) throws DataAccessException;

	int update(SysUserRole sysUserRole) throws DataAccessException;
	
	int updateSelective(SysUserRole sysUserRole) throws DataAccessException;

	int delete(int id) throws DataAccessException;

	SysUserRole select(int id) throws DataAccessException;

	List<SysUserRole> list(SysUserRoleCriteria sysUserRoleCriteria) throws DataAccessException;
	
	List<SysUserRole> listOnPage(SysUserRoleCriteria sysUserRoleCriteria,RowBounds bounds) throws DataAccessException;
	
	int count(SysUserRoleCriteria sysUserRoleCriteria) throws DataAccessException;

}
