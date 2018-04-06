package com.blog.blogback.dao;

import com.blog.blogback.model.UserDetail;

public interface UserDetailDAO {
 public boolean checkcredential(UserDetail userdetail);
 public boolean registeruser(UserDetail userdetail);
 public UserDetail getUser(String loginName);
 
}
