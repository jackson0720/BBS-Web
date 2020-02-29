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
import com.skysoft.tphone.service.PostsService;

@WebServlet("/checkfocused")
public class CheckFocusedServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		String aid = req.getParameter("aid");
		resp.setContentType("text/html;charset=utf-8");
		PostsService service = new PostsService();
		List<String> result = service.CheckFocused(aid);
		String msg = null;
		String sult = null;
		for(int i = 0 ; i < result.size() ; i++) {
			  sult = result.get(i);
		}
		if(sult == null)
		{
			msg = "Good";
		}
		else if(sult.equals(uid))
		{
			msg = "已经关注过啦！";
		}else
		{
			msg = "Good";
		}
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		String json = gson.toJson(msg);
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().print(json);
		System.out.println("返回出来的结果："+sult);
		System.out.println("已登录的账号："+aid);
		System.out.println("作者的账号："+uid);
	}
	
	

}
