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
<body class="myElement">
<!-- 顶部导航栏 -->
<jsp:include page="public/nav-top.jsp"></jsp:include>


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
                <img src="<%=path%>/img/spring.png"  alt="">
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
        <div class="col-md-8">

            <div class="row">
                <div class="col-md-6">
                    <p>
                        <a class="btn btn-primary" href="#">全部</a>
                        <a class="btn btn-info" href="#">精华</a>
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
                <c:forEach var="ns" items="${news }" varStatus="status">

                    <div class="panel-heading ">

                        <!-- 利用一个栅格系统向右偏移完成布局 -->
                        <div class="row">
                            <div class="col-md-6">
                                <div class="row">
                                    <div class="col-md-2">
                                        <a href="<%=path %>/frontuser/${ns.user_id}">
                                            <img id="" src="
									<c:choose>
										<c:when test="${empty ns.user_head_img}">
											<%=path %>/include/img/person.gif
										</c:when>
										<c:otherwise>
											<%=path %>/${ns.user_head_img}
										</c:otherwise>
									</c:choose>
									" class="img-responsive center-block img-circle" alt="图片无效">
                                        </a>
                                    </div>
                                    <div class="col-md-10">
                                        <b>
                                            <a href="<%=path %>/topic/${ns.id}">${ns.title }</a>
                                        </b>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4 col-md-offset-2">
                                <!-- text-muted：字体颜色的样式 -->
                                <p class="text-muted text-right">${ns.dateStr }
                                </p>
                            </div>
                        </div>


                    </div>
                    <div class="panel-body">
                        <c:choose>
                            <c:when test="${empty ns.index_src}">
                            </c:when>
                            <c:otherwise>
                                <a href="<%=path %>/topic/${ns.id}" class="thumbnail">
                                    <img id="index-src" src="${ns.index_src}" alt="">
                                </a>
                            </c:otherwise>
                        </c:choose>
                            <%--内容暂时不显示  ${ns.content }... --%>
                    </div>
                    <div class="panel-footer">
                        <p class="text-right">
							<span class="label label-default">
							<span class="glyphicon glyphicon-comment" aria-hidden="true"></span>
							 ${ns.comment_count }
							</span>
                        </p>
                    </div>
                    <hr class="divider"/>

                </c:forEach>


            </div>


        </div>
        <div class="col-md-4">

            <div class="panel panel-primary">
                <div class="panel-heading">
                    热门帖子
                </div>
                <c:forEach var="com" items="${hotTopic }" varStatus="status">
                    <div class="panel-body">
                        <a href="<%=path%>/topic/${com.news_id}">${com.news_title }</a>
				    	<span class="label label-primary">
							<span class="glyphicon glyphicon-comment" aria-hidden="true"></span>
							 ${com.count_news }
						</span>
                    </div>
                </c:forEach>

            </div>

            <hr class="hr-right"/>

        </div>
    </div>


    <!-- 分页 -->
    <nav class="text-right">
        <ul class="pagination pagination-lg">
            <li class="
    	<c:if test="${currentpage == 1}">
			disabled
		</c:if>
    ">
                <a href="<%=path%>/index/turnToIndex/${currentpage -1}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li class="
    	<c:if test="${currentpage == 1}">
			active
		</c:if>
    "><a href="<%=path%>/index/turnToIndex/1">1</a></li>

            <li class="
    	<c:if test="${currentpage == 2}">
			active
		</c:if>
    "><a href="<%=path%>/index/turnToIndex/2">2</a></li>

            <li class="
    	<c:if test="${currentpage == 3}">
			active
		</c:if>
    "><a href="<%=path%>/index/turnToIndex/3">3</a></li>

            <li class="
    	<c:if test="${currentpage == 4}">
			active
		</c:if>
    "><a href="<%=path%>/index/turnToIndex/4">4</a></li>

            <li class="
    	<c:if test="${currentpage == 5}">
			active
		</c:if>
    "><a href="<%=path%>/index/turnToIndex/5">5</a></li>

            <li><a href="#">.....</a></li>

            <li>
                <a href="<%=path%>/index/turnToIndex/${currentpage +1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
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
                    <a href="mailto:crossoverJie@163.com">crossoverJie@163.com</a>
                </address>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
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