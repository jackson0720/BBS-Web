package com.skysoft.tphone.service;

import java.util.List;

import com.skysoft.tphone.dao.CommentDao;
import com.skysoft.tphone.dao.PortDao;
import com.skysoft.tphone.entity.Port;
import com.skysoft.tphone.exception.DaoException;
import com.skysoft.tphone.exception.UserException;
import com.skysoft.tphone.util.PageBean2;

public class PortService {
	
	public String PortComment(Port port) {
		PortDao dao = new PortDao();
		try {
			  String msg = dao.PortComment(port);
			  return msg;
		}catch(DaoException e) {
			e.getStackTrace();
			throw new UserException("SQL´íÎó£º"+e.getMessage());
		}
	}
	
	public PageBean2<Port> listPort(int pageNum,int pageSize) {
		PortDao dao = new PortDao();
		try {
				int total = dao.count();
				PageBean2<Port> page = new PageBean2<Port>(pageNum,pageSize);
				page.setTotal(total);
				List<Port> list = dao.listPort(page);
				page.setList(list);
				return page;
			} catch (DaoException e) {
			e.printStackTrace();
			 throw new UserException(e.getMessage());
		}
	}

}
