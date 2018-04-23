package com.blog.blogback.dao;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blog.blogback.model.Blog;
import com.blog.blogback.model.BlogPostLikes;
import com.blog.blogback.model.UserDetail;
@Repository
@Transactional
public class BlogPostLikesDAOImpl implements BlogPostLikesDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public BlogPostLikes hasUserLikedBlog(int blogId, String email) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from BlogPostLikes where blogPost.id=? and user.email=?");
		query.setInteger(0, blogId);
		query.setString(1, email);
		BlogPostLikes blogPostLikes=(BlogPostLikes)query.uniqueResult();
		return blogPostLikes;
	}
	public Blog updateLikes(int id,String email){
		Session session=sessionFactory.getCurrentSession();
		BlogPostLikes blogPostLikes=hasUserLikedBlog(id,email);
		Blog blog=(Blog)session.get(Blog.class, id);
		if(blogPostLikes==null){
			blogPostLikes=new BlogPostLikes();
			UserDetail userDetail=(UserDetail)session.get(UserDetail.class, email);
			blogPostLikes.setBlog(blog);
			blogPostLikes.setUserDetail(userDetail);
			session.save(blogPostLikes);
			blog.setLikes(blog.getLikes() + 1);
			session.update(blog);
		}else{
			session.delete(blogPostLikes);
			blog.setLikes(blog.getLikes() - 1);
			session.update(blog);
		}
		return blog;
	}

}
