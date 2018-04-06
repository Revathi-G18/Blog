package com.blog.blogback.dao;

import java.util.List;

import com.blog.blogback.model.Job;

public interface JobDAO {
	public boolean addJob(Job job);
	 public boolean deleteJob(int jobId);
	 public boolean updateJob(int jobId);	 
	 public List<Job> listJobs(String userName);
	 public Job getJob(int jobId);
}
