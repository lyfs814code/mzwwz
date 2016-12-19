package com.ytkl.mzwwz.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ytkl.mzwwz.criteria.SysParaCriteria;
import com.ytkl.mzwwz.dao.SysParaDao;
import com.ytkl.mzwwz.domain.SysPara;
import com.ytkl.mzwwz.service.SysParaService;
import com.ytkl.mzwwz.util.Paging;

@Service
public class SysParaServiceImpl implements SysParaService {
	
	@Autowired
	private SysParaDao sysParaDao;

	public int insert(SysPara sysPara) {
		return sysParaDao.insert(sysPara);
	}

	public int update(SysPara sysPara) {
		int actualRowsAffected = 0;
		
		int id = sysPara.getId();

		SysPara _oldSysPara = sysParaDao.select(id);
		
		if (_oldSysPara != null) {
			actualRowsAffected = sysParaDao.update(sysPara);
		}
		
		return actualRowsAffected;
	}
	
	public int updateSelective(SysPara sysPara) {
		int actualRowsAffected = 0;
		
		int id = sysPara.getId();

		SysPara _oldSysPara = sysParaDao.select(id);
		
		if (_oldSysPara != null) {
			actualRowsAffected = sysParaDao.update(sysPara);
		}
		
		return actualRowsAffected;
	}
	
	public int delete(int id) {
		int actualRowsAffected = 0;
		
		SysPara _oldSysPara = sysParaDao.select(id);
		
		if (_oldSysPara != null) {
			actualRowsAffected = sysParaDao.delete(id);
		}
		
		return actualRowsAffected;
	}
	
	public SysPara select(int id) {
		return sysParaDao.select(id);
	}

	public List<SysPara> list(SysParaCriteria sysParaCriteria) {
		return sysParaDao.list(sysParaCriteria);
	}
	
	public List<SysPara> listOnPage(SysParaCriteria sysParaCriteria) {
		int totalResults = sysParaDao.count(sysParaCriteria);
		Paging paging = sysParaCriteria.getPaging();
		paging.setTotalResults(totalResults);
		
		return sysParaDao.listOnPage(sysParaCriteria,new RowBounds(paging.getFirstResult(),paging.getMaxResults()));
	}

}
