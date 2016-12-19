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
import com.ytkl.mzwwz.criteria.CommonParaCriteria;
import com.ytkl.mzwwz.domain.CommonPara;
import com.ytkl.mzwwz.service.CommonParaService;
import com.ytkl.mzwwz.util.SessionUtil;

@Controller
public class ParaOrgController {
	private static final Logger log = LoggerFactory.getLogger(ParaOrgController.class);

	@Autowired
	private CommonParaService commonParaService;

	@RequestMapping("/paraOrg/list.do")
	public String list(CommonParaCriteria commonParaCriteria,ModelMap model) {
		List<CommonPara> commonParaList = commonParaService.listOnPage(commonParaCriteria);
		
		model.addAttribute("commonParaList", commonParaList);
		model.addAttribute("commonParaCriteria", commonParaCriteria);
		
		return "commonPara/list";
	}
	
	@ActionControllerLog(channel = "commonPara", action = "detail.do", title = "commonPara详细", isSaveRequestData = true)
	@RequestMapping("/paraOrg/detail.do")
	public String detail(CommonParaCriteria commonParaCriteria,String code, HttpServletRequest request, ModelMap model) {
		CommonPara commonPara = commonParaService.select(code);

		model.addAttribute("commonPara", commonPara);
		model.addAttribute("commonParaCriteria", commonParaCriteria);

		return "commonPara/detail";
	}
	
	@RequestMapping("/paraOrg/write.do")
	public String write(CommonParaCriteria commonParaCriteria, ModelMap model) {
		model.addAttribute("commonParaCriteria", commonParaCriteria);
		
		return "commonPara/write";
	}
	
	@RequestMapping("/paraOrg/edit.do")
	public String edit(String code, CommonParaCriteria commonParaCriteria,ModelMap model) {
		CommonPara commonPara = commonParaService.select(code);
		
		model.addAttribute("commonPara", commonPara);
		model.addAttribute("commonParaCriteria", commonParaCriteria);
		
		return "commonPara/edit";
	}
	
	@ActionControllerLog(channel = "commonPara", action = "save.do", title = "新增commonPara", isSaveRequestData = true)
	@RequestMapping("/paraOrg/save.do")
	public @ResponseBody String save(@Valid CommonPara commonPara,BindingResult result,ModelMap model) {
		if(result.hasErrors()){
			return  ValidatorShow.create().showErrors(result,model);
		}
		commonParaService.insert(commonPara);
		log.info("save acquisition code={}", commonPara.getCode());
		
		return SessionUtil.FUN_SUCCESS_SAVE;
	}
	
	@ActionControllerLog(channel = "commonPara", action = "update.do", title = "修改commonPara", isSaveRequestData = true)
	@RequestMapping("/paraOrg/update.do")
	public @ResponseBody String update(@Valid CommonPara commonPara,BindingResult result,CommonParaCriteria commonParaCriteria,ModelMap model) {
		if(result.hasErrors()){
			return  ValidatorShow.create().showErrors(result,model);
		}
		commonParaService.update(commonPara);
		log.info("update CommonPara code={}", commonPara.getCode());
		
		return SessionUtil.FUN_SUCCESS_UPDATE;
	}
	
	@ActionControllerLog(channel = "commonPara", action = "delete.do", title = "删除commonPara", isSaveRequestData = true)
	@RequestMapping("/paraOrg/delete.do")
	public @ResponseBody String delete(String code, CommonParaCriteria commonParaCriteria, ModelMap model) {
		commonParaService.delete(code);
		log.info("delete to commonPara code={}", code);
		
		return SessionUtil.FUN_SUCCESS_DEL;
	}
	
}
