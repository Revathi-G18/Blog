package com.blog.blogback.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{


@Override
protected Class<?>[] getRootConfigClasses() {
	return new Class[] { DBConfig.class };
}

@Override
protected Class<?>[] getServletConfigClasses() {
	// TODO Auto-generated method stub
	return null;
}

@Override
protected String[] getServletMappings() {
	// TODO Auto-generated method stub
	return null;
}
}
