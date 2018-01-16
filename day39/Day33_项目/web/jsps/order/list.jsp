<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	* {
		font-size: 11pt;
	}
	div {
		border: solid 2px gray;
		width: 75px;
		height: 75px;
		text-align: center;
	}
	li {
		margin: 10px;
	}
	
	#buy {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -902px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
	#buy:HOVER {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -938px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
</style>
  </head>
  
  <body>
<h1>我的订单</h1>

<table border="1" width="100%" cellspacing="0" background="black">

	<c:if test="${sessionScope.myOrders !=null}">

	<c:forEach items="${sessionScope.myOrders}" var="myOrder">


		<tr bgcolor="gray" bordercolor="gray">

			<td colspan="6">

				订单编号：${myOrder.oid}　成交时间：${myOrder.ordertime}　金额：<font color="red"><b>${myOrder.total}</b></font>
				<c:if test="${myOrder.state == 0}">
				<a href="<c:url value='/order?method=load&oid=${myOrder.oid}'/>" target="body">付款</a>
				</c:if>
				<c:if test="${myOrder.state == 1}">
				<a href="/order?method=confirm&oid=${myOrder.oid}">确认收货</a>
					<c:if test="${myOrder.adminState==0}">
						未发货
					</c:if>
					<c:if test="${myOrder.adminState==1}">
						已发货
					</c:if>
				</c:if>
				<c:if test="${myOrder.state == 2}">
				订单结束
				</c:if>
			</td>
		</tr>
				<c:forEach items="${myOrder.allitems}" var="showItem">
		<tr bordercolor="gray" align="center">

			<td width="15%">
					<div><img src="<c:url value='/../../${showItem.book.image}'/>" height="75"/></div>

			</td>
			<td>书名：${showItem.book.bname}</td>
			<td>单价：${showItem.book.price}元</td>
			<td>作者：${showItem.book.author}</td>
			<td>数量：${showItem.count}</td>
			<td>小计：${showItem.book.price*showItem.count}</td>
		</tr>
			</c:forEach>

			</c:forEach>
	</c:if>


</table>
  </body>
</html>
