<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head data='${pageContext.request.contextPath}'>
    <base href="<%=basePath%>">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/club_list.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/Globals.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jqPaginator.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/club_list.js"></script>
</head>
<body data='${pageContext.request.contextPath}'>
<div class="title_box">
    <div class="title_txt">场馆登记</div>
    <div class="title_english">ASSIGN CLUB</div>
</div>
<div class="box">

    <div class="query_box">
        <div class="query_txt">场馆名称</div>
        <input type="text" id="name"/>
        <select name="authorization" id="authorization">
            <option value="0">全部</option>
            <option value="2">已授权</option>
            <option value="1">未授权</option>
        </select>
        <div class="query_but">查询</div>
        <div class="query_but go_register">登记</div>
    </div>
    <div class="explain_box">
        <div class="explain_link">场馆标识/名称</div>
        <div class="explain_link">是否授权</div>
        <div class="explain_link">老板账号</div>
        <div class="explain_link">场馆电话</div>
        <div class="explain_link">详细地址</div>
        <div class="explain_link product_operation">操作</div>
    </div>
    <div class="product_content">
    </div>
    <ul class="pagination" id="pagination"></ul>
    <div class="oper_box">共<span class="product_length_number"></span>个场馆</div>
</div>
</body>
</html>