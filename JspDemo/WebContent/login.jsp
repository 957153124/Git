<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<span style="color:Red;"><%=request.getAttribute("message")==null?"":request.getAttribute("message") %></span>
<form action="varify.jsp">
<table>
<tr>
<td>用户名:<input type="text" name="username" ></td>
</tr>

<tr>
<td>密码:<input type="password" name="pwd" ></td>
</tr>

<tr>
<td><input type="submit" value="提交" ></td>
</tr>
</table>
<a href="register.jsp">注册</a>
</form>
</body>
</html>