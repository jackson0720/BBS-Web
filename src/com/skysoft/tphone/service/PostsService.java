package com.skysoft.tphone.service;

import java.util.List;

import com.skysoft.tphone.dao.PostsDao;
import com.skysoft.tphone.entity.Comment;
import com.skysoft.tphone.entity.Posts;
import com.skysoft.tphone.exception.DaoException;
import com.skysoft.tphone.exception.UserException;
import com.skysoft.tphone.util.PageBean;
import com.skysoft.tphone.util.PageBean1;

public class PostsService {

	
	public String UpdateUserPointsByUid(String Uid) {
		PostsDao dao = new PostsDao();
		try {
			  String msg = dao.UpdateUserPointsByUid(Uid);
			  return msg;
		}catch(DaoException e) {
			e.getStackTrace();
			throw new UserException("SQL´íÎó£º"+e.getMessage());
		}
	}
	
	public void addView(String pid) {
		PostsDao dao = new PostsDao();
		try {
			  dao.addView(pid);
		}catch(DaoException e) {
			e.getStackTrace();
			throw new UserException("SQL´íÎó£º"+e.getMessage());
		}
	}
	
	
	public String InsertPosts(Posts posts) {
		PostsDao dao = new PostsDao();
		try {
			  String msg = dao.InsertPosts(posts);
			  return msg;
		}catch(DaoException e) {
			e.getStackTrace();
			throw new UserException("SQL´íÎó£º"+e.getMessage());
		}
	}
	
	public String ReportAuthorByPid(String id,String uid,String text,String date) {
		PostsDao dao = new PostsDao();
		try {
			  String msg = dao.ReportAuthorByPid(id, uid, text, date);
			  return msg;
		}catch(DaoException e) {
			e.getStackTrace();
			throw new UserException("SQL´íÎó£º"+e.getMessage());
		}
	}
	
	
	public List<String> CheckFocused(String uid) {
		PostsDao dao = new PostsDao();
		try {
			  List<String> msg = dao.CheckFocused(uid);
			  return msg;
		}catch(DaoException e) {
			e.getStackTrace();
			throw new UserException("SQL´íÎó£º"+e.getMessage());
		}
	}
	
	
	public String forfocus(String uid,String cid) {
		PostsDao dao = new PostsDao();
		try {
			  String msg = dao.forfocus(uid,cid);
			  return msg;
		}catch(DaoException e) {
			e.getStackTrace();
			throw new UserException("SQL´íÎó£º"+e.getMessage());
		}
	}
	
	public String forgood(String pid) {
		PostsDao dao = new PostsDao();
		try {
			  String msg = dao.forgood(pid);
			  return msg;
		}catch(DaoException e) {
			e.getStackTrace();
			throw new UserException("SQL´íÎó£º"+e.getMessage());
		}
	}
	
	
	public List<Posts> GetPostsByUid(String uid){
		PostsDao dao = new PostsDao();
		try {
			 return dao.GetPostsByUid(uid);
			
		}catch(DaoException e) {
			e.getStackTrace();
			throw new UserException("SQL´íÎó£º"+e.getMessage());
		}
	}
	
	
	public int FansCount(String uid) {
		PostsDao dao = new PostsDao();
		try {
			 return dao.FansCount(uid);
			
		}catch(DaoException e) {
			e.getStackTrace();
			throw new UserException("SQL´íÎó£º"+e.getMessage());
		}
	}
	
	public int PostsCount(String uid) {
		PostsDao dao = new PostsDao();
		try {
			 return dao.PostsCount(uid);
			
		}catch(DaoException e) {
			e.getStackTrace();
			throw new UserException("SQL´íÎó£º"+e.getMessage());
		}
	}
	
	public int GoodCount(String pid) {
		PostsDao dao = new PostsDao();
		try {
			 return dao.GoodCount(pid);
			
		}catch(DaoException e) {
			e.getStackTrace();
			throw new UserException("SQL´íÎó£º"+e.getMessage());
		}
	}
	
	public int commentcount(String pid)
	{
		PostsDao dao = new PostsDao();
		try {
			 return dao.commentcount(pid);
			
		}catch(DaoException e) {
			e.getStackTrace();
			throw new UserException("SQL´íÎó£º"+e.getMessage());
		}
	}
	
	
	public Posts viewPostByTheme(String pid)
	{
		PostsDao dao = new PostsDao();
		try {
			return dao.viewPostByTheme(pid);
		}catch(DaoException e) {
			e.getStackTrace();
			throw new UserException("SQLé”™è¯¯"+e.getMessage());
		}
	}
	
	public List<Posts> listTopThree(){
		PostsDao dao = new PostsDao();
		try {
			return dao.listTopThree();
		}catch(DaoException e) {
			e.getStackTrace();
			throw new UserException("SQL´íÎó£º"+e.getMessage());
		}
	}
	
	public PageBean<Posts> listPosts(int pageNum,int pageSize) {
		PostsDao dao = new PostsDao();
		try {
				int total = dao.count();
				PageBean<Posts> page = new PageBean<Posts>(pageNum,pageSize);
				page.setTotal(total);
				List<Posts> list = dao.listPosts(page);
				page.setList(list);
				return page;
			} catch (RuntimeException e) {
			e.printStackTrace();
			 throw new RuntimeException(e);
		}
	}
	
	
	public PageBean1<Posts> listPostss(int pageNum,int pageSize) {
		PostsDao dao = new PostsDao();
		try {
				int total = dao.count1();
				PageBean1<Posts> page = new PageBean1<Posts>(pageNum,pageSize);
				page.setTotal(total);
				List<Posts> list = dao.listPostss(page);
				page.setList(list);
				return page;
			} catch (DaoException e) {
			e.printStackTrace();
			 throw new UserException(e.getMessage());
		}
	}
	
	public List<Posts> listPostByName(String pname) {
		PostsDao dao = new PostsDao();
		try {
			return dao.listPostByName(pname);
		}catch(DaoException e) {
			e.getStackTrace();
			throw new UserException("SQLé”™è¯¯"+e.getMessage());
		}
	}
	
}
