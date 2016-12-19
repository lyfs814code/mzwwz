package com.ytkl.mzwwz.criteria;

import com.ytkl.mzwwz.base.Criteria;

public class SysUserCriteria extends Criteria {

	private static final long serialVersionUID = 1L;
	
	private String userid;

	public SysUserCriteria() {
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}
