package com.ytkl.mzwwz.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ytkl.mzwwz.criteria.MessageApplyCriteria;
import com.ytkl.mzwwz.dao.MessageApplyDao;
import com.ytkl.mzwwz.domain.MessageApply;
import com.ytkl.mzwwz.service.MessageApplyService;
import com.ytkl.mzwwz.util.Paging;

@Service
public class MessageApplyServiceImpl implements MessageApplyService {
	
	@Autowired
	private MessageApplyDao messageApplyDao;

	public int insert(MessageApply messageApply) {
		return messageApplyDao.insert(messageApply);
	}

	public int update(MessageApply messageApply) {
		int actualRowsAffected = 0;
		
		int id = messageApply.getId();

		MessageApply _oldMessageApply = messageApplyDao.select(id);
		
		if (_oldMessageApply != null) {
			actualRowsAffected = messageApplyDao.update(messageApply);
		}
		
		return actualRowsAffected;
	}
	
	public int updateSelective(MessageApply messageApply) {
		int actualRowsAffected = 0;
		
		int id = messageApply.getId();

		MessageApply _oldMessageApply = messageApplyDao.select(id);
		
		if (_oldMessageApply != null) {
			actualRowsAffected = messageApplyDao.update(messageApply);
		}
		
		return actualRowsAffected;
	}
	
	public int delete(int id) {
		int actualRowsAffected = 0;
		
		MessageApply _oldMessageApply = messageApplyDao.select(id);
		
		if (_oldMessageApply != null) {
			actualRowsAffected = messageApplyDao.delete(id);
		}
		
		return actualRowsAffected;
	}
	
	public MessageApply select(int id) {
		return messageApplyDao.select(id);
	}

	public List<MessageApply> list(MessageApplyCriteria messageApplyCriteria) {
		return messageApplyDao.list(messageApplyCriteria);
	}
	
	public List<MessageApply> listOnPage(MessageApplyCriteria messageApplyCriteria) {
		int totalResults = messageApplyDao.count(messageApplyCriteria);
		Paging paging = messageApplyCriteria.getPaging();
		paging.setTotalResults(totalResults);
		
		return messageApplyDao.listOnPage(messageApplyCriteria,new RowBounds(paging.getFirstResult(),paging.getMaxResults()));
	}

}
