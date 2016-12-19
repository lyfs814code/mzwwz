package com.ytkl.mzwwz.criteria;

import com.ytkl.mzwwz.base.Criteria;

public class SysUserLogCriteria extends Criteria {

	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String userIdQry;// 用户名

	public SysUserLogCriteria() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserIdQry() {
		return userIdQry;
	}

	public void setUserIdQry(String userIdQry) {
		this.userIdQry = userIdQry;
	}

}
