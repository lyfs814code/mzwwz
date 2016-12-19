package com.ytkl.mzwwz.domain;

import java.io.Serializable;
import java.util.Date;

public class SysUserLog implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String userId;
	private Date excTime;
	private String channel;
	private String actName;
	private String action;
	private String excUrl;
	private String ipAddr;
	private String params;
	private String errmsg;
	public SysUserLog() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getExcTime() {
		return excTime;
	}

	public void setExcTime(Date excTime) {
		this.excTime = excTime;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getExcUrl() {
		return excUrl;
	}

	public void setExcUrl(String excUrl) {
		this.excUrl = excUrl;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;

		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final SysUserLog other = (SysUserLog) obj;
		if (id != other.id)
			return false;

		return true;
	}
	
	@Override
	public String toString() {
		return getClass().getName() + "@" + Integer.toHexString(hashCode()) + 
			"(" + 
			"id=" + "'" + id + "'" + 
			")";
	}
	
}
