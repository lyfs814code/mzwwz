package com.ytkl.mzwwz.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.dao.DataAccessException;

import com.ytkl.mzwwz.criteria.SysMenuCriteria;
import com.ytkl.mzwwz.domain.SysMenu;

public interface SysMenuDao {

	int insert(SysMenu sysMenu) throws DataAccessException;

	int update(SysMenu sysMenu) throws DataAccessException;
	
	int updateSelective(SysMenu sysMenu) throws DataAccessException;

	int delete(int menuId) throws DataAccessException;

	SysMenu select(int menuId) throws DataAccessException;

	List<SysMenu> list(SysMenuCriteria sysMenuCriteria) throws DataAccessException;
	
	List<SysMenu> listOnPage(SysMenuCriteria sysMenuCriteria,RowBounds bounds) throws DataAccessException;
	
	int count(SysMenuCriteria sysMenuCriteria) throws DataAccessException;

}
