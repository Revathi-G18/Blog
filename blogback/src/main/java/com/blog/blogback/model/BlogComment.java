package com.blog.blogback.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;
@Component
@Entity
public class BlogComment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne
	private Blog blog;
	@ManyToOne
	private UserDetail commentedBy;
	private Date commentedOn;
	private String commentTxt;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public UserDetail getCommentedBy() {
		return commentedBy;
	}
	public void setCommentedBy(UserDetail commentedBy) {
		this.commentedBy = commentedBy;
	}
	public Date getCommentedOn() {
		return commentedOn;
	}
	public void setCommentedOn(Date commentedOn) {
		this.commentedOn = commentedOn;
	}
	public String getCommentTxt() {
		return commentTxt;
	}
	public void setCommentTxt(String commentTxt) {
		this.commentTxt = commentTxt;
	}

	
}
