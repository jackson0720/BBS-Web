package com.skysoft.tphone.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.GsonBuilder;
import com.skysoft.tphone.entity.Port;
import com.skysoft.tphone.service.PortService;
import com.skysoft.tphone.util.PageBean2;

@WebServlet("/listport")
public class ListPortServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pageNum;
		int pageSize;
		PortService service = new PortService();
		try { 
			pageNum = Integer.parseInt(req.getParameter("pageNum"));
			pageSize = Integer.parseInt(req.getParameter("pageSize"));
		} catch (Exception e) {
			pageNum=1;
			pageSize=5;
		}
		PageBean2<Port>  pageBean = service.listPort(pageNum, pageSize);
		String json = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(pageBean);
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().println(json);
		System.out.println(json);
	}
	
	

}
