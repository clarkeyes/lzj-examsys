$(function(){
			 // validate form on keyup and submit
	var validator = $("#addUserScoreForm").validate({
		rules: {
			"ueGrade": {
				required:true,
				avaiScore:true
			}
		},
		messages: {
			"ueGrade": 
			{
				required:"请输入成绩",
				avaiScore:"请输入数字类成绩"
			}
		},
		// the errorPlacement has to take the layout into account
		errorPlacement: function(error, element) {
			error.insertAfter(element.parent().find('label:first'));
		},
		// specifying a submitHandler prevents the default submit, good for the demo
		submitHandler: function() {
			$.post(
				"../admin/addUserScore.action",
				$("#addUserScoreForm").serialize(),
				function(data){
					if("success"==data.result){
						$.messager.alert("系统消息","提交成绩成功!",'info',function(){
							window.location.href="../admin/userscore_list.jsp?examId="+$("#examId").val();
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