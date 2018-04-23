package com.blog.blogback.dao;

import java.util.List;

import com.blog.blogback.model.Job;

public interface JobDAO {
	void addJob(Job job);
	List<Job> getAllJobs();
	Job getJob(int id);
}
