package com.ytkl.mzwwz.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ytkl.mzwwz.aspect.ActionControllerLog;
import com.ytkl.mzwwz.base.ValidatorShow;
import com.ytkl.mzwwz.criteria.NewsBookImgCriteria;
import com.ytkl.mzwwz.domain.NewsBookImg;
import com.ytkl.mzwwz.service.NewsBookImgService;
import com.ytkl.mzwwz.util.SessionUtil;

@Controller
public class NewsBookImgController {
	private static final Logger log = LoggerFactory.getLogger(NewsBookImgController.class);

	@Autowired
	private NewsBookImgService newsBookImgService;

	@RequestMapping("/newsBookImg/list.do")
	public String list(NewsBookImgCriteria newsBookImgCriteria,ModelMap model) {
		List<NewsBookImg> newsBookImgList = newsBookImgService.listOnPage(newsBookImgCriteria);
		
		model.addAttribute("newsBookImgList", newsBookImgList);
		model.addAttribute("newsBookImgCriteria", newsBookImgCriteria);
		
		return "newsBookImg/list";
	}
	
	@ActionControllerLog(channel = "newsBookImg", action = "detail.do", title = "newsBookImg详细", isSaveRequestData = true)
	@RequestMapping("/newsBookImg/detail.do")
	public String detail(NewsBookImgCriteria newsBookImgCriteria,int id, HttpServletRequest request, ModelMap model) {
		NewsBookImg newsBookImg = newsBookImgService.select(id);

		model.addAttribute("newsBookImg", newsBookImg);
		model.addAttribute("newsBookImgCriteria", newsBookImgCriteria);

		return "newsBookImg/detail";
	}
	
	@RequestMapping("/newsBookImg/write.do")
	public String write(NewsBookImgCriteria newsBookImgCriteria, ModelMap model) {
		model.addAttribute("newsBookImgCriteria", newsBookImgCriteria);
		
		return "newsBookImg/write";
	}
	
	@RequestMapping("/newsBookImg/edit.do")
	public String edit(int id, NewsBookImgCriteria newsBookImgCriteria,ModelMap model) {
		NewsBookImg newsBookImg = newsBookImgService.select(id);
		
		model.addAttribute("newsBookImg", newsBookImg);
		model.addAttribute("newsBookImgCriteria", newsBookImgCriteria);
		
		return "newsBookImg/edit";
	}
	
	@ActionControllerLog(channel = "newsBookImg", action = "save.do", title = "新增newsBookImg", isSaveRequestData = true)
	@RequestMapping("/newsBookImg/save.do")
	public @ResponseBody String save(@Valid NewsBookImg newsBookImg,BindingResult result,ModelMap model) {
		if(result.hasErrors()){
			return  ValidatorShow.create().showErrors(result,model);
		}
		newsBookImgService.insert(newsBookImg);
		log.info("save acquisition id={}", newsBookImg.getId());
		
		return SessionUtil.FUN_SUCCESS_SAVE;
	}
	
	@ActionControllerLog(channel = "newsBookImg", action = "update.do", title = "修改newsBookImg", isSaveRequestData = true)
	@RequestMapping("/newsBookImg/update.do")
	public @ResponseBody String update(@Valid NewsBookImg newsBookImg,BindingResult result,NewsBookImgCriteria newsBookImgCriteria,ModelMap model) {
		if(result.hasErrors()){
			return  ValidatorShow.create().showErrors(result,model);
		}
		newsBookImgService.update(newsBookImg);
		log.info("update NewsBookImg id={}", newsBookImg.getId());
		
		return SessionUtil.FUN_SUCCESS_UPDATE;
	}
	
	@ActionControllerLog(channel = "newsBookImg", action = "delete.do", title = "删除newsBookImg", isSaveRequestData = true)
	@RequestMapping("/newsBookImg/delete.do")
	public @ResponseBody String delete(int id, NewsBookImgCriteria newsBookImgCriteria, ModelMap model) {
		newsBookImgService.delete(id);
		log.info("delete to newsBookImg id={}", id);
		
		return SessionUtil.FUN_SUCCESS_DEL;
	}
	
}
