package com.example.demo;

import java.nio.charset.Charset;

import org.apache.catalina.Context;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/**
	 * Tomcat 설정
	 *
	 * [설명]
	 *
	 * @Method : servletContainer
	 * @return : EmbeddedServletContainerFactory
	 * @author : leebw
	 * @since : 2018. 1. 16.
	 */
	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
		tomcat.setPort(8080);
		tomcat.setContextPath("/demo");
		tomcat.setUriEncoding(Charset.forName("UTF-8"));
		tomcat.setSessionTimeout(60*24);

		TomcatContextCustomizer contextCustomizer = new TomcatContextCustomizer() {
			@Override
			public void customize(Context context) {
				context.addWelcomeFile("/index.jsp");
				context.setReloadable(false);
			}
		};
		tomcat.addContextCustomizers(contextCustomizer);


		return tomcat;
	}
}
