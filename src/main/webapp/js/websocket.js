$(function(){
    refresh();
}) ;


function refresh(){
    $.ajax({
        type:'POST',
        url:getPath()+'/content_load',
        success:function(data){
            if (data.data.result ==1){

            }else {

            }
        }
    });
}