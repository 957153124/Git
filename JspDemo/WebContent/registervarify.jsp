<%@ page language="java" import="com.javaketang.dao.UserDao,com.javaketang.dao.impl.UserDaoImpl,com.javaketang.entity.User" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String name = request.getParameter("username");
    String pwd = request.getParameter("pwd");
    String newpwd = request.getParameter("newpwd");
    UserDao user = new UserDaoImpl();
    User u = new User();
    u.setUsername(name);
    u.setPassword(pwd);
 	if(null==name||null==pwd||"".equals(name)||"".equals(pwd)){
 		request.setAttribute("message","用户名或密码不能为空!!");
 		request.getRequestDispatcher("register.jsp").forward(request, response);
 	}else{
 		if(pwd.equals(newpwd)){
 		    if(user.register(u)){
 		    	request.setAttribute("message", "注册成功!");
 		    	request.getRequestDispatcher("login.jsp").forward(request, response);
 		    }else{
 		    	request.setAttribute("message", "注册失败!");
 		    	request.getRequestDispatcher("register.jsp").forward(request, response);
 		    }
 		    }else{
 		    	request.setAttribute("message", "两次输入密码不一致!");
 		    	request.getRequestDispatcher("register.jsp").forward(request, response);
 		    }
 	}
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>