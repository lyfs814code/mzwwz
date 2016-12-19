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
import com.ytkl.mzwwz.criteria.SysMenuCriteria;
import com.ytkl.mzwwz.domain.SysMenu;
import com.ytkl.mzwwz.service.SysMenuService;
import com.ytkl.mzwwz.util.SessionUtil;

@Controller
public class SysMenuController {
	private static final Logger log = LoggerFactory.getLogger(SysMenuController.class);

	@Autowired
	private SysMenuService sysMenuService;

	@RequestMapping("/sysMenu/list.do")
	public String list(SysMenuCriteria sysMenuCriteria,ModelMap model) {
		List<SysMenu> sysMenuList = sysMenuService.listOnPage(sysMenuCriteria);
		
		model.addAttribute("sysMenuList", sysMenuList);
		model.addAttribute("sysMenuCriteria", sysMenuCriteria);
		
		return "sysMenu/list";
	}
	
	@ActionControllerLog(channel = "sysMenu", action = "detail.do", title = "sysMenu详细", isSaveRequestData = true)
	@RequestMapping("/sysMenu/detail.do")
	public String detail(SysMenuCriteria sysMenuCriteria,int menuId, HttpServletRequest request, ModelMap model) {
		SysMenu sysMenu = sysMenuService.select(menuId);

		model.addAttribute("sysMenu", sysMenu);
		model.addAttribute("sysMenuCriteria", sysMenuCriteria);

		return "sysMenu/detail";
	}
	
	@RequestMapping("/sysMenu/write.do")
	public String write(SysMenuCriteria sysMenuCriteria, ModelMap model) {
		model.addAttribute("sysMenuCriteria", sysMenuCriteria);
		
		return "sysMenu/write";
	}
	
	@RequestMapping("/sysMenu/edit.do")
	public String edit(int menuId, SysMenuCriteria sysMenuCriteria,ModelMap model) {
		SysMenu sysMenu = sysMenuService.select(menuId);
		
		model.addAttribute("sysMenu", sysMenu);
		model.addAttribute("sysMenuCriteria", sysMenuCriteria);
		
		return "sysMenu/edit";
	}
	
	@ActionControllerLog(channel = "sysMenu", action = "save.do", title = "新增sysMenu", isSaveRequestData = true)
	@RequestMapping("/sysMenu/save.do")
	public @ResponseBody String save(@Valid SysMenu sysMenu,BindingResult result,ModelMap model) {
		if(result.hasErrors()){
			return  ValidatorShow.create().showErrors(result,model);
		}
		sysMenuService.insert(sysMenu);
		log.info("save acquisition menuId={}", sysMenu.getMenuId());
		
		return SessionUtil.FUN_SUCCESS_SAVE;
	}
	
	@ActionControllerLog(channel = "sysMenu", action = "update.do", title = "修改sysMenu", isSaveRequestData = true)
	@RequestMapping("/sysMenu/update.do")
	public @ResponseBody String update(@Valid SysMenu sysMenu,BindingResult result,SysMenuCriteria sysMenuCriteria,ModelMap model) {
		if(result.hasErrors()){
			return  ValidatorShow.create().showErrors(result,model);
		}
		sysMenuService.update(sysMenu);
		log.info("update SysMenu menuId={}", sysMenu.getMenuId());
		
		return SessionUtil.FUN_SUCCESS_UPDATE;
	}
	
	@ActionControllerLog(channel = "sysMenu", action = "delete.do", title = "删除sysMenu", isSaveRequestData = true)
	@RequestMapping("/sysMenu/delete.do")
	public @ResponseBody String delete(int menuId, SysMenuCriteria sysMenuCriteria, ModelMap model) {
		sysMenuService.delete(menuId);
		log.info("delete to sysMenu menuId={}", menuId);
		
		return SessionUtil.FUN_SUCCESS_DEL;
	}
	
}
