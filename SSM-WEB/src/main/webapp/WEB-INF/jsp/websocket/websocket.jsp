<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">
    <!-- Bootstrap -->
    <link rel="stylesheet"
          href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript" charset="utf-8" src="<%=path%>/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=path%>/ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="<%=path%>/ueditor/lang/zh-cn/zh-cn.js"></script>

    <title>聊天室</title>
</head>

<body data="/SSM-WEB">
<input id="text" type="text"/>
<button onclick="send()">发送</button>
<button onclick="closeWebSocket()">关闭连接</button>
<div id="message">
</div>


<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-primary">
                <div class="panel-heading">聊天室</div>
                <div id="msg" class="panel-body">

                </div>
                <div class="panel-footer">
                    在线人数<span id="onlineCount">1</span>人
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <script id="editor" type="text/plain" style="width:1024px;height:200px;"></script>
        </div>
    </div>

</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <p class="text-right">
            <button onclick="sendMsg();" class="btn btn-success">发送</button>
            </p>
        </div>
    </div>

</div>

</body>

<script type="text/javascript">
    var ue = UE.getEditor('editor');
    var websocket = null;

    //判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://192.168.0.102:8080/ssm/websocket");
    }
    else {
        alert("对不起！你的浏览器不支持webSocket")
    }

    //连接发生错误的回调方法
    websocket.onerror = function () {
        setMessageInnerHTML("error");
    };

    //连接成功建立的回调方法
    websocket.onopen = function (event) {
        setMessageInnerHTML("加入连接");
    };

    //接收到消息的回调方法
    websocket.onmessage = function (event) {
        setMessageInnerHTML(event.data);
    };

    //连接关闭的回调方法
    websocket.onclose = function () {
        setMessageInnerHTML("断开连接");
    };

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，
    // 防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function () {
        var is = confirm("确定关闭窗口？");
        if (is){
            websocket.close();
        }
    };

    //将消息显示在网页上
    function setMessageInnerHTML(innerHTML) {
        $("#msg").append(innerHTML+"<br/>")
    };

    //关闭连接
    function closeWebSocket() {
        websocket.close();
    }

    //发送消息
    function send() {
        var message = $("#text").val() ;
        websocket.send(message);
        $("#text").val("") ;
    }

    function sendMsg(){
        var msg = ue.getContent();
        websocket.send(msg);
        ue.setContent('');
    }
</script>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/Globals.js"></script>
<script type="text/javascript" src="<%=path%>/js/websocket.js"></script>
</html>
