package com.ytkl.mzwwz.service;

import java.util.List;

import com.ytkl.mzwwz.criteria.NewsBookImgCriteria;
import com.ytkl.mzwwz.domain.NewsBookImg;

public interface NewsBookImgService {

	int insert(NewsBookImg newsBookImg);

	int update(NewsBookImg newsBookImg);
	
	int updateSelective(NewsBookImg newsBookImg);

	int delete(int id);
	
	int deleteImg(int id);
	
	NewsBookImg select(int id);
	
	List<NewsBookImg>  selectbookID  (int id);

	List<NewsBookImg> list(NewsBookImgCriteria newsBookImgCriteria);

	List<NewsBookImg> listOnPage(NewsBookImgCriteria newsBookImgCriteria);

}
