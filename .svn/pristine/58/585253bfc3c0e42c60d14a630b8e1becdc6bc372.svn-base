package com.ytkl.mzwwz.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.dao.DataAccessException;

import com.ytkl.mzwwz.criteria.MessageApplyCriteria;
import com.ytkl.mzwwz.domain.MessageApply;

public interface MessageApplyDao {

	int insert(MessageApply messageApply) throws DataAccessException;

	int update(MessageApply messageApply) throws DataAccessException;
	
	int updateSelective(MessageApply messageApply) throws DataAccessException;

	int delete(int id) throws DataAccessException;

	MessageApply select(int id) throws DataAccessException;

	List<MessageApply> list(MessageApplyCriteria messageApplyCriteria) throws DataAccessException;
	
	List<MessageApply> listOnPage(MessageApplyCriteria messageApplyCriteria,RowBounds bounds) throws DataAccessException;
	
	int count(MessageApplyCriteria messageApplyCriteria) throws DataAccessException;

}
