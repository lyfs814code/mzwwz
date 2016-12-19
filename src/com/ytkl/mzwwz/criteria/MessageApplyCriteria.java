package com.ytkl.mzwwz.criteria;

import com.ytkl.mzwwz.base.Criteria;

public class MessageApplyCriteria extends Criteria {

	private static final long serialVersionUID = 1L;
	
	private int id;

	private String message_id;
	
	private String nameque;
	
	public MessageApplyCriteria() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage_id() {
		return message_id;
	}

	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}

	public String getNameque() {
		return nameque;
	}

	public void setNameque(String nameque) {
		this.nameque = nameque;
	}
	
	
}
