package com.ytkl.mzwwz.service;

import java.util.List;

import com.ytkl.mzwwz.criteria.NewsBookCriteria;
import com.ytkl.mzwwz.domain.NewsBook;

public interface NewsBookService {

	int insert(NewsBook newsBook);

	int update(NewsBook newsBook);
	
	int updateSelective(NewsBook newsBook);

	int delete(int id);
	
	NewsBook select(int id);

	List<NewsBook> list(NewsBookCriteria newsBookCriteria);

	List<NewsBook> listOnPage(NewsBookCriteria newsBookCriteria);

}
