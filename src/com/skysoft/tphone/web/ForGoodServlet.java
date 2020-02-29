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

@WebServlet("/forgood")
public class ForGoodServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("pid");
		resp.setContentType("text/html;charset=utf-8");
		PostsService service = new PostsService();
		String msg = service.forgood(id);
		if(msg == "添加成功"){
			msg = "文章太好看了！[]~(￣▽￣)~*给个赞！！！！";
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
