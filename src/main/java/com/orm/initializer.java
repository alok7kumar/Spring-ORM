package com.orm;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class initializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		System.out.println("root config");
		return new Class[] {AppConfig.class};
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		System.out.println("servlet config");
		return new Class[] {AppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		System.out.println("servlet config");
		return new String[] {"/"};
	}

}
