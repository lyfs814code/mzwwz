package com.ytkl.mzwwz.service;

import java.util.List;

import com.ytkl.mzwwz.criteria.CommonParaCriteria;
import com.ytkl.mzwwz.domain.CommonPara;

public interface CommonParaService {

	int insert(CommonPara commonPara);

	int update(CommonPara commonPara);
	
	int updateSelective(CommonPara commonPara);

	int delete(String code);
	
	CommonPara select(String code);

	List<CommonPara> list(CommonParaCriteria commonParaCriteria);

	List<CommonPara> listOnPage(CommonParaCriteria commonParaCriteria);

}
