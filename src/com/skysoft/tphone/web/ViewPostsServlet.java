package com.skysoft.tphone.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.skysoft.tphone.entity.Posts;
import com.skysoft.tphone.service.PostsService;

@WebServlet("/view_posts")
public class ViewPostsServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("pid");
		String account = req.getParameter("account");
		PostsService service = new PostsService();
		Posts posts = service.viewPostByTheme(id);
		service.addView(id);
		HttpSession session = req.getSession();
		session.setAttribute("posts",posts);
		session.setAttribute("id", id);
		session.setAttribute("account", account);
		resp.sendRedirect("page/personalposts.html");
	}
	
	

}
