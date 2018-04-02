package com.blog.blogback.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Job {
@Id
String jobId;
String jobDesignation;
String company;
int salary;
String location;
String jobDesc;


public String getJobId() {
	return jobId;
}
public void setJobId(String jobId) {
	this.jobId = jobId;
}
public String getJobDesignation() {
	return jobDesignation;
}
public void setJobDesignation(String jobDesignation) {
	this.jobDesignation = jobDesignation;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getJobDesc() {
	return jobDesc;
}
public void setJobDesc(String jobDesc) {
	this.jobDesc = jobDesc;
}


}
