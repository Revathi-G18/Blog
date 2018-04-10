package com.blog.blogback.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.springframework.stereotype.Component;
@Component
@Entity
public class BlogComment {
@Id
@GeneratedValue

int commentId;
String commentText;
String loginName;
int blogId;
//jason
Date todayDate;


public int getCommentId() {
	return commentId;
}
public void setCommentId(int commentId) {
	this.commentId = commentId;
}
public String getCommentText() {
	return commentText;
}
public void setCommentText(String commentText) {
	this.commentText = commentText;
}
public String getLoginName() {
	return loginName;
}
public void setLoginName(String loginName) {
	this.loginName = loginName;
}
public int getBlogId() {
	return blogId;
}
public void setBlogId(int blogId) {
	this.blogId = blogId;
}
public Date gettodayDate() {
	return todayDate;
}

public void settodayDate(Date todayDate) {
	this.todayDate = todayDate;
}
}
