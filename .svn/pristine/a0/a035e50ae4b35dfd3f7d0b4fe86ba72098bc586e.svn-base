package com.ytkl.mzwwz.web.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.ytkl.mzwwz.service.NewXqdtService;
import com.ytkl.mzwwz.util.ResponseUtils;
import com.ytkl.mzwwz.util.SessionUtil;

@Controller
public class NewXqdtController {
	private static final Logger log = LoggerFactory.getLogger(NewXqdtController.class);

	@Autowired
	private NewXqdtService newXqdtService;
	
	@Autowired
	private HttpSession session;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

	@RequestMapping("/newXqdt/list.do")
	public String list(NewsCriteria newsCriteria,ModelMap model) {
		
		List<News> newsList = newXqdtService.listOnPage(newsCriteria);
		
		model.addAttribute("newsList", newsList);
		model.addAttribute("newsCriteria", newsCriteria);
		
		return "newXqdt/list";
	}
//	
	@ActionControllerLog(channel = "newXqdt", action = "detail.do", title = "news详细", isSaveRequestData = true)
	@RequestMapping("/newXqdt/detail.do")
	public String detail(NewsCriteria newsCriteria,int id, HttpServletRequest request, ModelMap model) {
		News news = newXqdtService.select(id);

		model.addAttribute("news", news);
		model.addAttribute("newsCriteria", newsCriteria);

		return "newXqdt/detail";
	}
	
	@RequestMapping("/newXqdt/write.do")
	public String write(NewsCriteria newsCriteria, ModelMap model) {
		model.addAttribute("newsCriteria", newsCriteria);
		
		return "newXqdt/write";
	}
	
	@RequestMapping("/newXqdt/edit.do")
	public String edit(int id, NewsCriteria newsCriteria,ModelMap model) {
		News news = newXqdtService.select(id);
		
		model.addAttribute("news", news);
		model.addAttribute("newsCriteria", newsCriteria);
		
		return "newXqdt/edit";
	}
	
	@ActionControllerLog(channel = "newXqdt", action = "save.do", title = "新增newMzyw", isSaveRequestData = true)
	@RequestMapping("/newXqdt/save.do")
	public @ResponseBody String save(@Valid News news,BindingResult result,ModelMap model) {
		if(result.hasErrors()){
			return  ValidatorShow.create().showErrors(result,model);
		}
		
		SysUser loginUser = (SysUser) session.getAttribute(SessionUtil.SESSION_USER);
		news.setCreater(loginUser.getUserid());
		newXqdtService.insert(news);
		log.info("save acquisition id={}", news.getId());
		
		return SessionUtil.FUN_SUCCESS_SAVE;
	}
	
	@ActionControllerLog(channel = "newXqdt", action = "update.do", title = "修改newMzyw", isSaveRequestData = true)
	@RequestMapping("/newXqdt/update.do")
	public @ResponseBody String update(@Valid News news,BindingResult result,NewsCriteria newsCriteria,ModelMap model) {
		if(result.hasErrors()){
			return  ValidatorShow.create().showErrors(result,model);
		}
		newXqdtService.update(news);
		log.info("update News id={}", news.getId());
		
		return SessionUtil.FUN_SUCCESS_UPDATE;
	}
	
	@ActionControllerLog(channel = "newXqdt", action = "delete.do", title = "删除newMzyw", isSaveRequestData = true)
	@RequestMapping("/newXqdt/delete.do")
	public @ResponseBody String delete(int id, NewsCriteria newsCriteria, ModelMap model) {
		newXqdtService.delete(id);
		log.info("delete to news id={}", id);
		
		return SessionUtil.FUN_SUCCESS_DEL;
	}
	@RequestMapping(value="/newXqdt/checkDel.do", method=RequestMethod.POST)
	public void checkDel(
			int id,
			HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		
		ResponseUtils.renderJson(response, "Success");
		
	}
}
