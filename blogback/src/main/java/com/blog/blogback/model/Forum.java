package com.blog.blogback.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Forum {
@Id
@GeneratedValue
int forumId;
String forumName;
String forumContent;
Date crateDate;
int likes;
String userName;
String status;


public int getForumId() {
	return forumId;
}
public void setForumId(int forumId) {
	this.forumId = forumId;
}
public String getForumName() {
	return forumName;
}
public void setForumName(String forumName) {
	this.forumName = forumName;
}
public String getForumContent() {
	return forumContent;
}
public void setForumContent(String forumContent) {
	this.forumContent = forumContent;
}
public Date getCrateDate() {
	return crateDate;
}
public void setCrateDate(Date crateDate) {
	this.crateDate = crateDate;
}
public int getLikes() {
	return likes;
}
public void setLikes(int likes) {
	this.likes = likes;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}


}
