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
import com.skysoft.tphone.service.UserService;
import com.skysoft.tphone.util.MailUtil;

@WebServlet("/checkmail")
public class CheckMailServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mail = req.getParameter("mail");
		UserService service = new UserService();
		HttpSession session =req.getSession();
		String oldmail =(String) session.getAttribute("mail");
		String msg = null;
		if(mail.equals(oldmail)) {
	        try {
	        	String pwd = service.GetUserPwdByUmail(mail);
	            MailUtil.sendActiveMail(mail, pwd);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			msg = "密码已发至你的密保邮箱，请注意查收并妥善保管！(邮件可能因网络因素而延迟，请等3-5分钟再查看邮箱！)";
		}else {
			msg = "密保邮箱验证不通过，请重试！";
		}
		resp.setContentType("text/html;charset=utf-8");
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String json = gson.toJson(msg);
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().print(json);
		System.out.println(json);
		
	}
	
}
