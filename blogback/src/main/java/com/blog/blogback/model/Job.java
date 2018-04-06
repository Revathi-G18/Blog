package com.blog.blogback.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;
//@Component
@Entity
//@SequenceGenerator(name="jobidseq",sequenceName="jobid_seq")
public class Job {
@Id
String jobId;
String jobDesignation;
String company;
int salary;
String location;
String jobDesc;
//Date lastDate;


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
/*public Date getLastDate() {
	return lastDate;
}
public void setLastDate(Date lastDate) {
	this.lastDate = lastDate;
}
*/

}
