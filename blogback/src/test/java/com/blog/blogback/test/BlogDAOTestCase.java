package com.blog.blogback.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.blog.blogback.dao.BlogDAO;
import com.blog.blogback.model.Blog;
import com.blog.blogback.model.BlogComment;

public class BlogDAOTestCase {

static BlogDAO blogDAO;

@BeforeClass
public static void intialize(){
	
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.blog.*");
	context.refresh();
	
	blogDAO=(BlogDAO)context.getBean("blogDAO");	
}
@Ignore
@Test
public void addBlogTest(){
	Blog blog=new Blog();
	blog.setBlogName("Scribble");
	blog.setBlogContent("u can scribble whatever u want");
	blog.setLikes(0);
	blog.setLoginName("ray");
	blog.setCreateDate(new java.util.Date());
	blog.setStatus("status");
	blog.setBlogId(954);
	assertTrue("Problem in Blog Insetion",blogDAO.addBlog(blog));
	
}
@Ignore
@Test
public void deleteBlogTest(){
	assertTrue("Problem in Blog Deletion",blogDAO.deleteBlog(50050));
	
}
@Ignore
@Test
public void rejectBlogTest(){
	Blog blog=blogDAO.getBlog(953);
	assertTrue("Problem in Blog Rejection",blogDAO.rejectBlog(blog));
	
}
@Ignore
@Test
public void approvalBlogTest(){
	Blog blog=blogDAO.getBlog(953);
	assertTrue("Problem in Blog Approval",blogDAO.approveBlog(blog));
	
}

@Test
public void listBlogbyUserTest(){
	List<Blog> listblog=blogDAO.listBlogs("ray");
	assertTrue("Problem in listing blog",listblog.size()>0);
	
	for(Blog blog:listblog)
	{
		System.out.println(blog.getBlogName()+"::::");
		System.out.println(blog.getBlogContent()+":::");
		System.out.println(blog.getLoginName());
	}
	
}
@Ignore
@Test
public void incrementBlogLikeTest(){
	Blog blog=blogDAO.getBlog(953);
	assertTrue("Problem in Increment Like",blogDAO.incrementLike(blog));
	
}

@Test
public void addCommentTest(){
	BlogComment comment=new BlogComment();
	comment.setLoginName("ray");
	comment.setCommentText("this is the comment line");
	comment.setBlogId(9);
	comment.settodayDate(new java.util.Date());
	comment.setCommentId(5);
	assertTrue("Problem in Blog Approval",blogDAO.addBlogComment(comment));
}
}
