$(function(){
			 // validate form on keyup and submit
	var validator = $("#addExamForm").validate({
		rules: {
			"examName": {
				required:true,
				avaiName:true,
				rangelength: [1, 25]
			},
			"qbId": {
				required:true
			}
		},
		messages: {
			"examName": 
			{
				required:"请输入考试名称",
				avaiName:"考试名称只能是数字、字母、下划线和汉字！",
				rangelength:"输入长度大于1小于25"
			},
			"qbId": 
			{
				required:"请选择题库"
			}
		},
		// the errorPlacement has to take the layout into account
		errorPlacement: function(error, element) {
			error.insertAfter(element.parent().find('label:first'));
		},
		// specifying a submitHandler prevents the default submit, good for the demo
		submitHandler: function() {
			//$("#addExamButton").attr("disabled",true);
			//var flag=validateQcAndQt();
			var flag=true;
			if(flag){
				$.post(
					"../admin/addExam.action",
					$("#addExamForm").serialize(),
					function(data){
						if("success"==data.result){
							$.messager.alert("系统消息","考试添加成功!",'info',function(){
								window.location.href="../admin/exam_list.jsp";
							});
						}else if(null!=data.result){
							$.messager.alert("系统消息",data.result,"warning");
						}
					}
				);
			}
			
			//$("#addExamButton").attr("disabled",false);
		},
		// set new class to error-labels to indicate valid fields
		success: function(label) {
			// set &nbsp; as text for IE
			label.html("&nbsp;").addClass("ok");
		}
	});
});	 
//验证类别比例、题型数量和分值  
/*function validateQcAndQt(){
	//验证类别比例
	var regex=/^[0-9]|[1-9][0-9]|100$/;
	var qcs=$("#addExamForm").find("#qcRatio");
	var total=0;
	var flag=true;
	$.each(qcs,function(i,item){
		item.prev().prev().find(".error").remove();//删除以前的提醒元素
		var ratio=item.value;
		if(ratio.length>0){
			if(!regex.test(ratio)){
				flag=false;
				item.prev().prev().append("<label class='error onError'>请输入整数，范围为0~100</label>");
			}else{
				total=total+parseInt(ratio);
			}
		}
	});
	//验证题型分数
	var queScore=$("#addExamForm").find("#queScore");
	var scoreRegex=/^\d+\56{0,1}\d{0,2}$/;
	$.each(queScore,function(i,item){
		item.prev().prev().find(".error").remove();//删除以前的提醒元素
		var score=item.value;
		if(score.length>0){
			if(!scoreRegex.test(score)){
				flag=false;
				item.prev().prev().append("<label class='error onError'>请输入正整数或小数</label>");
			}
		}
	});
	//验证题型数量
	var queNum=$("#addExamForm").find("#queNum");
	var numRegex=/^\d+$/;
	$.each(queNum,function(i,item){
		item.prev().prev().find(".error").remove();//删除以前的提醒元素
		var num=item.value;
		if(num.length>0){
			if(!numRegex.test(num)){
				flag=false;
				item.prev().prev().append("<label class='error onError'>请输入正整数</label>");
			}
		}
	});
	if(total>100){
		$.messager.alert("系统消息","类别比例之和不得超过100","info");
		flag=false;
	}
	return flag;
}*/