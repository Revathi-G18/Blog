package com.blog.blogback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Friend {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
	@ManyToOne
private UserDetail fromId;
	@ManyToOne
private UserDetail toId;
private char status;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public UserDetail getFromId() {
	return fromId;
}
public void setFromId(UserDetail fromId) {
	this.fromId = fromId;
}
public UserDetail getToId() {
	return toId;
}
public void setToId(UserDetail toId) {
	this.toId = toId;
}
public char getStatus() {
	return status;
}
public void setStatus(char status) {
	this.status = status;
}


}
