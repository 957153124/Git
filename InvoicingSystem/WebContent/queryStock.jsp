<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		欢迎,${realName} <a href="">退出登录</a>
	</div>
	<br>
	<br>
	<div style="float: left; margin-right: 10px">

		<a href="SaleServlet?action=addA">销售</a><br> <br> <a
			href="SaleServlet?action=chaxun">销售信息查询</a><br> <br> <a
			href="SaleServlet?action=queryStock">查看库存 </a> <br> <br>

	</div>
	<!-- 显示a标签 -->
	<div
		style="float: left; width: 700px; height: 300px; border: 1px solid blue; margin: 0 auto;">

		<div style="width: 125px; height: 46px; margin-top: 30px; float: left">
			<h3>查看库存:</h3>
		</div>
		<div
			style="width: 288px; height: 28px; float: left; margin-top: 50px; margin-left: 269px;">
			<form action="SaleServlet">
			<input type="hidden" value="queryQuantity" name="action"/>
				商品名称: <select style="width: 160px; height: 23px;" name="commodity">
					<c:forEach items="${ProductList }" var="list">
						<option value="${list.id}" ${list.id==id?'selected':'' }>${list.productName}</option>
					</c:forEach>


				</select> <input type="submit" value="查询">
			</form>
		</div>

		<div style="height: 300px; width: 683px; text-align: center;margin-top:136px; ">

			<h1>${zifu }${quantity }</h1>

		</div>


	</div>

</body>
</html>