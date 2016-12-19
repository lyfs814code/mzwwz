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
import com.ytkl.mzwwz.criteria.SysRoleMenuCriteria;
import com.ytkl.mzwwz.domain.SysRoleMenu;
import com.ytkl.mzwwz.service.SysRoleMenuService;
import com.ytkl.mzwwz.util.SessionUtil;

@Controller
public class SysRoleMenuController {
	private static final Logger log = LoggerFactory.getLogger(SysRoleMenuController.class);

	@Autowired
	private SysRoleMenuService sysRoleMenuService;

	@RequestMapping("/sysRoleMenu/list.do")
	public String list(SysRoleMenuCriteria sysRoleMenuCriteria,ModelMap model) {
		List<SysRoleMenu> sysRoleMenuList = sysRoleMenuService.listOnPage(sysRoleMenuCriteria);
		
		model.addAttribute("sysRoleMenuList", sysRoleMenuList);
		model.addAttribute("sysRoleMenuCriteria", sysRoleMenuCriteria);
		
		return "sysRoleMenu/list";
	}
	
	@ActionControllerLog(channel = "sysRoleMenu", action = "detail.do", title = "sysRoleMenu详细", isSaveRequestData = true)
	@RequestMapping("/sysRoleMenu/detail.do")
	public String detail(SysRoleMenuCriteria sysRoleMenuCriteria,int id, HttpServletRequest request, ModelMap model) {
		SysRoleMenu sysRoleMenu = sysRoleMenuService.select(id);

		model.addAttribute("sysRoleMenu", sysRoleMenu);
		model.addAttribute("sysRoleMenuCriteria", sysRoleMenuCriteria);

		return "sysRoleMenu/detail";
	}
	
	@RequestMapping("/sysRoleMenu/write.do")
	public String write(SysRoleMenuCriteria sysRoleMenuCriteria, ModelMap model) {
		model.addAttribute("sysRoleMenuCriteria", sysRoleMenuCriteria);
		
		return "sysRoleMenu/write";
	}
	
	@RequestMapping("/sysRoleMenu/edit.do")
	public String edit(int id, SysRoleMenuCriteria sysRoleMenuCriteria,ModelMap model) {
		SysRoleMenu sysRoleMenu = sysRoleMenuService.select(id);
		
		model.addAttribute("sysRoleMenu", sysRoleMenu);
		model.addAttribute("sysRoleMenuCriteria", sysRoleMenuCriteria);
		
		return "sysRoleMenu/edit";
	}
	
	@ActionControllerLog(channel = "sysRoleMenu", action = "save.do", title = "新增sysRoleMenu", isSaveRequestData = true)
	@RequestMapping("/sysRoleMenu/save.do")
	public @ResponseBody String save(@Valid SysRoleMenu sysRoleMenu,BindingResult result,ModelMap model) {
		if(result.hasErrors()){
			return  ValidatorShow.create().showErrors(result,model);
		}
		sysRoleMenuService.insert(sysRoleMenu);
		log.info("save acquisition id={}", sysRoleMenu.getId());
		
		return SessionUtil.FUN_SUCCESS_SAVE;
	}
	
	@ActionControllerLog(channel = "sysRoleMenu", action = "update.do", title = "修改sysRoleMenu", isSaveRequestData = true)
	@RequestMapping("/sysRoleMenu/update.do")
	public @ResponseBody String update(@Valid SysRoleMenu sysRoleMenu,BindingResult result,SysRoleMenuCriteria sysRoleMenuCriteria,ModelMap model) {
		if(result.hasErrors()){
			return  ValidatorShow.create().showErrors(result,model);
		}
		sysRoleMenuService.update(sysRoleMenu);
		log.info("update SysRoleMenu id={}", sysRoleMenu.getId());
		
		return SessionUtil.FUN_SUCCESS_UPDATE;
	}
	
	@ActionControllerLog(channel = "sysRoleMenu", action = "delete.do", title = "删除sysRoleMenu", isSaveRequestData = true)
	@RequestMapping("/sysRoleMenu/delete.do")
	public @ResponseBody String delete(int id, SysRoleMenuCriteria sysRoleMenuCriteria, ModelMap model) {
		sysRoleMenuService.delete(id);
		log.info("delete to sysRoleMenu id={}", id);
		
		return SessionUtil.FUN_SUCCESS_DEL;
	}
	
}
