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
    <title>jsonp</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/supersized.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <script type="text/javascript">
        $(document).ready(function(){
            $.ajax({
                type: "get",
                async: false,
                url: "http://www.crossoverjie.top/SSM/jsonpInfo?callback=getUser&userId=3",
                dataType: "jsonp",
                jsonp: "callback",//一般默认为:callback
                jsonpCallback:"getUser",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名，也可以写"?"，jQuery会自动为你处理数据
                success: function(json){
                    /**
                     * 获得服务器返回的信息。
                     * 可以做具体的业务处理。
                     */
                    alert('用户信息：ID： ' + json.userId + ' ，姓名： ' + json.username + '。');
                },
                error: function(){
                    alert('fail');
                }
            });
        });
    </script>

</head>

<body oncontextmenu="return false">

</body>

</html>
