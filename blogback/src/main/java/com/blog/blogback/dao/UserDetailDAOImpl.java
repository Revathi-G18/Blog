package com.blog.blogback.dao;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blog.blogback.model.UserDetail;
@Transactional
@Repository("userDetailDAO")
public class UserDetailDAOImpl implements UserDetailDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	public boolean checkcredential(UserDetail userdetail) {
		try{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from UserDetail where loginName=:loginName and password");
			System.out.println(query.list());
			query.setParameter("loginName",userdetail.getLoginName() );
			query.setParameter("password",userdetail.getPassword() );
			UserDetail userDetail=(UserDetail) query.list().get(0);
			if(userDetail==null){
				return false;
			}
			else{
				return true;
			}}
			catch(Exception e){
				return false;
			}
	}

	public boolean registeruser(UserDetail userdetail) {
		try
		{
			sessionFactory.getCurrentSession().save(userdetail);
			return true;
		}
		catch(Exception e)
		{
			
			System.out.println("Exception Arised:"+e);
			return false;
		}			
	}

	public UserDetail getUser(String loginName) {
		Session session=sessionFactory.openSession();
		UserDetail userDetail=(UserDetail) session.get(UserDetail.class, loginName);
		return userDetail;
	}

}
