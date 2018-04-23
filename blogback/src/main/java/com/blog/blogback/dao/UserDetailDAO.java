package com.blog.blogback.dao;

import java.util.List;

import com.blog.blogback.model.UserDetail;

public interface UserDetailDAO {
	void registerUser(UserDetail userDetail);
	boolean isEmailUnique(String email);
	UserDetail login(UserDetail userDetail);
	void update(UserDetail validUser);
	UserDetail getUser(String email);
	Void updateUser(UserDetail userDetail);
	List<UserDetail>searchUser(String name);
 
}
