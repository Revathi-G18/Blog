package com.blog.blogback.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

@Component
@Entity
@SequenceGenerator(name="blogidseq",sequenceName="myblog_seq")
public class Blog {
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="blogidseq")
int blogId;
String blogName;
String blogContent;
Date createDate;
int likes;
String loginName;
String status;

public int getBlogId() {
	return blogId;
}
public void setBlogId(int blogId) {
	this.blogId = blogId;
}
public String getBlogName() {
	return blogName;
}
public void setBlogName(String blogName) {
	this.blogName = blogName;
}
public String getBlogContent() {
	return blogContent;
}
public void setBlogContent(String blogContent) {
	this.blogContent = blogContent;
}
public Date getCreateDate() {
	return createDate;
}
public void setCreateDate(Date createDate) {
	this.createDate = createDate;
}
public int getLikes() {
	return likes;
}
public void setLikes(int likes) {
	this.likes = likes;
}
public String getLoginName() {
	return loginName;
}
public void setLoginName(String loginName) {
	this.loginName = loginName;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
}
