<%@ page import="homework.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/3
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
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
        .img1{
            width: 50px;
            height: 50px;
            padding-left:10px;
            float: left;
        }
        .div2{
            position: fixed;
            left: 70px;
            top: 12px;
            font-size: 20px;
            font-family: "Adobe 黑体 Std R";

        }
        .img2{
            width: 600px;
            height: 400px;
            position: relative;

        }
        .div3{
            width: 400px;
            height: 500px;
            background-color: white;
            float: left;
            margin-top: 200px;



        }

        .div4{
            float: left;
            margin-left: 400px;
            margin-top: 200px;
            margin-right: 100px;
            margin-bottom: 400px;

        }


        .text{
            width: 360px;
            height: 50px;
            margin-left: 15px;
            margin-right: 20px;
            margin-top: 15px;
            margin-bottom: 15px;


        }
        .button{
            width: 360px;
            height: 50px;
            background-color: skyblue;
            margin-right: 20px;
            margin-left: 20px;
            margin-top: 10px;
            margin-bottom: 10px;
        }
        div1{
            margin-left: 20px;
            margin-right: 20px;
        }

        .div5{
            margin: 20px;
            float: right

        }

        a{
            text-decoration-line: none;
            color: cornflowerblue;

        }

    </style>
</head>
<body>


<div class="div1">
    <img src="img/kl.png" id="kl" class="img1">
    <div class="div2">某某
        <span style="font-size: 15px">登录</span>
    </div>

    <div class="div5">
        <a href="">某某首页</a>
        <span>|</span>
        <a href="">帮助与文档</a>
        <span id="timer"></span>
    </div>

</div>

<div class="div4">
    <img src="img/61746.jpg" id="61746" class="img2" >
</div>
<div class="div3">
    <form action="user" method="post">
        <input type="hidden" name="method" value="login">
        <div>
            <center><h2 style="color: dimgray ">某某登录</h2></center>
        </div>

        <input name = "uname" type="text" class="text" placeholder="请输入账号" id="inputUname"

               value="${cookie.uname.value}"
        >

        <input name = "password" type="password" class="text"  placeholder="登录密码" id="inputPassword"

               <c:if test="${!empty sessionScope.user}">
               value="${user.getPassword()}"
        </c:if>
                      >

        <span class="span" style="visibility: hidden">

        </span>
        <br>
        <br>
        <br>
        <br>

        <div1 style="float: left">
            <input type="checkbox" id="ty" name="chose" style="color-profile: cornflowerblue">
            <label for="ty">同意并遵守 <a href="">《服务条款》</a></label>
        </div1>
        <div1 style="float: right">
            <input type="checkbox" id="time" name="chose">
            <label for="time">15天免登录</label>
        </div1>

        <div>
            <input class="button" type="submit" value="登录" >
        </div>

        <div1 style="float: left">
            还没有账号? <a href="123_register.jsp">免费注册</a>
        </div1>

        <div1 style="float: right">
            <a href="">忘记密码?</a>
        </div1>



    </form>
</div>

</body>
<script type="text/javascript">
    $("#inputUname").focus(function () {
        $(this).css({"borderColor":"red","fontSize":"large"})
    }).blur(function () {
        $(this).css({"borderColor":"grey","fontSize":"small","borderWidth":"1px"})
    })

    $("#inputPassword").focus(function () {
        $(this).css({"borderColor":"red","fontSize":"large"})
    }).blur(function () {
        $(this).css({"borderColor":"grey","fontSize":"small","borderWidth":"1px"})
    })


</script>
</html>
