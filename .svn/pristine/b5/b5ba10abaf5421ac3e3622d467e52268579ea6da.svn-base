package com.ytkl.mzwwz.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ytkl.mzwwz.criteria.MessageCriteria;
import com.ytkl.mzwwz.dao.MessageDao;
import com.ytkl.mzwwz.domain.Message;
import com.ytkl.mzwwz.service.MessageService;
import com.ytkl.mzwwz.util.Paging;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	private MessageDao messageDao;

	public int insert(Message message) {
		return messageDao.insert(message);
	}

	public int update(Message message) {
		int actualRowsAffected = 0;
		
		int id = message.getId();

		Message _oldMessage = messageDao.select(id);
		
		if (_oldMessage != null) {
			actualRowsAffected = messageDao.update(message);
		}
		
		return actualRowsAffected;
	}
	
	public int updateSelective(Message message) {
		int actualRowsAffected = 0;
		
		int id = message.getId();

		Message _oldMessage = messageDao.select(id);
		
		if (_oldMessage != null) {
			actualRowsAffected = messageDao.update(message);
		}
		
		return actualRowsAffected;
	}
	
	public int delete(int id) {
		int actualRowsAffected = 0;
		
		Message _oldMessage = messageDao.select(id);
		
		if (_oldMessage != null) {
			actualRowsAffected = messageDao.delete(id);
		}
		
		return actualRowsAffected;
	}
	
	public Message select(int id) {
		return messageDao.select(id);
	}

	public List<Message> list(MessageCriteria messageCriteria) {
		return messageDao.list(messageCriteria);
	}
	
	public List<Message> listOnPage(MessageCriteria messageCriteria) {
		int totalResults = messageDao.count(messageCriteria);
		Paging paging = messageCriteria.getPaging();
		paging.setTotalResults(totalResults);
		
		return messageDao.listOnPage(messageCriteria,new RowBounds(paging.getFirstResult(),paging.getMaxResults()));
	}
	//在回复信息自动将状态改为已回复

	@Override
	public void updateState(int id, String state) {
		messageDao.updateState(id,state);
		
	}

}
