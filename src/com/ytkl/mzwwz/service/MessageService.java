package com.ytkl.mzwwz.service;

import java.util.List;

import com.ytkl.mzwwz.criteria.MessageCriteria;
import com.ytkl.mzwwz.domain.Message;

public interface MessageService {

	int insert(Message message);

	int update(Message message);
	//在回复信息自动将状态改为已回复
	void updateState(int id,String state);
	
	int updateSelective(Message message);

	int delete(int id);
	
	Message select(int id);

	List<Message> list(MessageCriteria messageCriteria);

	List<Message> listOnPage(MessageCriteria messageCriteria);

}
