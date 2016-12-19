package com.ytkl.mzwwz.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ytkl.mzwwz.criteria.NewsCriteria;
import com.ytkl.mzwwz.dao.NewXqdtDao;
import com.ytkl.mzwwz.domain.News;
import com.ytkl.mzwwz.service.NewXqdtService;
import com.ytkl.mzwwz.util.Paging;

@Service
public class NewXqdtServiceImpl implements NewXqdtService {
	
	@Autowired
	private NewXqdtDao newsXqdtDao;

	public int insert(News news) {
		return newsXqdtDao.insert(news);
	}

	public int update(News news) {
		int actualRowsAffected = 0;
		
		int id = news.getId();

		News _oldNews = newsXqdtDao.select(id);
		
		if (_oldNews != null) {
			actualRowsAffected = newsXqdtDao.update(news);
		}
		
		return actualRowsAffected;
	}
	
	public int updateSelective(News news) {
		int actualRowsAffected = 0;
		
		int id = news.getId();

		News _oldNews = newsXqdtDao.select(id);
		
		if (_oldNews != null) {
			actualRowsAffected = newsXqdtDao.update(news);
		}
		
		return actualRowsAffected;
	}
	
	public int delete(int id) {
		int actualRowsAffected = 0;
		
		News _oldNews = newsXqdtDao.select(id);
		
		if (_oldNews != null) {
			actualRowsAffected = newsXqdtDao.delete(id);
		}
		
		return actualRowsAffected;
	}
	
	public News select(int id) {
		return newsXqdtDao.select(id);
	}

	public List<News> list(NewsCriteria newsCriteria) {
		return newsXqdtDao.list(newsCriteria);
	}
	
	public List<News> listOnPage(NewsCriteria newsCriteria) {
		int totalResults = newsXqdtDao.count(newsCriteria);
		Paging paging = newsCriteria.getPaging();
		paging.setTotalResults(totalResults);
		
		return newsXqdtDao.listOnPage(newsCriteria,new RowBounds(paging.getFirstResult(),paging.getMaxResults()));
	}

}
