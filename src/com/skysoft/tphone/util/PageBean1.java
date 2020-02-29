package com.skysoft.tphone.util;

import java.util.List;

import com.skysoft.tphone.entity.Posts;

public class PageBean1<T> {
	private Integer pageNum;
	private Integer pageSize;
	private Integer total;
	private Integer pageCount;
	
	public PageBean1(Integer pageNum, Integer pageSize) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}
	
	
	private List<Posts> list;
	
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		pageNum = pageNum<=0?1:pageNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getPageCount() {
		this.pageCount = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
		return pageCount;
	}

	public Integer getPageRow() {
		 return  (pageNum-1)*pageSize+1;
	}
	public Integer getFectyRow() {
		return getPageRow()+pageSize-1;
	}
	public List<Posts> getList() {
		return list;
	}
	public void setList(List<Posts> list) {
		this.list = list;
	}
	
	
	
	
	
		
}
