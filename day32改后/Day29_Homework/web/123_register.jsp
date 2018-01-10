<%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/5
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script src="js/jquery-3.2.1.min.js"></script>
    <style type="text/css">
        body{
            background:grey;
            margin: 0;
        }
        .div1{
            margin-top: 0;
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
            font-size: 20px;
            font-family: "Adobe 黑体 Std R";

        }

        .div3{
            width: 80%;
            height:600px;
            margin-left: 200px;
            margin-right:200px;
            margin-top: 100px;
            background-color: white;
        }

        div{
            margin-bottom: 10px;
            margin-top: 20px;
        }
        .bottun{
            width: 400px;
            height:60px;
            background-color: cornflowerblue;
            margin-left: 70px;

        }
        .text{
            width: 400px;
            height: 60px;
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
        <span style="font-size: 15px">注册</span>
    </div>
</div>

<div class="div3">
    <br>
    <center ><h2 style="color: cornflowerblue;margin-left: 50px;margin-bottom: 10px" >邮箱号注册</h2>
        <hr style="width: 200px;margin-left: 700px">
        <br>

        <form action="user" method="post">
            <input type="hidden" name="method" value="register">
            <div style="margin-left: 120px">
                <label for="zh" style="margin-right: 10px">邮箱地址 </label>

                <input class="text" type="text" placeholder="请输入邮箱地址" id="zh" name="uname" onfocus="inputFocus()" onblur="inputBlur()" >
                <span id="mailReminder"style="visibility: hidden">请填写邮箱地址</span>

            </div>
            <div style="margin-left: 100px">
                <label for="password" style="margin-right: 10px">登录密码 </label>

                <input class="text" type="password" placeholder="请设置登录密码" id="password" name="password" >
                <span id="passwordReminder" style="visibility: hidden">密码不能为空</span>
            </div>

            <div>
                <input type="checkbox" id="ty">
                <label style="margin-right: 130px" for="ty">同意并遵守 <a href="">《服务条款》</a></label>
            </div>
            <div>
                <input type="submit" id="commit" value="下一步" class="bottun" >
            </div>
            <a href="123_login.jsp" style="margin-right: 230px">已注册,去登录</a>

        </form>
    </center>
</div>


</body>
<script type="text/javascript">

    $("#zh").focus(function () {
        $("#mailReminder").css({"color":"red","visibility":"visible"})
    }).blur(function () {
        $("#mailReminder").css({"visibility":"hidden"})
    })

    $("#password").focus(function () {
        $("#passwordReminder").css({"color":"red","visibility":"visible"})
    }).blur(function () {
        $("#passwordReminder").css({"visibility":"hidden"})
    })

    $("#commit").click(function () {
        $(this).css({"border":"dotted"})
    })


</script>
</html>
