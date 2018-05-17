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

import com.blog.blogback.dao.JobDAO;
import com.blog.blogback.dao.UserDetailDAO;
import com.blog.blogback.model.ErrorClazz;
import com.blog.blogback.model.Job;
import com.blog.blogback.model.UserDetail;

@Controller
public class JobController {
	@Autowired
	private JobDAO jobDao;
	@Autowired
	private UserDetailDAO userDetailDao;

	@RequestMapping(value="/addjob",method=RequestMethod.POST)
	public ResponseEntity<?> addJob(@RequestBody Job job,HttpSession session){
		System.out.println("in add job of job controller");
		String email=(String)session.getAttribute("currentuser");
		if(email==null){
			ErrorClazz error=new ErrorClazz(4,"UNAUTHORIZED ACCESS...");
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
		}
		UserDetail userDetail=userDetailDao.getUser(email);
		/*.equals("ADMIN")*/
		if(!userDetail.getRole().equals("ADMIN")){
			ErrorClazz error=new ErrorClazz(5,"Access Denied...");
					return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
		}
		try{
			job.setPostedon(new Date());
			jobDao.addJob(job);
			return new ResponseEntity<Job>(job,HttpStatus.OK);
		}
		catch(Exception e)
		{
			ErrorClazz error = new ErrorClazz(6,"Unable to post job details.." +e.getMessage());
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
		@RequestMapping(value="/alljobs",method=RequestMethod.GET)
		public ResponseEntity<?>getAllJobs( HttpSession session){
			String email=(String)session.getAttribute("currentuser");
			if(email==null){
				ErrorClazz error=new ErrorClazz(4,"UNAUTHORIZED ACCESS...");
				return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
			}
			List<Job>jobs=jobDao.getAllJobs();
			return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);
		}
		@RequestMapping(value="/getjob/{id}",method=RequestMethod.GET)
		public ResponseEntity<?> getJob(@PathVariable int id, HttpSession session){
			String email=(String)session.getAttribute("currentuser");
			if(email==null){
				ErrorClazz error=new ErrorClazz(4,"UNAUTHORIZED ACCESS...");
				return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
			}
			Job job= jobDao.getJob(id);
			return new ResponseEntity<Job>(job,HttpStatus.OK);
		}

}
