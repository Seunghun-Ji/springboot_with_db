/**
 *
 */
package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.HelloWorldDao;
import com.example.demo.domain.HelloWorld;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 *
 * [설명]
 *
 * @file : HelloWorldService.java
 * @package : com.example.demo.service
 * @project : demo
 * @author : leebw
 * @since : 2018. 1. 16.
 */
@Service
public class HelloWorldService {

	@Autowired
	HelloWorldDao helloWorldDao;

	/**
	 * HelloWorld 등록
	 *
	 * [설명]
	 *
	 * @Method : addHelloWorld
	 * @param helloWorld
	 * @return : String
	 * @author : leebw
	 * @since : 2018. 1. 16.
	 */
	public String addHelloWorld(HelloWorld helloWorld){
		JsonObject json = new JsonObject();
		String message = "";
		boolean result;
		// 유니크 아이디값 설정
		helloWorld.setHelloWorldId(UUID.randomUUID().toString());

		result = helloWorldDao.add(helloWorld);
		if(result){
			// 성공 메시지 만들어서 반환
			json.addProperty("result", "success");
			message = json.toString();
		}

		return message;
	}

	/**
	 * HelloWorld 단일 조회
	 *
	 * [설명]
	 *
	 * @Method : getHelloWorld
	 * @param helloWorldId
	 * @return : String
	 * @author : leebw
	 * @since : 2018. 1. 16.
	 */
	public String getHelloWorld(String helloWorldId){
		JsonObject json = new JsonObject();
		String message;
		HelloWorld helloWorld = null;
		helloWorld = helloWorldDao.get(helloWorldId);
		if(helloWorld == null){
			json.addProperty("result", "fail");
		}else{
			json.addProperty("result", "success");
		}

		message = json.toString();

		return message;
	}

	/**
	 * HelloWorld 목록 조회
	 *
	 * [설명]
	 *
	 * @Method : getListHelloWorld
	 * @return : String
	 * @author : leebw
	 * @since : 2018. 1. 16.
	 */
	public String getListHelloWorld(){
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonArray json = new JsonArray();

		List<HelloWorld> list = helloWorldDao.getList();
		if( ! list.isEmpty()){
			json = (JsonArray) parser.parse(gson.toJson(list));
			for(HelloWorld helloWorld : list){
				System.out.println(helloWorld.toString());
			}
		}

		return json.toString();
	}


	/**
	 * HelloWorld 목록 수정
	 *
	 * [설명]
	 *
	 * @Method : updateHelloWorld
	 * @return : String
	 * @author : leebw
	 * @since : 2018. 1. 16.
	 */
	public String updateHelloWorld(){
		return "";
	}

	/**
	 * HelloWorld 목록 삭제
	 *
	 * [설명]
	 *
	 * @Method : deleteHelloWorld
	 * @return : String
	 * @author : leebw
	 * @since : 2018. 1. 16.
	 */
	public String deleteHelloWorld(){
		return "";
	}
}
