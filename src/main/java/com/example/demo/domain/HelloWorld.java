/**
 * 
 */
package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.Gson;

/**
 * 
 * [설명]
 * 
 * @file : HelloWorld.java
 * @package : com.example.demo.domain
 * @project : demo
 * @author : leebw 
 * @since : 2018. 1. 16.
 */
@Entity
@Table(name="HELLO_WORLD")
public class HelloWorld {

	@Id
	@Column(name="HELLO_WORLD_ID", length=40, nullable=false) // not null
	private String helloWorldId;
	
	@Column(name="HELLO_WORLD_USER_ID", length=20)
	private String userId;
	
	@Column(name="HELLO_WORLD_USER_NAME", length=20)
	private String userName;
	
	@Column(name="HELLO_WORLD_CONTENT", length=20)
	private String content;

	/**
	 * @return the helloWorldId
	 */
	public String getHelloWorldId() {
		return helloWorldId;
	}

	/**
	 * @param helloWorldId the helloWorldId to set
	 */
	public void setHelloWorldId(String helloWorldId) {
		this.helloWorldId = helloWorldId;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString(){
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
}
