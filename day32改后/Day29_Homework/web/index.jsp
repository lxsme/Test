<%@ page import="homework.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/2
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="js/jquery-3.2.1.min.js"></script>
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

      a{
        text-decoration-line: none;
        color: cornflowerblue;

      }
      button{
        width: 100px;
        height: 50px;
        background-color: cornflowerblue;
        margin: 15px;
      }


    </style>
  </head>
  <body>





  <div class="div1" >
    <img src="img/kl.png" id="kl" class="img1">
    <div class="div2">某某
      <span style="font-size: 15px">主页</span>
    </div>

    <div class="div5">
      <c:if test="${!empty sessionScope.user}" var="hasUser">
      <span>用户名:<span id="username">${user.getUname()}</span></span>
      <span>已登录</span>
      <a href="123_login.jsp" >退出登录</a>
      </c:if>
      <c:if test="${!hasUser}">

      <span><a href="123_login.jsp">请去登录</a></span>
      </c:if>

      <span>|</span>
      <a href="">帮助与文档</a>
      <span id="timer"></span>
    </div>

  </div>

  <div style="width:150px;height: 600px;background-color: #ede6ff;float: left ;border: #4e807d">

      <button id="returnBook">查看书籍</button>
      <button id="seebooks">查看书籍的所有信息</button>

  </div>

<div style="float: left;background-color: #cadbde;border: #4e807d"id="showScope">
  <div id="showAllBooksImg" style="display:none">
    <c:if test="${sessionScope.books !=null}">

        <c:forEach var="book1" items="${sessionScope.books}">

          <a href="http://localhost:8080/day29/showBook?bname=${book1.bname}&method=queryBookBybname"><img src="<c:url value="${book1.path}"/>" style="width: 120px;height: 180px;margin: 20px"></a>

        </c:forEach>


    </c:if>
  </div>
  <div style="display:none" id="showAllBookInformation">
    <c:if test="${sessionScope.books !=null}">
      <table border="1" style="margin: 50px">
        <tr>
          <th>书名</th>
          <th>作者</th>
          <th>价格</th>
        </tr>

      <c:forEach var="book" items="${sessionScope.books}">

        <tr>
          <td>${book.bname}</td>
          <td>${book.author}</td>
          <td>${book.price}</td>
        </tr>

      </c:forEach>

      </table>
    </c:if>



  </div>

</div>






  <%--<img src="<c:url value="img/shiLeYuan.jpg"/> ">--%>

<div id="div1">
  <table border="1" id="table1"></table>
</div>


  </body>
  <script type="text/javascript">

    // 设置时间
    setInterval("timer.innerHTML=new Date().toLocaleString()");
    window.onload = function (){
        setInterval("timer.innerHTML=new Date().toLocaleString()",1000);
    }


    $('#returnBook').click(function () {
        $("#showScope div").css({"display":"none"})
      $("#showAllBooksImg").css({"display":"block"})

})

    $('#seebooks').click(function () {
      $("#showScope div").css({"display":"none"})
        $("#showAllBookInformation").css({"display":"block"})

    })





  </script>
</html>
