package com.skysoft.tphone.entity;

import java.util.Date;

public class UserInfo {
	
	private String u_uid;
	private String u_account;
	private String u_email;
	private String u_ip;
	private Integer u_state;
	private String u_nick;
	private String u_name;
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_account() {
		return u_account;
	}
	public void setU_account(String u_account) {
		this.u_account = u_account;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public String getU_ip() {
		return u_ip;
	}
	public void setU_ip(String u_ip) {
		this.u_ip = u_ip;
	}
	public Integer getU_state() {
		return u_state;
	}
	public void setU_state(Integer u_state) {
		this.u_state = u_state;
	}
	private Integer u_points;
	private Date u_birthday;
	private Integer u_code;
	private String u_codename;
	private String u_sex;
	private String u_idcard;
	private String u_dev;
	private Date u_regtime;
	private String u_pic;
	
	public String getU_pic() {
		return u_pic;
	}
	public void setU_pic(String u_pic) {
		this.u_pic = u_pic;
	}
	public String getU_uid() {
		return u_uid;
	}
	public void setU_uid(String u_uid) {
		this.u_uid = u_uid;
	}
	public String getU_nick() {
		return u_nick;
	}
	public void setU_nick(String u_nick) {
		this.u_nick = u_nick;
	}
	public Integer getU_points() {
		return u_points;
	}
	public void setU_points(Integer u_points) {
		this.u_points = u_points;
	}
	
	public Date getU_birthday() {
		return u_birthday;
	}
	
	public void setU_birthday(Date u_birthday) {
		this.u_birthday = u_birthday;
	}
	public Integer getU_code() {
		return u_code;
	}
	public void setU_code(Integer u_code) {
		this.u_code = u_code;
	}
	public String getU_codename() {
		return u_codename;
	}
	public void setU_codename(String u_codename) {
		this.u_codename = u_codename;
	}
	public String getU_sex() {
		return u_sex;
	}
	public void setU_sex(String u_sex) {
		this.u_sex = u_sex;
	}
	public String getU_idcard() {
		return u_idcard;
	}
	public void setU_idcard(String u_idcard) {
		this.u_idcard = u_idcard;
	}
	public String getU_dev() {
		return u_dev;
	}
	public void setU_dev(String u_dev) {
		this.u_dev = u_dev;
	}
	public Date getU_regtime() {
		return u_regtime;
	}
	public void setU_regtime(Date u_regtime) {
		this.u_regtime = u_regtime;
	}
	
	

}
