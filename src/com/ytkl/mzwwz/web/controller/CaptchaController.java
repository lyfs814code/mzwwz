package com.ytkl.mzwwz.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ytkl.mzwwz.util.CaptchaCode;

@Controller
public class CaptchaController {
	@Autowired
	private HttpSession session;

	@RequestMapping("/getKaptchaImage.do")
	public ModelAndView getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 设置响应的类型格式为图片格式
		response.setContentType("image/jpeg");
		// 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		CaptchaCode vCode = new CaptchaCode(120, 32, 4, 10);
		session.setAttribute("KAPTCHA_SESSION_KEY", vCode.getCode());
		vCode.write(response.getOutputStream());
		return null;
	}
}
