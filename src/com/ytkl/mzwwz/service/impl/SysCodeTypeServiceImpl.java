package com.ytkl.mzwwz.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ytkl.mzwwz.criteria.SysCodeTypeCriteria;
import com.ytkl.mzwwz.dao.SysCodeTypeDao;
import com.ytkl.mzwwz.domain.SysCodeType;
import com.ytkl.mzwwz.service.SysCodeTypeService;
import com.ytkl.mzwwz.util.Paging;

@Service
public class SysCodeTypeServiceImpl implements SysCodeTypeService {
	
	@Autowired
	private SysCodeTypeDao sysCodeTypeDao;

	public int insert(SysCodeType sysCodeType) {
		return sysCodeTypeDao.insert(sysCodeType);
	}

	public int update(SysCodeType sysCodeType) {
		int actualRowsAffected = 0;
		
		String codeType = sysCodeType.getCodeType();

		SysCodeType _oldSysCodeType = sysCodeTypeDao.select(codeType);
		
		if (_oldSysCodeType != null) {
			actualRowsAffected = sysCodeTypeDao.update(sysCodeType);
		}
		
		return actualRowsAffected;
	}
	
	public int updateSelective(SysCodeType sysCodeType) {
		int actualRowsAffected = 0;
		
		String codeType = sysCodeType.getCodeType();

		SysCodeType _oldSysCodeType = sysCodeTypeDao.select(codeType);
		
		if (_oldSysCodeType != null) {
			actualRowsAffected = sysCodeTypeDao.update(sysCodeType);
		}
		
		return actualRowsAffected;
	}
	
	public int delete(String codeType) {
		int actualRowsAffected = 0;
		
		SysCodeType _oldSysCodeType = sysCodeTypeDao.select(codeType);
		
		if (_oldSysCodeType != null) {
			actualRowsAffected = sysCodeTypeDao.delete(codeType);
		}
		
		return actualRowsAffected;
	}
	
	public SysCodeType select(String codeType) {
		return sysCodeTypeDao.select(codeType);
	}

	public List<SysCodeType> list(SysCodeTypeCriteria sysCodeTypeCriteria) {
		return sysCodeTypeDao.list(sysCodeTypeCriteria);
	}
	
	public List<SysCodeType> listOnPage(SysCodeTypeCriteria sysCodeTypeCriteria) {
		int totalResults = sysCodeTypeDao.count(sysCodeTypeCriteria);
		Paging paging = sysCodeTypeCriteria.getPaging();
		paging.setTotalResults(totalResults);
		
		return sysCodeTypeDao.listOnPage(sysCodeTypeCriteria,new RowBounds(paging.getFirstResult(),paging.getMaxResults()));
	}

}
