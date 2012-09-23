var maxtime = 60*60;//一个小时，按秒计算，自己调整!
$(function(){

			 // validate form on keyup and submit
	var validator = $("#commitUserAnswer").validate({
		// the errorPlacement has to take the layout into account
		errorPlacement: function(error, element) {
			error.insertAfter(element.parent().find('label:first'));
		},
		// specifying a submitHandler prevents the default submit, good for the demo
		submitHandler: function() {
			$.messager.confirm("系统消息","确认交卷？",function(bool)
			{
				if(bool){
					$.post(
						"../user/commitAnswer.action",
						$("#commitUserAnswer").serialize(),
						function(data){
							if("success"==data.result){
								$.messager.alert("系统消息","提交成功!",'info',function(){
									window.location.href="../user/userExamList.action";
								});
							}else if(null!=data.result){
								$.messager.alert("系统消息",data.result,"warning");
							}
						}
					);
				}
			});
		},
		// set new class to error-labels to indicate valid fields
		success: function(label) {
			// set &nbsp; as text for IE
			label.html("&nbsp;").addClass("ok");
		}
	});
	
	var ue=$("#retime").val() ;
	maxtime=ue*60;
	
    
    
});	 
//标记
function makeSign(uqId){
	$("#uq_"+uqId).toggleClass('p123');
}


 
	
	
	function CountDown(){   
if(maxtime>=0){   
minutes = Math.floor(maxtime/60);   
seconds = Math.floor(maxtime%60); 
if(minutes>10)  {
msg = "剩余时间 "+minutes+"分钟"; 
}
else{
msg = "剩余时间 "+minutes+"分钟"+seconds+"秒"; 
$("#timer").css("color","red");   
}
  
$("#timer").text(msg);   
--maxtime;   
}   
else{   
$.post(
		"../user/commitAnswer.action",
		$("#commitUserAnswer").serialize(),
		function(data){
			if("success"==data.result){
				$.messager.alert("系统消息","提交成功!",'info',function(){
					window.location.href="../user/userExamList.action";
				});
			}else if(null!=data.result){
				$.messager.alert("系统消息",data.result,"warning");
			}
		}
	);
clearInterval(timer);   
alert("时间到，结束!");   
}   
}
timer = setInterval("CountDown()",1000);

  
   

