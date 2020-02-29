package com.skysoft.tphone.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.code.kaptcha.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.skysoft.tphone.entity.User;
import com.skysoft.tphone.exception.UserException;
import com.skysoft.tphone.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  	//先设置响应的类型以及编码
			response.setContentType("text/plain;charset=utf-8");
			//获取响应输出流，用于后面响应数据回客户端
			PrintWriter pw = response.getWriter();
			//通过request对象获取页面表单的数据
			String uname = request.getParameter("userName");
			String password = request.getParameter("password");
			String code = request.getParameter("code"); 
			//将用户名和密码传给业务层进行登陆的业务处理
			UserService service = new UserService();
			try {
				String sessionCode = (String)request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
				  if(!code.equals(sessionCode)) {
					  throw new UserException("验证码错误！");
				  }
				  
				//如果用户存在则登录成功跳转到主页，并把用户信息存到Session
				User user = service.Login(uname, password);
				HttpSession session = request.getSession();
				session.setAttribute("user", user); 
				
				//把Session里的用户信息取出来显示到页面上
				//User users =(User)session.getAttribute("user");
				//Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
				//String json = gson.toJson(users);
				//response.setContentType("application/json;charset=utf-8");
				//response.getWriter().print(json);
				
				response.sendRedirect("../tphone/page/index.html");
				
			}catch(UserException e) {
				//一旦产生异，常将封装好的异常信息输出到浏览器客户端
				pw.println(e.getMessage());
			}
	}
	
	

}
