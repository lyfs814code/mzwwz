package com.ytkl.mzwwz.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ytkl.mzwwz.criteria.NewsBookCriteria;
import com.ytkl.mzwwz.dao.NewsBookDao;
import com.ytkl.mzwwz.domain.NewsBook;
import com.ytkl.mzwwz.service.NewsBookService;
import com.ytkl.mzwwz.util.Paging;

@Service
public class NewsBookServiceImpl implements NewsBookService {
	
	@Autowired
	private NewsBookDao newsBookDao;

	public int insert(NewsBook newsBook) {
		return newsBookDao.insert(newsBook);
	}

	public int update(NewsBook newsBook) {
		int actualRowsAffected = 0;
		
		int id = newsBook.getId();

		NewsBook _oldNewsBook = newsBookDao.select(id);
		
		if (_oldNewsBook != null) {
			actualRowsAffected = newsBookDao.update(newsBook);
		}
		
		return actualRowsAffected;
	}
	
	public int updateSelective(NewsBook newsBook) {
		int actualRowsAffected = 0;
		
		int id = newsBook.getId();

		NewsBook _oldNewsBook = newsBookDao.select(id);
		
		if (_oldNewsBook != null) {
			actualRowsAffected = newsBookDao.update(newsBook);
		}
		
		return actualRowsAffected;
	}
	
	public int delete(int id) {
		int actualRowsAffected = 0;
		
		NewsBook _oldNewsBook = newsBookDao.select(id);
		
		if (_oldNewsBook != null) {
			actualRowsAffected = newsBookDao.delete(id);
		}
		
		return actualRowsAffected;
	}
	
	public NewsBook select(int id) {
		return newsBookDao.select(id);
	}

	public List<NewsBook> list(NewsBookCriteria newsBookCriteria) {
		return newsBookDao.list(newsBookCriteria);
	}
	
	public List<NewsBook> listOnPage(NewsBookCriteria newsBookCriteria) {
		int totalResults = newsBookDao.count(newsBookCriteria);
		Paging paging = newsBookCriteria.getPaging();
		paging.setTotalResults(totalResults);
		
		return newsBookDao.listOnPage(newsBookCriteria,new RowBounds(paging.getFirstResult(),paging.getMaxResults()));
	}

}
