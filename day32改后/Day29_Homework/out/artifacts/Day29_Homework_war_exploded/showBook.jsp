<%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/6
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>图书信息</title>
    <style type="text/css">
        body{
            background:grey;
            margin: 0;
        }
        .div1{
            height: 50px;
            background: white;

        }
        .div2{
            position: fixed;
            left: 70px;
            top: 12px;
            font-size: 20px;
            font-family: "Adobe 黑体 Std R";

        }
        .div5{
            margin: 20px;
            float: right

        }
        .img1{
            width: 50px;
            height: 50px;
            padding-left:10px;
            float: left;
        }



    </style>
</head>
<body>


<div class="div1">
    <img src="img/kl.png" id="kl" class="img1">
    <div class="div2">某某
        <span style="font-size: 15px">图书--${sessionScope.book.bname}--信息</span>
    </div>

    <div class="div5">
        <a href="http://localhost:8080/day29/index.jsp">某某首页</a>
        <span>|</span>
        <a href="">帮助与文档</a>
        <span id="timer"></span>
    </div>

</div>

<div style="float: left">
    <img src="<c:url value="${sessionScope.book.path}"/> " style="margin: 50px;width: 300px;height: 400px">
</div>


<div style="float: left;margin-top: 50px">
    <h1>书名:</h1><h2 style="margin-right: 10px">${sessionScope.book.bname}</h2>
   <h1>作者:</h1> <h2 style="margin-right: 10px">${sessionScope.book.author}</h2>
    <h1>价钱:</h1><h2 style="margin-right: 10px">${sessionScope.book.price}</h2>
</div>

</body>
</html>
