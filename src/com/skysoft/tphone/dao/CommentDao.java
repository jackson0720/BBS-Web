package com.skysoft.tphone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skysoft.tphone.entity.Comment;
import com.skysoft.tphone.entity.Posts;
import com.skysoft.tphone.exception.DaoException;
import com.skysoft.tphone.exception.UserException;
import com.skysoft.tphone.util.ConnUtils;

public class CommentDao {
	
	public String InsertComment(Comment comment)
	{
		String sql = "insert into comment values(?,?,?,?,?)";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, comment.getC_cid());
				ps.setString(2, comment.getC_text());
				ps.setString(3, comment.getC_caccount());
				ps.setDate(4, new java.sql.Date(comment.getC_ctime().getTime()));
				ps.setInt(5, 0);
				int row = ps.executeUpdate();
				if(row == 0)
				{
					throw new UserException("服务器错误！");
				}
				return "发表成功";
			}catch(SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
	}
	
	
	public List<Comment> GetCommentByPid(String pid){
		
		String sql = "select * from comment c,[user] u,userinfo ui where c.c_caccount = u.u_account and u.u_uid = ui.u_uid and c.c_cid = ?";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, pid);
				try(ResultSet rs = ps.executeQuery()) {
					List<Comment> list = new ArrayList<Comment>();
					while(rs.next()) {
						Comment comment = new Comment();
						comment.setC_no(rs.getInt("c_no"));
						comment.setC_cid(rs.getString("c_cid"));
						comment.setC_text(rs.getString("c_text"));
						comment.setC_caccount(rs.getString("u_nick"));
						comment.setC_ctime(new java.sql.Date(rs.getDate("c_ctime").getTime()));
						comment.setC_state(rs.getInt("c_state"));
						list.add(comment);
					}
					return list;
					
			} catch (Exception e) {
				throw new DaoException("系统繁忙");
				}
		}catch(SQLException e) {
			throw new DaoException(e);
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println();
	}

}
