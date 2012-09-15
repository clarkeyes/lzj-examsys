$(function(){
			 // validate form on keyup and submit
	var validator = $("#importUserGroupForm").validate({
		rules: {
			"userGroupId": {
				required:true,
			}
		},
		messages: {
			"userGroupId": 
			{
				required:"请选择用户组",
			}
		},
		// the errorPlacement has to take the layout into account
		errorPlacement: function(error, element) {
			error.insertAfter(element.parent().find('label:first'));
		},
		// specifying a submitHandler prevents the default submit, good for the demo
		submitHandler: function() {
			$("#importUserGroupButton").attr("disabled","disabled");
			$.post(
				"../admin/importUserGroup.action",
				$("#importUserGroupForm").serialize(),
				function(data){
					if("success"==data.result){
						$.messager.alert("系统消息","导入用户组成功!",'info',function(){
							window.location.href="../admin/exam_list.jsp";
						});
					}else if(null!=data.result){
						$.messager.alert("系统消息",data.result,"warning");
					}
				}
			);
			$("#importUserGroupButton").attr("disabled","");
		},
		// set new class to error-labels to indicate valid fields
		success: function(label) {
			// set &nbsp; as text for IE
			label.html("&nbsp;").addClass("ok");
		}
	});
});	 