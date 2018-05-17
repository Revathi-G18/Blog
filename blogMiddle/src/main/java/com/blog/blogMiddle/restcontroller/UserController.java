
package com.blog.blogMiddle.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blogback.dao.UserDetailDAO;
import com.blog.blogback.model.ErrorClazz;
import com.blog.blogback.model.UserDetail;
@RestController
public class UserController {
	@Autowired
	private UserDetailDAO userDetailDao;
		public UserController()
		{
			System.out.println("UserController is Created");
		}
		@RequestMapping(value="/registeruser",method=RequestMethod.POST)
		public ResponseEntity<?> registerUser(@RequestBody UserDetail userDetail){
			System.out.println("registeruser in usercontroller" +userDetail);
			if(!userDetailDao.isEmailUnique(userDetail.getEmail()))
			{   System.out.println("email");
				ErrorClazz error= new ErrorClazz(1,"Email already exist");
				return new ResponseEntity<ErrorClazz>(error,HttpStatus.CONFLICT);
			}
			try {
				userDetailDao.registerUser(userDetail);
				}
				catch(Exception e) {
					ErrorClazz error =new ErrorClazz(2,"Some required field are empty" +e.getMessage());
					return new ResponseEntity<ErrorClazz>(error, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			return new ResponseEntity<UserDetail>(userDetail,HttpStatus.OK);
		}
		@RequestMapping(value="/login",method=RequestMethod.POST)
		public ResponseEntity<?>login(@RequestBody UserDetail user,HttpSession session){
			UserDetail ValidUser=userDetailDao.login(user);
			if(ValidUser==null){
				ErrorClazz error=new ErrorClazz(5,"Login Failed Invalid Email Id or Password" );
				return new ResponseEntity<ErrorClazz>(error, HttpStatus.UNAUTHORIZED);
			}
			else
				{ 
				ValidUser.setOnline(true);
			    userDetailDao.update(ValidUser);
				session.setAttribute("currentuser", user.getEmail());
				return new ResponseEntity<UserDetail>(ValidUser,HttpStatus.OK);
			}
		}
		@RequestMapping(value="/logout",method=RequestMethod.PUT)
		public ResponseEntity<?> logout(HttpSession session){
			String email=(String)session.getAttribute("currentuser");
			System.out.println(email);
			if(email==null){
				ErrorClazz error=new ErrorClazz(4,"Please login..");
				return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
			}
			UserDetail userDetail=userDetailDao.getUser(email);
			userDetail.setOnline(false);
			userDetailDao.update(userDetail);
			session.removeAttribute("currentuser");
			session.invalidate();
			return new ResponseEntity<UserDetail>(userDetail,HttpStatus.OK);
		}
		@RequestMapping(value="/getuser",method=RequestMethod.GET)
		public ResponseEntity<?>getUser(HttpSession session){
			String email=(String)session.getAttribute("currentuser");
			if(email==null){
				ErrorClazz error=new ErrorClazz(5,"Unauthorised access...");
				return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
			}
			UserDetail userDetail=userDetailDao.getUser(email);
			return new ResponseEntity<UserDetail>(userDetail,HttpStatus.OK);
		}
		@RequestMapping(value="/updateUser",method=RequestMethod.PUT)
		public ResponseEntity<?>updateUser(@RequestBody UserDetail userDetail,HttpSession session){
			System.out.println("updateuser in usercontroller" +userDetail);
			String email=(String)session.getAttribute("currentuser");
			if(email==null){
				ErrorClazz error=new ErrorClazz(5,"Unauthorised access...");
				return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
			}
			try{
				userDetailDao.update(userDetail);
				return new ResponseEntity<UserDetail>(userDetail,HttpStatus.OK);
						}
			catch(Exception e){
				ErrorClazz error = new ErrorClazz(5,"Unable to update userdetails..." +e.getMessage());
				return new ResponseEntity<ErrorClazz>(error,HttpStatus.INTERNAL_SERVER_ERROR);
			}
	   	}
		@RequestMapping(value="/searchuser/{name}",method=RequestMethod.GET)
		   public ResponseEntity<?>searchUsers(@PathVariable String name,HttpSession session ){
			   String email=(String)session.getAttribute("currentuser");
				if(email==null){
					ErrorClazz error=new ErrorClazz(5,"Unauthorised access...");
					return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
				}
				System.out.println("Enter to searchcontroller");
				List<UserDetail>users=userDetailDao.searchUser(name);
				return new ResponseEntity<List<UserDetail>>(users,HttpStatus.OK);
		   }}
