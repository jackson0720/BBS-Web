package com.skysoft.tphone.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skysoft.tphone.entity.UserInfo;
import com.skysoft.tphone.exception.DaoException;
import com.skysoft.tphone.exception.UserException;
import com.skysoft.tphone.util.ConnUtils;

public class UserInfoDao {
	
	public String UpdateCertiByUid(String name,String idcard,String uid) {
		String sql = "update userinfo set u_name = ?,u_idcard = ? where u_uid = ?";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1,  name);
				ps.setString(2, idcard);
				ps.setString(3, uid);
				int row = ps.executeUpdate();
				if(row == 0)
				{
					throw new UserException("服务器错误！");
				}
				return "实名成功！";
			}catch(SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
	}
	
	public void InsertUserInfoByUid(UserInfo uinfo) {
		String sql = "insert into userinfo([u_uid],[u_nick],[u_birthday],[u_sex],[u_dev],[u_regtime]) values(?,?,?,?,?,?)";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1,  uinfo.getU_uid());
				ps.setString(2, uinfo.getU_nick());
				ps.setDate(3, new java.sql.Date(uinfo.getU_birthday().getTime()));
				ps.setString(4, uinfo.getU_sex());
				ps.setString(5, uinfo.getU_dev());
				ps.setDate(6, new java.sql.Date(uinfo.getU_regtime().getTime()));
				int row = ps.executeUpdate();
				if(row == 0)
				{
					throw new UserException("服务器错误！");
				}
			}catch(SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
	}
	
	public Integer CheckUserInfoByUid(String uid) {
		String sql = "select COUNT(*) as Count from userinfo where u_uid = ?";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, uid);
				try(ResultSet rs = ps.executeQuery()) {
					int count = 0;
					if(rs.next()) {
						count = rs.getInt(1);
					}
					return count;
			} catch (Exception e) {
				throw new DaoException("系统繁忙");
				}
		}catch(SQLException e) {
			throw new DaoException(e);
		}
	}
	
	
	public UserInfo GetUserCertiByUid(String uid) {
		String sql = "select u_name,u_idcard from userinfo where u_uid = ?";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, uid);
				try(ResultSet rs = ps.executeQuery()) {
					UserInfo uinfo = null;
					if(rs.next()) {
						uinfo = new UserInfo();
						uinfo.setU_name(rs.getString(1));
						uinfo.setU_idcard(rs.getString(2));
					}
					return uinfo;
			} catch (Exception e) {
				throw new DaoException("系统繁忙");
				}
		}catch(SQLException e) {
			throw new DaoException(e);
		}
	}
	
	public UserInfo GetUserInfoByUid(String uid) {
		String sql = "select * from  [user] u,userinfo ui,usertype ut where u.u_uid = ui.u_uid and ui.u_code = ut.utype_code and u.u_uid = ?";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, uid);
				try(ResultSet rs = ps.executeQuery()) {
					UserInfo uinfo = null;
					if(rs.next()) {
						uinfo = new UserInfo();
						uinfo.setU_uid(rs.getString(1));
						uinfo.setU_account(rs.getString(2));
						uinfo.setU_nick(rs.getString(9));
						uinfo.setU_points(rs.getInt(10));
						uinfo.setU_birthday(new java.sql.Date(rs.getDate(11).getTime()));
						uinfo.setU_code(rs.getInt(12));
						uinfo.setU_codename(rs.getString(19));
						uinfo.setU_sex(rs.getString(13));
						uinfo.setU_idcard(rs.getString(14));
						uinfo.setU_dev(rs.getString(16));
						uinfo.setU_regtime(new java.sql.Date(rs.getDate(17).getTime()));
						uinfo.setU_pic(rs.getString(18));
						uinfo.setU_email(rs.getString(4));
						uinfo.setU_ip(rs.getString(5));
					}
					return uinfo;
			} catch (Exception e) {
				throw new RuntimeException(e);
				}
		}catch(SQLException e) {
			throw new DaoException(e);
		}
	}
	
	
	public UserInfo GetUserInfoByPid(String pid){
		
		String sql = "select * from posts s,[user] u,userinfo ui where s.p_account = u.u_account and u.u_uid = ui.u_uid and p_id = ?";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, pid);
				try(ResultSet rs = ps.executeQuery()) {
					UserInfo uinfo = null;
					if(rs.next()) {
						uinfo = new UserInfo();
						uinfo.setU_uid(rs.getString(11));
						uinfo.setU_nick(rs.getString(5));
						uinfo.setU_regtime(new java.sql.Date(rs.getDate(27).getTime()));
						uinfo.setU_pic(rs.getString(28));
						uinfo.setU_sex(rs.getString(23));
					}
					return uinfo;
			} catch (Exception e) {
				throw new DaoException("系统繁忙");
				}
		}catch(SQLException e) {
			throw new DaoException(e);
		}
	}

}
