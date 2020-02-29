package com.skysoft.tphone.entity;

import java.util.Date;

public class Comment {

	private Integer c_no;
	private String c_cid;
	private String c_text;
	private String c_caccount;
	private Date c_ctime;
	private Integer c_state;
	public Integer getC_state() {
		return c_state;
	}
	public void setC_state(Integer c_state) {
		this.c_state = c_state;
	}
	public Integer getC_no() {
		return c_no;
	}
	public void setC_no(Integer c_no) {
		this.c_no = c_no;
	}
	public String getC_cid() {
		return c_cid;
	}
	public void setC_cid(String c_cid) {
		this.c_cid = c_cid;
	}
	public String getC_text() {
		return c_text;
	}
	public void setC_text(String c_text) {
		this.c_text = c_text;
	}
	public String getC_caccount() {
		return c_caccount;
	}
	public void setC_caccount(String c_caccount) {
		this.c_caccount = c_caccount;
	}
	public Date getC_ctime() {
		return c_ctime;
	}
	public void setC_ctime(Date c_ctime) {
		this.c_ctime = c_ctime;
	}
	
	
	
	
}
