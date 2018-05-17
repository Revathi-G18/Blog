package com.blog.blogback.dao;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blog.blogback.model.Blog;
import com.blog.blogback.model.BlogComment;
import com.blog.blogback.model.Notification;
@Transactional
@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addBlogPost(Blog blog) {
		
         Session session=sessionFactory.getCurrentSession();
         session.save(blog);
	}
	
	public List<Blog> listofBlogs(int approved) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Blog where approved=" +approved);
		List<Blog> blogs=query.list();
		return blogs;
	}
	
	public Blog getBlog(int id) {
		Session session=sessionFactory.getCurrentSession();
		Blog blog=(Blog)session.get(Blog.class, id);
		return blog;
	}
	
	public void approve(Blog blog) {
		Session session=sessionFactory.getCurrentSession();
		blog.setApproved(1);
		session.update(blog);
		Notification notification=new Notification();
		notification.setBlogTitle(blog.getBlogTitle());
		notification.setApprovalStatus("Approved");
		notification.setEmail(blog.getPostedBy().getEmail());
		session.save(notification);
		
	}
	
	public void reject(Blog blog,String rejectionReason) {
		Session session=sessionFactory.getCurrentSession();
		Notification notification=new Notification();
		notification.setBlogTitle(blog.getBlogTitle());
		notification.setApprovalStatus("Rejected");
		notification.setEmail(blog.getPostedBy().getEmail());
		notification.setRejectionReason(rejectionReason);
		session.save(notification);
		session.delete(blog);
		
	}
	
	public void addBlogComment(BlogComment blogComment) {
	Session session=sessionFactory.getCurrentSession();
	session.save(blogComment);
		
	}
	
	public List<BlogComment> getAllBlogComments(int blogId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from BlogComment where blog.id=?");
		query.setInteger(0, blogId);
		List<BlogComment> blogComments=query.list();
		return blogComments;
	}

}
