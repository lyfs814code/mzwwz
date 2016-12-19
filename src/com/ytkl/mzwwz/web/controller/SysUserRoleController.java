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
import com.ytkl.mzwwz.criteria.SysUserRoleCriteria;
import com.ytkl.mzwwz.domain.SysUserRole;
import com.ytkl.mzwwz.service.SysUserRoleService;
import com.ytkl.mzwwz.util.SessionUtil;

@Controller
public class SysUserRoleController {
	private static final Logger log = LoggerFactory.getLogger(SysUserRoleController.class);

	@Autowired
	private SysUserRoleService sysUserRoleService;

	@RequestMapping("/sysUserRole/list.do")
	public String list(SysUserRoleCriteria sysUserRoleCriteria,ModelMap model) {
		List<SysUserRole> sysUserRoleList = sysUserRoleService.listOnPage(sysUserRoleCriteria);
		
		model.addAttribute("sysUserRoleList", sysUserRoleList);
		model.addAttribute("sysUserRoleCriteria", sysUserRoleCriteria);

		return "sysUserRole/list";
	}
	
	@ActionControllerLog(channel = "sysUserRole", action = "detail.do", title = "sysUserRole详细", isSaveRequestData = true)
	@RequestMapping("/sysUserRole/detail.do")
	public String detail(SysUserRoleCriteria sysUserRoleCriteria,int id, HttpServletRequest request, ModelMap model) {
		SysUserRole sysUserRole = sysUserRoleService.select(id);

		model.addAttribute("sysUserRole", sysUserRole);
		model.addAttribute("sysUserRoleCriteria", sysUserRoleCriteria);

		return "sysUserRole/detail";
	}
	
	@RequestMapping("/sysUserRole/write.do")
	public String write(SysUserRoleCriteria sysUserRoleCriteria, ModelMap model) {
		model.addAttribute("sysUserRoleCriteria", sysUserRoleCriteria);
		
		return "sysUserRole/write";
	}
	
	@RequestMapping("/sysUserRole/edit.do")
	public String edit(int id, SysUserRoleCriteria sysUserRoleCriteria,ModelMap model) {
		SysUserRole sysUserRole = sysUserRoleService.select(id);
		
		model.addAttribute("sysUserRole", sysUserRole);
		model.addAttribute("sysUserRoleCriteria", sysUserRoleCriteria);
		
		return "sysUserRole/edit";
	}
	
	@ActionControllerLog(channel = "sysUserRole", action = "save.do", title = "新增sysUserRole", isSaveRequestData = true)
	@RequestMapping("/sysUserRole/save.do")
	public @ResponseBody String save(@Valid SysUserRole sysUserRole,BindingResult result,ModelMap model) {
		if(result.hasErrors()){
			return  ValidatorShow.create().showErrors(result,model);
		}
		sysUserRoleService.insert(sysUserRole);
		log.info("save acquisition id={}", sysUserRole.getId());
		
		return SessionUtil.FUN_SUCCESS_SAVE;
	}
	
	@ActionControllerLog(channel = "sysUserRole", action = "update.do", title = "修改sysUserRole", isSaveRequestData = true)
	@RequestMapping("/sysUserRole/update.do")
	public @ResponseBody String update(@Valid SysUserRole sysUserRole,BindingResult result,SysUserRoleCriteria sysUserRoleCriteria,ModelMap model) {
		if(result.hasErrors()){
			return  ValidatorShow.create().showErrors(result,model);
		}
		sysUserRoleService.update(sysUserRole);
		log.info("update SysUserRole id={}", sysUserRole.getId());
		
		return SessionUtil.FUN_SUCCESS_UPDATE;
	}
	
	@ActionControllerLog(channel = "sysUserRole", action = "delete.do", title = "删除sysUserRole", isSaveRequestData = true)
	@RequestMapping("/sysUserRole/delete.do")
	public @ResponseBody String delete(int id, SysUserRoleCriteria sysUserRoleCriteria, ModelMap model) {
		sysUserRoleService.delete(id);
		log.info("delete to sysUserRole id={}", id);
		
		return SessionUtil.FUN_SUCCESS_DEL;
	}
	
}
