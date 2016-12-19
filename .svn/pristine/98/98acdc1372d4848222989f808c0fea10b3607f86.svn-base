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
import com.ytkl.mzwwz.criteria.SysCodeTypeCriteria;
import com.ytkl.mzwwz.domain.SysCodeType;
import com.ytkl.mzwwz.service.SysCodeTypeService;
import com.ytkl.mzwwz.util.SessionUtil;

@Controller
public class SysCodeTypeController {
	private static final Logger log = LoggerFactory.getLogger(SysCodeTypeController.class);

	@Autowired
	private SysCodeTypeService sysCodeTypeService;

	@RequestMapping("/sysCodeType/list.do")
	public String list(SysCodeTypeCriteria sysCodeTypeCriteria,ModelMap model) {
		List<SysCodeType> sysCodeTypeList = sysCodeTypeService.listOnPage(sysCodeTypeCriteria);
		
		model.addAttribute("sysCodeTypeList", sysCodeTypeList);
		model.addAttribute("sysCodeTypeCriteria", sysCodeTypeCriteria);
		
		return "sysCodeType/list";
	}
	
	@ActionControllerLog(channel = "sysCodeType", action = "detail.do", title = "sysCodeType详细", isSaveRequestData = true)
	@RequestMapping("/sysCodeType/detail.do")
	public String detail(SysCodeTypeCriteria sysCodeTypeCriteria,String codeType, HttpServletRequest request, ModelMap model) {
		SysCodeType sysCodeType = sysCodeTypeService.select(codeType);

		model.addAttribute("sysCodeType", sysCodeType);
		model.addAttribute("sysCodeTypeCriteria", sysCodeTypeCriteria);

		return "sysCodeType/detail";
	}
	
	@RequestMapping("/sysCodeType/write.do")
	public String write(SysCodeTypeCriteria sysCodeTypeCriteria, ModelMap model) {
		model.addAttribute("sysCodeTypeCriteria", sysCodeTypeCriteria);
		
		return "sysCodeType/write";
	}
	
	@RequestMapping("/sysCodeType/edit.do")
	public String edit(String codeType, SysCodeTypeCriteria sysCodeTypeCriteria,ModelMap model) {
		SysCodeType sysCodeType = sysCodeTypeService.select(codeType);
		
		model.addAttribute("sysCodeType", sysCodeType);
		model.addAttribute("sysCodeTypeCriteria", sysCodeTypeCriteria);
		
		return "sysCodeType/edit";
	}
	
	@ActionControllerLog(channel = "sysCodeType", action = "save.do", title = "新增sysCodeType", isSaveRequestData = true)
	@RequestMapping("/sysCodeType/save.do")
	public @ResponseBody String save(@Valid SysCodeType sysCodeType,BindingResult result,ModelMap model) {
		if(result.hasErrors()){
			return  ValidatorShow.create().showErrors(result,model);
		}
		sysCodeTypeService.insert(sysCodeType);
		log.info("save acquisition codeType={}", sysCodeType.getCodeType());
		
		return SessionUtil.FUN_SUCCESS_SAVE;
	}
	
	@ActionControllerLog(channel = "sysCodeType", action = "update.do", title = "修改sysCodeType", isSaveRequestData = true)
	@RequestMapping("/sysCodeType/update.do")
	public @ResponseBody String update(@Valid SysCodeType sysCodeType,BindingResult result,SysCodeTypeCriteria sysCodeTypeCriteria,ModelMap model) {
		if(result.hasErrors()){
			return  ValidatorShow.create().showErrors(result,model);
		}
		sysCodeTypeService.update(sysCodeType);
		log.info("update SysCodeType codeType={}", sysCodeType.getCodeType());
		
		return SessionUtil.FUN_SUCCESS_UPDATE;
	}
	
	@ActionControllerLog(channel = "sysCodeType", action = "delete.do", title = "删除sysCodeType", isSaveRequestData = true)
	@RequestMapping("/sysCodeType/delete.do")
	public @ResponseBody String delete(String codeType, SysCodeTypeCriteria sysCodeTypeCriteria, ModelMap model) {
		sysCodeTypeService.delete(codeType);
		log.info("delete to sysCodeType codeType={}", codeType);
		
		return SessionUtil.FUN_SUCCESS_DEL;
	}
	
}
