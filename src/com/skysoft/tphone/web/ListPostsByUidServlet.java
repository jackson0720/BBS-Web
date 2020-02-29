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
import com.skysoft.tphone.entity.UserInfo;
import com.skysoft.tphone.service.PostsService;
import com.skysoft.tphone.service.UserInfoService;

@WebServlet("/listpostsbyuid")
public class ListPostsByUidServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		resp.setContentType("text/html;charset=utf-8");
		PostsService service = new PostsService();
		List<Posts> list = service.GetPostsByUid(uid);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String json = gson.toJson(list);
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().print(json);
		System.out.println(json);
	}
	
	

}
