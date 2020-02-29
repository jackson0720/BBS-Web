package com.skysoft.tphone.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.skysoft.tphone.service.UserInfoService;

@WebServlet("/add_certifiation")
public class AddCertiServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String cardnumber = req.getParameter("cardnumber");
		String uid = req.getParameter("uid");
		resp.setContentType("text/html;charset=utf-8");
		UserInfoService service = new UserInfoService();
		String msg = service.UpdateCertiByUid(name, cardnumber, uid);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String json = gson.toJson(msg);
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().print(json);
	}
	
	

}
