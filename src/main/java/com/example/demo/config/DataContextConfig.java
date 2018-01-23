package com.example.demo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

/**
 * spring-persistence.xml (db 접근 관련) 파일을 대체하는 설정
 *
 * @filename DataContextConfig.java
 * @date 2016. 2. 22.
 * @author Ahn Cheolhwan
 */
@Configuration
public class DataContextConfig {

//	private static final Logger logger = LoggerFactory.getLogger(DataContextConfig.class);

	@Value(value="${db.driver}")
	String dbClassName;

	@Value(value="${db.url}")
	String dbUrl;

	@Value(value="${db.username}")
	String dbUserName;

	@Value(value="${db.password}")
	String dbPassword;

	@Value(value="${db.dialect}")
	String dbDirect;


	String defaultPackage = "com.example.demo.domain";

	/**
	 * data source 설정
	 * @author Ahn Cheolhwan
	 * @date 2016. 2. 22.
	 */
	@Bean(name="dataSource")
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(dbClassName);
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(dbUserName);
		dataSource.setPassword(dbPassword);
		return dataSource;
	}


	@Bean
	@Qualifier(value = "hibernateTransactionManager")
	@Primary
	public HibernateTransactionManager hibernateTransactionManager(){
		return new HibernateTransactionManager((SessionFactory) this.hibernateSessionFactoryBean().getObject());
	}

	/**
	 * Hibernate LocalSessionFactoryBean 생성
	 * @author Ahn Cheolhwan
	 * @date 2016. 2. 23.
	 */
	@Bean(name="hibernateSessionFactoryBean")
	public LocalSessionFactoryBean hibernateSessionFactoryBean(){
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setDataSource(this.dataSource());
		bean.setPackagesToScan(defaultPackage);
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", dbDirect);
		props.setProperty("hibernate.show_sql", "false");
		props.setProperty("hibernate.format_sql", "false");
		props.setProperty("hibernate.hbm2ddl.auto", "none"); // db 수정할 경우 : update로 변경, 평시에는 none으로 사용
		props.setProperty("hibernate.cache.use_second_level_cache", "true");
		props.setProperty("hibernate.cache.use_query_cache", "true");
		props.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
		props.setProperty("hibernate.c3p0.min_size", "1");
		props.setProperty("hibernate.c3p0.max_size", "5");
		props.setProperty("hibernate.c3p0.timeout", "10");
		props.setProperty("hibernate.c3p0.idle_test_period", "60000");

		bean.setHibernateProperties(props);
		return bean;
	}

}
