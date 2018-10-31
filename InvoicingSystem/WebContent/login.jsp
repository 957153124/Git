<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
body{
margin:0 auto;
text-align:center
}
</style>
<body > 
<div style="width:450px;height:270px;border:1px solid red;margin:0 auto;" align="center">
<h2>小型进销存系统</h2>
<form action="LoginServlet">
<table align="center">

<tr>

<td>用户名:</td>
<Td><input type="text" name="username"/></Td>

</tr>

<tr>

<td>密码:</td>
<Td><input type="password" name="password"/></Td>

</tr>

<tr>

<td></td>
<Td align="center"><input type="submit" value="提交"/></Td>

</tr>

</table>
</form>
</div>
</body>
</html>