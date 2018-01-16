<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>left</title>
    <base target="body"/>
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
		*{
			font-size:10pt;
			text-align: center;
		}
		div {
			background: #87CEFA; 
			margin: 3px; 
			padding: 3px;
		}
		a {
			text-decoration: none;
		}
	</style>
	  <script src="/js/jquery-3.2.1.min.js"></script>
  </head>
  
  <body>
<div>
	<%--<a href="<c:url value='http://localhost:8080/book?method=findAll'/>">全部分类</a>--%>
	<a id="showall" href="/jsps/book/list.jsp}">全部分类</a>
</div>


<c:if test="${sessionScope.categories !=null}">

<c:forEach items="${sessionScope.categories}" var="cate">
<div>
<%--<a href="<c:url value='/book?method=findByCategory&cid=${cate.cid}'/>">${cate.cname}</a>--%>
<a href="<c:url value='/jsps/book/list.jsp?cid=${cate.cid}' />" id="${cate.cid}">${cate.cname}</a>
</div>
</c:forEach>


</c:if>




<%--<c:if test="${sessionScope.category !=null}">--%>

	<%--<c:forEach items="${sessionScope.category}" var="cate">--%>
		<%--<div>--%>
		<%--<a href="<c:url value='/book?method=findByCategory&cid=${cate.cid}'/>">${cate.cname}</a>--%>
		<%--</div>--%>
	<%--</c:forEach>--%>


<%--</c:if>--%>


  </body>
  <script type="text/javascript">
	  $('#showall').attr({"href":"/jsps/book/list.jsp"})


  </script>
</html>
