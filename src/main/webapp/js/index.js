function refresh(){
    $.ajax({
        type:'POST',
        url:getPath()+'/createAllIndex',
        async:false,
        success:function(data){
            alert("生成索引成功！");
        }
    });
}