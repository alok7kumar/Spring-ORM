package com.orm;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

								// RUN ON SERVER 9

@Configuration 
@EnableWebMvc
@ComponentScan(basePackages = "com.orm")
public class AppConfig implements WebMvcConfigurer {
	
	public AppConfig() {
		System.out.println("hello");
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver(); 
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/"); 
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public DataSource dataSource() {
		// Configure your data source here (e.g., DriverManagerDataSource or connection pool)
		DriverManagerDataSource dataSource = new DriverManagerDataSource(); 
		dataSource.setDriverClassName("com.mysql.jdbc.Driver"); 
		dataSource.setUrl("jdbc:mysql://localhost:3306/firstdb"); 
		dataSource.setUsername("root");
		dataSource.setPassword("yourpassword");
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean(); 
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.orm"); 
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
	
	private Properties hibernateProperties() { 
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		//mandatory to update
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	
	@Bean
	public HibernateTemplate hibernateTemplate(LocalSessionFactoryBean sessionFactory)
	{
		HibernateTemplate template = new HibernateTemplate(); 
		template.setSessionFactory(sessionFactory.getObject()); 
		template.setCheckWriteOperations(false);
		return template;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager() { 
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
	
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/").addResourceLocations("/");
	}
	
	
	//@Bean
	//public userDAO userDAO() {
	//return new userDAO();
	//}
	//@Bean
	//public Service1 Service1() {
	//return new Service1();
	//}
	//@Bean
	//public contoller contoller() {
	//return new contoller();
	//}
	
}
