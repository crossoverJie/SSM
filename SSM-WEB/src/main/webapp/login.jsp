<%@ page import="java.nio.file.Path" %>
<%--
  Created by IntelliJ IDEA.
  User: crossoverJie
  Date: 2016/7/14
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh" class="no-js">

<head>

    <meta charset="utf-8">
    <title>后台登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/supersized.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</head>

<body oncontextmenu="return false">

<div class="page-container">
    <input type="hidden" id="error" value="${error}"/>
    <h1>Login</h1>
    <form action="${pageContext.request.contextPath }/loginAdmin" method="post">
        <div>
            <input type="text" name="userName" class="username" placeholder="Username" autocomplete="off"/>
        </div>
        <div>
            <input type="password" name="password" class="password" placeholder="Password" oncontextmenu="return false"
                   onpaste="return false" />
        </div>
        <button id="submit" type="submit">Sign in</button>
    </form>
    <div class="connect">
        <p>You never know what you can do till you try.</p>
        <p style="margin-top:20px;">除非你亲自尝试一下,否则你永远不知道你能做什么。</p>
    </div>
</div>
<div class="alert" style="display:none">
    <h2>消息</h2>
    <div class="alert_con">
        <p id="ts"></p>
        <p style="line-height:70px"><a class="btn">确定</a></p>
    </div>
</div>

<!-- Javascript -->
<script src="http://apps.bdimg.com/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/supersized.3.2.7.min.js"></script>
<script src="${pageContext.request.contextPath }/js/supersized-init.js"></script>
<script>
    $(".btn").click(function(){
        is_hide();
    })
    var u = $("input[name=username]");
    var p = $("input[name=password]");
    $("#submit").live('click',function(){
        if(u.val() == '' || p.val() =='')
        {
            $("#ts").html("用户名或密码不能为空~");
            is_show();
            return false;
        }
        else{
            var reg = /^[0-9A-Za-z]+$/;
            if(!reg.exec(u.val()))
            {
                $("#ts").html("用户名错误");
                is_show();
                return false;
            }
        }
    });
    window.onload = function()
    {
        var error = $("#error").val() ;
        if(error != ""){
            $("#ts").html("用户名或密码错误！");
            is_show();
        }
        $(".connect p").eq(0).animate({"left":"0%"}, 600);
        $(".connect p").eq(1).animate({"left":"0%"}, 400);
    }
    function is_hide(){ $(".alert").animate({"top":"-40%"}, 300) }
    function is_show(){ $(".alert").show().animate({"top":"45%"}, 300) }
</script>
</body>

</html>
