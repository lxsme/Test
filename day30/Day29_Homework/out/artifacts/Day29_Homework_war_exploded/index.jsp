<%--
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
  </head>
  <body>
  <%
    if(session.getAttribute("uname") != null){

  %>
  <p>已登录</p>
  <h3>用户名:<span id="username"></span></h3>
  <h3>密码:<span id="password"></span></h3>
  <%
  }else{
  %>
  <p><a href="123_login.jsp">请去登录</a></p>

  <%
    }
  %>


<div id="div1">
  <table border="1" id="table1"></table>
</div>
  <button id="returnBook">返回到图书名</button>
<a href="123_login.jsp">退出</a>
  </body>
  <script type="text/javascript">


      $.getJSON("http://localhost:8080/day29/showone",
          function (json,status) {
              if(status == "success"){

                  $('#username').text(json['uname']);
                  $('#password').text(json['password']);
              }
          })





          $('#div1 button').remove();
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


      $('#returnBook').click(function () {
          $('#table1 tr').remove();
          $.get("http://localhost:8080/day29/show",function (data,status) {
              if(status == "success"){
                  var jsonData = $.parseJSON(data);

                  if(jsonData !=null){

                      $.each(jsonData,function (index,data) {

                          $('#div1').append($('<button>')
                              .text(data['bname']))

                      })

                  }

              }

          })
      })


  </script>
</html>
