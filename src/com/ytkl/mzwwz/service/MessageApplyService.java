package com.ytkl.mzwwz.service;

import java.util.List;

import com.ytkl.mzwwz.criteria.MessageApplyCriteria;
import com.ytkl.mzwwz.domain.MessageApply;

public interface MessageApplyService {

	int insert(MessageApply messageApply);

	int update(MessageApply messageApply);
	
	int updateSelective(MessageApply messageApply);

	int delete(int id);
	
	MessageApply select(int id);

	List<MessageApply> list(MessageApplyCriteria messageApplyCriteria);

	List<MessageApply> listOnPage(MessageApplyCriteria messageApplyCriteria);

}
