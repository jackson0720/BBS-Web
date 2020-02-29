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
import com.skysoft.tphone.entity.Port;
import com.skysoft.tphone.service.PortService;

@WebServlet("/report_comment")
public class ReportComment extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.getParameter("operatorSign");
		Date dd = new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String time=sim.format(dd);
		Random random = new Random();
		int [] arr = new int[4];
        arr[0] = random.nextInt(10);
        arr[1] = random.nextInt(10);
        arr[2] = random.nextInt(10);
        arr[3] = random.nextInt(10);
		String no = time.replace("-", "")+arr[0]+arr[1]+arr[2]+arr[3];
		String account = req.getParameter("account");
		Port port = new Port();
		port.setP_no(no);
		port.setP_account(account);
		port.setP_type("评论投诉");
		port.setP_title("举报言论！");
		port.setP_text("举报"+account+"发表不正当言论");
		port.setP_time(dd);
		PortService service = new PortService();
		String msg = service.PortComment(port);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String json = gson.toJson(msg);
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().print(json);
	}

	
}
