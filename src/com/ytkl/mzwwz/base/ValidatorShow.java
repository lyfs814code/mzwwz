package com.ytkl.mzwwz.base;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class ValidatorShow {
	/**
	 * 默认错误页面
	 */
	private  String error_page = "/common/error_message";
	/**
	 * 默认错误信息属性名称
	 */
	private  String error_attr_name = "errors";
	
	private static ValidatorShow validatorShow;
	
	public  static ValidatorShow create(){
		if(validatorShow!=null){
			return validatorShow;
		}else{
			return new ValidatorShow();
		}
	}
	
	public String showErrors(BindingResult result,ModelMap model){
		List<FieldError> list = result.getFieldErrors();
		List<String> errors = new ArrayList<String>();
		for(int i=0;i<list.size();i++){
			FieldError fieldError = list.get(i);
			errors.add(fieldError.getField()+":"+fieldError.getDefaultMessage());
		}
		model.put(error_attr_name, errors);
		return error_page;
	}
}
