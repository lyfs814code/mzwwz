package com.ytkl.mzwwz.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ytkl.mzwwz.criteria.SysCodeValueCriteria;
import com.ytkl.mzwwz.dao.SysCodeValueDao;
import com.ytkl.mzwwz.domain.SysCodeValue;
import com.ytkl.mzwwz.service.SysCodeValueService;
import com.ytkl.mzwwz.util.Paging;

@Service
public class SysCodeValueServiceImpl implements SysCodeValueService {
	
	@Autowired
	private SysCodeValueDao sysCodeValueDao;

	public int insert(SysCodeValue sysCodeValue) {
		return sysCodeValueDao.insert(sysCodeValue);
	}

	public int update(SysCodeValue sysCodeValue) {
		int actualRowsAffected = 0;
		
		int id = sysCodeValue.getId();

		SysCodeValue _oldSysCodeValue = sysCodeValueDao.select(id);
		
		if (_oldSysCodeValue != null) {
			actualRowsAffected = sysCodeValueDao.update(sysCodeValue);
		}
		
		return actualRowsAffected;
	}
	
	public int updateSelective(SysCodeValue sysCodeValue) {
		int actualRowsAffected = 0;
		
		int id = sysCodeValue.getId();

		SysCodeValue _oldSysCodeValue = sysCodeValueDao.select(id);
		
		if (_oldSysCodeValue != null) {
			actualRowsAffected = sysCodeValueDao.update(sysCodeValue);
		}
		
		return actualRowsAffected;
	}
	
	public int delete(int id) {
		int actualRowsAffected = 0;
		
		SysCodeValue _oldSysCodeValue = sysCodeValueDao.select(id);
		
		if (_oldSysCodeValue != null) {
			actualRowsAffected = sysCodeValueDao.delete(id);
		}
		
		return actualRowsAffected;
	}
	
	public SysCodeValue select(int id) {
		return sysCodeValueDao.select(id);
	}

	public List<SysCodeValue> list(SysCodeValueCriteria sysCodeValueCriteria) {
		return sysCodeValueDao.list(sysCodeValueCriteria);
	}
	
	public List<SysCodeValue> listOnPage(SysCodeValueCriteria sysCodeValueCriteria) {
		int totalResults = sysCodeValueDao.count(sysCodeValueCriteria);
		Paging paging = sysCodeValueCriteria.getPaging();
		paging.setTotalResults(totalResults);
		
		return sysCodeValueDao.listOnPage(sysCodeValueCriteria,new RowBounds(paging.getFirstResult(),paging.getMaxResults()));
	}

}
