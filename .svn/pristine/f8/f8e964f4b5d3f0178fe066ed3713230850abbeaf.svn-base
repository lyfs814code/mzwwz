package com.ytkl.mzwwz.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.dao.DataAccessException;

import com.ytkl.mzwwz.criteria.NewsBookCriteria;
import com.ytkl.mzwwz.domain.NewsBook;

public interface NewsBookDao {

	int insert(NewsBook newsBook) throws DataAccessException;

	int update(NewsBook newsBook) throws DataAccessException;
	
	int updateSelective(NewsBook newsBook) throws DataAccessException;

	int delete(int id) throws DataAccessException;

	NewsBook select(int id) throws DataAccessException;

	List<NewsBook> list(NewsBookCriteria newsBookCriteria) throws DataAccessException;
	
	List<NewsBook> listOnPage(NewsBookCriteria newsBookCriteria,RowBounds bounds) throws DataAccessException;
	
	int count(NewsBookCriteria newsBookCriteria) throws DataAccessException;

}
