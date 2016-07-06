var clubId = GetQueryString("clubId") | 0;
var userId = getCookie("userId")|0;
//获取java路径
function getPath() {
	return $('body').attr('data');
}

//404情况下的图片或头像
function imgError(img,type){
	img.src=getPath()+'/images/default/'+type+'.jpg';
	if(type=='default_coach_list_img'){
		window.setTimeout(function(){
			$('#coachPic img').css('height',''+$('.content_bg:eq(1) img').height()+'px');									
		},50);
	}
}
//获取请求URL参数
function GetQueryString(name){
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null){
    	 return  unescape(r[2]);
     } 
     return null;
}
//获取cookies参数
function getCookie(name){  
    var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));  
    if(arr != null){  
     return unescape(arr[2]);   
    }else{  
     return null;  
    }  
}

//倒计时时间大小判断
var zero = function(num)
{
	return num < 10 ? ("0" + num) : num;
}

//倒计时时间执行顺序
function time_obj(date1,date2){
	if(date2<=date1){
		return "活动已结束";
	}else{
		var date3 = date2.getTime() - date1.getTime();//时间差的毫秒数
		//var time = 24 * 3600 * 1000;
		//计算出相差天数，相差毫秒数除以一天的毫秒数
		var days = Math.floor(date3 / (24 * 3600 * 1000));
		 
		//计算出小时数
		var leave1 = date3 % (24 * 3600 * 1000);//时间差的毫秒数除以一天的毫秒数的余数，计算天数后剩余的毫秒数
		var hours = Math.floor(leave1 / (3600 * 1000));//剩下的多少个小时
		
		//计算相差分钟数
		var leave2 = leave1 % (3600 * 1000);//计算小时数后剩余的毫秒数
		var minutes = Math.floor(leave2 / (60 * 1000));//剩下的分钟
		 
		//计算相差秒数
		var leave3 = leave2 % (60 * 1000);//计算分钟数后剩余的毫秒数
		var seconds = Math.round(leave3 / 1000);

		return zero(days) + "天" + zero(hours) + "小时" + zero(minutes) + "分" + zero(seconds) + "秒";
	}
}

