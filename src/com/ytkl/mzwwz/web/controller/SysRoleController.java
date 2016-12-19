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
import com.ytkl.mzwwz.criteria.SysRoleCriteria;
import com.ytkl.mzwwz.domain.SysRole;
import com.ytkl.mzwwz.service.SysRoleService;
import com.ytkl.mzwwz.util.SessionUtil;

@Controller
public class SysRoleController {
	private static final Logger log = LoggerFactory.getLogger(SysRoleController.class);

	@Autowired
	private SysRoleService sysRoleService;

	@RequestMapping("/sysRole/list.do")
	public String list(SysRoleCriteria sysRoleCriteria,ModelMap model) {
		List<SysRole> sysRoleList = sysRoleService.listOnPage(sysRoleCriteria);
		
		model.addAttribute("sysRoleList", sysRoleList);
		model.addAttribute("sysRoleCriteria", sysRoleCriteria);
		
		return "sysRole/list";
	}
	
	@ActionControllerLog(channel = "sysRole", action = "detail.do", title = "sysRole详细", isSaveRequestData = true)
	@RequestMapping("/sysRole/detail.do")
	public String detail(SysRoleCriteria sysRoleCriteria,int roleId, HttpServletRequest request, ModelMap model) {
		SysRole sysRole = sysRoleService.select(roleId);

		model.addAttribute("sysRole", sysRole);
		model.addAttribute("sysRoleCriteria", sysRoleCriteria);

		return "sysRole/detail";
	}
	
	@RequestMapping("/sysRole/write.do")
	public String write(SysRoleCriteria sysRoleCriteria, ModelMap model) {
		model.addAttribute("sysRoleCriteria", sysRoleCriteria);
		
		return "sysRole/write";
	}
	
	@RequestMapping("/sysRole/edit.do")
	public String edit(int roleId, SysRoleCriteria sysRoleCriteria,ModelMap model) {
		SysRole sysRole = sysRoleService.select(roleId);
		
		model.addAttribute("sysRole", sysRole);
		model.addAttribute("sysRoleCriteria", sysRoleCriteria);
		
		return "sysRole/edit";
	}
	
	@ActionControllerLog(channel = "sysRole", action = "save.do", title = "新增sysRole", isSaveRequestData = true)
	@RequestMapping("/sysRole/save.do")
	public @ResponseBody String save(@Valid SysRole sysRole,BindingResult result,ModelMap model) {
		if(result.hasErrors()){
			return  ValidatorShow.create().showErrors(result,model);
		}
		sysRoleService.insert(sysRole);
		log.info("save acquisition roleId={}", sysRole.getRoleId());
		
		return SessionUtil.FUN_SUCCESS_SAVE;
	}
	
	@ActionControllerLog(channel = "sysRole", action = "update.do", title = "修改sysRole", isSaveRequestData = true)
	@RequestMapping("/sysRole/update.do")
	public @ResponseBody String update(@Valid SysRole sysRole,BindingResult result,SysRoleCriteria sysRoleCriteria,ModelMap model) {
		if(result.hasErrors()){
			return  ValidatorShow.create().showErrors(result,model);
		}
		sysRoleService.update(sysRole);
		log.info("update SysRole roleId={}", sysRole.getRoleId());
		
		return SessionUtil.FUN_SUCCESS_UPDATE;
	}
	
	@ActionControllerLog(channel = "sysRole", action = "delete.do", title = "删除sysRole", isSaveRequestData = true)
	@RequestMapping("/sysRole/delete.do")
	public @ResponseBody String delete(int roleId, SysRoleCriteria sysRoleCriteria, ModelMap model) {
		sysRoleService.delete(roleId);
		log.info("delete to sysRole roleId={}", roleId);
		
		return SessionUtil.FUN_SUCCESS_DEL;
	}
	
}
