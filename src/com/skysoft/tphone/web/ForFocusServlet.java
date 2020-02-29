package com.skysoft.tphone.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.skysoft.tphone.entity.User;
import com.skysoft.tphone.service.PostsService;

@WebServlet("/forfocus")
public class ForFocusServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fid = req.getParameter("uid");
		String aid = req.getParameter("cid");
		resp.setContentType("text/html;charset=utf-8");
		PostsService service = new PostsService();
		String msg = service.forfocus(fid,aid);
		if(msg == "关注成功"){
			msg = "作者长得太帅了！[]~(￣▽￣)~*关注一波！";
		}
		else {
			msg = "服务器繁忙，请稍后再试！";
		}
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		String json = gson.toJson(msg);
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().print(json);
	}
	}
