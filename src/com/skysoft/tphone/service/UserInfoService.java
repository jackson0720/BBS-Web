package com.skysoft.tphone.service;

import com.skysoft.tphone.dao.UserInfoDao;
import com.skysoft.tphone.entity.UserInfo;
import com.skysoft.tphone.exception.DaoException;
import com.skysoft.tphone.exception.UserException;

public class UserInfoService {

	public String UpdateCertiByUid(String name,String idcard,String uid) {
		UserInfoDao dao = new UserInfoDao();
		try {
			String msg = dao.UpdateCertiByUid(name,idcard,uid);
			return msg;
		}catch(DaoException e) {
			e.getStackTrace();
			throw new UserException("SQL´íÎó£º"+e.getMessage());
		}
	}
	
	
	public void InsertUserInfoByUid(UserInfo uinfo) {
		UserInfoDao dao = new UserInfoDao();
		try {
			dao.InsertUserInfoByUid(uinfo);
		}catch(DaoException e) {
			e.getStackTrace();
			throw new UserException("SQL´íÎó£º"+e.getMessage());
		}
	}
	
	
	public Integer CheckUserInfoByUid(String uid) {
		UserInfoDao dao = new UserInfoDao();
		try {
			int count = dao.CheckUserInfoByUid(uid);
			return count;
		}catch(DaoException e) {
			e.getStackTrace();
			throw new UserException("SQL´íÎó£º"+e.getMessage());
		}
	}
	
	public UserInfo GetUserCertiByUid(String uid) {
		UserInfoDao dao = new UserInfoDao();
		try {
			UserInfo uinfo = dao.GetUserCertiByUid(uid);
			return uinfo;
		}catch(DaoException e) {
			e.getStackTrace();
			throw new UserException("SQL´íÎó£º"+e.getMessage());
		}
	}
	
	public UserInfo GetUserInfoByUid(String uid) {
		UserInfoDao dao = new UserInfoDao();
		try {
			return dao.GetUserInfoByUid(uid);
		}catch(DaoException e) {
			e.getStackTrace();
			throw new RuntimeException("SQL´íÎó£º"+e.getMessage());
		}
	}
	
	public UserInfo GetUserInfoByPid(String pid){
		UserInfoDao dao = new UserInfoDao();
		try {
			return dao.GetUserInfoByPid(pid);
		}catch(DaoException e) {
			e.getStackTrace();
			throw new UserException("SQL´íÎó£º"+e.getMessage());
		}
	}
	
}
