<%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/3
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
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

    <%!
        String uname = null;
        String passwordd = null;
    %>

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
    <form action="qs" method="post">
        <div>
            <center><h2 style="color: dimgray ">某某登录</h2></center>
        </div>

        <input name = "uname" type="text" class="text" placeholder="请输入账号"
               <%
                  if (session.getAttribute("uname") !=null){
            uname=session.getAttribute("uname").toString();

               %>value=<%=uname%>
                    <%
                   }
                    %>
                       onfocus="inputFocus(this)" onblur="inputBlur(this)">
        <input name = "password" type="password" class="text"  placeholder="登录密码" onfocus="inputFocus(this)"
               <%
                  if (session.getAttribute("password") !=null){

            passwordd=session.getAttribute("password").toString();

               %>value=<%=passwordd%>
                   <%
                   }
                    %>
                       onblur="inputBlur(this)" >

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
            还没有账号? <a href="123_register.html">免费注册</a>
        </div1>

        <div1 style="float: right">
            <a href="">忘记密码?</a>
        </div1>



    </form>
</div>

</body>
<script type="text/javascript">
    function inputFocus(ele) {
        ele.style.borderColor = "red";
        ele.style.fontSize = "large";
    }

    function inputBlur(ele) {
        ele.style.borderColor = "grey";
        ele.style.fontSize = "small";
        ele.style.borderWidth = "1px";


    }
    var arr = ["../img/61746.jpg","../img/456.jpg","../img/457.jpg"];
    setInterval("timer.innerHTML=new Date().toLocaleString()");
    window.onload = function (){
        setInterval("timer.innerHTML=new Date().toLocaleString()",1000);
    }





</script>
</html>
