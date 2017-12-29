<%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2017/12/28
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
   <script src="js/jquery-3.2.1.min.js"></script>
  </head>
  <body>


  <form action="doServlet" method="post">
    <label for="uname">用户名:</label>
    <input type="text" id="uname" name="uname"/>
    <label for="uid">用户id:</label>
    <input type="text" id="uid" name="uid"/>
    <label for="loc">所在地:</label>
    <input type="text" id="loc" name="loc"/>
    <label for="age">年龄:</label>
    <input type="text" id="age" name="age"/>
    <input type="submit"/>


  </form>
<button onclick="addTable()">查看所有信息</button>
  <table border="1">
  </table>
  </body>
<script type="text/javascript">
  function addTable() {
      $.get("http://localhost:8080/GetAll",function (data,status) {
          if(status == "success"){
              var jsonData = $.parseJSON(data);

              if(jsonData !=null){

                  $('table').append($('<tr>').append(
                      $('<th>').text("用户名")
                      ).append(
                      $('<th>').text("用户id")
                      ).append(
                      $('<th>').text("所在地")
                      ).append(
                      $('<th>').text("年龄")
                      )
                  )

                  $.each(jsonData,function (index,data) {

                      $('table').append($('<tr>').append(
                          $('<td>').text(data['uname'])
                          ).append(
                          $('<td>').text('uid')
                          ).append(
                          $('<td>').text('loc')
                          ).append(
                          $('<td>').text('age')
                          )
                      )
                  })






              }



          }



      })

  }



</script>
</html>
