<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'bookdesc.jsp' starting page</title>
    
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
	body {
		font-size: 10pt;
		background: rgb(254,238,189);
	}
	div {
		margin:20px;
		border: solid 2px gray;
		width: 150px;
		height: 150px;
		text-align: center;
	}
	li {
		margin: 10px;
	}
</style>
  </head>
  
  <body>
  <p style="font-weight: 900; color: red">${msg}</p>
  	<c:if test="${sessionScope.book !=null}">

		<div>
			<img src="<c:url value='/../../${sessionScope.book.image}'/>" border="0"/>
		</div>
		<form style="margin:20px;" id="form" method="post" action="/aBook?method=delBook&bid=${sessionScope.book.bid}">
			图书名称：<input type="text" name="bname" value="${sessionScope.book.bname}"/><br/>
			图书单价：<input type="text" name="price" value="${sessionScope.book.price}元"/><br/>
			图书作者：<input type="text" name="author" value="${sessionScope.book.author}"/><br/>
			图书分类：<select style="width: 150px; height: 20px;" name="cid">

			<c:forEach items="${categories}" var="categorie">
				<option value="">${categorie.cname}</option>
			</c:forEach>
		</select><br/>
			<input type="submit" id="subDel" name="method" value="del" onclick="{if(confirm('确定删除吗?')){this.document.formname.submit();return true;}return false;}" />
			<input type="submit" name="method" value="mod"/>
		</form>

	</c:if>




  </body>

</html>
