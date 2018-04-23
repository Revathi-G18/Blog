package com.blog.blogMiddle.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.blogback.dao.BlogPostLikesDAO;
import com.blog.blogback.model.Blog;
import com.blog.blogback.model.BlogPostLikes;
import com.blog.blogback.model.ErrorClazz;

@Controller
public class BlogPostLikesController {
	@Autowired
	private BlogPostLikesDAO blogPostLikesDao;
	@RequestMapping(value="/hasuserlikedblog/{blogId}",method=RequestMethod.GET)
	public ResponseEntity<?> hasUserLikedBlog(@PathVariable int blogId,HttpSession session){
		String email=(String)session.getAttribute("currentuser");
		if(email==null){
			ErrorClazz error=new ErrorClazz(5,"Unauthorised access....");
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
		}
		BlogPostLikes blogPostLikes=blogPostLikesDao.hasUserLikedBlog(blogId, email);
		return new ResponseEntity<BlogPostLikes>(blogPostLikes,HttpStatus.OK);
	}
	@RequestMapping(value="/updatelikes/{id}",method=RequestMethod.PUT)
	public ResponseEntity<?> updateLikes(@PathVariable int id,HttpSession session){
		String email=(String)session.getAttribute("currentuser");
		if(email==null){
			ErrorClazz error=new ErrorClazz(5,"Unauthorised access....");
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
		}
		Blog blog=blogPostLikesDao.updateLikes(id, email);
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
}
