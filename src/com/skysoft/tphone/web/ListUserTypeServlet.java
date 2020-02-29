package com.skysoft.tphone.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.GsonBuilder;
import com.skysoft.tphone.entity.UserType;
import com.skysoft.tphone.service.UserTypeService;

@WebServlet("/list_usertype")
public class ListUserTypeServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserTypeService service = new UserTypeService();
		List<UserType> usertype = service.listUserType();
		String json = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(usertype);
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().println(json);
		System.out.println(json);
	}
	
	
	
	

}
