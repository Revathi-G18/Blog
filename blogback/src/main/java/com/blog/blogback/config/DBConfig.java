package com.blog.blogback.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.blog.blogback.model.Blog;
import com.blog.blogback.model.Forum;
import com.blog.blogback.model.Job;
import com.blog.blogback.model.UserDetail;


@Configuration
@ComponentScan("com.blog")
@EnableTransactionManagement
public class DBConfig {
	@Bean(name="dataSource")
	public DataSource getDataSource() 
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();		
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("BLOG");
		dataSource.setPassword("root");
		return dataSource;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateProp=new Properties();
		hibernateProp.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProp.setProperty("hibernate.show_sql", "true");
		hibernateProp.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		LocalSessionFactoryBuilder factoryBuilder=new LocalSessionFactoryBuilder(getDataSource());
		factoryBuilder.addAnnotatedClass(Blog.class);
		factoryBuilder.addAnnotatedClass(Forum.class);
		factoryBuilder.addAnnotatedClass(Job.class);
		factoryBuilder.addAnnotatedClass(UserDetail.class);	
		System.out.println("classes are created");
		return factoryBuilder.buildSessionFactory();
	}
	
	@Bean(name="txManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		return new HibernateTransactionManager(sessionFactory);
	}
}
