
package com.blog.blogMiddle.restcontroller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.blogback.dao.BlogDAO;
import com.blog.blogback.dao.UserDetailDAO;
import com.blog.blogback.model.Blog;
import com.blog.blogback.model.BlogComment;
import com.blog.blogback.model.ErrorClazz;
import com.blog.blogback.model.UserDetail;

@Controller
public class BlogController {
	@Autowired
	private BlogDAO blogDao;
	@Autowired
	private UserDetailDAO userDetailDao;
	@RequestMapping(value="/addblogpost", method=RequestMethod.POST)
	public ResponseEntity<?> addBlogPost(@RequestBody Blog blog,HttpSession session){
		System.out.println("in add blogpost of blogcontroller");
		String email=(String)session.getAttribute("currentuser");
		if(email==null){
			ErrorClazz error=new ErrorClazz(5,"Unauthorised access....");
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
		}
		blog.setPostedon(new Date());
		System.out.println("blog   1");
		UserDetail postedBy=userDetailDao.getUser(email);
		System.out.println("blog   2");
		blog.setPostedBy(postedBy);
		try
		{	System.out.println(blog);
			blogDao.addBlogPost(blog);
			return new ResponseEntity<Blog>(blog,HttpStatus.OK);
		}catch(Exception e)
		{
			ErrorClazz error=new ErrorClazz(6,"Unable to post blog..." +e.getMessage());
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		}			
	}
	@RequestMapping(value="/getblogs/{approved}",method=RequestMethod.GET)
	public ResponseEntity<?>getAllBlogs(@PathVariable int approved,HttpSession session){
		System.out.println("in middlewares blogcontroller");
		String email=(String)session.getAttribute("currentuser");
		if(email==null){
			ErrorClazz error=new ErrorClazz(5,"Unauthorised access....");
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
		}
		if(approved==0){
			System.out.println(" aloooo...........in middlewares blogcontroller");
			UserDetail userDetail=userDetailDao.getUser(email);
			if(!userDetail.getRole().equals("ADMIN")){
				ErrorClazz error=new ErrorClazz(7,"Access Denied");
				return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
			}
		}
		List<Blog>blogs=blogDao.listofBlogs(approved);
		return new ResponseEntity<List<Blog>>(blogs,HttpStatus.OK);
	}
	@RequestMapping(value="/getblog/{id}",method=RequestMethod.GET)
	public ResponseEntity<?>getBlog(@PathVariable int id,HttpSession session){
		String email=(String)session.getAttribute("currentuser");
		if(email==null){
			ErrorClazz error=new ErrorClazz(5,"Unauthorised access....");
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
		}
		Blog blog=blogDao.getBlog(id);
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
	@RequestMapping(value="/approve",method=RequestMethod.PUT)
	public ResponseEntity<?>approve(@RequestBody Blog blog,HttpSession session){
		String email=(String)session.getAttribute("currentuser");
		if(email==null){
			ErrorClazz error=new ErrorClazz(5,"Unauthorised access....");
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
		}
		UserDetail userDetail=userDetailDao.getUser(email);
		if(!userDetail.getRole().equals("ADMIN")){
			ErrorClazz error=new ErrorClazz(7,"Access Denied");
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
		}
		blogDao.approve(blog);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@RequestMapping(value="/reject/{rejectionReason}",method=RequestMethod.PUT)
	public ResponseEntity<?>reject(@RequestBody Blog blog,@PathVariable String rejectionReason,HttpSession session){
		String email=(String)session.getAttribute("currentuser");
		if(email==null){
			ErrorClazz error=new ErrorClazz(5,"Unauthorised access....");
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
		}
		UserDetail user=userDetailDao.getUser(email);
		if(!user.getRole().equals("ADMIN")){
			ErrorClazz error=new ErrorClazz(7,"Access Denied");
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
		}
		blogDao.reject(blog,rejectionReason);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@RequestMapping(value="/addcomment", method=RequestMethod.POST)
	public ResponseEntity<?> addBlogComment(@RequestBody BlogComment blogComment,HttpSession session){
		String email=(String)session.getAttribute("currentuser");
		if(email==null){
			ErrorClazz error=new ErrorClazz(5,"Unauthorised access....");
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
		}
		UserDetail commentedBy=userDetailDao.getUser(email);
		blogComment.setCommentedOn(new Date());
		blogComment.setCommentedBy(commentedBy);
		try{
			blogDao.addBlogComment(blogComment);
		}catch(Exception e){
			ErrorClazz error=new ErrorClazz(6,"Unable to post comment"+e.getMessage());
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<BlogComment>(blogComment,HttpStatus.OK);
	}
	@RequestMapping(value="/blogcomments/{blogId}",method=RequestMethod.GET)
	public ResponseEntity<?> getAllBlogComments(@PathVariable int blogId,HttpSession session){
		String email=(String)session.getAttribute("currentuser");
		if(email==null){
			ErrorClazz error=new ErrorClazz(5,"Unauthorised access....");
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
		}
		List<BlogComment> blogComments=blogDao.getAllBlogComments(blogId);
		return new ResponseEntity<List<BlogComment>>(blogComments,HttpStatus.OK);
	}
}
