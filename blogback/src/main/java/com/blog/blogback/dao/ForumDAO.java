package com.blog.blogback.dao;

import java.util.List;

import com.blog.blogback.model.Forum;
import com.blog.blogback.model.ForumComment;

public interface ForumDAO {
	public boolean addForum(Forum forum);
	 public boolean updateForum(int forumId);
	 public boolean deleteForum(int forumId);
	 
	 public List<Forum> listForums(String username);
	 public boolean approvedForum(Forum forum);
	 public boolean rejectedForum(Forum forum);
	 public Forum getForum(int forumId);
	 public List<Forum> listAllForums();
	 public boolean incrementLike(Forum forum);
	 
	 public boolean addForumComment(ForumComment forumComment);
	 public boolean deleteForumComment(ForumComment forumComment);
	 public ForumComment getForumComment(int commentId);
	 public List<ForumComment> listForumComments(int ForumId);
}
