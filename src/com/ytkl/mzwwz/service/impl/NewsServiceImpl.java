package com.ytkl.mzwwz.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ytkl.mzwwz.criteria.NewsCriteria;
import com.ytkl.mzwwz.dao.NewsDao;
import com.ytkl.mzwwz.domain.News;
import com.ytkl.mzwwz.service.NewsService;
import com.ytkl.mzwwz.util.Paging;

@Service
public class NewsServiceImpl implements NewsService {
	
	@Autowired
	private NewsDao newsDao;

	public int insert(News news) {
		return newsDao.insert(news);
	}

	public int update(News news) {
		int actualRowsAffected = 0;
		
		int id = news.getId();

		News _oldNews = newsDao.select(id);
		
		if (_oldNews != null) {
			actualRowsAffected = newsDao.update(news);
		}
		
		return actualRowsAffected;
	}
	
	public int updateSelective(News news) {
		int actualRowsAffected = 0;
		
		int id = news.getId();

		News _oldNews = newsDao.select(id);
		
		if (_oldNews != null) {
			actualRowsAffected = newsDao.updateSelective(news);
		}
		
		return actualRowsAffected;
	}
	
	public int delete(int id) {
		int actualRowsAffected = 0;
		
		News _oldNews = newsDao.select(id);
		
		if (_oldNews != null) {
			actualRowsAffected = newsDao.delete(id);
		}
		
		return actualRowsAffected;
	}
	
	public News select(int id) {
		return newsDao.select(id);
	}

	public List<News> list(NewsCriteria newsCriteria) {
		return newsDao.list(newsCriteria);
	}
	
	public List<News> listOnPage(NewsCriteria newsCriteria) {
		int totalResults = newsDao.count(newsCriteria);
		Paging paging = newsCriteria.getPaging();
		paging.setTotalResults(totalResults);
		
		return newsDao.listOnPage(newsCriteria,new RowBounds(paging.getFirstResult(),paging.getMaxResults()));
	}

}
