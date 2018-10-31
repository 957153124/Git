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
			<h3>销售信息查询:</h3>
		</div>
		<div
			style="width: 200px; height: 28px; float: left; margin-top: 50px; margin-left: 356px;">
			<form action="SaleServlet">
				<input type="hidden" name="action" value="chaxun" /> 排序方式: <select
					name="Salequery">
					<option value="id">ID</option>
					<option value="price">单价</option>
					<option value="quantity">数量</option>
					<option value="totalPrice">总价</option>
					<option value="saleDate">销售日期</option>
				</select> <input type="submit" value="查询">
			</form>
		</div>

		<div style="height: 300px; width: 700px;">

			<Table border="2">

				<tr align="center">
					<Td style="width: 100px;">ID</Td>
					<Td style="width: 100px;">商品</Td>
					<Td style="width: 100px;">单价</Td>
					<Td style="width: 100px;">数量</Td>
					<Td style="width: 100px;">总价</Td>
					<Td style="width: 100px;">销售日期</Td>
					<Td style="width: 100px;">销售员</Td>
				</tr>


				<c:forEach items="${SaleList }" var="list">
					<tr align="center">
						<Td>${list.id }</Td>
						<Td>${list.productId }</Td>
						<Td>${list.price }</Td>
						<Td>${list.quantity }</Td>
						<Td>${list.totalPrice }</Td>
						<Td>${list.saleDate }</Td>
						<Td>${list.userId大家都在发 }</Td>
					</tr>
				</c:forEach>

				<Tr>
					<td align="center" colspan="7"><a href="SaleServlet">首页</a> <c:choose>
							<c:when test="${pages > 1 }">
								<a href="SaleServlet?action=chaxun&yeshu=shang&page=1">上一页</a>
							</c:when>
							<c:otherwise>
								<span>上一页</span>

							</c:otherwise>
						</c:choose> <c:choose>
							<c:when test="${totalPages > pages}">大家都在发
								<a href="SaleServlet?action=chaxun大家都在发
								&yeshu=xia&page=1">下一页</a>
							</c:when>
							<c:otherwise>
								<span>下一页</span>

							</c:otherwise>
						</c:choose> <a href="SaleServlet">尾页</a> <span>第${pages }页/共${totalPages }页(${record }条记录)</span>
					</td>
				</Tr>
			</Table>

		</div>

	</div>
</body>
</html>