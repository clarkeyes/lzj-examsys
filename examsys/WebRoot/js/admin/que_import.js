$(function(){
			 // validate form on keyup and submit
	var validator = $("#addQueForm").validate({
		rules: {
			"qcName": {
				required:true,
				avaiName:true
			},
			"queBaseFile": {
				required:true
			}
		},
		messages: {
			"qcName": 
			{
				required:"请输入类别",
				avaiName:"名称只能为汉字、数字、字母和下划线"
			},
			"queBaseFile": 
			{
				required:"请选择题目文件"
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
			var qcName=encodeURIComponent(encodeURIComponent($("#qcName").val()));
			
			$.ajaxFileUpload({    
                 url:'../admin/importQue.action?qcName='+qcName+'&qbId='+$("#qbId").val(),    
                 secureuri:false,    
                 fileElementId:'queBaseFile',    
                 dataType:'json',
                 success:function(data,status){
                 	$("div.datagrid-mask").remove();
				    $("#loading").hide();//隐藏提示
                     if(data=="success"){
                     	$.messager.alert("系统消息","添加题目成功","info",function(){
                     		window.location.href="../admin/quebase_list.jsp";
                     	});
                     }else if(null!=data){
                         $.messager.alert("系统消息",data,"warning");
                     }
                 },    
                error:function(data, status, e){
                	$("div.datagrid-mask").remove();
				    $("#loading").hide();//隐藏提示
                    $.messager.alert("系统消息","添加题目失败","warning");
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