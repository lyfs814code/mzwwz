package com.ytkl.mzwwz.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ytkl.mzwwz.criteria.NewsCriteria;
import com.ytkl.mzwwz.dao.NewJqjdDao;
import com.ytkl.mzwwz.domain.News;
import com.ytkl.mzwwz.service.NewJqjdService;
import com.ytkl.mzwwz.util.Paging;

@Service
public class NewJqjdServiceImpl implements NewJqjdService {
	
	@Autowired
	private NewJqjdDao newsJqjdDao;

	public int insert(News news) {
		return newsJqjdDao.insert(news);
	}

	public int update(News news) {
		int actualRowsAffected = 0;
		
		int id = news.getId();

		News _oldNews = newsJqjdDao.select(id);
		
		if (_oldNews != null) {
			actualRowsAffected = newsJqjdDao.update(news);
		}
		
		return actualRowsAffected;
	}
	
	public int updateSelective(News news) {
		int actualRowsAffected = 0;
		
		int id = news.getId();

		News _oldNews = newsJqjdDao.select(id);
		
		if (_oldNews != null) {
			actualRowsAffected = newsJqjdDao.update(news);
		}
		
		return actualRowsAffected;
	}
	
	public int delete(int id) {
		int actualRowsAffected = 0;
		
		News _oldNews = newsJqjdDao.select(id);
		
		if (_oldNews != null) {
			actualRowsAffected = newsJqjdDao.delete(id);
		}
		
		return actualRowsAffected;
	}
	
	public News select(int id) {
		return newsJqjdDao.select(id);
	}

	public List<News> list(NewsCriteria newsCriteria) {
		return newsJqjdDao.list(newsCriteria);
	}
	
	public List<News> listOnPage(NewsCriteria newsCriteria) {
		int totalResults = newsJqjdDao.count(newsCriteria);
		Paging paging = newsCriteria.getPaging();
		paging.setTotalResults(totalResults);
		
		return newsJqjdDao.listOnPage(newsCriteria,new RowBounds(paging.getFirstResult(),paging.getMaxResults()));
	}

}
