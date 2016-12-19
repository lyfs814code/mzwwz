package com.ytkl.mzwwz.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ytkl.mzwwz.criteria.CommonParaCriteria;
import com.ytkl.mzwwz.dao.CommonParaDao;
import com.ytkl.mzwwz.domain.CommonPara;
import com.ytkl.mzwwz.service.CommonParaService;
import com.ytkl.mzwwz.util.Paging;

@Service
public class CommonParaServiceImpl implements CommonParaService {
	
	@Autowired
	private CommonParaDao commonParaDao;

	public int insert(CommonPara commonPara) {
		return commonParaDao.insert(commonPara);
	}

	public int update(CommonPara commonPara) {
		int actualRowsAffected = 0;
		
		String code = commonPara.getCode();

		CommonPara _oldCommonPara = commonParaDao.select(code);
		
		if (_oldCommonPara != null) {
			actualRowsAffected = commonParaDao.update(commonPara);
		}
		
		return actualRowsAffected;
	}
	
	public int updateSelective(CommonPara commonPara) {
		int actualRowsAffected = 0;
		
		String code = commonPara.getCode();

		CommonPara _oldCommonPara = commonParaDao.select(code);
		
		if (_oldCommonPara != null) {
			actualRowsAffected = commonParaDao.update(commonPara);
		}
		
		return actualRowsAffected;
	}
	
	public int delete(String code) {
		int actualRowsAffected = 0;
		
		CommonPara _oldCommonPara = commonParaDao.select(code);
		
		if (_oldCommonPara != null) {
			actualRowsAffected = commonParaDao.delete(code);
		}
		
		return actualRowsAffected;
	}
	
	public CommonPara select(String code) {
		return commonParaDao.select(code);
	}

	public List<CommonPara> list(CommonParaCriteria commonParaCriteria) {
		return commonParaDao.list(commonParaCriteria);
	}
	
	public List<CommonPara> listOnPage(CommonParaCriteria commonParaCriteria) {
		int totalResults = commonParaDao.count(commonParaCriteria);
		Paging paging = commonParaCriteria.getPaging();
		paging.setTotalResults(totalResults);
		
		return commonParaDao.listOnPage(commonParaCriteria,new RowBounds(paging.getFirstResult(),paging.getMaxResults()));
	}

}
