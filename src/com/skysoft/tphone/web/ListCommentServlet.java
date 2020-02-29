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
import com.skysoft.tphone.entity.Comment;
import com.skysoft.tphone.service.CommentService;

@WebServlet("/list_comment")
public class ListCommentServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("pid");
		resp.setContentType("text/html;charset=utf-8");
		CommentService service = new CommentService();
		List<Comment> comment = service.GetCommentByPid(id);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String json = gson.toJson(comment);
		//String json = new Gson().toJson(comment);
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().print(json);
		System.out.println(json);
	}
	
	

}
