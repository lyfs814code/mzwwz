package com.ytkl.mzwwz.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ytkl.mzwwz.criteria.NewsBookImgCriteria;
import com.ytkl.mzwwz.dao.NewsBookImgDao;
import com.ytkl.mzwwz.domain.NewsBookImg;
import com.ytkl.mzwwz.service.NewsBookImgService;
import com.ytkl.mzwwz.util.Paging;

@Service
public class NewsBookImgServiceImpl implements NewsBookImgService {
	
	@Autowired
	private NewsBookImgDao newsBookImgDao;

	public int insert(NewsBookImg newsBookImg) {
		return newsBookImgDao.insert(newsBookImg);
	}

	public int update(NewsBookImg newsBookImg) {
		int actualRowsAffected = 0;
		
		int id = newsBookImg.getId();

		NewsBookImg _oldNewsBookImg = newsBookImgDao.select(id);
		
		if (_oldNewsBookImg != null) {
			actualRowsAffected = newsBookImgDao.update(newsBookImg);
		}
		
		return actualRowsAffected;
	}
	
	public int updateSelective(NewsBookImg newsBookImg) {
		int actualRowsAffected = 0;
		
		int id = newsBookImg.getId();

		NewsBookImg _oldNewsBookImg = newsBookImgDao.select(id);
		
		if (_oldNewsBookImg != null) {
			actualRowsAffected = newsBookImgDao.update(newsBookImg);
		}
		
		return actualRowsAffected;
	}
	
	public int delete(int id) {
		int actualRowsAffected = 0;
		
		NewsBookImg _oldNewsBookImg = newsBookImgDao.select(id);
		
		if (_oldNewsBookImg != null) {
			actualRowsAffected = newsBookImgDao.delete(id);
		}
		
		return actualRowsAffected;
	}
	
	public NewsBookImg select(int id) {
		return newsBookImgDao.select(id);
	}

	public List<NewsBookImg> list(NewsBookImgCriteria newsBookImgCriteria) {
		return newsBookImgDao.list(newsBookImgCriteria);
	}
	
	public List<NewsBookImg> listOnPage(NewsBookImgCriteria newsBookImgCriteria) {
		int totalResults = newsBookImgDao.count(newsBookImgCriteria);
		Paging paging = newsBookImgCriteria.getPaging();
		paging.setTotalResults(totalResults);
		
		return newsBookImgDao.listOnPage(newsBookImgCriteria,new RowBounds(paging.getFirstResult(),paging.getMaxResults()));
	}

	@Override
	public List<NewsBookImg> selectbookID(int id) {
		List<NewsBookImg> newsBookImg =newsBookImgDao.selectbookID(id);
		return newsBookImg;
	}

	@Override
	public int deleteImg(int id) {
		return newsBookImgDao.deleteImg(id);
	}

}
