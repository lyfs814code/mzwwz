package com.ytkl.mzwwz.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ytkl.mzwwz.criteria.SysUserRoleCriteria;
import com.ytkl.mzwwz.dao.SysUserRoleDao;
import com.ytkl.mzwwz.domain.SysUserRole;
import com.ytkl.mzwwz.service.SysUserRoleService;
import com.ytkl.mzwwz.util.Paging;

@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
	
	@Autowired
	private SysUserRoleDao sysUserRoleDao;

	public int insert(SysUserRole sysUserRole) {
		return sysUserRoleDao.insert(sysUserRole);
	}

	public int update(SysUserRole sysUserRole) {
		int actualRowsAffected = 0;
		
		int id = sysUserRole.getId();

		SysUserRole _oldSysUserRole = sysUserRoleDao.select(id);
		
		if (_oldSysUserRole != null) {
			actualRowsAffected = sysUserRoleDao.update(sysUserRole);
		}
		
		return actualRowsAffected;
	}
	
	public int updateSelective(SysUserRole sysUserRole) {
		int actualRowsAffected = 0;
		
		int id = sysUserRole.getId();

		SysUserRole _oldSysUserRole = sysUserRoleDao.select(id);
		
		if (_oldSysUserRole != null) {
			actualRowsAffected = sysUserRoleDao.update(sysUserRole);
		}
		
		return actualRowsAffected;
	}
	
	public int delete(int id) {
		int actualRowsAffected = 0;
		
		SysUserRole _oldSysUserRole = sysUserRoleDao.select(id);
		
		if (_oldSysUserRole != null) {
			actualRowsAffected = sysUserRoleDao.delete(id);
		}
		
		return actualRowsAffected;
	}
	
	public SysUserRole select(int id) {
		return sysUserRoleDao.select(id);
	}

	public List<SysUserRole> list(SysUserRoleCriteria sysUserRoleCriteria) {
		return sysUserRoleDao.list(sysUserRoleCriteria);
	}
	
	public List<SysUserRole> listOnPage(SysUserRoleCriteria sysUserRoleCriteria) {
		int totalResults = sysUserRoleDao.count(sysUserRoleCriteria);
		Paging paging = sysUserRoleCriteria.getPaging();
		paging.setTotalResults(totalResults);
		
		return sysUserRoleDao.listOnPage(sysUserRoleCriteria,new RowBounds(paging.getFirstResult(),paging.getMaxResults()));
	}

}
