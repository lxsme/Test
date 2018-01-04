<%@ page import="homework.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/2
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    </style>
  </head>
  <body>
  <%

    String referer = request.getHeader("Referer");
    if(referer ==null){

  %>

  <h1><a href="123_login.jsp" style="margin-left: 40%">请登录后浏览,点击此登录</a></h1>
  <%
  }else {


    User user = (User) session.getAttribute("user");
    if(user != null){

  %>



  <div class="div1">
    <img src="img/kl.png" id="kl" class="img1">
    <div class="div2">某某
      <span style="font-size: 15px">主页</span>
    </div>

    <div class="div5">

      <span>用户名:<span id="username">${user.getUname()}</span></span>
      <span>已登录</span>
      <a href="123_login.jsp" >退出登录</a>
      <%
      }else{
      %>
      <span><a href="123_login.jsp">请去登录</a></span>

      <%
        }
      %>
      <span>|</span>
      <a href="">帮助与文档</a>
      <span id="timer"></span>
    </div>

  </div>






<div id="div1">
  <table border="1" id="table1"></table>
</div>
  <div>
    <button id="returnBook">查看书籍</button>
  </div>

  <%
    }
  %>
  </body>
  <script type="text/javascript">

//     通过ajax显示登录用户信息
//      $.getJSON("http://localhost:8080/day29/showone",
//          function (json,status) {
//              if(status == "success"){
//
//                  $('#username').text(json['uname']);
//                  $('#password').text(json['password']);
//              }
//          })

    // 设置时间
    setInterval("timer.innerHTML=new Date().toLocaleString()");
    window.onload = function (){
        setInterval("timer.innerHTML=new Date().toLocaleString()",1000);
    }


          $('#returnBook').click(function () {


              $('#div1 button').remove();
              $('#table1 tr').remove();
              $.get("http://localhost:8080/day29/show",function (data,status) {
                  if(status == "success"){
                      var jsonData = $.parseJSON(data);

                      if(jsonData !=null){

                          $.each(jsonData,function (index,data) {

                              $('#div1').append($('<button>')
                                  .text(data['bname']).click(function () {
                                      $('#div1 button').remove();

                                      $('#div1>table').append($('<tr>').append(
                                          $('<th>').text("书名")
                                          ).append(
                                          $('<th>').text("作者")
                                          ).append(
                                          $('<th>').text("价格")
                                          )
                                      ).append($('<tr>').append(
                                          $('<td>').text(data['bname'])
                                          ).append(
                                          $('<td>').text(data['author'])
                                          ).append(
                                          $('<td>').text(data['price'])
                                          )
                                      )

                                  }))

                          })

                      }

                  }

              })

          })



  </script>
</html>
