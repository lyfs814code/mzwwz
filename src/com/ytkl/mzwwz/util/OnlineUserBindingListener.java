package com.ytkl.mzwwz.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 实现在线用户统计功能<br/>
 * 原理：建立一个自增数组，每次用户登陆时建立一个键值对，然后放入数组中。
 * 
 * @author 户晓庭
 * 
 */
public class OnlineUserBindingListener implements HttpSessionBindingListener {

	private static final Logger log = LoggerFactory.getLogger(OnlineUserBindingListener.class);

	public String userId = "";
	public String remoteAddr;
	public String sessKey;
	public Vector onlineUserList;
	public static Map<String, Integer> userId_count = new HashMap<String, Integer>();

	public OnlineUserBindingListener(String userId, String remoteAddr, String sessKey) {
		this.userId = userId;
		this.remoteAddr = remoteAddr;
		this.sessKey = sessKey;
	}

	public int getCount() {
		onlineUserList.trimToSize();// 调整Vector users的容量为Vector users的大小
		return onlineUserList.capacity();// 返回users的容量
	}

	public boolean existUser(String userId) {
		int n = 1;
		onlineUserList.trimToSize();
		boolean existUser = false;
		for (int i = 0; i < onlineUserList.capacity(); i++) {
			if (userId.equals((String) onlineUserList.get(i))) {
				existUser = true;
				// 用户重复登陆时，其对应的登陆数加1
				n = userId_count.get(userId) + 1;
				userId_count.remove(userId);
				break;
			}
		}
		userId_count.put(userId, n);
		return existUser;
	}

	public void valueBound(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		ServletContext application = session.getServletContext();
		// 把用户名放入在线列表
		onlineUserList = (Vector) application.getAttribute("onlineUserList");
		// 第一次使用前，需要初始化
		if (onlineUserList == null) {
			onlineUserList = new Vector();
			application.setAttribute("onlineUserList", onlineUserList);
		}

		if (!existUser(userId)) {
			onlineUserList.add(this.userId);
		}

		log.info("用户" + userId + "登陆系统，该账号登陆数：" + userId_count.get(userId));

	}

	public void valueUnbound(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		ServletContext application = session.getServletContext();
		int n = 0;
		// 从在线列表中删除用户名
		onlineUserList = (Vector) application.getAttribute("onlineUserList");
		//
		// 用户退出登陆时，将其对应得登陆数减1
		n = userId_count.get(userId) - 1;

		if (n >= 1) {
			userId_count.remove(userId);
			userId_count.put(userId, n);
		} else {
			onlineUserList.remove(this.userId);
			userId_count.remove(userId);
		}
		log.info("用户" + userId + "登出系统，该账号登陆数：" + (userId_count.get(userId) == null ? 0 : userId_count.get(userId)));

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Map<String, Integer> getUserId_count() {
		return userId_count;
	}

	public void setUserId_count(Map<String, Integer> userIdCount) {
		userId_count = userIdCount;
	}

	public String getRemoteAddr() {
		return remoteAddr;
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

	public String getSessKey() {
		return sessKey;
	}

	public void setSessKey(String sessKey) {
		this.sessKey = sessKey;
	}
}
