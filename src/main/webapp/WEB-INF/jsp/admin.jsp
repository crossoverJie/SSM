<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/7/14
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>后台</title>
</head>
<body>
<shiro:hasRole name="admin">
    这是admin角色登录：<shiro:principal></shiro:principal>
</shiro:hasRole>

<shiro:hasPermission name="user:create">
    有user:create权限信息
</shiro:hasPermission>
<br>
登录成功
</body>
</html>
