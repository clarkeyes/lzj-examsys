$(function(){
			 // validate form on keyup and submit
	var validator = $("#importUsersForm").validate({
		rules: {
			"userFile": {
				required:true
			}
		},
		messages: {
			"userFile": 
			{
				required:"请选择用户表"
			}
		},
		// the errorPlacement has to take the layout into account
		errorPlacement: function(error, element) {
			error.insertAfter(element.parent().find('label:first'));
		},
		// specifying a submitHandler prevents the default submit, good for the demo
		submitHandler: function() {
			//封屏操作
		/*	$("<div class=\"datagrid-mask\"></div>").css({display:"block",
	       		width:$(".width6").width(),height:$(".width6").height(),
	       		left:"50px",
				top:($("#page").height()-$("div.datagrid-mask-msg").outerHeight())/3}).appendTo($(".width6"));
			$("#loading").html("导入用户，请稍等……").css({display:"block",
			left:($("#page").width()-$("div.datagrid-mask-msg").outerWidth())/2,
			top:($("#page").height()-$("div.datagrid-mask-msg").outerHeight())/2 });*/
			//封屏操作结束
			
			$.ajaxFileUpload({    
                 url:'../admin/importUsers.action',    
                 secureuri:false,    
                 fileElementId:'userFile',    
                 dataType:'json',
                 success:function(data,status){
                 	$("div.datagrid-mask").remove();
				    $("#loading").hide();//隐藏提示
                     if(data=="success"){
                     	$.messager.alert("系统消息","导入用户成功","info",function(){
                     		window.location.href="../admin/user_list.jsp";
                     	});
                     }else if(null!=data){
                         $.messager.alert("系统消息",data,"warning");
                     }
                 },    
                error:function(data, status, e){
                	$("div.datagrid-mask").remove();
				    $("#loading").hide();//隐藏提示
                    $.messager.alert("系统消息","导入用户失败","warning");
                }   
            });   
		},
		// set new class to error-labels to indicate valid fields
		success: function(label) {
			// set &nbsp; as text for IE
			label.html("&nbsp;").addClass("ok");
		}
	});
});	 