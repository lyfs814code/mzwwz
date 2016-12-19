package com.ytkl.mzwwz.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ytkl.mzwwz.criteria.LinkInfoCriteria;
import com.ytkl.mzwwz.dao.LinkInfoDao;
import com.ytkl.mzwwz.domain.LinkInfo;
import com.ytkl.mzwwz.service.LinkInfoService;
import com.ytkl.mzwwz.util.Paging;

@Service
public class LinkInfoServiceImpl implements LinkInfoService {
	
	@Autowired
	private LinkInfoDao linkInfoDao;

	public int insert(LinkInfo linkInfo) {
		return linkInfoDao.insert(linkInfo);
	}

	public int update(LinkInfo linkInfo) {
		int actualRowsAffected = 0;
		
		int id = linkInfo.getId();

		LinkInfo _oldLinkInfo = linkInfoDao.select(id);
		
		if (_oldLinkInfo != null) {
			actualRowsAffected = linkInfoDao.update(linkInfo);
		}
		
		return actualRowsAffected;
	}
	
	public int updateSelective(LinkInfo linkInfo) {
		int actualRowsAffected = 0;
		
		int id = linkInfo.getId();

		LinkInfo _oldLinkInfo = linkInfoDao.select(id);
		
		if (_oldLinkInfo != null) {
			actualRowsAffected = linkInfoDao.update(linkInfo);
		}
		
		return actualRowsAffected;
	}
	
	public int delete(int id) {
		int actualRowsAffected = 0;
		
		LinkInfo _oldLinkInfo = linkInfoDao.select(id);
		
		if (_oldLinkInfo != null) {
			actualRowsAffected = linkInfoDao.delete(id);
		}
		
		return actualRowsAffected;
	}
	
	public LinkInfo select(int id) {
		return linkInfoDao.select(id);
	}

	public List<LinkInfo> list(LinkInfoCriteria linkInfoCriteria) {
		return linkInfoDao.list(linkInfoCriteria);
	}
	
	public List<LinkInfo> listOnPage(LinkInfoCriteria linkInfoCriteria) {
		int totalResults = linkInfoDao.count(linkInfoCriteria);
		Paging paging = linkInfoCriteria.getPaging();
		paging.setTotalResults(totalResults);
		
		return linkInfoDao.listOnPage(linkInfoCriteria,new RowBounds(paging.getFirstResult(),paging.getMaxResults()));
	}

}
