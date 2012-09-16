$(function(){
			 // validate form on keyup and submit
	var validator = $("#addUgForm").validate({
		rules: {
			"ugName": {
				required:true,
				avaiName:true,
				rangelength: [1, 25]
			}
		},
		messages: {
			"ugName": 
			{
				required:"请输入用户组名",
				avaiName:"用户组名只能是数字、字母、下划线和汉字！",
				rangelength:"输入长度大于1小于25"
			}
		},
		// the errorPlacement has to take the layout into account
		errorPlacement: function(error, element) {
			error.insertAfter(element.parent().find('label:first'));
		},
		// specifying a submitHandler prevents the default submit, good for the demo
		submitHandler: function() {
			$.post(
				"../admin/addUg.action",
				$("#addUgForm").serialize(),
				function(data){
					if("success"==data.result){
						$.messager.alert("系统消息","添加用户组成功!",'info',function(){
							window.location.href="../admin/usergroup_list.jsp";
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