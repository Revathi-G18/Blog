package com.blog.blogback.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.blogback.model.Blog;
import com.blog.blogback.model.BlogComment;
@Service
public interface BlogDAO {
 public boolean addBlog(Blog blog);
 public boolean deleteBlog(int blogId);
 public boolean updateBlog(int blogId);
 
 public List<Blog> listBlogs(String userName);
 public boolean approveBlog(Blog blog);
 public boolean rejectBlog(Blog blog);
 public Blog getBlog(int blogId);
 public List<Blog> listAllBlogs();
 public boolean incrementLike(Blog blog);
 
 public boolean addBlogComment(BlogComment blogComment);
 public boolean deleteBlogComment(BlogComment blogComment);
 public BlogComment getBlogComment(int commentId);
 public List<BlogComment> listBlogComments(int blogId); 
}
