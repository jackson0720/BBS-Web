package com.skysoft.tphone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skysoft.tphone.entity.Port;
import com.skysoft.tphone.exception.DaoException;
import com.skysoft.tphone.exception.UserException;
import com.skysoft.tphone.util.ConnUtils;
import com.skysoft.tphone.util.PageBean2;

public class PortDao {

	
	public String PortComment(Port port) {
		String sql = "insert into port(p_no,p_account,p_type,p_title,p_text,p_time) values(?,?,?,?,?,?)";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, port.getP_no());
				ps.setString(2, port.getP_account());
				ps.setString(3, port.getP_type());
				ps.setString(4, port.getP_title());
				ps.setString(5, port.getP_text());
				ps.setDate(6, new java.sql.Date(port.getP_time().getTime()));
				int row = ps.executeUpdate();
				if(row == 0)
				{
					throw new UserException("服务器错误！");
				}
				return "提交成功";
			}catch(SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		
	}
	
	
	public List<Port> listPort(PageBean2<Port> page){
		String sql = "select * from (select ROW_NUMBER() over(order by p_no) as rownum,* from port p) as temp where rownum between ? and ? and p_state = 0";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setInt(1,page.getPageRow());
				ps.setInt(2,page.getFectyRow());
				try(ResultSet rs = ps.executeQuery()) {
					List<Port> list = new ArrayList<Port>();
					while(rs.next()) {
						Port port = new Port();
						port.setP_no(rs.getString(2));
						port.setP_account(rs.getString(3));
						port.setP_type(rs.getString(4));
						port.setP_title(rs.getString(5));
						port.setP_text(rs.getString(6));
						port.setP_time(new java.sql.Date(rs.getDate(7).getTime()));
						port.setP_success(rs.getInt(8));
						port.setP_state(rs.getInt(9));
						list.add(port);
					}
					return list;
			} catch (Exception e) {
				throw new DaoException(e.getMessage());
				}
		}catch(SQLException e) {
			throw new DaoException(e);
		}
		
	}
	
	public int count() {
		String sql = "select count(*) from port";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
}
