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
import com.ytkl.mzwwz.criteria.SysParaCriteria;
import com.ytkl.mzwwz.domain.SysPara;
import com.ytkl.mzwwz.service.SysParaService;
import com.ytkl.mzwwz.util.SessionUtil;

@Controller
public class SysParaController {
	private static final Logger log = LoggerFactory.getLogger(SysParaController.class);

	@Autowired
	private SysParaService sysParaService;

	@RequestMapping("/sysPara/list.do")
	public String list(SysParaCriteria sysParaCriteria,ModelMap model) {
		List<SysPara> sysParaList = sysParaService.listOnPage(sysParaCriteria);
		
		model.addAttribute("sysParaList", sysParaList);
		model.addAttribute("sysParaCriteria", sysParaCriteria);
		
		return "sysPara/list";
	}
	
	@ActionControllerLog(channel = "sysPara", action = "detail.do", title = "sysPara详细", isSaveRequestData = true)
	@RequestMapping("/sysPara/detail.do")
	public String detail(SysParaCriteria sysParaCriteria,int id, HttpServletRequest request, ModelMap model) {
		SysPara sysPara = sysParaService.select(id);

		model.addAttribute("sysPara", sysPara);
		model.addAttribute("sysParaCriteria", sysParaCriteria);

		return "sysPara/detail";
	}
	
	@RequestMapping("/sysPara/write.do")
	public String write(SysParaCriteria sysParaCriteria, ModelMap model) {
		model.addAttribute("sysParaCriteria", sysParaCriteria);
		
		return "sysPara/write";
	}
	
	@RequestMapping("/sysPara/edit.do")
	public String edit(int id, SysParaCriteria sysParaCriteria,ModelMap model) {
		SysPara sysPara = sysParaService.select(id);
		
		model.addAttribute("sysPara", sysPara);
		model.addAttribute("sysParaCriteria", sysParaCriteria);
		
		return "sysPara/edit";
	}
	
	@ActionControllerLog(channel = "sysPara", action = "save.do", title = "新增sysPara", isSaveRequestData = true)
	@RequestMapping("/sysPara/save.do")
	public @ResponseBody String save(@Valid SysPara sysPara,BindingResult result,ModelMap model) {
		if(result.hasErrors()){
			return  ValidatorShow.create().showErrors(result,model);
		}
		sysParaService.insert(sysPara);
		log.info("save acquisition id={}", sysPara.getId());
		
		return SessionUtil.FUN_SUCCESS_SAVE;
	}
	
	@ActionControllerLog(channel = "sysPara", action = "update.do", title = "修改sysPara", isSaveRequestData = true)
	@RequestMapping("/sysPara/update.do")
	public @ResponseBody String update(@Valid SysPara sysPara,BindingResult result,SysParaCriteria sysParaCriteria,ModelMap model) {
		if(result.hasErrors()){
			return  ValidatorShow.create().showErrors(result,model);
		}
		sysParaService.update(sysPara);
		log.info("update SysPara id={}", sysPara.getId());
		
		return SessionUtil.FUN_SUCCESS_UPDATE;
	}
	
	@ActionControllerLog(channel = "sysPara", action = "delete.do", title = "删除sysPara", isSaveRequestData = true)
	@RequestMapping("/sysPara/delete.do")
	public @ResponseBody String delete(int id, SysParaCriteria sysParaCriteria, ModelMap model) {
		sysParaService.delete(id);
		log.info("delete to sysPara id={}", id);
		
		return SessionUtil.FUN_SUCCESS_DEL;
	}
	
}
