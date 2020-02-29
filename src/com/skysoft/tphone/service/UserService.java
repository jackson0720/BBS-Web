package com.skysoft.tphone.service;


import com.skysoft.tphone.dao.UserDao;
import com.skysoft.tphone.entity.User;
import com.skysoft.tphone.entity.UserInfo;
import com.skysoft.tphone.exception.DaoException;
import com.skysoft.tphone.exception.UserException;

public class UserService {
	
	public String GetUserPwdByUmail(String mail) {
		UserDao dao = new UserDao();
		try {
			String u = dao.GetUserPwdByUmail(mail);
			return u;
		}catch(DaoException e) {
			e.printStackTrace();
			throw new UserException("服务器繁忙");
		}
	}
	
	public User GetUserMailBoxByUid(String uid) {
		UserDao dao = new UserDao();
		try {
			User u = dao.GetUserMailBoxByUid(uid);
			return u;
		}catch(DaoException e) {
			e.printStackTrace();
			throw new UserException("服务器繁忙");
		}
	}
	
	public User Login(String account,String pwd)
	{
		UserDao dao = new UserDao();
		try {
			User u = dao.Login(account,pwd);
			
			if(u!=null) {
				return u;
			}
			else {
				throw new UserException("用户名不存在或密码错误");
			}
			
		}catch(DaoException e) {
			e.printStackTrace();
			throw new UserException("鐢ㄦ埛鍚嶆垨瀵嗙爜閿欒");
		}
	}
	
	public void InsertUser(User user)
	{
		UserDao dao = new UserDao();
		try {
			dao.InsertUser(user);
		}catch(DaoException e) {
			e.printStackTrace();
			throw new UserException(e.getMessage());
		}
	}
	
	public UserInfo GetInfoByID(String uid)
	{
		UserDao dao = new UserDao();
		try {
			UserInfo u = dao.GetInfoByID(uid);
			return u;
		}catch(DaoException e) {
			e.printStackTrace();
			throw new UserException("鐢ㄦ埛鍚嶆垨瀵嗙爜閿欒");
		}
	}

}
