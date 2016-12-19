package com.ytkl.mzwwz.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ytkl.mzwwz.criteria.SysUserLogCriteria;
import com.ytkl.mzwwz.dao.SysUserLogDao;
import com.ytkl.mzwwz.domain.SysUserLog;
import com.ytkl.mzwwz.service.SysUserLogService;
import com.ytkl.mzwwz.util.Paging;

@Service
public class SysUserLogServiceImpl implements SysUserLogService {
	
	@Autowired
	private SysUserLogDao sysUserLogDao;

	public int insert(SysUserLog sysUserLog) {
		return sysUserLogDao.insert(sysUserLog);
	}

	public int update(SysUserLog sysUserLog) {
		int actualRowsAffected = 0;
		
		int id = sysUserLog.getId();

		SysUserLog _oldSysUserLog = sysUserLogDao.select(id);
		
		if (_oldSysUserLog != null) {
			actualRowsAffected = sysUserLogDao.update(sysUserLog);
		}
		
		return actualRowsAffected;
	}
	
	public int updateSelective(SysUserLog sysUserLog) {
		int actualRowsAffected = 0;
		
		int id = sysUserLog.getId();

		SysUserLog _oldSysUserLog = sysUserLogDao.select(id);
		
		if (_oldSysUserLog != null) {
			actualRowsAffected = sysUserLogDao.update(sysUserLog);
		}
		
		return actualRowsAffected;
	}
	
	public int delete(int id) {
		int actualRowsAffected = 0;
		
		SysUserLog _oldSysUserLog = sysUserLogDao.select(id);
		
		if (_oldSysUserLog != null) {
			actualRowsAffected = sysUserLogDao.delete(id);
		}
		
		return actualRowsAffected;
	}
	
	public SysUserLog select(int id) {
		return sysUserLogDao.select(id);
	}

	public List<SysUserLog> list(SysUserLogCriteria sysUserLogCriteria) {
		return sysUserLogDao.list(sysUserLogCriteria);
	}
	
	public List<SysUserLog> listOnPage(SysUserLogCriteria sysUserLogCriteria) {
		int totalResults = sysUserLogDao.count(sysUserLogCriteria);
		Paging paging = sysUserLogCriteria.getPaging();
		paging.setTotalResults(totalResults);
		
		return sysUserLogDao.listOnPage(sysUserLogCriteria,new RowBounds(paging.getFirstResult(),paging.getMaxResults()));
	}

}
