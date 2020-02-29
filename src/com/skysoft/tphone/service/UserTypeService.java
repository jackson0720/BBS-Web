package com.skysoft.tphone.service;

import java.util.List;

import com.skysoft.tphone.dao.UserTypeDao;
import com.skysoft.tphone.entity.UserType;
import com.skysoft.tphone.exception.DaoException;
import com.skysoft.tphone.exception.UserException;

public class UserTypeService {
	
	public List<UserType> listUserType()
	{
		UserTypeDao dao = new UserTypeDao();
		try {
			return dao.listUserType();
		}catch(DaoException e) {
			e.getStackTrace();
			throw new UserException("SQL´íÎó"+e.getMessage());
		}
	}
	

}
