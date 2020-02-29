package com.skysoft.tphone.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.skysoft.tphone.entity.Posts;
import com.skysoft.tphone.service.PostsService;
import com.skysoft.tphone.util.PageBean;

@WebServlet("/find_posts")
public class FindPostsServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		 String pname = req.getParameter("pname");
		 PostsService service = new PostsService();
		 List<Posts> list = service.listPostByName(pname);
		 String json = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(list);
		 resp.setContentType("application/json;charset=utf-8");
		 resp.getWriter().println(json);
		 System.out.println(json);
	}

	
	
}
