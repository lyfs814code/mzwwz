package com.ytkl.mzwwz.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import com.ytkl.mzwwz.criteria.OrgGuideCriteria;
import com.ytkl.mzwwz.domain.OrgGuide;
import com.ytkl.mzwwz.domain.SysUser;
import com.ytkl.mzwwz.service.OrgGuideService;
import com.ytkl.mzwwz.util.SessionUtil;

@Controller
public class OrgGuideController {
	private static final Logger log = LoggerFactory.getLogger(OrgGuideController.class);

	@Autowired
	private OrgGuideService orgGuideService;
	@Autowired
	private HttpSession session;

	@RequestMapping("/orgGuide/list.do")
	public String list(OrgGuideCriteria orgGuideCriteria, ModelMap model) {
		List<OrgGuide> orgGuideList = orgGuideService.listOnPage(orgGuideCriteria);

		model.addAttribute("orgGuideList", orgGuideList);
		model.addAttribute("orgGuideCriteria", orgGuideCriteria);

		return "orgGuide/list";
	}

	@ActionControllerLog(channel = "orgGuide", action = "detail.do", title = "orgGuide详细", isSaveRequestData = true)
	@RequestMapping("/orgGuide/detail.do")
	public String detail(OrgGuideCriteria orgGuideCriteria, int id, HttpServletRequest request, ModelMap model) {
		OrgGuide orgGuide = orgGuideService.select(id);

		model.addAttribute("orgGuide", orgGuide);
		model.addAttribute("orgGuideCriteria", orgGuideCriteria);

		return "orgGuide/detail";
	}

	@RequestMapping("/orgGuide/write.do")
	public String write(OrgGuideCriteria orgGuideCriteria, ModelMap model) {
		model.addAttribute("orgGuideCriteria", orgGuideCriteria);

		return "orgGuide/write";
	}

	@RequestMapping("/orgGuide/edit.do")
	public String edit(int id, OrgGuideCriteria orgGuideCriteria, ModelMap model) {
		OrgGuide orgGuide = orgGuideService.select(id);

		model.addAttribute("orgGuide", orgGuide);
		model.addAttribute("orgGuideCriteria", orgGuideCriteria);

		return "orgGuide/edit";
	}

	@ActionControllerLog(channel = "orgGuide", action = "save.do", title = "新增办事指南", isSaveRequestData = true)
	@RequestMapping("/orgGuide/save.do")
	public @ResponseBody String save(@Valid OrgGuide orgGuide, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return ValidatorShow.create().showErrors(result, model);
		}

		SysUser loginUser = (SysUser) session.getAttribute(SessionUtil.SESSION_USER);
		orgGuide.setCreater(loginUser.getUserid());

		orgGuideService.insert(orgGuide);
		log.info("save acquisition id={}", orgGuide.getId());

		return SessionUtil.FUN_SUCCESS_SAVE;
	}

	@ActionControllerLog(channel = "orgGuide", action = "update.do", title = "修改办事指南", isSaveRequestData = true)
	@RequestMapping("/orgGuide/update.do")
	public @ResponseBody String update(@Valid OrgGuide orgGuide, BindingResult result,
			OrgGuideCriteria orgGuideCriteria, ModelMap model) {
		if (result.hasErrors()) {
			return ValidatorShow.create().showErrors(result, model);
		}

		SysUser loginUser = (SysUser) session.getAttribute(SessionUtil.SESSION_USER);
		orgGuide.setModifier(loginUser.getUserid());

		orgGuideService.update(orgGuide);
		log.info("update OrgGuide id={}", orgGuide.getId());

		return SessionUtil.FUN_SUCCESS_UPDATE;
	}

	@ActionControllerLog(channel = "orgGuide", action = "delete.do", title = "删除办事指南", isSaveRequestData = true)
	@RequestMapping("/orgGuide/delete.do")
	public @ResponseBody String delete(int id, OrgGuideCriteria orgGuideCriteria, ModelMap model) {
		orgGuideService.delete(id);
		log.info("delete to orgGuide id={}", id);

		return SessionUtil.FUN_SUCCESS_DEL;
	}
}
