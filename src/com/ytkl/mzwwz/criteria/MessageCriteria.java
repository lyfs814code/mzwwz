package com.ytkl.mzwwz.criteria;

import com.ytkl.mzwwz.base.Criteria;

public class MessageCriteria extends Criteria {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;

	public MessageCriteria() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
