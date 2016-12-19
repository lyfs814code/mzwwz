package com.ytkl.mzwwz.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ytkl.mzwwz.criteria.SysUserCriteria;
import com.ytkl.mzwwz.dao.SysUserDao;
import com.ytkl.mzwwz.domain.SysUser;
import com.ytkl.mzwwz.service.SysUserService;
import com.ytkl.mzwwz.util.Paging;

@Service
public class SysUserServiceImpl implements SysUserService {
	
	@Autowired
	private SysUserDao sysUserDao;

	public int insert(SysUser sysUser) {
		return sysUserDao.insert(sysUser);
	}

	public int update(SysUser sysUser) {
		int actualRowsAffected = 0;
		
		String userid = sysUser.getUserid();

		SysUser _oldSysUser = sysUserDao.select(userid);
		
		if (_oldSysUser != null) {
			actualRowsAffected = sysUserDao.update(sysUser);
		}
		
		return actualRowsAffected;
	}
	
	public int updateSelective(SysUser sysUser) {
		int actualRowsAffected = 0;
		
		String userid = sysUser.getUserid();

		SysUser _oldSysUser = sysUserDao.select(userid);
		
		if (_oldSysUser != null) {
			actualRowsAffected = sysUserDao.update(sysUser);
		}
		
		return actualRowsAffected;
	}
	
	public int delete(String userid) {
		int actualRowsAffected = 0;
		
		SysUser _oldSysUser = sysUserDao.select(userid);
		
		if (_oldSysUser != null) {
			actualRowsAffected = sysUserDao.delete(userid);
		}
		
		return actualRowsAffected;
	}
	
	public SysUser select(String userid) {
		return sysUserDao.select(userid);
	}

	public List<SysUser> list(SysUserCriteria sysUserCriteria) {
		return sysUserDao.list(sysUserCriteria);
	}
	
	public List<SysUser> listOnPage(SysUserCriteria sysUserCriteria) {
		int totalResults = sysUserDao.count(sysUserCriteria);
		Paging paging = sysUserCriteria.getPaging();
		paging.setTotalResults(totalResults);
		
		return sysUserDao.listOnPage(sysUserCriteria,new RowBounds(paging.getFirstResult(),paging.getMaxResults()));
	}

}
