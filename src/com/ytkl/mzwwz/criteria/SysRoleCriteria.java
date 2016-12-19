package com.ytkl.mzwwz.criteria;

import com.ytkl.mzwwz.base.Criteria;

public class SysRoleCriteria extends Criteria {

	private static final long serialVersionUID = 1L;
	
	private int roleId;

	public SysRoleCriteria() {
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}
