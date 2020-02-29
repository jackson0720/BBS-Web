package com.skysoft.tphone.web;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.skysoft.tphone.entity.UserInfo;
import com.skysoft.tphone.service.UserInfoService;
import com.skysoft.tphone.util.DateUtil;

@WebServlet("/check_user")
public class CheckUserInfoServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		String nick = req.getParameter("nick");
		String sex = req.getParameter("sex");
		String birthday = req.getParameter("birthday");
		String dev = req.getParameter("dev");
		UserInfo uinfo = new UserInfo();
		uinfo.setU_nick(nick);
		uinfo.setU_uid(uid);
		uinfo.setU_dev(dev);
		uinfo.setU_sex(sex);
		uinfo.setU_birthday(DateUtil.convert(birthday));
		uinfo.setU_regtime(new Date());
		resp.setContentType("text/html;charset=utf-8");
		UserInfoService service = new UserInfoService();
		int result = service.CheckUserInfoByUid(uid);
		String msg = null;
		if(result != 0)
		{
			
		}
		else
		{
			service.InsertUserInfoByUid(uinfo);
			msg = "Ìí¼Ó³É¹¦£¡";
		}
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		String json = gson.toJson(msg);
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().print(json);
	}
	
	

}
