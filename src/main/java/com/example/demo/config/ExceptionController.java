/**
 * 
 */
package com.example.demo.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;

/**
 * 
 * [설명]
 * 
 * @file : ExceptionController.java
 * @package : com.example.demo.config
 * @project : demo
 * @author : leebw 
 * @since : 2018. 1. 16.
 */
@ControllerAdvice
public class ExceptionController {

	@ResponseBody
	@ExceptionHandler(Exception.class)
	public JsonObject exception(Exception ex) {
		JsonObject exceptionObject = new JsonObject();
		exceptionObject.addProperty("errMsg", ex.getMessage());
		
		System.out.println(exceptionObject.toString());
		
		return exceptionObject;
	}
}
