package com.skysoft.tphone.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.skysoft.tphone.entity.Comment;
import com.skysoft.tphone.entity.User;
import com.skysoft.tphone.service.CommentService;
import com.skysoft.tphone.service.PostsService;

@WebServlet("/add_comment")
public class AddCommentServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String account = req.getParameter("uaccount");
		String pid = req.getParameter("pid");
		String cnt = req.getParameter("comment");
		Date date = new Date();
		Comment comment = new Comment();
		comment.setC_cid(pid);
		comment.setC_text(cnt);
		comment.setC_caccount(account);
		comment.setC_ctime(date);
		resp.setContentType("text/html;charset=utf-8");
		CommentService service = new CommentService();
		String i = service.InsertComment(comment);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String json = gson.toJson(i);
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().print(json);
		System.out.println(date);
		}
	}

