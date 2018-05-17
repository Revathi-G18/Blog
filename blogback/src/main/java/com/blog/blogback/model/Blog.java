package com.blog.blogback.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

@Component
@Entity
//@SequenceGenerator(name="blogidseq",sequenceName="myblog_seq")
public class Blog {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 private int id;
 private String blogTitle;
 @Lob
 private String blogcontent;
 private Date postedon;
 @ManyToOne
 private UserDetail postedBy;
 private int likes;
 private int approved;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getBlogTitle() {
	return blogTitle;
}
public void setBlogTitle(String blogTitle) {
	this.blogTitle = blogTitle;
}
public String getBlogcontent() {
	return blogcontent;
}
public void setBlogcontent(String blogcontent) {
	this.blogcontent = blogcontent;
}
public Date getPostedon() {
	return postedon;
}
public void setPostedon(Date postedon) {
	this.postedon = postedon;
}
public UserDetail getPostedBy() {
	return postedBy;
}
public void setPostedBy(UserDetail postedBy) {
	this.postedBy = postedBy;
}
public int getLikes() {
	return likes;
}
public void setLikes(int likes) {
	this.likes = likes;
}
public int getApproved() {
	return approved;
}
public void setApproved(int approved) {
	this.approved = approved;
}

}
