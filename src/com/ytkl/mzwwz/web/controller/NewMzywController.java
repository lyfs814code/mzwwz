package com.ytkl.mzwwz.web.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ytkl.mzwwz.aspect.ActionControllerLog;
import com.ytkl.mzwwz.base.ValidatorShow;
import com.ytkl.mzwwz.criteria.NewsCriteria;
import com.ytkl.mzwwz.domain.News;
import com.ytkl.mzwwz.domain.SysUser;
import com.ytkl.mzwwz.service.NewMzywService;
import com.ytkl.mzwwz.util.ResponseUtils;
import com.ytkl.mzwwz.util.SessionUtil;

@Controller
public class NewMzywController {
	private static final Logger log = LoggerFactory.getLogger(NewMzywController.class);
	
	@Autowired
	private HttpSession session;
	@Autowired
	private NewMzywService newMzywService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

	@RequestMapping("/newMzyw/list.do")
	public String list(NewsCriteria newsCriteria,ModelMap model) {
		
		List<News> newsList = newMzywService.listOnPage(newsCriteria);
		
		model.addAttribute("newsList", newsList);
		model.addAttribute("newsCriteria", newsCriteria);
		
		return "newMzyw/list";
	}
//	
	@ActionControllerLog(channel = "newMzyw", action = "detail.do", title = "newMzyw详细", isSaveRequestData = true)
	@RequestMapping("/newMzyw/detail.do")
	public String detail(NewsCriteria newsCriteria,int id, HttpServletRequest request, ModelMap model) {
		News news = newMzywService.select(id);

		model.addAttribute("news", news);
		model.addAttribute("newsCriteria", newsCriteria);

		return "newMzyw/detail";
	}
	
	@RequestMapping("/newMzyw/write.do")
	public String write(NewsCriteria newsCriteria, ModelMap model) {
		model.addAttribute("newsCriteria", newsCriteria);
		
		return "newMzyw/write";
	}
	
	@RequestMapping("/newMzyw/edit.do")
	public String edit(int id, NewsCriteria newsCriteria,ModelMap model) {
		News news = newMzywService.select(id);
		
		model.addAttribute("news", news);
		model.addAttribute("newsCriteria", newsCriteria);
		
		return "newMzyw/edit";
	}
	
	@ActionControllerLog(channel = "newMzyw", action = "save.do", title = "新增newMzyw", isSaveRequestData = true)
	@RequestMapping("/newMzyw/save.do")
	public @ResponseBody String save(@Valid News news,BindingResult result,ModelMap model) {
		if(result.hasErrors()){
			return  ValidatorShow.create().showErrors(result,model);
		}
		
		SysUser loginUser = (SysUser) session.getAttribute(SessionUtil.SESSION_USER);
		news.setCreater(loginUser.getUserid());
		
		news.setCreateTime(new Date());
		
		newMzywService.insert(news);
		log.info("save acquisition id={}", news.getId());
		
		return SessionUtil.FUN_SUCCESS_SAVE;
	}
	
	@ActionControllerLog(channel = "newMzyw", action = "update.do", title = "修改newMzyw", isSaveRequestData = true)
	@RequestMapping("/newMzyw/update.do")
	public @ResponseBody String update(@Valid News news,BindingResult result,NewsCriteria newsCriteria,ModelMap model) {
		if(result.hasErrors()){
			return  ValidatorShow.create().showErrors(result,model);
		}
		news.setModifyTime(new Date());
		newMzywService.update(news);
		log.info("update News id={}", news.getId());
		
		return SessionUtil.FUN_SUCCESS_UPDATE;
	}
	
	@ActionControllerLog(channel = "newMzyw", action = "delete.do", title = "删除newMzyw", isSaveRequestData = true)
	@RequestMapping("/newMzyw/delete.do")
	public @ResponseBody String delete(int id, NewsCriteria newsCriteria, ModelMap model) {
		newMzywService.delete(id);
		log.info("delete to news id={}", id);
		
		return SessionUtil.FUN_SUCCESS_DEL;
	}
	@RequestMapping(value="/newMzyw/checkDel.do", method=RequestMethod.POST)
	public void checkDel(
			int id,
			HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		
		ResponseUtils.renderJson(response, "Success");
		
	}
}
