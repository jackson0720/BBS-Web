package com.skysoft.tphone.dao;

import java.sql.Connection;
import java.sql.Date;
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
import com.skysoft.tphone.util.PageBean;
import com.skysoft.tphone.util.PageBean1;

public class PostsDao {
	
	
	public String UpdateUserPointsByUid(String Uid) {
		String sql = "update userinfo set u_points += 10 where u_uid = ?";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, Uid);
				int row = ps.executeUpdate();
				if(row == 0)
				{
					throw new UserException("服务器错误！");
				}
				return "积分+10";
			}catch(SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
	}
	
	
	public String ReportAuthorByPid(String id,String uid,String text,String date) {
		String sql = "insert into port values(?,?,'用户举报','用户举报',?,?,0,0)";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, id);
				ps.setString(2, uid);
				ps.setString(3, text);
				ps.setString(4, date);
				int row = ps.executeUpdate();
				if(row == 0)
				{
					throw new UserException("服务器错误！");
				}
				return "举报提交成功，我们将尽快处理！";
			}catch(SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
	}
	
	
	public List<String> CheckFocused(String uid) {
		String sql = "select top 10000f_focus from fans s where f_account = ?";
		try(Connection conn = ConnUtils.getConnection();
				  PreparedStatement ps = conn.prepareStatement(sql)){
				  ps.setString(1, uid);
				  List<String> str = new ArrayList<>();
				  try(ResultSet rs = ps.executeQuery()) {
					  while(rs.next()) {
						  String str1 = new String();
						  str1 = rs.getString("f_focus");
						  str.add(str1);
					  }
					  return str;
				  }catch(Exception e) {
					  throw new DaoException(e);
				  }
			}catch(Exception e) {
				throw new DaoException(e.getMessage());
			}
	}
	
	public String forfocus(String uid,String cid) {
		String sql = "insert into fans values(?,?)";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, uid);
				ps.setString(2, cid);
				int row = ps.executeUpdate();
				if(row == 0)
				{
					return "服务器繁忙";
				}
				return "关注成功";
			}catch(SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
	}
	
	
	public String forgood(String pid) {
		String sql = "update posts set p_good += 1 where p_id = ?";
		try(Connection conn = ConnUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, pid);
			int row = ps.executeUpdate();
			if(row == 0)
			{
				throw new UserException("服务器错误！");
			}
			return "添加成功";
		}catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public List<Posts> GetPostsByUid(String uid){
		String sql = "select * from posts s,userinfo ui,[user] u  where s.p_account = u_account and u.u_uid = ui.u_uid and u.u_uid = ?";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, uid);
				try(ResultSet rs = ps.executeQuery()) {
					List<Posts> list = new ArrayList<Posts>();
					while(rs.next()) {
						Posts posts = new Posts();
						posts.setP_id(rs.getString(1));
						posts.setP_theme(rs.getString(2));
						posts.setP_time(new java.sql.Date(rs.getDate(3).getTime()));
						posts.setP_account(rs.getString(4));
						posts.setP_nick(rs.getString(5));
						posts.setP_text(rs.getString(6));
						posts.setP_good(rs.getInt(7));
						posts.setP_view(rs.getInt(8));
						posts.setP_plate(rs.getString(12));
						posts.setP_state(rs.getInt(10));
						list.add(posts);
					}
					return list;
			} catch (Exception e) {
				throw new DaoException("系统繁忙");
				}
		}catch(SQLException e) {
			throw new DaoException(e);
		}
	}
	
	
	public int FansCount(String uid) {
		String sql = "select COUNT(f_account) as Count from fans where f_focus = ?";
		try(Connection conn = ConnUtils.getConnection();
				  PreparedStatement ps = conn.prepareStatement(sql)){
				  ps.setString(1, uid);
				  try(ResultSet rs = ps.executeQuery()) {
					  int i = 0;
					  if(rs.next()) {
						  i = rs.getInt("Count");
					  }
					  return i;
				  }catch(Exception e) {
					  throw new DaoException(e);
				  }
			}catch(Exception e) {
				throw new DaoException(e.getMessage());
			}
	}
	
	public int PostsCount(String uid)
	{
		String sql = "select COUNT(*) as Count from posts s,userinfo ui,[user] u  where s.p_account = u_account and u.u_uid = ui.u_uid and u.u_uid = ?";
		try(Connection conn = ConnUtils.getConnection();
				  PreparedStatement ps = conn.prepareStatement(sql)){
				  ps.setString(1, uid);
				  try(ResultSet rs = ps.executeQuery()) {
					  int i = 0;
					  if(rs.next()) {
						  i = rs.getInt("Count");
					  }
					  return i;
				  }catch(Exception e) {
					  throw new DaoException(e);
				  }
			}catch(Exception e) {
				throw new DaoException(e.getMessage());
			}
	}
	
	public int GoodCount(String pid) {
		String sql = "select p_good as Count from posts where  p_id = ?";
		try(Connection conn = ConnUtils.getConnection();
				  PreparedStatement ps = conn.prepareStatement(sql)){
				  ps.setString(1, pid);
				  try(ResultSet rs = ps.executeQuery()) {
					  int i = 0;
					  if(rs.next()) {
						  i = rs.getInt("Count");
					  }
					  return i;
				  }catch(Exception e) {
					  throw new DaoException(e);
				  }
			}catch(Exception e) {
				throw new DaoException(e.getMessage());
			}
	}
	
	public int commentcount(String pid) {
		String sql = "select count(*) as Count from comment ct,posts s where ct.c_cid = s.p_id and s.p_id = ?";
		try(Connection conn = ConnUtils.getConnection();
				  PreparedStatement ps = conn.prepareStatement(sql)){
				  ps.setString(1, pid);
				  try(ResultSet rs = ps.executeQuery()) {
					  int i = 0;
					  if(rs.next()) {
						  i = rs.getInt("Count");
					  }
					  return i;
				  }catch(Exception e) {
					  throw new DaoException(e);
				  }
			}catch(Exception e) {
				throw new DaoException(e.getMessage());
			}
	}
	
	public Posts viewPostByTheme(String pid){
		String sql = "select * from Posts ps,Plate pt where ps.p_plate = pt.p_no and ps.p_id = ?";
		try(Connection conn = ConnUtils.getConnection();
			  PreparedStatement ps = conn.prepareStatement(sql)){
			  ps.setString(1, pid);
			  try(ResultSet rs = ps.executeQuery()) {
				  Posts p =null;
				  if(rs.next()) {
					  p = new Posts();
					  p.setP_id(rs.getString(1));
					  p.setP_theme(rs.getString(2));
				      p.setP_time(rs.getDate(3));
					  p.setP_account(rs.getString(4));
					  p.setP_nick(rs.getString(5));
					  p.setP_text(rs.getString(6));
				      p.setP_good(rs.getInt(7));
				      p.setP_view(rs.getInt(8));
					  p.setP_plate(rs.getString(12));
					  p.setP_state(rs.getInt(10));
					  
				  }
				  return p;
			  }catch(Exception e) {
				  throw new DaoException(e);
			  }
		}catch(Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	
	
	public List<Posts> listTopThree()
	{
		String sql = "select top 3* from posts ps,plate pl where ps.p_plate = pl.p_no order by ps.p_good desc";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
				try(ResultSet rs = ps.executeQuery()) {
					List<Posts> list = new ArrayList<Posts>();
					while(rs.next()) {
						Posts posts = new Posts();
						posts.setP_id(rs.getString(1));
						posts.setP_theme(rs.getString(2));
						posts.setP_time(new java.sql.Date(rs.getDate(3).getTime()));
						posts.setP_account(rs.getString(4));
						posts.setP_nick(rs.getString(5));
						posts.setP_text(rs.getString(6));
						posts.setP_good(rs.getInt(7));
						posts.setP_view(rs.getInt(8));
						posts.setP_plate(rs.getString(12));
						posts.setP_state(rs.getInt(10));
						list.add(posts);
					}
					return list;
			} catch (Exception e) {
				throw new DaoException("系统繁忙");
				}
		}catch(SQLException e) {
			throw new DaoException(e);
		}
	}
	
	
	public List<Posts> listPostss(PageBean1<Posts> page){
		String sql = "select * from (select Row_Number() over (order by p_id) as rownum,p_no,p_theme,p_account,p_time,p_nick,p_text,p_good,p_view,p_plate,ps.p_name,p_id from posts s,plate ps where s.p_plate = ps.p_no and s.p_state = 0 and ps.p_no = 'PL001') b where rownum between ? and ? order by p_time desc";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setInt(1,page.getPageRow());
				ps.setInt(2,page.getFectyRow());
				try(ResultSet rs = ps.executeQuery()) {
					List<Posts> list = new ArrayList<Posts>();
					while(rs.next()) {
						Posts posts = new Posts();
						posts.setP_id(rs.getString(12));
						posts.setP_theme(rs.getString(3));
						posts.setP_time(new java.sql.Date(rs.getDate(5).getTime()));
						posts.setP_account(rs.getString(4));
						posts.setP_nick(rs.getString(6));
						posts.setP_text(rs.getString(7));
						posts.setP_good(rs.getInt(8));
						posts.setP_view(rs.getInt(9));
						posts.setP_plate(rs.getString(11));
						list.add(posts);
					}
					return list;
			} catch (Exception e) {
				throw new DaoException("系统繁忙");
				}
		}catch(SQLException e) {
			throw new DaoException(e);
		}
		
	}
	
	public List<Posts> listPosts(PageBean<Posts> page)
	{
		String sql = "select * from (select Row_Number() over (order by p_id) as rownum,p_no,p_theme,p_account,p_time,p_nick,p_text,p_good,p_view,p_plate,ps.p_name,p_id from posts s,plate ps where s.p_plate = ps.p_no and s.p_state = 0) b where rownum between ? and ? order by p_time desc";
		
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setInt(1,page.getPageRow());
				ps.setInt(2,page.getFectyRow());
				try(ResultSet rs = ps.executeQuery()) {
					List<Posts> list = new ArrayList<Posts>();
					while(rs.next()) {
						Posts posts = new Posts();
						posts.setP_id(rs.getString(12));
						posts.setP_theme(rs.getString(3));
						posts.setP_time(new java.sql.Date(rs.getDate(5).getTime()));
						posts.setP_account(rs.getString(4));
						posts.setP_nick(rs.getString(6));
						posts.setP_text(rs.getString(7));
						posts.setP_good(rs.getInt(8));
						posts.setP_view(rs.getInt(9));
						posts.setP_plate(rs.getString(11));
						list.add(posts);
					}
					return list;
			} catch (Exception e) {
				throw new DaoException("系统繁忙");
				}
		}catch(SQLException e) {
			throw new DaoException(e);
		}
		
		
	}
	
	public int count() {
		String sql = "select count(*) from posts";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public int count1() {
		String sql = "select count(*) from posts";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public List<Posts> listPostByName(String pname){
		String sql = "select * from Posts ps,Plate pt where ps.p_plate = pt.p_no and pt.p_name = ?";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, pname);
				try(ResultSet rs = ps.executeQuery()) {
					List<Posts> list = new ArrayList<Posts>();
					while(rs.next()) {
						Posts posts = new Posts();
						posts.setP_id(rs.getString(1));
						posts.setP_theme(rs.getString(2));
						posts.setP_time(new java.sql.Date(rs.getDate(3).getTime()));
						posts.setP_account(rs.getString(4));
						posts.setP_nick(rs.getString(5));
						posts.setP_text(rs.getString(6));
						posts.setP_good(rs.getInt(7));
						posts.setP_view(rs.getInt(8));
						posts.setP_plate(rs.getString(12));
						posts.setP_state(rs.getInt(10));
						list.add(posts);
					}
					return list;
			} catch (Exception e) {
				throw new DaoException("系统繁忙");
				}
		}catch(SQLException e) {
			throw new DaoException(e);
		}
		
	}
	
	public void addView(String pid) {
		String sql = "update posts set p_view+=1 where p_id = ?";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1,pid);
				int row = ps.executeUpdate();
				if(row == 0)
				{
					throw new UserException("服务器错误！");
				}
			}catch(SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
	}
	
	public String InsertPosts(Posts posts) {
		String sql = "insert into posts([p_id],[p_theme],[p_time],[p_account],[p_nick],[p_text],[p_plate]) values(?,?,?,?,?,?,?)";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, posts.getP_id());
				ps.setString(2, posts.getP_theme());
				ps.setDate(3, new java.sql.Date(posts.getP_time().getTime()));
				ps.setString(4, posts.getP_account());
				ps.setString(5, posts.getP_nick());
				ps.setString(6, posts.getP_text());
				ps.setString(7, posts.getP_plate());
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
	

}
