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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.skysoft.tphone.entity.User;
import com.skysoft.tphone.service.PostsService;

@WebServlet("/report_author")
public class ReportAuthorServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fid = req.getParameter("uid");
		String aid = req.getParameter("aid");
		Date dd=new Date();
		//格式化
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String time=sim.format(dd);
		Random random = new Random();
		int [] arr = new int[4];
        arr[0] = random.nextInt(10);
        arr[1] = random.nextInt(10);
        arr[2] = random.nextInt(10);
        arr[3] = random.nextInt(10);
		String id = time.replace("-", "")+arr[0]+arr[1]+arr[2]+arr[3];
		
		resp.setContentType("text/html;charset=utf-8");
		PostsService service = new PostsService();
		String msg = service.ReportAuthorByPid(id, aid, "举报用户账号为@"+fid, time);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String json = gson.toJson(msg);
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().print(json);
		System.out.println(aid);
	}
}

