package com.blog.blogMiddle.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blogback.dao.UserDetailDAO;
import com.blog.blogback.model.UserDetail;
@RestController
public class UserController {
	@Autowired
	private UserDetailDAO userDetailDao;
	@RequestMapping(value="/registeruser",method=RequestMethod.POST)
	public ResponseEntity<?> registerUser(@RequestBody UserDetail userdetail){
		if(!userDetailDao.registeruser(userdetail))
		{
			//ErrorClazz error= new ErrorClazz(1,"Email already exist");
			return new ResponseEntity<String>("Successfully registered ",HttpStatus.OK);
		}
		else{
			return new ResponseEntity<String>("problem in regitering", HttpStatus.UNAUTHORIZED);
		}
		}
		
	@RequestMapping(value="/Checklogin",method=RequestMethod.POST)
	public ResponseEntity<?>login(@RequestBody UserDetail userDetail,HttpSession session){
		if(userDetailDao.checkcredential(userDetail)){
			//ErrorClazz error=new ErrorClazz(5,"Login Failed Invalid Email Id or Password" );
			UserDetail tempUser=userDetailDao.getUser(userDetail.getLoginName());
			session.setAttribute("userDetail",tempUser);
			return new ResponseEntity<UserDetail>(tempUser, HttpStatus.OK);
		}
		else
			{ 
			return new ResponseEntity<UserDetail>(userDetail,HttpStatus.UNAUTHORIZED);
		}
	}
}
