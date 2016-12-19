package com.ytkl.mzwwz.aspect;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ytkl.mzwwz.domain.SysUser;
import com.ytkl.mzwwz.domain.SysUserLog;
import com.ytkl.mzwwz.service.SysUserLogService;
import com.ytkl.mzwwz.util.DateUtils;
import com.ytkl.mzwwz.util.SessionUtil;

@Component
@Aspect
public class ActionControllerLogAspect {

	private static final Logger logger = LoggerFactory.getLogger(ActionControllerLogAspect.class);

	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpSession session;
	// 注入Service用于把日志保存数据库
	@Autowired
	private SysUserLogService sysUserLogService;

	@Pointcut("execution(* com.ytkl.mzwwz.web.controller.*Controller.*(..))")
	public void controllerAspect() {
	};

	/**
	 * 
	 * @param joinPoint
	 */
	@AfterReturning(pointcut = "controllerAspect()", returning = "r")
	public void afterReturning(JoinPoint joinPoint) {
		handleLog(joinPoint, null);
	}

	/**
	 * 日志--异常处理
	 */
	@AfterThrowing(pointcut = "controllerAspect()", throwing = "e")
	public void afterThrowing(JoinPoint joinPoint, Exception e) {
		handleLog(joinPoint, e);
	}

	/**
	 * 日志处理，存入数据库
	 */
	private void handleLog(JoinPoint joinPoint, Exception e) {
		try {
			// 获得注解
			ActionControllerLog controllerLog = giveController(joinPoint);
			if (controllerLog == null) {
				return;
			}
			SysUser sysUser = (SysUser) session.getAttribute(SessionUtil.SESSION_USER);

			if (sysUser == null) {
				return;
			}

			// *========数据库日志=========*//
			SysUserLog sysUserLog = new SysUserLog();
			// 请求的IP
			sysUserLog.setUserId(sysUser.getUserid());// 操作用户
			sysUserLog.setIpAddr(request.getRemoteAddr());// IP地址
			sysUserLog.setExcUrl(request.getRequestURI());
			if (e != null) {
				sysUserLog.setErrmsg(e.getMessage());
			}

			// 处理设置注解上的参数
			getControllerMethodDescription(controllerLog, sysUserLog, request);
			// 保存日志到数据库
			sysUserLogService.insert(sysUserLog);

			// 输出日志到控制台
			StringBuffer sb = new StringBuffer();
			sb.append("\n");
			sb.append("操作时间：");
			sb.append(DateUtils.format(new Date(System.currentTimeMillis()), DateUtils.YYYY_MM_DD_HH_MM_SS));
			sb.append("\n");
			sb.append("操作用户：");
			sb.append(sysUser.getUserid() + "，" + sysUser.getName());
			sb.append("\n");
			sb.append("操作方法：");
			sb.append(joinPoint.getSignature());
			sb.append("\n");
			logger.info(sb.toString());
		} catch (Exception exp) {
			// 记录本地异常日志
			logger.error("异常信息:{}", exp.getMessage());
		}
	}

	/**
	 * 获取注解中对方法的描述信息 用于Controller层注解
	 * 
	 * @param joinPoint
	 *            切点
	 * @return 方法描述
	 * @throws Exception
	 */
	public static void getControllerMethodDescription(ActionControllerLog controllerLog, SysUserLog sysUserLog,
			HttpServletRequest request) throws Exception {
		// 设置action动作
		sysUserLog.setAction(controllerLog.action());
		// 设置标题
		sysUserLog.setActName(controllerLog.title());
		// 设置channel
		sysUserLog.setChannel(controllerLog.channel());
		// 是否需要保存request，参数和值
		if (controllerLog.isSaveRequestData()) {
			// 获取参数的信息，传入到数据库中。
			setRequestValue(sysUserLog, request);
		}
	}

	/**
	 * 获取请求的参数，放到log中
	 * 
	 * @param userlogModel
	 * @param request
	 */
	@SuppressWarnings("rawtypes")
	private static void setRequestValue(SysUserLog userlogModel, HttpServletRequest request) {
		if (userlogModel == null)
			userlogModel = new SysUserLog();
		Map map = request.getParameterMap();
		String params = JSONObject.toJSONString(map);
		userlogModel.setParams(params);
	}

	/**
	 * 是否存在注解，如果存在就记录日志
	 * 
	 * @param joinPoint
	 * @param controllerLog
	 * @return
	 * @throws Exception
	 */
	private static ActionControllerLog giveController(JoinPoint joinPoint) throws Exception {
		Signature signature = joinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method method = methodSignature.getMethod();

		if (method != null) {
			return method.getAnnotation(ActionControllerLog.class);
		}
		return null;
	}
}
