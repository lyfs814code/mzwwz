package com.ytkl.mzwwz.web.controller;

import java.util.Date;
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
import com.ytkl.mzwwz.criteria.MessageApplyCriteria;
import com.ytkl.mzwwz.criteria.MessageCriteria;
import com.ytkl.mzwwz.domain.Message;
import com.ytkl.mzwwz.service.MessageService;
import com.ytkl.mzwwz.util.SessionUtil;

@Controller
public class MessageController {
	private static final Logger log = LoggerFactory.getLogger(MessageController.class);

	@Autowired
	private MessageService messageService;

	@RequestMapping("/message/list.do")
	public String list(MessageCriteria messageCriteria,ModelMap model) {
		List<Message> messageList = messageService.listOnPage(messageCriteria);
		
		model.addAttribute("messageList", messageList);
		model.addAttribute("messageCriteria", messageCriteria);
		
		return "message/list";
	}
	
	@ActionControllerLog(channel = "message", action = "detail.do", title = "message详细", isSaveRequestData = true)
	@RequestMapping("/message/detail.do")
	public String detail(MessageCriteria messageCriteria,int id, HttpServletRequest request, ModelMap model) {
		Message message = messageService.select(id);

		model.addAttribute("message", message);
		model.addAttribute("messageCriteria", messageCriteria);

		return "message/detail";
	}
	
	@RequestMapping("/message/write.do")
	public String write(MessageCriteria messageCriteria, ModelMap model) {
		model.addAttribute("messageCriteria", messageCriteria);
		
		return "message/write";
	}
	
	@RequestMapping("/message/edit.do")
	public String edit(int id, MessageCriteria messageCriteria,ModelMap model) {
		Message message = messageService.select(id);
		
		model.addAttribute("message", message);
		model.addAttribute("messageCriteria", messageCriteria);
		
		return "message/edit";
	}
	
	@ActionControllerLog(channel = "message", action = "save.do", title = "新增message", isSaveRequestData = true)
	@RequestMapping("/message/save.do")
	public @ResponseBody String save(@Valid Message message,BindingResult result,ModelMap model) {
		if(result.hasErrors()){
			return  ValidatorShow.create().showErrors(result,model);
		}
		message.setCreateTime(new Date());
		messageService.insert(message);
		log.info("save acquisition id={}", message.getId());
		return SessionUtil.FUN_SUCCESS_SAVE;
	}
	
	@ActionControllerLog(channel = "message", action = "update.do", title = "修改message", isSaveRequestData = true)
	@RequestMapping("/message/update.do")
	public @ResponseBody String update(@Valid Message message,BindingResult result,MessageCriteria messageCriteria,ModelMap model) {
		if(result.hasErrors()){
			return  ValidatorShow.create().showErrors(result,model);
		}
		messageService.update(message);
		log.info("update Message id={}", message.getId());
		
		return SessionUtil.FUN_SUCCESS_UPDATE;
	}
	
	@ActionControllerLog(channel = "message", action = "delete.do", title = "删除message", isSaveRequestData = true)
	@RequestMapping("/message/delete.do")
	public @ResponseBody String delete(int id, MessageCriteria messageCriteria, ModelMap model) {
		messageService.delete(id);
		log.info("delete to message id={}", id);
		
		return SessionUtil.FUN_SUCCESS_DEL;
	}
	
	@RequestMapping("/message/remapper.do")
	public String remapper(int id,String replyFlag, MessageCriteria messageCriteria,ModelMap model) {
		model.addAttribute("messageId", String.valueOf(id));
		if(replyFlag.equals("1")){
			return "messageApply/write";
		}
		else{
			return "redirect:/messageApply/list.do";
		}
	}
}
