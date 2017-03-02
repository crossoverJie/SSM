$(function(){
    refresh();
}) ;


function refresh(){
    $.ajax({
        type:'POST',
        url:getPath()+'/content_load',
        success:function(data){
            if (data.result ==1){
                var contents = data.data.contents ;
                for (var i=0 ;i<contents.length ;i++){
                    var content = contents[i];
                    var msg = content.content;
                    $("#msg").append(msg+"<br/>")
                }
            }else {

            }
        }
    });
}