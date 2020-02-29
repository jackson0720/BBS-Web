package com.skysoft.tphone.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.GsonBuilder;
import com.skysoft.tphone.entity.Posts;
import com.skysoft.tphone.service.PostsService;
import com.skysoft.tphone.util.PageBean;

@WebServlet("/list_postss")
public class ListPostssServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pageNum;
		int pageSize;
		PostsService service = new PostsService();
		try { 
			pageNum = Integer.parseInt(req.getParameter("pageNum"));
			pageSize = Integer.parseInt(req.getParameter("pageSize"));
		} catch (Exception e) {
			pageNum=1;
			pageSize=5;
		}
		
		PageBean<Posts>  pageBean = service.listPosts(pageNum, pageSize);
		String json = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(pageBean);
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().println(json);
		System.out.println(json);
	}
	
	

}
