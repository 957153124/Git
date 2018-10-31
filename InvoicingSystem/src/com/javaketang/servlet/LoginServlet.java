package com.javaketang.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.reflection.SystemMetaObject;

import com.javaketang.entity.User;
import com.javaketang.mybatis.Mybatis;

public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		String userNmae = req.getParameter("username");
		
		String password = req.getParameter("password");
		
		PrintWriter out = resp.getWriter();
		
		User user = new User();
		
		
		
		user.setUserName(userNmae);
		user.setPassword(password);
		
		User userA = Mybatis.login(user);
		
		
		System.out.println("IDaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa="+userA.getId());
		
		
		if(userA.getId()>0 ) {
			req.getSession().setAttribute("realName", userA.getRealName());
			req.getSession().setAttribute("userId", userA.getId());
			out.print("<script type='text/javascript'>alert('µÇÂ¼³É¹¦!');window.location.href='userManager.jsp';</script>");
		}else if(userA.getId()==0){
			out.print("<script type='text/javascript'>alert('µÇÂ¼Ê§°Ü!');window.location.href='login.jsp';</script>");
		}
		
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	


}
