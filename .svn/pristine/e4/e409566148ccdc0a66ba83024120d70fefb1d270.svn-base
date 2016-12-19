package com.ytkl.mzwwz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.dao.DataAccessException;

import com.ytkl.mzwwz.criteria.MessageCriteria;
import com.ytkl.mzwwz.domain.Message;

public interface MessageDao {

	int insert(Message message) throws DataAccessException;

	int update(Message message) throws DataAccessException;
	//在回复信息自动将状态改为已回复
	
	void updateState(@Param("id")int id,@Param("state")String state) throws DataAccessException; 
	
	int updateSelective(Message message) throws DataAccessException;

	int delete(int id) throws DataAccessException;

	Message select(int id) throws DataAccessException;

	List<Message> list(MessageCriteria messageCriteria) throws DataAccessException;
	
	List<Message> listOnPage(MessageCriteria messageCriteria,RowBounds bounds) throws DataAccessException;
	
	int count(MessageCriteria messageCriteria) throws DataAccessException;

}
