<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>首页</title>
    <!-- Bootstrap -->
    <link rel="stylesheet"
          href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="<%=path%>/js/Globals.js"></script>
    <script src="<%=path%>/js/index.js"></script>

    <style type="text/css">
        .carousel-inner > .item > a > img, .carousel-inner > .item > img, .img-responsive, .thumbnail a > img,
        .thumbnail > img {
            display: block;
            height: 300px;
            width: 1200px;
            max-width: 100%;
        }

        /* 为标题栏上的选项卡设置底部距离 */
        .tab-topic {
            margin-bottom: 3px;
        }
    </style>
</head>
<body class="myElement" data="/SSM-WEB">
<!-- 顶部导航栏 -->
<jsp:include page="../../public/nav-top.jsp"></jsp:include>


<div id="carousel-example-generic" class="carousel slide"
     data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <div class="carousel-caption">
                <p class="text-primary">
                    Spring+SpringMVC+mybatis整合实例
                </p>
            </div>
            <a href="<%=path%>/user/showUser/1">
                <img src="<%=path%>/img/spring.png" alt="">
            </a>
        </div>
        <div class="item">
            <img src="<%=path%>/img/ngix.gif" alt="...">
            <div class="carousel-caption">
                <p class="text-primary">
                    Ngix搭建实例
                </p>
            </div>
        </div>

    </div>
    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic"
       role="button" data-slide="prev"> <span
            class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
            class="sr-only">上一页</span> </a> <a class="right carousel-control"
                                               href="#carousel-example-generic" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">下一页</span> </a>
</div>

<hr/>
<!-- 栅格系统 平均分三列 -->
<div class="container" id="summary-container">

    <!-- 分割线暂时注释掉
    <hr class="divider"/> -->
    <div class="row">
        <div class="col-md-12">

            <div class="row">
                <div class="col-md-6">
                    <p>
                        <a class="btn btn-primary" href="<%=path%>/jsonp.jsp">JsonP</a>
                        <a class="btn btn-info" href="<%=path%>/redis/showRedis.jsp">redisDemo</a>
                        <a class="btn btn-danger" href="#">热门</a>
                    </p>
                </div>
                <div class="col-md-4 col-md-offset-2">
                    <p class="text-right">
                        <a class="btn btn-success" onclick="createTopic();" href="javascript:void(0)">发&nbsp;&nbsp;&nbsp;&nbsp;帖</a>
                        <input type="hidden" id="session_username" value="${user.username }"/>
                    </p>
                </div>
            </div>


            <div class="panel panel-info">

                <!-- 利用一个栅格系统向右偏移完成布局 -->
                <c:forEach var="u" items="${users }" varStatus="status">
                    <div class="panel-heading ">

                        <div class="row">
                            <div class="col-md-6">
                                <div class="row">
                                    <div class="col-md-12">
                                        <b>
                                            <a href="<%=path %>/user/showUser/${u.userId}">${u.username}</a>
                                        </b>
                                        <br/>
                                            ${u.description}
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4 col-md-offset-2">
                                <p class="text-muted text-right">
                                        ${u.password}
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="panel-footer">
                        <p class="text-right">
							<span class="label label-default">
							<span class="glyphicon glyphicon-comment" aria-hidden="true"></span>
							 ${u.password}
							</span>
                        </p>
                    </div>
                </c:forEach>
                <hr class="divider"/>
            </div>


        </div>
    </div>


    <!-- 分页 -->
    <nav class="text-right">
        <ul class="pagination pagination-sm">
            ${pageHtml}
        </ul>
    </nav>
    <!-- 分割线 -->
    <hr class="divider"/>
</div>


<!-- 弹出框 模态框关于 -->
<div class="modal fade" id="about" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">关于</h4>
            </div>
            <div class="modal-body">
                <p>
                    自由开发者crossoverJie
                </p>
                <address>
                    <a href="mailto:crossoverJie@gmail.com">crossoverJie@gmail.com</a>
                </address>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>


<!-- 弹出框 模态框关于 -->
<div class="modal fade" id="about" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">关于</h4>
            </div>
            <div class="modal-body">
                <p>
                    自由开发者crossoverJie
                </p>
                <address>
                    <a href="mailto:crossoverJie@gmail.com">crossoverJie@gmail.com</a>
                </address>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

<!-- 弹出框 模态框登录 -->
<div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel_login">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel_login">登录</h4>
            </div>
            <div class="modal-body">
                <form id="loginForm" method="post">
                    <div class="form-group">
                        <label for="exampleInputEmail1">用户名</label>
                        <input type="email" name="text" required="required" class="form-control" id="login-name"
                               placeholder="用户名">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">密码</label>
                        <input type="password" name="password" required="required" class="form-control"
                               id="login-password" placeholder="密码">
                    </div>
                    <div class="modal-footer">
                        <button type="button" onclick="login();" class="btn btn-primary">登录</button>
                        <button type="reset" class="btn btn-danger">重置</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- 弹出框 模态框注册 -->
<div class="modal fade" id="register" tabindex="-1" role="dialog" aria-labelledby="myModalLabel_register">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel_register">注册</h4>
            </div>
            <div class="modal-body">
                <form method="post" id="registerUserForm" action="<%=path%>/index/register">

                    <div class="form-group" id="div-username">
                        <label for="register-username">用户名</label>
                        <input type="text" name="username" class="form-control" id="register-username"
                               required="required"
                               min="1" maxlength="20" placeholder="用户名(1-20位中英文、数字。下划线)"/>
                    </div>
                    <div class="form-group" id="div-email">
                        <label for="register-email">邮箱</label>
                        <input type="email" name="email" required="required" class="form-control" id="register-email"
                               placeholder="邮箱">
                    </div>

                    <div class="form-group " id="div-password1">
                        <label for="exampleInputPassword1">密码</label>
                        <input type="password" required="required" class="form-control" id="password1" name="password"
                               min="6" maxlength="20" placeholder="密码(6-20位数字、英文)">
                    </div>
                    <div class="form-group" id="div-password2">
                        <label for="exampleInputPassword2">确认密码</label>
                        <input type="password" required="required" class="form-control" id="password2"
                               placeholder="确认密码">

                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary">注册</button>
                        <button type="reset" class="btn btn-danger">重置</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


<footer>
    <p class="text-center">© 2016 crossoverJie</p>
    <p class="text-center">
    </p>
</footer>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>