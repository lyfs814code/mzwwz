package com.ytkl.mzwwz.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.dao.DataAccessException;

import com.ytkl.mzwwz.criteria.NewsBookImgCriteria;
import com.ytkl.mzwwz.domain.NewsBookImg;

public interface NewsBookImgDao {

	int insert(NewsBookImg newsBookImg) throws DataAccessException;

	int update(NewsBookImg newsBookImg) throws DataAccessException;
	
	int updateSelective(NewsBookImg newsBookImg) throws DataAccessException;

	int delete(int id) throws DataAccessException;
	
	int deleteImg(int id) throws DataAccessException;

	NewsBookImg select(int id) throws DataAccessException;
	
	List<NewsBookImg>  selectbookID  (int id) throws DataAccessException;;

	List<NewsBookImg> list(NewsBookImgCriteria newsBookImgCriteria) throws DataAccessException;
	
	List<NewsBookImg> listOnPage(NewsBookImgCriteria newsBookImgCriteria,RowBounds bounds) throws DataAccessException;
	
	int count(NewsBookImgCriteria newsBookImgCriteria) throws DataAccessException;

}
