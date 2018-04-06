package com.blog.blogback.dao;

import java.io.Serializable;
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
import com.blog.blogback.model.Forum;
import com.blog.blogback.model.ForumComment;
@Transactional
@Repository("forumDAO")
public class ForumDAOImpl implements ForumDAO{
	@Autowired
	private SessionFactory sessionFactory;
	public boolean addForum(Forum forum) {
		try
		{
			Session session=sessionFactory.openSession();
			Transaction transaction =session.getTransaction();
			transaction.begin();
			session.save(forum);
			transaction.commit();
			session.close();
		//sessionFactory.getCurrentSession().save(blog);
	
		System.out.println(sessionFactory.getCurrentSession());
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}

	public boolean updateForum(int forumId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteForum(int forumId) {
		try
		{
			Forum forum=(Forum) sessionFactory.getCurrentSession().get(Forum.class, forumId);
			sessionFactory.getCurrentSession().delete(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}

	public List<Forum> listForums(String username) {
		try{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Forum where loginName=:userName");
		System.out.println(query.list());
		//List<Category> listCategories=(List<Category>)query.list();
		return query.list();}
		catch(Exception e){
			return null;
		}
	}

	public boolean approvedForum(Forum forum) {
		sessionFactory.getCurrentSession().saveOrUpdate(forum);
		return true;
	}

	public boolean rejectedForum(Forum forum) {
		try
		{
			forum.setStatus("NA");
			sessionFactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}	
	}

	public Forum getForum(int forumId) {
		try{
			Session session=sessionFactory.openSession();
			Forum forum=(Forum)session.get(Forum.class,forumId);
			return forum;}
			catch(Exception e){
				return null;
			}
	}

	public List<Forum> listAllForums() {
		try{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Forum");
			//List<Category> listCategories=(List<Category>)query.list();
			return query.list();}
			catch(Exception e){
				return null;
			}
	}

	public boolean incrementLike(Forum forum) {
		try{
			int likes=forum.getLikes();
			likes++;
			forum.setLikes(likes);
			sessionFactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	public boolean addForumComment(ForumComment forumComment) {
		try
		{
		sessionFactory.getCurrentSession().save(forumComment);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}

	public boolean deleteForumComment(ForumComment forumComment) {
		//BlogComment blogcomment=(BlogComment) sessionFactory.getCurrentSession().get(BlogComment.class,commentId);
		sessionFactory.getCurrentSession().delete(forumComment);
		return true;
	}

	public ForumComment getForumComment(int commentId) {
		try{
			Session session=sessionFactory.openSession();
			ForumComment forumcomment=(ForumComment)session.get(ForumComment.class,commentId);
			return forumcomment;}
			catch(Exception e){
				return null;
			}
	}
	

	public List<ForumComment> listForumComments(int ForumId) {
		try{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from ForumComment");
			//List<Category> listCategories=(List<Category>)query.list();
			return query.list();}
			catch(Exception e){
				return null;
			}
	}

}
