$(function(){
			 // validate form on keyup and submit
	var validator = $("#commitUserAnswer").validate({
		// the errorPlacement has to take the layout into account
		errorPlacement: function(error, element) {
			error.insertAfter(element.parent().find('label:first'));
		},
		// specifying a submitHandler prevents the default submit, good for the demo
		submitHandler: function() {
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
		},
		// set new class to error-labels to indicate valid fields
		success: function(label) {
			// set &nbsp; as text for IE
			label.html("&nbsp;").addClass("ok");
		}
	});
});	 