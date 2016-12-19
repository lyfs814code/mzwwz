package com.ytkl.mzwwz.service;

import java.util.List;

import com.ytkl.mzwwz.criteria.SysCodeTypeCriteria;
import com.ytkl.mzwwz.domain.SysCodeType;

public interface SysCodeTypeService {

	int insert(SysCodeType sysCodeType);

	int update(SysCodeType sysCodeType);
	
	int updateSelective(SysCodeType sysCodeType);

	int delete(String codeType);
	
	SysCodeType select(String codeType);

	List<SysCodeType> list(SysCodeTypeCriteria sysCodeTypeCriteria);

	List<SysCodeType> listOnPage(SysCodeTypeCriteria sysCodeTypeCriteria);

}
