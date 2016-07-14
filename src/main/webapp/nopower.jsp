<%@ page import="java.nio.file.Path" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh" class="no-js">

<head>

    <meta charset="utf-8">
    <title>没有权限</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- CSS -->
    <link href="${pageContext.request.contextPath }/css/nopower.css" rel="stylesheet" type="text/css" />


</head>

<body>
<div class="tail-left"></div>
<div id="main">
    <!-- header -->
    <div id="header">
        <h1>Nothing alive here!<span><strong>NO Power</strong> error - not found</span></h1>
    </div>
    <!-- content -->
    <div id="content">
        <ul class="nav">
            <li class="home"><a href="${pageContext.request.contextPath }/index">Home Page</a></li>
            <li class="site_map"><a href="#">Site Map</a></li>
            <li class="search"><a href="#">Website Search</a></li>
        </ul>
        <p>对不起，你没有权限访问此网页<br /> </p>
    </div>
    <!-- footer -->
    <div id="footer">
        Designed by TemplateMonster - all <a href="http://www.cssmoban.com" target="_blank">网页模板</a> found and safe!
    </div>
</div>

</body>

</html>
