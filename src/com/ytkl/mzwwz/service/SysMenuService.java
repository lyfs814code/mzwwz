package com.ytkl.mzwwz.service;

import java.util.List;

import com.ytkl.mzwwz.criteria.SysMenuCriteria;
import com.ytkl.mzwwz.domain.SysMenu;

public interface SysMenuService {

	int insert(SysMenu sysMenu);

	int update(SysMenu sysMenu);
	
	int updateSelective(SysMenu sysMenu);

	int delete(int menuId);
	
	SysMenu select(int menuId);

	List<SysMenu> list(SysMenuCriteria sysMenuCriteria);

	List<SysMenu> listOnPage(SysMenuCriteria sysMenuCriteria);

}
