<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书分类</title>
    
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
	.icon {
		margin:10px;
		border: solid 2px gray;
		width: 160px;
		height: 190px;
		text-align: center;
		float: left;
	}
</style>
  </head>
  
  <body>

  <c:if test="${sessionScope.bookList !=null}">

      <c:forEach items="${sessionScope.bookList}" var="book">

          <div class="icon">
              <c:if test="${fn:contains(book.image,'C:/Users/lanou/Desktop/pic')==true}">
                  <a href="<c:url value='/aBook?method=findBook&bid=${book.bid}'/>"><img src="<c:url value='${book.image}'/>" border="0"/></a>
              </c:if>
              <c:if test="${fn:contains(book.image,'C:/Users/lanou/Desktop/pic')==false}">
              <a href="<c:url value='/aBook?method=findBook&bid=${book.bid}'/>"><img src="<c:url value='/../../${book.image}'/>" border="0"/></a>
              </c:if>
              <br/>
              <a href="<c:url value='/aBook?method=findBook&bid=${book.bid}'/>">${book.bname}</a>
          </div>

      </c:forEach>
  </c:if>

  </body>
 
</html>

