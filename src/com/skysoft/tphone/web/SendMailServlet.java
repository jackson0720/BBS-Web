package com.skysoft.tphone.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skysoft.tphone.util.MailUtil;


@WebServlet("/sendmail")
public class SendMailServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		String mailbox = req.getParameter("mail");
        try {
            MailUtil.sendActiveMail(mailbox, new java.util.Date().getTime()+"");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	

}
