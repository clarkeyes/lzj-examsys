$(function(){
			 // validate form on keyup and submit
	var validator = $("#addUserForm").validate({
		rules: {
			"user.userAccount": {
				required:true,
				avaiWord:true,
				rangelength: [1, 25]
			},
			"user.userName": {
				required:true,
				avaiName:true,
				rangelength: [1, 25]
			},
			"user.userPassword": {
				required:true,
				avaiWord:true,
				rangelength: [6, 25]
			},
			"rePassword": {
				required:true,
				equalTo:"#userPassword",
			},
			"user.userRole": {
				required:true
			}
		},
		messages: {
			"user.userAccount": 
			{
				required:"请输入账号",
				avaiWord:"账号只能是数字、字母、下划线！",
				rangelength:"输入长度大于1小于25"
			},
			"user.userName": 
			{
				required:"请输入用户姓名",
				avaiName:"姓名只能是数字、字母、下划线和汉字！",
				rangelength:"输入长度大于1小于25"
			},
			"user.userPassword": 
			{
				required:"请输入密码",
				avaiWord:"密码只能是数字、字母、下划线！",
				rangelength:"输入长度大于6小于25"
			},
			"rePassword": 
			{
				required:"请输入确认密码",
				equalTo:"两次密码不一致！",
			},
			"user.userRole": 
			{
				required:"请选择用户角色"
			},
		},
		// the errorPlacement has to take the layout into account
		errorPlacement: function(error, element) {
			error.insertAfter(element.parent().find('label:first'));
		},
		// specifying a submitHandler prevents the default submit, good for the demo
		submitHandler: function() {
			$.post(
				"../admin/addUser.action",
				$("#addUserForm").serialize(),
				function(data){
					if("success"==data.result){
						$.messager.alert("系统消息","添加成功!",'info',function(){
							if($("#userRole").val()=='1'){
								window.location.href="../admin/user_list.jsp";
							}else{
								window.location.href="../admin/user_public_list.jsp";
							}
						});
					}else if(null!=data.result){
						$.messager.alert("系统消息",data.result,"warning");
					}
				}
			);
			
		},
		// set new class to error-labels to indicate valid fields
		success: function(label) {
			// set &nbsp; as text for IE
			label.html("&nbsp;").addClass("ok");
		}
	});
});	 