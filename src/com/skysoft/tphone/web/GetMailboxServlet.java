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
import com.skysoft.tphone.entity.UserInfo;
import com.skysoft.tphone.service.UserInfoService;
import com.skysoft.tphone.service.UserService;

@WebServlet("/getmailbox")
public class GetMailboxServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String aid = req.getParameter("aid");
		resp.setContentType("text/html;charset=utf-8");
		UserService service = new UserService();
		User user = service.GetUserMailBoxByUid(aid);
		String mail = user.getU_email();
		String sult = mail.substring(9);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String json = gson.toJson("********"+sult);
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().print(json);
		HttpSession session = req.getSession();
		session.setAttribute("mail", mail); 
		System.out.println(json);
	}
	
	

}
