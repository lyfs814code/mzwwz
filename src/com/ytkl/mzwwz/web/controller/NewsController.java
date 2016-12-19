package com.ytkl.mzwwz.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ytkl.mzwwz.aspect.ActionControllerLog;
import com.ytkl.mzwwz.base.ValidatorShow;
import com.ytkl.mzwwz.criteria.NewsCriteria;
import com.ytkl.mzwwz.domain.News;
import com.ytkl.mzwwz.domain.SysUser;
import com.ytkl.mzwwz.service.NewsService;
import com.ytkl.mzwwz.util.ResponseUtils;
import com.ytkl.mzwwz.util.SessionUtil;

@Controller
public class NewsController {
	private static final Logger log = LoggerFactory.getLogger(NewsController.class);

	@Autowired
	private NewsService newsService;
	@Autowired
	private HttpSession session;

	@RequestMapping("/news/list.do")
	public String list(NewsCriteria newsCriteria,ModelMap model) {
		List<News> newsList = newsService.listOnPage(newsCriteria);
		
		model.addAttribute("newsList", newsList);
		model.addAttribute("newsCriteria", newsCriteria);
		
		return "news/list";
	}
	
	@ActionControllerLog(channel = "news", action = "detail.do", title = "news详细", isSaveRequestData = true)
	@RequestMapping("/news/detail.do")
	public String detail(NewsCriteria newsCriteria,int id, HttpServletRequest request, ModelMap model) {
		News news = newsService.select(id);

		model.addAttribute("news", news);
		model.addAttribute("newsCriteria", newsCriteria);

		return "news/detail";
	}
	
	@RequestMapping("/news/write.do")
	public String write(NewsCriteria newsCriteria, ModelMap model) {
		model.addAttribute("newsCriteria", newsCriteria);
		
		return "news/write";
	}
	
	@RequestMapping("/news/edit.do")
	public String edit(int id, NewsCriteria newsCriteria,ModelMap model) {
		News news = newsService.select(id);
		
		model.addAttribute("news", news);
		model.addAttribute("newsCriteria", newsCriteria);
		
		return "news/edit";
	}
	
	@ActionControllerLog(channel = "news", action = "save.do", title = "新增news", isSaveRequestData = true)
	@RequestMapping("/news/save.do")
	public @ResponseBody String save(@Valid News news,BindingResult result,ModelMap model) {
		if(result.hasErrors()){
			return  ValidatorShow.create().showErrors(result,model);
		}
		SysUser sysUser = (SysUser)session.getAttribute(SessionUtil.SESSION_USER);
		news.setCreater(sysUser.getUserid());
		news.setCreateTime(new Date());
		newsService.insert(news);
		log.info("save acquisition id={}", news.getId());
		
		return SessionUtil.FUN_SUCCESS_SAVE;
	}
	
	@ActionControllerLog(channel = "news", action = "update.do", title = "修改news", isSaveRequestData = true)
	@RequestMapping("/news/update.do")
	public @ResponseBody String update(@Valid News news,BindingResult result,NewsCriteria newsCriteria,ModelMap model) {
		if(result.hasErrors()){
			return  ValidatorShow.create().showErrors(result,model);
		}
		SysUser sysUser = (SysUser)session.getAttribute(SessionUtil.SESSION_USER);
		news.setModifier(sysUser.getUserid());
		news.setModifyTime(new Date());
		newsService.updateSelective(news);
		log.info("update News id={}", news.getId());
		
		return SessionUtil.FUN_SUCCESS_UPDATE;
	}
	
	@ActionControllerLog(channel = "news", action = "delete.do", title = "删除news", isSaveRequestData = true)
	@RequestMapping("/news/delete.do")
	public @ResponseBody String delete(int id, NewsCriteria newsCriteria, ModelMap model) {
		newsService.delete(id);
		log.info("delete to news id={}", id);
		
		return SessionUtil.FUN_SUCCESS_DEL;
	}
	
	@ActionControllerLog(channel = "news", action = "checkDel.do", title = "核对news是否存在", isSaveRequestData = true)
	@RequestMapping(value="/news/checkDel.do", method=RequestMethod.POST)
	public void checkDel(int id,HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		News news = newsService.select(id);
		if(news!=null){
			ResponseUtils.renderJson(response, "Success");
		}else{
			ResponseUtils.renderJson(response, "该条记录不存在，请刷新后重试");
		}
	}
	
}
