package com.ytkl.mzwwz.web.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.ytkl.mzwwz.criteria.SysCodeValueCriteria;
import com.ytkl.mzwwz.domain.SysCodeValue;
import com.ytkl.mzwwz.service.SysCodeValueService;
import com.ytkl.mzwwz.util.SessionUtil;

@Controller
public class SysCodeValueController {
	private static final Logger log = LoggerFactory.getLogger(SysCodeValueController.class);

	@Autowired
	private ServletContext application;
	@Autowired
	private SysCodeValueService sysCodeValueService;

	@RequestMapping("/sysCodeValue/list.do")
	public String list(SysCodeValueCriteria sysCodeValueCriteria, ModelMap model) {
		List<SysCodeValue> sysCodeValueList = sysCodeValueService.listOnPage(sysCodeValueCriteria);

		model.addAttribute("sysCodeValueList", sysCodeValueList);
		model.addAttribute("sysCodeValueCriteria", sysCodeValueCriteria);

		return "sysCodeValue/list";
	}

	@ActionControllerLog(channel = "sysCodeValue", action = "detail.do", title = "sysCodeValue详细", isSaveRequestData = true)
	@RequestMapping("/sysCodeValue/detail.do")
	public String detail(SysCodeValueCriteria sysCodeValueCriteria, int id, HttpServletRequest request,
			ModelMap model) {
		SysCodeValue sysCodeValue = sysCodeValueService.select(id);

		model.addAttribute("sysCodeValue", sysCodeValue);
		model.addAttribute("sysCodeValueCriteria", sysCodeValueCriteria);

		return "sysCodeValue/detail";
	}

	@RequestMapping("/sysCodeValue/write.do")
	public String write(SysCodeValueCriteria sysCodeValueCriteria, ModelMap model) {
		model.addAttribute("sysCodeValueCriteria", sysCodeValueCriteria);

		return "sysCodeValue/write";
	}

	@RequestMapping("/sysCodeValue/edit.do")
	public String edit(int id, SysCodeValueCriteria sysCodeValueCriteria, ModelMap model) {
		SysCodeValue sysCodeValue = sysCodeValueService.select(id);

		model.addAttribute("sysCodeValue", sysCodeValue);
		model.addAttribute("sysCodeValueCriteria", sysCodeValueCriteria);

		return "sysCodeValue/edit";
	}

	@ActionControllerLog(channel = "sysCodeValue", action = "save.do", title = "新增sysCodeValue", isSaveRequestData = true)
	@RequestMapping("/sysCodeValue/save.do")
	public @ResponseBody String save(@Valid SysCodeValue sysCodeValue, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return ValidatorShow.create().showErrors(result, model);
		}
		sysCodeValueService.insert(sysCodeValue);
		log.info("save acquisition id={}", sysCodeValue.getId());

		return SessionUtil.FUN_SUCCESS_SAVE;
	}

	@ActionControllerLog(channel = "sysCodeValue", action = "update.do", title = "修改sysCodeValue", isSaveRequestData = true)
	@RequestMapping("/sysCodeValue/update.do")
	public @ResponseBody String update(@Valid SysCodeValue sysCodeValue, BindingResult result,
			SysCodeValueCriteria sysCodeValueCriteria, ModelMap model) {
		if (result.hasErrors()) {
			return ValidatorShow.create().showErrors(result, model);
		}
		sysCodeValueService.update(sysCodeValue);
		log.info("update SysCodeValue id={}", sysCodeValue.getId());

		return SessionUtil.FUN_SUCCESS_UPDATE;
	}

	@ActionControllerLog(channel = "sysCodeValue", action = "delete.do", title = "删除sysCodeValue", isSaveRequestData = true)
	@RequestMapping("/sysCodeValue/delete.do")
	public @ResponseBody String delete(int id, SysCodeValueCriteria sysCodeValueCriteria, ModelMap model) {
		sysCodeValueService.delete(id);
		log.info("delete to sysCodeValue id={}", id);

		return SessionUtil.FUN_SUCCESS_DEL;
	}

	/**
	 * 刷新系统缓存
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@ActionControllerLog(channel = "sysCodeValue", action = "refreshSjzd.do", title = "刷新数据字典缓存", isSaveRequestData = false)
	@RequestMapping("/sysCodeValue/refreshSjzd.do")
	public @ResponseBody String refreshSjzd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<SysCodeValue> tConstants = sysCodeValueService.list(null);
		application.setAttribute("constants", tConstants);

		return SessionUtil.FUN_SUCCESS;
	}

}
