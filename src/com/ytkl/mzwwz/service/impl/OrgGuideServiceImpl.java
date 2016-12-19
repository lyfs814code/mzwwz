package com.ytkl.mzwwz.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ytkl.mzwwz.criteria.OrgGuideCriteria;
import com.ytkl.mzwwz.dao.OrgGuideDao;
import com.ytkl.mzwwz.domain.OrgGuide;
import com.ytkl.mzwwz.service.OrgGuideService;
import com.ytkl.mzwwz.util.Paging;

@Service
public class OrgGuideServiceImpl implements OrgGuideService {
	
	@Autowired
	private OrgGuideDao orgGuideDao;

	public int insert(OrgGuide orgGuide) {
		return orgGuideDao.insert(orgGuide);
	}

	public int update(OrgGuide orgGuide) {
		int actualRowsAffected = 0;
		
		int id = orgGuide.getId();

		OrgGuide _oldOrgGuide = orgGuideDao.select(id);
		
		if (_oldOrgGuide != null) {
			actualRowsAffected = orgGuideDao.update(orgGuide);
		}
		
		return actualRowsAffected;
	}
	
	public int updateSelective(OrgGuide orgGuide) {
		int actualRowsAffected = 0;
		
		int id = orgGuide.getId();

		OrgGuide _oldOrgGuide = orgGuideDao.select(id);
		
		if (_oldOrgGuide != null) {
			actualRowsAffected = orgGuideDao.update(orgGuide);
		}
		
		return actualRowsAffected;
	}
	
	public int delete(int id) {
		int actualRowsAffected = 0;
		
		OrgGuide _oldOrgGuide = orgGuideDao.select(id);
		
		if (_oldOrgGuide != null) {
			actualRowsAffected = orgGuideDao.delete(id);
		}
		
		return actualRowsAffected;
	}
	
	public OrgGuide select(int id) {
		return orgGuideDao.select(id);
	}

	public List<OrgGuide> list(OrgGuideCriteria orgGuideCriteria) {
		return orgGuideDao.list(orgGuideCriteria);
	}
	
	public List<OrgGuide> listOnPage(OrgGuideCriteria orgGuideCriteria) {
		int totalResults = orgGuideDao.count(orgGuideCriteria);
		Paging paging = orgGuideCriteria.getPaging();
		paging.setTotalResults(totalResults);
		
		return orgGuideDao.listOnPage(orgGuideCriteria,new RowBounds(paging.getFirstResult(),paging.getMaxResults()));
	}

}
