package com.ytkl.mzwwz.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.dao.DataAccessException;

import com.ytkl.mzwwz.criteria.CommonParaCriteria;
import com.ytkl.mzwwz.domain.CommonPara;

public interface CommonParaDao {

	int insert(CommonPara commonPara) throws DataAccessException;

	int update(CommonPara commonPara) throws DataAccessException;
	
	int updateSelective(CommonPara commonPara) throws DataAccessException;

	int delete(String code) throws DataAccessException;

	CommonPara select(String code) throws DataAccessException;

	List<CommonPara> list(CommonParaCriteria commonParaCriteria) throws DataAccessException;
	
	List<CommonPara> listOnPage(CommonParaCriteria commonParaCriteria,RowBounds bounds) throws DataAccessException;
	
	int count(CommonParaCriteria commonParaCriteria) throws DataAccessException;

}
