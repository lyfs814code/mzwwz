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
import com.ytkl.mzwwz.criteria.SysUserLogCriteria;
import com.ytkl.mzwwz.domain.SysUserLog;
import com.ytkl.mzwwz.service.SysUserLogService;
import com.ytkl.mzwwz.util.SessionUtil;

@Controller
public class SysUserLogController {
	private static final Logger log = LoggerFactory.getLogger(SysUserLogController.class);

	@Autowired
	private SysUserLogService sysUserLogService;

	@RequestMapping("/sysUserLog/list.do")
	public String list(SysUserLogCriteria sysUserLogCriteria,ModelMap model) {
		List<SysUserLog> sysUserLogList = sysUserLogService.listOnPage(sysUserLogCriteria);
		
		model.addAttribute("sysUserLogList", sysUserLogList);
		model.addAttribute("sysUserLogCriteria", sysUserLogCriteria);
		
		return "sysUserLog/list";
	}
	
	@ActionControllerLog(channel = "sysUserLog", action = "detail.do", title = "sysUserLog详细", isSaveRequestData = true)
	@RequestMapping("/sysUserLog/detail.do")
	public String detail(SysUserLogCriteria sysUserLogCriteria,int id, HttpServletRequest request, ModelMap model) {
		SysUserLog sysUserLog = sysUserLogService.select(id);

		model.addAttribute("sysUserLog", sysUserLog);
		model.addAttribute("sysUserLogCriteria", sysUserLogCriteria);

		return "sysUserLog/detail";
	}
	
	@RequestMapping("/sysUserLog/write.do")
	public String write(SysUserLogCriteria sysUserLogCriteria, ModelMap model) {
		model.addAttribute("sysUserLogCriteria", sysUserLogCriteria);
		
		return "sysUserLog/write";
	}
	
	@RequestMapping("/sysUserLog/edit.do")
	public String edit(int id, SysUserLogCriteria sysUserLogCriteria,ModelMap model) {
		SysUserLog sysUserLog = sysUserLogService.select(id);
		
		model.addAttribute("sysUserLog", sysUserLog);
		model.addAttribute("sysUserLogCriteria", sysUserLogCriteria);
		
		return "sysUserLog/edit";
	}
	
	@ActionControllerLog(channel = "sysUserLog", action = "save.do", title = "新增sysUserLog", isSaveRequestData = true)
	@RequestMapping("/sysUserLog/save.do")
	public @ResponseBody String save(@Valid SysUserLog sysUserLog,BindingResult result,ModelMap model) {
		if(result.hasErrors()){
			return  ValidatorShow.create().showErrors(result,model);
		}
		sysUserLogService.insert(sysUserLog);
		log.info("save acquisition id={}", sysUserLog.getId());
		
		return SessionUtil.FUN_SUCCESS_SAVE;
	}
	
	@ActionControllerLog(channel = "sysUserLog", action = "update.do", title = "修改sysUserLog", isSaveRequestData = true)
	@RequestMapping("/sysUserLog/update.do")
	public @ResponseBody String update(@Valid SysUserLog sysUserLog,BindingResult result,SysUserLogCriteria sysUserLogCriteria,ModelMap model) {
		if(result.hasErrors()){
			return  ValidatorShow.create().showErrors(result,model);
		}
		sysUserLogService.update(sysUserLog);
		log.info("update SysUserLog id={}", sysUserLog.getId());
		
		return SessionUtil.FUN_SUCCESS_UPDATE;
	}
	
	@ActionControllerLog(channel = "sysUserLog", action = "delete.do", title = "删除sysUserLog", isSaveRequestData = true)
	@RequestMapping("/sysUserLog/delete.do")
	public @ResponseBody String delete(int id, SysUserLogCriteria sysUserLogCriteria, ModelMap model) {
		sysUserLogService.delete(id);
		log.info("delete to sysUserLog id={}", id);
		
		return SessionUtil.FUN_SUCCESS_DEL;
	}
	
}
