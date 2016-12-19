package com.ytkl.mzwwz.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ytkl.mzwwz.criteria.SysRoleCriteria;
import com.ytkl.mzwwz.dao.SysRoleDao;
import com.ytkl.mzwwz.domain.SysRole;
import com.ytkl.mzwwz.service.SysRoleService;
import com.ytkl.mzwwz.util.Paging;

@Service
public class SysRoleServiceImpl implements SysRoleService {
	
	@Autowired
	private SysRoleDao sysRoleDao;

	public int insert(SysRole sysRole) {
		return sysRoleDao.insert(sysRole);
	}

	public int update(SysRole sysRole) {
		int actualRowsAffected = 0;
		
		int roleId = sysRole.getRoleId();

		SysRole _oldSysRole = sysRoleDao.select(roleId);
		
		if (_oldSysRole != null) {
			actualRowsAffected = sysRoleDao.update(sysRole);
		}
		
		return actualRowsAffected;
	}
	
	public int updateSelective(SysRole sysRole) {
		int actualRowsAffected = 0;
		
		int roleId = sysRole.getRoleId();

		SysRole _oldSysRole = sysRoleDao.select(roleId);
		
		if (_oldSysRole != null) {
			actualRowsAffected = sysRoleDao.update(sysRole);
		}
		
		return actualRowsAffected;
	}
	
	public int delete(int roleId) {
		int actualRowsAffected = 0;
		
		SysRole _oldSysRole = sysRoleDao.select(roleId);
		
		if (_oldSysRole != null) {
			actualRowsAffected = sysRoleDao.delete(roleId);
		}
		
		return actualRowsAffected;
	}
	
	public SysRole select(int roleId) {
		return sysRoleDao.select(roleId);
	}

	public List<SysRole> list(SysRoleCriteria sysRoleCriteria) {
		return sysRoleDao.list(sysRoleCriteria);
	}
	
	public List<SysRole> listOnPage(SysRoleCriteria sysRoleCriteria) {
		int totalResults = sysRoleDao.count(sysRoleCriteria);
		Paging paging = sysRoleCriteria.getPaging();
		paging.setTotalResults(totalResults);
		
		return sysRoleDao.listOnPage(sysRoleCriteria,new RowBounds(paging.getFirstResult(),paging.getMaxResults()));
	}

}
