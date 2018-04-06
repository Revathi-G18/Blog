package com.blog.blogback.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.blog.blogback.dao.JobDAO;
import com.blog.blogback.model.Job;

public class JobDAOTestCase {
	static JobDAO jobDAO;

	@BeforeClass
	public static void intialize(){
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.blog.*");
		context.refresh();
		
		jobDAO=(JobDAO)context.getBean("jobDAO");
		
	}
	@Test
	public void addJobtest() {
		Job job=new Job();
		job.setCompany("ABC");
		job.setJobDesc("description");
		job.setJobDesignation("Developer");
		//job.setLastDate(new java.util.Date());
		job.setLocation("Bangalore");
		job.setSalary(30000);
		job.setJobId("2");
		assertTrue("Problem in Blog Insetion",jobDAO.addJob(job));
		}
}
