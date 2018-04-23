package com.blog.blogback.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="userdetail")
public class UserDetail {
@Id
String password;
String firstName;
String lastName;
String email;
String phonenumber;
private String role;
@Column(name="online_status")
private boolean online;

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhonenumber() {
	return phonenumber;
}
public void setPhonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public boolean isOnline() {
	return online;
}
public void setOnline(boolean online) {
	this.online = online;
}
}
