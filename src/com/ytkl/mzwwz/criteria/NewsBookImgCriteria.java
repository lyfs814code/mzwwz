package com.ytkl.mzwwz.criteria;

import com.ytkl.mzwwz.base.Criteria;

public class NewsBookImgCriteria extends Criteria {

	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private int newBookId;

	public NewsBookImgCriteria() {
	}

	public NewsBookImgCriteria(int newBookId) {
		this.newBookId = newBookId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNewBookId() {
		return newBookId;
	}

	public void setNewBookId(int newBookId) {
		this.newBookId = newBookId;
	}

}
