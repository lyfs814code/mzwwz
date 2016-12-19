package com.ytkl.mzwwz.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ytkl.mzwwz.criteria.SysMenuCriteria;
import com.ytkl.mzwwz.dao.SysMenuDao;
import com.ytkl.mzwwz.domain.SysMenu;
import com.ytkl.mzwwz.service.SysMenuService;
import com.ytkl.mzwwz.util.Paging;

@Service
public class SysMenuServiceImpl implements SysMenuService {
	
	@Autowired
	private SysMenuDao sysMenuDao;

	public int insert(SysMenu sysMenu) {
		return sysMenuDao.insert(sysMenu);
	}

	public int update(SysMenu sysMenu) {
		int actualRowsAffected = 0;
		
		int menuId = sysMenu.getMenuId();

		SysMenu _oldSysMenu = sysMenuDao.select(menuId);
		
		if (_oldSysMenu != null) {
			actualRowsAffected = sysMenuDao.update(sysMenu);
		}
		
		return actualRowsAffected;
	}
	
	public int updateSelective(SysMenu sysMenu) {
		int actualRowsAffected = 0;
		
		int menuId = sysMenu.getMenuId();

		SysMenu _oldSysMenu = sysMenuDao.select(menuId);
		
		if (_oldSysMenu != null) {
			actualRowsAffected = sysMenuDao.update(sysMenu);
		}
		
		return actualRowsAffected;
	}
	
	public int delete(int menuId) {
		int actualRowsAffected = 0;
		
		SysMenu _oldSysMenu = sysMenuDao.select(menuId);
		
		if (_oldSysMenu != null) {
			actualRowsAffected = sysMenuDao.delete(menuId);
		}
		
		return actualRowsAffected;
	}
	
	public SysMenu select(int menuId) {
		return sysMenuDao.select(menuId);
	}

	public List<SysMenu> list(SysMenuCriteria sysMenuCriteria) {
		return sysMenuDao.list(sysMenuCriteria);
	}
	
	public List<SysMenu> listOnPage(SysMenuCriteria sysMenuCriteria) {
		int totalResults = sysMenuDao.count(sysMenuCriteria);
		Paging paging = sysMenuCriteria.getPaging();
		paging.setTotalResults(totalResults);
		
		return sysMenuDao.listOnPage(sysMenuCriteria,new RowBounds(paging.getFirstResult(),paging.getMaxResults()));
	}

}
