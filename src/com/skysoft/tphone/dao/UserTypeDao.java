package com.skysoft.tphone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skysoft.tphone.entity.UserType;
import com.skysoft.tphone.util.ConnUtils;

public class UserTypeDao {
	
	public List<UserType> listUserType()
	{
		String sql = "select top 3* from usertype order by utype_code desc";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()){
			List<UserType> list = new ArrayList<>();
			while(rs.next()) {
				UserType usertype = new UserType();
				usertype.setUtype_code(rs.getInt(1));
				usertype.setUtype_name(rs.getString(2));
				usertype.setUtype_desc(rs.getString(3));
				usertype.setUtype_remark(rs.getString(4));
				list.add(usertype);
			}
			return list;
		}catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
