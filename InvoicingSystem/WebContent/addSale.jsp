<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		欢迎,${realName}
		<a href="">退出登录</a>
	</div>
	<br>
	<br>
	<div style="float: left; margin-right: 10px">

		<a href="SaleServlet?action=addA">销售</a><br>
		<br> <a href="SaleServlet?action=chaxun">销售信息查询</a><br>
		<br> <a href="SaleServlet?action=queryStock">查看库存   </a>   <br>
		<br>

	</div>
	<!-- 显示a标签 -->
	<div
		style="float: left; width: 700px; height: 300px; border: 1px solid blue; margin: 0 auto; text-align: center;">

		<div style="margin-top: 30px;">
			<h3>添加销售:</h3>
			<form action="SaleServlet"> 
			<input type="hidden" name="action" value="add" />
			<table align="center">
				<tr>
					<td>商品名称</td>
					<td><select style="width: 160px; height: 23px;" name="commodity">
						<c:forEach items="${ProductList }" var="list" >
							<option value="${list.id}">${list.productName}</option>
						</c:forEach>
					</select></td>

				</tr>

				<tr>

					<td>销售单价:</td>
					<td><input type="text" name="SellingPrice" /></td>

				</tr>

				<tr>

					<td>销售数量:</td>
					<td><input type="text" name="SellingVolumes" /></td>

				</tr>

				<tr>

					<Td></Td>
					<Td><input type="submit" value="保存" /></Td>

				</tr>

			</table>
			</form>


		</div>

	</div>
</body>
</html>