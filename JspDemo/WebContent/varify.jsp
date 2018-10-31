<%@ page language="java" import="com.javaketang.dao.UserDao,com.javaketang.dao.impl.UserDaoImpl,com.javaketang.entity.User" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String name = request.getParameter("username");
    
    String pwd = request.getParameter("pwd");
    UserDao user = new UserDaoImpl();
    User u = new User();
    u.setPassword(pwd);
    u.setUsername(name);
    if(null==name||null==pwd||"".equals(name)||"".equals(pwd)){
    	request.setAttribute("message", "用户名或密码不能为空!!");
    	request.getRequestDispatcher("login.jsp").forward(request, response);
    }else{
    	if(user.Login(u)){
        	request.setAttribute("message", "登录成功!!");
        	request.getRequestDispatcher("user.jsp?username="+name).forward(request,response);
        }else{
        	request.setAttribute("message", "用户名或密码错误!!");
        	request.getRequestDispatcher("login.jsp").forward(request, response);
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