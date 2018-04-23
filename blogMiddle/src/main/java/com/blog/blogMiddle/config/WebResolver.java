package com.blog.blogMiddle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.blog")
public class WebResolver {
	@Bean
	public InternalResourceViewResolver getViewResolver()
	{
		InternalResourceViewResolver iRVResolver=new InternalResourceViewResolver();
		iRVResolver.setPrefix("/WEB-INF/html");
		iRVResolver.setSuffix(".html");
		return iRVResolver;
	}	
}
