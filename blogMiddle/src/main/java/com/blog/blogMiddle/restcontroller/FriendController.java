package com.blog.blogMiddle.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.blogback.dao.FriendDAO;
import com.blog.blogback.dao.UserDetailDAO;
import com.blog.blogback.model.ErrorClazz;
import com.blog.blogback.model.Friend;
import com.blog.blogback.model.UserDetail;

@Controller
public class FriendController {
	@Autowired
	private FriendDAO friendDao;
	@Autowired
	private UserDetailDAO userDao;
	@RequestMapping(value="/suggestedusers",method=RequestMethod.GET)
	public ResponseEntity<?>suggestedUsers(HttpSession session){
		String email=(String)session.getAttribute("currentuser");
		if(email==null){
			ErrorClazz error=new ErrorClazz(5,"Unauthorised access....");
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
		}
		List<UserDetail>suggestedUsers=friendDao.suggestedUsers(email);
		return new ResponseEntity<List<UserDetail>>(suggestedUsers,HttpStatus.OK);
	}
	@RequestMapping(value="/addfriend",method=RequestMethod.POST)
	public ResponseEntity<?>addFriend(@RequestBody UserDetail toId,HttpSession session)
	{
		String email=(String)session.getAttribute("currentuser");
		if(email==null){
			ErrorClazz error=new ErrorClazz(5,"Unauthorised access....");
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
		}
		UserDetail fromId=userDao.getUser(email);
		Friend friend=new Friend();
		friend.setFromId(fromId);
		friend.setToId(toId);
		friend.setStatus('P');
		friendDao.addFriend(friend);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@RequestMapping(value="/pendingrequests",method=RequestMethod.GET)
	public ResponseEntity<?>pendingRequests(HttpSession session){
		String email=(String)session.getAttribute("currentuser");
		if(email==null){
			ErrorClazz error=new ErrorClazz(5,"Unauthorised access....");
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
		}
		List<Friend>pendingRequests=friendDao.pendingRequests(email);
		return new ResponseEntity<List<Friend>>(pendingRequests,HttpStatus.OK);
	}
	@RequestMapping(value="/acceptrequest",method=RequestMethod.PUT)
	public ResponseEntity<?>acceptRequest(@RequestBody Friend request,HttpSession session){
		String email=(String)session.getAttribute("currentuser");
		if(email==null){
			ErrorClazz error=new ErrorClazz(5,"Unauthorised access....");
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
		}
		friendDao.acceptRequest(request);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@RequestMapping(value="/deleterequest",method=RequestMethod.PUT)
	public ResponseEntity<?>deleteRequest(@RequestBody Friend request,HttpSession session){
		String email=(String)session.getAttribute("currentuser");
		if(email==null){
			ErrorClazz error=new ErrorClazz(5,"Unauthorised access....");
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
		}
		friendDao.deleteRequest(request);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@RequestMapping(value="/friends",method=RequestMethod.GET)
	public ResponseEntity<?>getAllFriends(HttpSession session)
	{
		String email=(String)session.getAttribute("currentuser");
		if(email==null){
			ErrorClazz error=new ErrorClazz(5,"Unauthorised access....");
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
		}
		List<Friend>friends=friendDao.listofFriends(email);
		return new ResponseEntity<List<Friend>>(friends,HttpStatus.OK);
	}
}
