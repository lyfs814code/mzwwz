package com.ytkl.mzwwz.service;

import java.util.List;

import com.ytkl.mzwwz.criteria.SysParaCriteria;
import com.ytkl.mzwwz.domain.SysPara;

public interface SysParaService {

	int insert(SysPara sysPara);

	int update(SysPara sysPara);
	
	int updateSelective(SysPara sysPara);

	int delete(int id);
	
	SysPara select(int id);

	List<SysPara> list(SysParaCriteria sysParaCriteria);

	List<SysPara> listOnPage(SysParaCriteria sysParaCriteria);

}
