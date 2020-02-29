package com.skysoft.tphone.entity;

import java.util.Date;

public class Port {
	
	private String p_no;
	private String p_account;
	private String p_type;
	private String p_title;
	public String getP_title() {
		return p_title;
	}
	public void setP_title(String p_title) {
		this.p_title = p_title;
	}
	private String p_text;
	private Date p_time;
	private Integer p_success;
	public Integer getP_success() {
		return p_success;
	}
	public void setP_success(Integer p_success) {
		this.p_success = p_success;
	}
	private Integer p_state;
	
	
	public Integer getP_state() {
		return p_state;
	}
	public void setP_state(Integer p_state) {
		this.p_state = p_state;
	}
	public String getP_no() {
		return p_no;
	}
	public void setP_no(String p_no) {
		this.p_no = p_no;
	}
	public String getP_account() {
		return p_account;
	}
	public void setP_account(String p_account) {
		this.p_account = p_account;
	}
	public String getP_type() {
		return p_type;
	}
	public void setP_type(String p_type) {
		this.p_type = p_type;
	}
	public String getP_text() {
		return p_text;
	}
	public void setP_text(String p_text) {
		this.p_text = p_text;
	}
	public Date getP_time() {
		return p_time;
	}
	public void setP_time(Date p_time) {
		this.p_time = p_time;
	}
	
	

}
