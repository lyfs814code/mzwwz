package com.ytkl.mzwwz.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.dao.DataAccessException;

import com.ytkl.mzwwz.criteria.NewsCriteria;
import com.ytkl.mzwwz.domain.News;

public interface NewXqdtDao {

	int insert(News news) throws DataAccessException;

	int update(News news) throws DataAccessException;
	
	int updateSelective(News news) throws DataAccessException;

	int delete(int id) throws DataAccessException;

	News select(int id) throws DataAccessException;

	List<News> list(NewsCriteria newsCriteria) throws DataAccessException;
	
	List<News> listOnPage(NewsCriteria newsCriteria,RowBounds bounds) throws DataAccessException;
	
	int count(NewsCriteria newsCriteria) throws DataAccessException;

}
