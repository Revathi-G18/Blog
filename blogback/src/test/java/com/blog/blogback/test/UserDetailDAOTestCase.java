package com.blog.blogback.test;


import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import com.blog.blogback.dao.BlogDAO;
import com.blog.blogback.dao.UserDetailDAO;
import com.blog.blogback.model.UserDetail;

public class UserDetailDAOTestCase {
	
	static UserDetailDAO userDetailDAO;

	@BeforeClass
	public static void intialize(){
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.blog.*");
		context.refresh();
		
		userDetailDAO=(UserDetailDAO)context.getBean("userDetailDAO");
	}
	
@Test
public void registerUserTest(){
	UserDetail userDetail=new UserDetail();
	userDetail.setLoginName("sagar");
	userDetail.setPassword("pass@123");
	userDetail.setUserName("Sagar Akshay");
	userDetail.setEmailId("sagar@gmail.com");
	userDetail.setAddress("chennai");
	userDetail.setMobileNo("123456");
	assertTrue("Problem in userdetail registeration",userDetailDAO.registeruser(userDetail));
}


}
