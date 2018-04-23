package com.blog.blogback.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blog.blogback.model.UserDetail;
@Transactional
@Repository
public class UserDetailDAOImpl implements UserDetailDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
		
		public void registerUser(UserDetail userDetail) {
			System.out.println("registeruser in dao" +userDetail);
			Session session=sessionFactory.getCurrentSession();
			session.save(userDetail);
		}
		
		public boolean isEmailUnique(String email) {
			Session session=sessionFactory.getCurrentSession();
		UserDetail userDetail =(UserDetail)session.get(UserDetail.class,email);
		if(userDetail==null)
			return true;
		else
			return false;
		}
		
		public UserDetail login(UserDetail userDetail) {
		
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from User where email=? and password=?");
			query.setString(0, userDetail.getEmail());
			query.setString(1, userDetail.getPassword());
			return (UserDetail)query.uniqueResult();
			
		}
		
		public void update(UserDetail validUser) {
			Session session=sessionFactory.getCurrentSession();
			session.update(validUser);
			
		}
		
		public UserDetail getUser(String email) {
			Session session=sessionFactory.getCurrentSession();
			UserDetail userDetail=(UserDetail)session.get(UserDetail.class, email);
			return userDetail;
		}
		
		public Void updateUser(UserDetail userDetail) {
			Session session=sessionFactory.getCurrentSession();
			session.update(userDetail);
			return null;
		}
		
		public List<UserDetail> searchUser(String name) {
			System.out.println(name);
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from User u where u.firstname like ? or u.lastname like ? or u.email like ? or u.phonenumber like ?");
			query.setString(0,"%"+name+ "%");
			query.setString(1,"%"+name+ "%");
			query.setString(2,"%"+name+ "%");
			List<UserDetail>users=query.list();
			return users;
		}

}
