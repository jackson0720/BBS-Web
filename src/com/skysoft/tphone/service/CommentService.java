package com.skysoft.tphone.service;

import java.util.List;

import com.skysoft.tphone.dao.CommentDao;
import com.skysoft.tphone.entity.Comment;
import com.skysoft.tphone.exception.DaoException;
import com.skysoft.tphone.exception.UserException;

public class CommentService {
	
	public String InsertComment(Comment comment) {
		CommentDao dao = new CommentDao();
		try {
			  String msg = dao.InsertComment(comment);
			  return msg;
		}catch(DaoException e) {
			e.getStackTrace();
			throw new UserException("SQL´íÎó£º"+e.getMessage());
		}
	}
	
	public List<Comment> GetCommentByPid(String pid){
		CommentDao dao = new CommentDao();
		try {
			 return dao.GetCommentByPid(pid);
		}catch(DaoException e) {
			e.getStackTrace();
			throw new UserException("SQL´íÎó£º"+e.getMessage());
		}
	}

}
