/**
 * 
 */
package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.HelloWorld;
import com.example.demo.service.HelloWorldService;

/**
 * 
 * [설명]
 * 
 * @file : HelloWorldController.java
 * @package : com.example.demo.controller
 * @project : demo
 * @author : leebw 
 * @since : 2018. 1. 16.
 */

@Controller
@RequestMapping(value = "/hello")
public class HelloWorldController {

	
	@Autowired
	HelloWorldService helloWorldService; 
	
	@RequestMapping(value = "/world", method = RequestMethod.GET)
	public String helloPage(
			HttpServletRequest request,
			Model model){
		
		System.out.println("hello 페이지 접속!");
		/**
		 * src/main/webapp/WEB-INF/views/hello 폴더 밑에 world.jsp
		 * DispatcherServletConfig.ViewResolver에서 Bean 등록을 통해
		 * prefix, suffix 설정을 미리 했기 때문에 생략이 가능
		 */
		return "/hello/world";
	}
	
	@ResponseBody
	@RequestMapping(
			value = "/list",
			method = RequestMethod.GET,
			produces = "application/json; charset=utf8")
	public String getListHelloWorld(){
		
		return helloWorldService.getListHelloWorld();
	}
	
	@ResponseBody
	@RequestMapping(
			value = "/{helloWorldId}",
			method = {RequestMethod.GET},
			produces = "application/json; charset=utf8")
	public String getHelloWorld(
			@PathVariable(value="helloWorldId") String helloWorldId){
		
		return helloWorldService.getHelloWorld(helloWorldId);
	}
	
	@ResponseBody
	@RequestMapping(
			value = "",
			method = RequestMethod.POST,
			produces = "application/json; charset=utf8")
	public String addHelloWorld(
			@RequestBody HelloWorld helloWorld){
		return helloWorldService.addHelloWorld(helloWorld);
	}
	
	@ResponseBody
	@RequestMapping(
			value = "",
			method = RequestMethod.PUT,
			produces = "application/json; charset=utf8")
	public String updateHelloWorld(
			@RequestBody HelloWorld helloWorld){
		helloWorldService.updateHelloWorld();
		return "";
	}
	
	@ResponseBody
	@RequestMapping(
			value = "",
			method = RequestMethod.DELETE,
			produces = "application/json; charset=utf8")
	public String deleteHelloWorld(
			@RequestBody HelloWorld helloWorld){
		helloWorldService.deleteHelloWorld();
		return "";
	}
}
