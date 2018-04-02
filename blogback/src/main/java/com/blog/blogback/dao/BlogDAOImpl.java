package com.blog.blogback.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blog.blogback.model.Blog;
import com.blog.blogback.model.BlogComment;
@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	public boolean addBlog(Blog blog) {
		try
		{
		sessionFactory.getCurrentSession().save(blog);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}

	public boolean deleteBlog(int blogId) {
		try
		{
			Blog blog=(Blog) sessionFactory.getCurrentSession().get(Blog.class,blogId);
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}

	public boolean updateBlog(int blogId) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Blog> listBlogs(String userName) {
		try{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Blog where loginName=:userName");
		System.out.println(query.list());
		//List<Category> listCategories=(List<Category>)query.list();
		return query.list();}
		catch(Exception e){
			return null;
		}
	}
	@Transactional
	public boolean approveBlog(Blog blog) {
		sessionFactory.getCurrentSession().update(blog);
		return true;
	}
	@Transactional
	public boolean rejectBlog(Blog blog) {
		try
		{
			blog.setStatus("NA");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}	
	}

	public Blog getBlog(int blogId) {
		try{
		Session session=sessionFactory.openSession();
		Blog blog=(Blog)session.get(Blog.class,blogId);
		return blog;}
		catch(Exception e){
			return null;
		}
	}

	public List<Blog> listAllBlogs() {
		try{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Blog");
			//List<Category> listCategories=(List<Category>)query.list();
			return query.list();}
			catch(Exception e){
				return null;
			}
		
	}

	public boolean incrementLike(Blog blog) {
		try{
			int likes=blog.getLikes();
			likes++;
			blog.setLikes(likes);
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e){
			return false;
		}
		
	}

	public List<BlogComment> listBlogComments(int blogId) {
		try{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from BlogComment");
			//List<Category> listCategories=(List<Category>)query.list();
			return query.list();}
			catch(Exception e){
				return null;
			}
	}

	public boolean addBlogComment(BlogComment blogComment) {
		try
		{
		sessionFactory.getCurrentSession().save(blogComment);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}

	public boolean deleteBlogComment(BlogComment blogComment) {
		try
		{
			//BlogComment blogcomment=(BlogComment) sessionFactory.getCurrentSession().get(BlogComment.class,commentId);
			sessionFactory.getCurrentSession().delete(blogComment);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}

	public BlogComment getBlogComment(int commentId) {
		try{
			Session session=sessionFactory.openSession();
			BlogComment blogcomment=(BlogComment)session.get(BlogComment.class,commentId);
			return blogcomment;}
			catch(Exception e){
				return null;
			}
	}

}
