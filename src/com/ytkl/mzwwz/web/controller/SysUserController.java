package com.ytkl.mzwwz.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.ytkl.mzwwz.aspect.ActionControllerLog;
import com.ytkl.mzwwz.base.ValidatorShow;
import com.ytkl.mzwwz.criteria.SysUserCriteria;
import com.ytkl.mzwwz.domain.SysUser;
import com.ytkl.mzwwz.service.SysUserService;
import com.ytkl.mzwwz.util.SessionUtil;

@Controller
public class SysUserController {
	private static final Logger log = LoggerFactory.getLogger(SysUserController.class);

	@Autowired
	private SysUserService sysUserService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	@RequestMapping("/sysUser/list.do")
	public String list(SysUserCriteria sysUserCriteria,ModelMap model) {
		List<SysUser> sysUserList = sysUserService.listOnPage(sysUserCriteria);
		
		model.addAttribute("sysUserList", sysUserList);
		model.addAttribute("sysUserCriteria", sysUserCriteria);
		
		return "sysUser/list";
	}
	
	@ActionControllerLog(channel = "sysUser", action = "detail.do", title = "sysUser详细", isSaveRequestData = true)
	@RequestMapping("/sysUser/detail.do")
	public String detail(SysUserCriteria sysUserCriteria,String userid, HttpServletRequest request, ModelMap model) {
		SysUser sysUser = sysUserService.select(userid);

		model.addAttribute("sysUser", sysUser);
		model.addAttribute("sysUserCriteria", sysUserCriteria);

		return "sysUser/detail";
	}
	
	@RequestMapping("/sysUser/write.do")
	public String write(SysUserCriteria sysUserCriteria, ModelMap model) {
		model.addAttribute("sysUserCriteria", sysUserCriteria);
		
		return "sysUser/write";
	}
	
	@RequestMapping("/sysUser/edit.do")
	public String edit(String userid, SysUserCriteria sysUserCriteria,ModelMap model) {
		SysUser sysUser = sysUserService.select(userid);
		
		model.addAttribute("sysUser", sysUser);
		model.addAttribute("sysUserCriteria", sysUserCriteria);
		
		return "sysUser/edit";
	}
	
	@ActionControllerLog(channel = "sysUser", action = "save.do", title = "新增sysUser", isSaveRequestData = true)
	@RequestMapping("/sysUser/save.do")
	public @ResponseBody String save(@Valid SysUser sysUser,BindingResult result,ModelMap model) {
		if(result.hasErrors()){
			return  ValidatorShow.create().showErrors(result,model);
		}
		sysUser.setCreateTime(new Date());
		sysUserService.insert(sysUser);
		log.info("save acquisition userid={}", sysUser.getUserid());
		
		return SessionUtil.FUN_SUCCESS_SAVE;
	}
	
	@ActionControllerLog(channel = "sysUser", action = "update.do", title = "修改sysUser", isSaveRequestData = true)
	@RequestMapping("/sysUser/update.do")
	public @ResponseBody String update(@Valid SysUser sysUser,BindingResult result,SysUserCriteria sysUserCriteria,ModelMap model) {
		if(result.hasErrors()){
			return  ValidatorShow.create().showErrors(result,model);
		}
		sysUserService.update(sysUser);
		log.info("update SysUser userid={}", sysUser.getUserid());
		
		return SessionUtil.FUN_SUCCESS_UPDATE;
	}
	
	@ActionControllerLog(channel = "sysUser", action = "delete.do", title = "删除sysUser", isSaveRequestData = true)
	@RequestMapping("/sysUser/delete.do")
	public @ResponseBody String delete(String userid, SysUserCriteria sysUserCriteria, ModelMap model) {
		sysUserService.delete(userid);
		log.info("delete to sysUser userid={}", userid);
		
		return SessionUtil.FUN_SUCCESS_DEL;
	}
	
}
