package com.ytkl.mzwwz.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ytkl.mzwwz.aspect.ActionControllerLog;
import com.ytkl.mzwwz.domain.SysUser;
import com.ytkl.mzwwz.service.SysCodeValueService;
import com.ytkl.mzwwz.service.SysUserService;
import com.ytkl.mzwwz.util.DigestUtil;
import com.ytkl.mzwwz.util.OnlineUserBindingListener;
import com.ytkl.mzwwz.util.ResponseUtils;
import com.ytkl.mzwwz.util.SessionUtil;

@Controller
public class LoginController {
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private HttpSession session;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private SysCodeValueService sysCodeValueService;

	/**
	 * 跳转到注册页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/register.do")
	public String register(ModelMap model) throws Exception {
		return "register";
	}

	/**
	 * 跳转到登陆页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login.do")
	public String login(String re, ModelMap model) throws Exception {
		return "login";
	}

	/**
	 * 登陆，验证用户
	 * 
	 * @return
	 * @throws Exception
	 */
	@ActionControllerLog(channel = "web", action = "toLogin", title = "用户登陆", isSaveRequestData = true)
	@RequestMapping("/toLogin.do")
	public String toLogin(String loginId, String pwd, String authCode, ModelMap model, RedirectAttributes reAttr)
			throws Exception {
		String authCodeTrue = (String) session.getAttribute("KAPTCHA_SESSION_KEY");// 从session中取验证码

		String errMsg = "";

		if (loginId == null || "".equals(loginId)) {
			errMsg = "请输入登录名！";

			model.addAttribute("errMsg", errMsg);
			return "login";
		}
		if (pwd == null || "".equals(pwd)) {
			errMsg = "请输入密码！";

			model.addAttribute("errMsg", errMsg);
			return "login";
		}
		if (authCode == null || "".equals(authCode)) {
			errMsg = "请输入验证码！";

			model.addAttribute("errMsg", errMsg);
			return "login";
		}
		if (!authCode.equals(authCodeTrue)) {
			errMsg = "请输入正确的验证码！";

			model.addAttribute("errMsg", errMsg);
			return "login";
		}

		SysUser loginUser = sysUserService.select(loginId);
		if (loginUser == null) {
			errMsg = "登录名错误！";

			model.addAttribute("errMsg", errMsg);
			return "login";
		}
		if (loginUser.getUserstatus().equals("2")) {
			errMsg = "该账户待验证！";

			model.addAttribute("errMsg", errMsg);
			return "login";
		}
		if (loginUser.getUserstatus().equals("3")) {
			errMsg = "该账户已冻结！";

			model.addAttribute("errMsg", errMsg);
			return "login";
		}

		if (loginUser.getPwd().equals(DigestUtil.md5(pwd, DigestUtil.bit32))) {
			// 登陆成功后将登陆用户绑定监听
			String sessKey = session.getId();
			String remoteAddr = request.getRemoteAddr();
			OnlineUserBindingListener onlineUserBindingListener = new OnlineUserBindingListener(loginUser.getUserid()
					+ "", remoteAddr, sessKey);
			session.setAttribute("onlineUserBindingListener", onlineUserBindingListener);

			// 记录用户session
			session.setAttribute(SessionUtil.SESSION_USER, loginUser);
			return "redirect:main.do";
		} else {
			errMsg = "密码错误";
		}
		model.addAttribute("errMsg", errMsg);
		return "login";
	}

	/**
	 * 统计在线用户数
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/onlineCount.do")
	public void onlineCount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		OnlineUserBindingListener onlineUserBindingListener = (OnlineUserBindingListener) session
				.getAttribute("onlineUserBindingListener");
		int count = onlineUserBindingListener.getCount();
		ResponseUtils.renderJson(response, count + "");
	}

	/**
	 * 用于用户注册时，验证用户账号是否存在<br>
	 * <ul>
	 * <li>true：不存在，可以使用</li>
	 * <li>false：已存在，不可以使用，需要修改用户名</li>
	 * </ul>
	 * 
	 * @param userid
	 *            用户名
	 * @param request
	 * @param response
	 */
	@RequestMapping("/checkOnly.do")
	public void checkOnly(String userid, HttpServletRequest request, HttpServletResponse response) {
		SysUser user = sysUserService.select(userid);
		if (user == null) {
			ResponseUtils.renderJson(response, "true");
		} else {
			ResponseUtils.renderJson(response, "false");
		}
	}

	/**
	 * 
	 * 获取验证码
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * 
	 */
	@RequestMapping("/getAuthCode.do")
	public @ResponseBody
	String getAuthCode(@RequestParam String authCode) throws Exception {
		Boolean flag = false;
		String sessionCode = (String) session.getAttribute("KAPTCHA_SESSION_KEY");
		if (authCode.equals(sessionCode)) {
			flag = true;
		}
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("valid", flag);

		ObjectMapper mapper = new ObjectMapper();
		String resultString = "";
		try {
			resultString = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return resultString;
	}

	/**
	 * 退出系统
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/logout.do")
	public String logout() throws Exception {
		session.removeAttribute(SessionUtil.SESSION_USER);
		// 用户退出登陆时，解除session绑定
		session.removeAttribute("onlineUserBindingListener");

		return "redirect:login.do";
	}
}
