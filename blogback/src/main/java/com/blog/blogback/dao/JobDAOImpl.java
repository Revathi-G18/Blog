package com.blog.blogback.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blog.blogback.model.Job;


@Repository("jobDAO")
@Transactional
public class JobDAOImpl implements JobDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean deleteJob(int jobId) {
		try
		{
			Job job=(Job) sessionFactory.getCurrentSession().get(Job.class,jobId);
			sessionFactory.getCurrentSession().delete(job);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}

	public boolean updateJob(int jobId) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Job> listJobs(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addJob(Job job) {
		try
		{
			Session session=sessionFactory.openSession();
			Transaction transaction =session.getTransaction();
			transaction.begin();
			session.save(job);
			transaction.commit();
			session.close();
		//sessionFactory.getCurrentSession().save(job);
		System.out.println(sessionFactory.getCurrentSession());
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}

	public Job getJob(int jobId) {
		// TODO Auto-generated method stub
		return null;
	}

}
