package com.example.demo.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;

/**
 * web.xml을 대체하기 위한 class
 *
 * @author Ahn Cheolhwan
 * @filename WebInitializer.java
 * @date 2016. 2. 22.
 */
public class WebInitializer implements ServletContextInitializer {

	private static final Logger logger = LoggerFactory.getLogger(WebInitializer.class);

    /**
     * @author Ahn Cheolhwan
     * @date 2016. 2. 22.
     * @see org.springframework.web.WebApplicationInitializer#onStartup(javax.servlet.ServletContext)
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        try {


        } catch (NullPointerException e) {
            logger.error(e.getMessage(), e);
        }
    }

}
