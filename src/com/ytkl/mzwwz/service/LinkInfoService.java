package com.ytkl.mzwwz.service;

import java.util.List;

import com.ytkl.mzwwz.criteria.LinkInfoCriteria;
import com.ytkl.mzwwz.domain.LinkInfo;

public interface LinkInfoService {

	int insert(LinkInfo linkInfo);

	int update(LinkInfo linkInfo);
	
	int updateSelective(LinkInfo linkInfo);

	int delete(int id);
	
	LinkInfo select(int id);

	List<LinkInfo> list(LinkInfoCriteria linkInfoCriteria);

	List<LinkInfo> listOnPage(LinkInfoCriteria linkInfoCriteria);

}
