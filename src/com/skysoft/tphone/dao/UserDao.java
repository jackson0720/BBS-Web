package com.skysoft.tphone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.skysoft.tphone.entity.User;
import com.skysoft.tphone.entity.UserInfo;
import com.skysoft.tphone.exception.UserException;
import com.skysoft.tphone.util.ConnUtils;

public class UserDao {
	
	public String GetUserPwdByUmail(String mail) {
		String sql = "select u_password from [user] where u_email = ?";
		String pwd = null;
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, mail);
			try(ResultSet rs = ps.executeQuery()) {
				if(rs.next()) {
					pwd = rs.getString(1);
				}
				return pwd;
			}catch(Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}
	
	public User GetUserMailBoxByUid(String uid) {
		String sql = "select u_email from [user] where u_account = ?";
		User users = null;
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, uid);
			try(ResultSet rs = ps.executeQuery()) {
				if(rs.next()) {
					users = new User();
					users.setU_email(rs.getString(1));
				}
			}catch(Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return users;
	}
	
	public User Login(String account,String pwd)
	{
		String sql = "select * from [user] where u_account =? and u_password = ?";
		User users = null;
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, account);
			ps.setString(2, pwd);
			try(ResultSet rs = ps.executeQuery()) {
				if(rs.next()) {
					users = new User();
					users.setU_uid(rs.getString(1));
					users.setU_account(rs.getString(2));
					users.setU_password(rs.getString(3));
					users.setU_email(rs.getString(4));
					users.setU_ip(rs.getString(5));
					users.setU_state(rs.getInt(6));
					users.setU_num(rs.getInt(7));
				}
			}catch(Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return users;
	}
	
	
	
	public void InsertUser(User user)
	{
		String sql = "insert into [user] values(?,?,?,?,?,?,?)";
		try(Connection conn = ConnUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, user.getU_uid());
			ps.setString(2, user.getU_account());
			ps.setString(3, user.getU_password());
			ps.setString(4, user.getU_email());
			ps.setString(5, user.getU_ip());
			ps.setInt(6, 0);
			ps.setInt(7, 0);
			int row = ps.executeUpdate();
			if(row == 0)
			{
				throw new UserException("·þÎñÆ÷´íÎó£¡");
			}
		}catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public UserInfo GetInfoByID(String uid)
	{
		String sql = "select * from [userinfo] ui,[usertype] ut where ui.u_code = ut.utype_code and ui.u_uid = ?";
		
		UserInfo userinfo = null;
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, uid);
			try(ResultSet rs = ps.executeQuery()) {
				if(rs.next()) {
					userinfo = new UserInfo();
					userinfo.setU_uid(rs.getString(1));
					userinfo.setU_nick(rs.getString(2));
					userinfo.setU_points(rs.getInt(3));
					userinfo.setU_birthday(rs.getDate(4));
					userinfo.setU_codename(rs.getString(11));
					userinfo.setU_sex(rs.getString(6));
					userinfo.setU_idcard(rs.getString(7));
					userinfo.setU_dev(rs.getString(8));
					userinfo.setU_regtime(rs.getDate(9));
				}
			}catch(Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return userinfo;
		
	}

}
