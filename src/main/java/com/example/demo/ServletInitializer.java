package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}

	/**
	 * 시스템 시작시 실행할 부분을 여기에 추가
	 * PostConstruct가 빈 생성후 자동으로 호출됨...
	 */
	@PostConstruct
	public void initialization(){


	}
}
