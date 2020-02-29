package com.skysoft.tphone.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.skysoft.tphone.entity.Posts;
import com.skysoft.tphone.service.PostsService;

@WebServlet("/add_posts")
public class AddPostsServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ptheme = req.getParameter("ptheme");
		String ptext = req.getParameter("ptext");
		String account = req.getParameter("account");
		String unick = req.getParameter("unick");
		String plate = req.getParameter("plate");
		Date dd=new Date();
		//∏Ò ΩªØ
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String time=sim.format(dd);
		Random random = new Random();
		int [] arr = new int[4];
        arr[0] = random.nextInt(10);
        arr[1] = random.nextInt(10);
        arr[2] = random.nextInt(10);
        arr[3] = random.nextInt(10);
		String id = time.replace("-", "")+arr[0]+arr[1]+arr[2]+arr[3];
		Posts posts = new Posts();
		posts.setP_id(id);
		posts.setP_theme(ptheme);
		posts.setP_time(dd);
		posts.setP_text(ptext);
		posts.setP_account(account);
		posts.setP_nick(unick);
		posts.setP_plate(plate);
		resp.setContentType("text/html;charset=utf-8");
		PostsService service = new PostsService();
		String i = service.InsertPosts(posts);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String json = gson.toJson(i);
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().print(json);
		System.out.println(json);
	}
	
	

}
