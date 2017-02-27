var page = 1,
    rows = 10;
$(document).ready(function () {
    initJqPaginator();
    //加载
    load_redis_list();
    $(".query_but").click(function () {//查询按钮
        page = 1;
        load_redis_list();
    });
});
//初始化分页
function initJqPaginator() {
    $.jqPaginator('#pagination', {
        totalPages: 100,
        visiblePages: 10,
        currentPage: 1,
        first: '<li class="prev"><a href="javascript:;">首页</a></li>',
        last: '<li class="prev"><a href="javascript:;">末页</a></li>',
        prev: '<li class="prev"><a href="javascript:;">上一页</a></li>',
        next: '<li class="next"><a href="javascript:;">下一页</a></li>',
        page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
        onPageChange: function (num, type) {
            page = num;
            if (type == "change") {
                load_redis_list();
            }
        }
    });
}
//列表
function create_club_list(redisContens) {
    var phone = 0;
    var html = '<div class="product_box">'
        + '<div class="br">'
        + '<div class="product_link">'
        + '<div class="product_phc">'
        + '<img class="phc" src="" >'
        + '</div>'
        + '<span class="product_name">' + redisContens.id + '</span></div>'
        + '<div class="product_link toto">' + redisContens.content + '</div>'
        + '<div class="product_link toto">'
        + '<span>' + "" + '</span>'
        + '</div>'
        + '<div class="product_link toto">'
        + '<span>' + phone + '</span></div>'
        + '<div class="product_link toto">'
        + '<span>' + 0 + '</span></div>'
        + '<div class="product_link toto product_operation">'
        + '<span onclick="edit_club(' + 0 + ')">编辑</span>'
        + '<span onclick="edit_del(' + 0 + ')">删除</span></div></div>'
        + '</div>';
    return html;
}
//加载列表
function load_redis_list() {
    var name = $("#name").val();
    $.ajax({
        type: 'POST',
        url: getPath() + '/redis/redis_list',
        async: false,
        data: {name: name, page: page, pageSize: rows},
        datatype: 'json',
        success: function (data) {
            if (data.result == 1) {
                $(".product_length_number").html(data.data.count);
                var html = "";
                var count = data.data.count;
                for (var i = 0; i < data.data.redisContents.length; i++) {
                    var redisContent = data.data.redisContents[i];
                    html += create_club_list(redisContent.rediscontent);
                }
                $(".product_content").html(html);
                //这里是分页的插件
                $('#pagination').jqPaginator('option', {
                    totalPages: (Math.ceil(count / rows) < 1 ? 1 : Math.ceil(count / rows)),
                    currentPage: page
                });
            } else {
                alert(data.msg);
            }
        }
    });
    $(".product_box:even").css("background", "#e6e6e6");//隔行变色
}