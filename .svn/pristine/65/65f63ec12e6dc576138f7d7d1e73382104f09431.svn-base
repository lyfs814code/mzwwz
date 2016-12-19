package com.ytkl.mzwwz.base;

import java.io.Serializable;

import com.ytkl.mzwwz.util.Paging;

public class Criteria implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Paging paging;

	private String mode;

	public Criteria() {
		this(new Paging());
	}

	public Criteria(int maxResults, int pagingLinks) {
		this(new Paging(maxResults, pagingLinks));
	}

	public Criteria(Paging paging) {
		this.paging = paging;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

}
