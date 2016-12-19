package com.ytkl.mzwwz.criteria;

import com.ytkl.mzwwz.base.Criteria;

public class OrgGuideCriteria extends Criteria {

	private static final long serialVersionUID = 1L;

	private int id;

	private String titleQry;// 名称
	private String publishFlagQry;// 是否发布

	public OrgGuideCriteria() {
		this.publishFlagQry = "";
	}

	public OrgGuideCriteria(String publishFlagQry) {
		this.publishFlagQry = publishFlagQry;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitleQry() {
		return titleQry;
	}

	public void setTitleQry(String titleQry) {
		this.titleQry = titleQry;
	}

	public String getPublishFlagQry() {
		return publishFlagQry;
	}

	public void setPublishFlagQry(String publishFlagQry) {
		this.publishFlagQry = publishFlagQry;
	}

}
