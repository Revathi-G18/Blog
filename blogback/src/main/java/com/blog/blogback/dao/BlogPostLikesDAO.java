package com.blog.blogback.dao;

import com.blog.blogback.model.Blog;
import com.blog.blogback.model.BlogPostLikes;

public interface BlogPostLikesDAO {
	public BlogPostLikes hasUserLikedBlog(int blogId,String email);
	public Blog updateLikes(int id,String email);
}
