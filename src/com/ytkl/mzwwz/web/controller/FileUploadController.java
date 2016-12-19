package com.ytkl.mzwwz.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ytkl.mzwwz.aspect.ActionControllerLog;

@Controller
public class FileUploadController {

	@Value("${file.uploadSaveDir}")
	private String IMG_SAVEDIR;

	@ActionControllerLog(channel = "web", action = "fileUpload.do", title = "文件上传", isSaveRequestData = true)
	@RequestMapping(value = "/fileUpload.do", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> fileUpload(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");

		Map<String, Object> json = new HashMap<String, Object>();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		/** 页面控件的文件流* */
		MultipartFile multipartFile = null;
		Map<String, MultipartFile> map = multipartRequest.getFileMap();
		for (Iterator<String> i = map.keySet().iterator(); i.hasNext();) {
			Object obj = i.next();
			multipartFile = (MultipartFile) map.get(obj);

		}
		String fileName = new Date().getTime() + "_" + multipartFile.getOriginalFilename();
		String path = IMG_SAVEDIR + fileName;
		File localFile = new File(path);
		try {
			multipartFile.transferTo(localFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		json.put("fileUrl", "/static/" + fileName);
		return json;
	}

}
