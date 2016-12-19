package com.ytkl.mzwwz.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ytkl.mzwwz.criteria.SysRoleMenuCriteria;
import com.ytkl.mzwwz.dao.SysRoleMenuDao;
import com.ytkl.mzwwz.domain.SysRoleMenu;
import com.ytkl.mzwwz.service.SysRoleMenuService;
import com.ytkl.mzwwz.util.Paging;

@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {
	
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;

	public int insert(SysRoleMenu sysRoleMenu) {
		return sysRoleMenuDao.insert(sysRoleMenu);
	}

	public int update(SysRoleMenu sysRoleMenu) {
		int actualRowsAffected = 0;
		
		int id = sysRoleMenu.getId();

		SysRoleMenu _oldSysRoleMenu = sysRoleMenuDao.select(id);
		
		if (_oldSysRoleMenu != null) {
			actualRowsAffected = sysRoleMenuDao.update(sysRoleMenu);
		}
		
		return actualRowsAffected;
	}
	
	public int updateSelective(SysRoleMenu sysRoleMenu) {
		int actualRowsAffected = 0;
		
		int id = sysRoleMenu.getId();

		SysRoleMenu _oldSysRoleMenu = sysRoleMenuDao.select(id);
		
		if (_oldSysRoleMenu != null) {
			actualRowsAffected = sysRoleMenuDao.update(sysRoleMenu);
		}
		
		return actualRowsAffected;
	}
	
	public int delete(int id) {
		int actualRowsAffected = 0;
		
		SysRoleMenu _oldSysRoleMenu = sysRoleMenuDao.select(id);
		
		if (_oldSysRoleMenu != null) {
			actualRowsAffected = sysRoleMenuDao.delete(id);
		}
		
		return actualRowsAffected;
	}
	
	public SysRoleMenu select(int id) {
		return sysRoleMenuDao.select(id);
	}

	public List<SysRoleMenu> list(SysRoleMenuCriteria sysRoleMenuCriteria) {
		return sysRoleMenuDao.list(sysRoleMenuCriteria);
	}
	
	public List<SysRoleMenu> listOnPage(SysRoleMenuCriteria sysRoleMenuCriteria) {
		int totalResults = sysRoleMenuDao.count(sysRoleMenuCriteria);
		Paging paging = sysRoleMenuCriteria.getPaging();
		paging.setTotalResults(totalResults);
		
		return sysRoleMenuDao.listOnPage(sysRoleMenuCriteria,new RowBounds(paging.getFirstResult(),paging.getMaxResults()));
	}

}
