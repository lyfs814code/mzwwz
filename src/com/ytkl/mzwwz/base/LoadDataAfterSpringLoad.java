package com.ytkl.mzwwz.base;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.ytkl.mzwwz.domain.SysCodeValue;
import com.ytkl.mzwwz.service.SysCodeValueService;

public class LoadDataAfterSpringLoad implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private ServletContext application;
	@Autowired
	private SysCodeValueService sysCodeValueService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (event.getApplicationContext().getParent() == null) {
			// 需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
			// 加载数据字典
			List<SysCodeValue> tConstants = (List<SysCodeValue>) application.getAttribute("constants");
			if (tConstants == null || tConstants.size() == 0) {
				tConstants = sysCodeValueService.list(null);
				application.setAttribute("constants", tConstants);
			}
		}
	}

}
