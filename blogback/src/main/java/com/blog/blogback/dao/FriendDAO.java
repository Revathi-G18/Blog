package com.blog.blogback.dao;

import java.util.List;

import com.blog.blogback.model.Friend;
import com.blog.blogback.model.UserDetail;

public interface FriendDAO {
	List<UserDetail>suggestedUsers(String email);
	void addFriend(Friend friend);
	List<Friend>pendingRequests(String toIdEmail);
	void acceptRequest(Friend request);
	void deleteRequest(Friend request);
	List<Friend>listofFriends(String email);
}
