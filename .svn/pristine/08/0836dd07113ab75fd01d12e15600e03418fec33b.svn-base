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
import com.ytkl.mzwwz.criteria.LinkInfoCriteria;
import com.ytkl.mzwwz.domain.LinkInfo;
import com.ytkl.mzwwz.domain.SysUser;
import com.ytkl.mzwwz.service.LinkInfoService;
import com.ytkl.mzwwz.util.SessionUtil;

@Controller
public class LinkInfoController {
	private static final Logger log = LoggerFactory.getLogger(LinkInfoController.class);

	@Autowired
	private LinkInfoService linkInfoService;
	@Autowired
	private HttpSession session;

	@RequestMapping("/linkInfo/list.do")
	public String list(LinkInfoCriteria linkInfoCriteria,ModelMap model) {
		List<LinkInfo> linkInfoList = linkInfoService.listOnPage(linkInfoCriteria);
		
		model.addAttribute("linkInfoList", linkInfoList);
		model.addAttribute("linkInfoCriteria", linkInfoCriteria);
		
		return "linkInfo/list";
	}
	
	@ActionControllerLog(channel = "linkInfo", action = "detail.do", title = "linkInfo详细", isSaveRequestData = true)
	@RequestMapping("/linkInfo/detail.do")
	public String detail(LinkInfoCriteria linkInfoCriteria,int id, HttpServletRequest request, ModelMap model) {
		LinkInfo linkInfo = linkInfoService.select(id);

		model.addAttribute("linkInfo", linkInfo);
		model.addAttribute("linkInfoCriteria", linkInfoCriteria);

		return "linkInfo/detail";
	}
	
	@RequestMapping("/linkInfo/write.do")
	public String write(LinkInfoCriteria linkInfoCriteria, ModelMap model) {
		model.addAttribute("linkInfoCriteria", linkInfoCriteria);
		
		return "linkInfo/write";
	}
	
	@RequestMapping("/linkInfo/edit.do")
	public String edit(int id, LinkInfoCriteria linkInfoCriteria,ModelMap model) {
		LinkInfo linkInfo = linkInfoService.select(id);
		
		model.addAttribute("linkInfo", linkInfo);
		model.addAttribute("linkInfoCriteria", linkInfoCriteria);
		
		return "linkInfo/edit";
	}
	
	@ActionControllerLog(channel = "linkInfo", action = "save.do", title = "新增联系方式", isSaveRequestData = true)
	@RequestMapping("/linkInfo/save.do")
	public @ResponseBody String save(@Valid LinkInfo linkInfo,BindingResult result,ModelMap model) {
		if(result.hasErrors()){
			return  ValidatorShow.create().showErrors(result,model);
		}
		
		SysUser loginUser = (SysUser) session.getAttribute(SessionUtil.SESSION_USER);
		linkInfo.setCreater(loginUser.getUserid());
		
		linkInfoService.insert(linkInfo);
		log.info("save acquisition id={}", linkInfo.getId());
		
		return SessionUtil.FUN_SUCCESS_SAVE;
	}
	
	@ActionControllerLog(channel = "linkInfo", action = "update.do", title = "修改联系方式", isSaveRequestData = true)
	@RequestMapping("/linkInfo/update.do")
	public @ResponseBody String update(@Valid LinkInfo linkInfo,BindingResult result,LinkInfoCriteria linkInfoCriteria,ModelMap model) {
		if(result.hasErrors()){
			return  ValidatorShow.create().showErrors(result,model);
		}
		
		SysUser loginUser = (SysUser) session.getAttribute(SessionUtil.SESSION_USER);
		linkInfo.setModifier(loginUser.getUserid());
		
		linkInfoService.update(linkInfo);
		log.info("update LinkInfo id={}", linkInfo.getId());
		
		return SessionUtil.FUN_SUCCESS_UPDATE;
	}
	
	@ActionControllerLog(channel = "linkInfo", action = "delete.do", title = "删除联系方式", isSaveRequestData = true)
	@RequestMapping("/linkInfo/delete.do")
	public @ResponseBody String delete(int id, LinkInfoCriteria linkInfoCriteria, ModelMap model) {
		linkInfoService.delete(id);
		log.info("delete to linkInfo id={}", id);
		
		return SessionUtil.FUN_SUCCESS_DEL;
	}
	
}
