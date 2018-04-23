package com.blog.blogback.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.blogback.model.Blog;
import com.blog.blogback.model.BlogComment;
@Service
public interface BlogDAO {
	void addBlogPost(Blog blog);
	List<Blog>listofBlogs(int approved);
	Blog getBlog(int id);
	void approve(Blog blog);
	void reject(Blog blog,String rejectionReason);
	void addBlogComment(BlogComment blogComment);
	List<BlogComment> getAllBlogComments(int blogPostId);
}
