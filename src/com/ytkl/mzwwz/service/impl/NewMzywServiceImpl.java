package com.ytkl.mzwwz.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ytkl.mzwwz.criteria.NewsCriteria;
import com.ytkl.mzwwz.dao.NewMzywDao;
import com.ytkl.mzwwz.domain.News;
import com.ytkl.mzwwz.service.NewMzywService;
import com.ytkl.mzwwz.util.Paging;

@Service
public class NewMzywServiceImpl implements NewMzywService {
	
	@Autowired
	private NewMzywDao newMzywDao;

	public int insert(News news) {
		return newMzywDao.insert(news);
	}

	public int update(News news) {
		int actualRowsAffected = 0;
		
		int id = news.getId();

		News _oldNews = newMzywDao.select(id);
		
		if (_oldNews != null) {
			actualRowsAffected = newMzywDao.update(news);
		}
		
		return actualRowsAffected;
	}
	
	public int updateSelective(News news) {
		int actualRowsAffected = 0;
		
		int id = news.getId();

		News _oldNews = newMzywDao.select(id);
		
		if (_oldNews != null) {
			actualRowsAffected = newMzywDao.updateSelective(news);
		}
		
		return actualRowsAffected;
	}
	
	public int delete(int id) {
		int actualRowsAffected = 0;
		
		News _oldNews = newMzywDao.select(id);
		
		if (_oldNews != null) {
			actualRowsAffected = newMzywDao.delete(id);
		}
		
		return actualRowsAffected;
	}
	
	public News select(int id) {
		return newMzywDao.select(id);
	}

	public List<News> list(NewsCriteria newsCriteria) {
		return newMzywDao.list(newsCriteria);
	}
	
	public List<News> listOnPage(NewsCriteria newsCriteria) {
		int totalResults = newMzywDao.count(newsCriteria);
		Paging paging = newsCriteria.getPaging();
		paging.setTotalResults(totalResults);
		
		return newMzywDao.listOnPage(newsCriteria,new RowBounds(paging.getFirstResult(),paging.getMaxResults()));
	}

}
