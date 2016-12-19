package com.ytkl.mzwwz.criteria;

import com.ytkl.mzwwz.base.Criteria;

public class LinkInfoCriteria extends Criteria {

	private static final long serialVersionUID = 1L;

	private int id;

	private String publishFlagQry;
	private String linkLevelQry;
	private String linkNameQry;

	public LinkInfoCriteria() {
		this.linkLevelQry = "";
	}

	public LinkInfoCriteria(String publishFlagQry, String linkLevelQry) {
		this.publishFlagQry = publishFlagQry;
		this.linkLevelQry = linkLevelQry;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPublishFlagQry() {
		return publishFlagQry;
	}

	public void setPublishFlagQry(String publishFlagQry) {
		this.publishFlagQry = publishFlagQry;
	}

	public String getLinkLevelQry() {
		return linkLevelQry;
	}

	public void setLinkLevelQry(String linkLevelQry) {
		this.linkLevelQry = linkLevelQry;
	}

	public String getLinkNameQry() {
		return linkNameQry;
	}

	public void setLinkNameQry(String linkNameQry) {
		this.linkNameQry = linkNameQry;
	}

}
