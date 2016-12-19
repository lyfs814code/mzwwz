package com.ytkl.mzwwz.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.dao.DataAccessException;

import com.ytkl.mzwwz.criteria.SysRoleMenuCriteria;
import com.ytkl.mzwwz.domain.SysRoleMenu;

public interface SysRoleMenuDao {

	int insert(SysRoleMenu sysRoleMenu) throws DataAccessException;

	int update(SysRoleMenu sysRoleMenu) throws DataAccessException;
	
	int updateSelective(SysRoleMenu sysRoleMenu) throws DataAccessException;

	int delete(int id) throws DataAccessException;

	SysRoleMenu select(int id) throws DataAccessException;

	List<SysRoleMenu> list(SysRoleMenuCriteria sysRoleMenuCriteria) throws DataAccessException;
	
	List<SysRoleMenu> listOnPage(SysRoleMenuCriteria sysRoleMenuCriteria,RowBounds bounds) throws DataAccessException;
	
	int count(SysRoleMenuCriteria sysRoleMenuCriteria) throws DataAccessException;

}
