package com.blog.blogback.dao;

import java.util.List;

import com.blog.blogback.model.Notification;

public interface NotificationDAO {
	public List<Notification>getNotificationsNotViewed(String email);

	public Notification getNotification(int id);

	public void updateNotification(int id);
}
