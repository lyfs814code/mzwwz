package com.ytkl.mzwwz.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.UrlPathHelper;

import com.ytkl.mzwwz.domain.SysUser;
import com.ytkl.mzwwz.util.SessionUtil;

public class AdminContextInterceptor extends HandlerInterceptorAdapter {

	private String[] excludeUrls;

	@Autowired
	private HttpSession session;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String uri = getURI(request);

		// 不在验证的范围内6
		if (exclude(uri)) {
			return true;
		} else {
			SysUser sysUser = (SysUser) request.getSession().getAttribute(SessionUtil.SESSION_USER);
			if (sysUser == null) {
				throw new ModelAndViewDefiningException(new ModelAndView("redirect:/login.do"));
			}
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mav)
			throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	private boolean exclude(String uri) {
		if (excludeUrls != null) {
			for (String exc : excludeUrls) {
				if (uri.indexOf(exc) != -1)
					return true;
			}
		}
		return false;

	}

	private static String getURI(HttpServletRequest request) throws IllegalStateException {
		UrlPathHelper helper = new UrlPathHelper();
		String uri = helper.getOriginatingRequestUri(request);
		String ctxPath = helper.getOriginatingContextPath(request);
		uri = uri.replaceAll(ctxPath, "");
		if (uri.indexOf("?") == -1) {
			return uri;
		}
		return uri.substring(0, uri.indexOf("?"));
	}

	public void setExcludeUrls(String[] excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

}