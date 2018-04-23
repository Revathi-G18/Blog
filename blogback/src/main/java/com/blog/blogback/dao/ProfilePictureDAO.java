package com.blog.blogback.dao;

import com.blog.blogback.model.ProfilePicture;

public interface ProfilePictureDAO {
	ProfilePicture getProfilePic(String email);
	void uploadProfilePicture(ProfilePicture profilePicture);
}
