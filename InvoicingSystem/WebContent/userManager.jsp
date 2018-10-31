<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>欢迎,${realName}<a href="">退出登录</a></div>
<br>
<br>
<div style="float:left;margin-right:10px ">

<a href="SaleServlet?action=addA">销售</a><br><br>
<a href="SaleServlet?action=chaxun">销售信息查询</a><br><br>
<a href="SaleServlet?action=queryStock">查看库存</a><br><br>

</div>
<!-- 显示a标签 -->
<div style="float:left;width:700px;height:300px;border:1px solid blue;margin:0 auto;text-align:center;">

<div style="margin-top:121px; "><h1>欢迎使用小型进销存系统</h1></div>

</div>
</body>
</html>