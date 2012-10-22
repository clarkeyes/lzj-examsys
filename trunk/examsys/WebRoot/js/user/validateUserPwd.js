 $(function(){
			 // validate form on keyup and submit
	var validator = $("#editUserPwdForm").validate({
		rules: {
			"oldPassword": {
			required:true,
			avaiWord:true,
			rangelength: [1, 25]
			},
			"newPassword": {
			required:true,
			avaiWord:true,
			rangelength: [1, 25]
			},
			"rePassword": {
			required:true,
			equalTo:"#newPassword",
			}
		},
		messages: {
			"oldPassword": 
			{
			required:"请输入当前密码",
			avaiWord:"密码只能是数字、字母、下划线！",
			rangelength:"输入长度大于1小于25"
			},
			"newPassword": 
			{
			required:"请输入密码",
			avaiWord:"密码只能是数字、字母、下划线！",
			rangelength:"输入长度大于1小于25"
			},
			"rePassword": 
			{
			required:"请输入确认密码",
			equalTo:"两次密码不一致！",
			}
		},
		// the errorPlacement has to take the layout into account
		errorPlacement: function(error, element) {
			error.insertAfter(element.parent().find('label:first'));
		},
		// specifying a submitHandler prevents the default submit, good for the demo
		submitHandler: function() {
			$.post(
			"../user/userPwd.action",
			$("#editUserPwdForm").serialize(),
			function(data){
			    if(data.fieldErrors['oldPassword']!=null){
			     $("#oldPassword").prev().prev().find(".error").remove();
			        $("#oldPassword").prev().prev().append("<label class='error onError'>"+data.fieldErrors['oldPassword']+"</label>");
			    }
			    if(data.fieldErrors['newPassword']!=null){
			    	$("#newPassword").prev().prev().find(".error").remove();
			        $("#newPassword").prev().prev().append("<label class='error onError'>"+data.fieldErrors['newPassword']+"</label>");
			    }
			    if(data.fieldErrors['rePassword']!=null){
			    	$("#rePassword").prev().prev().find(".error").remove();
			        $("#rePassword").prev().prev().append("<label class='error onError'>"+data.fieldErrors['rePassword']+"</label>");
			    }
				if(data.result == "error")
				{
                    $.messager.alert("系统消息","密码修改失败","warning");
				}
				else if(data.result == "success")
				{
					$.messager.alert("系统消息","密码修改成功!",'info',function(){
						window.location.href="javascript:history.go(-1);";
					});
				}else if(data.result == "pwdError"){
				    var errorMsg="当前密码错误，请重新输入";
					$("#oldPassword").prev().prev().append("<label class='error onError'>"+errorMsg+"</label>");
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
