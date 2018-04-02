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
import com.blog.blogback.model.UserDetails;

@Configuration
@ComponentScan("com.blog.blogback")
//@EnableWebMvc
@EnableTransactionManagement
public class DBConfig {
	@Bean(name="dataSource")
	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("SYSTEM");
		dataSource.setPassword("root");
		return dataSource;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(getDataSource());
		sessionBuilder.scanPackages("com.blog.blogback.model");
		sessionBuilder.setProperty("hibernate.show_sql", "true");
		sessionBuilder.setProperty("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		sessionBuilder.setProperty("hibernate.hbm2ddl.auto", "create");
		//sessionBuilder.addAnnotatedClass(Blog.class);
		//return sessionBuilder.buildSessionFactory();​
		return sessionBuilder.buildSessionFactory();
	}
		/*Properties hibernateProp=new Properties();
		hibernateProp.setProperty("hibernate.hbm2ddl.auto", "create");
		hibernateProp.put("hibernate.dialect","org.hibernate.dialect.OracleDialect");
		LocalSessionFactoryBuilder factoryBuilder=new LocalSessionFactoryBuilder(getDataSource());
		factoryBuilder.addAnnotatedClass(Blog.class);
		factoryBuilder.addAnnotatedClass(Forum.class);
		factoryBuilder.addAnnotatedClass(Job.class);
		factoryBuilder.addAnnotatedClass(UserDetails.class);		
		factoryBuilder.addAnnotatedClass(UserDetails.class);
			factoryBuilder.addAnnotatedClass(BillingAddress.class);
		factoryBuilder.addAnnotatedClass(ShippingAddress.class);
		factoryBuilder.addAnnotatedClass(Cart.class);
		factoryBuilder.addAnnotatedClass(CartItem.class);
		factoryBuilder.addAnnotatedClass(CustomerOrder.class);
		factoryBuilder.addProperties(hibernateProp);
		return factoryBuilder.buildSessionFactory();*/
	
	
	@Bean(name="txManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		return new HibernateTransactionManager(sessionFactory);
	}
}
