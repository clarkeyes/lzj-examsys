$(function(){
			 // validate form on keyup and submit
	var validator = $("#addQueBaseForm").validate({
		rules: {
			"queBaseName": {
				required:true,
				avaiName:true
			}
		},
		messages: {
			"queBaseName": 
			{
				required:"请输入题库名称",
				avaiName:"名称只能为汉字、数字、字母和下划线"
			}
		},
		// the errorPlacement has to take the layout into account
		errorPlacement: function(error, element) {
			error.insertAfter(element.parent().find('label:first'));
		},
		// specifying a submitHandler prevents the default submit, good for the demo
		submitHandler: function() {
			
			$.post(    
                 '../admin/addQueBase.action',  
                 $("#addQueBaseForm").serialize(),  
                 function(data){
                     if(data.result=="success"){
                     	$.messager.alert("系统消息","添加题库成功","info",function(){
                     		window.location.href="../admin/quebase_list.jsp";
                     	});
                     }else if(null!=data.result){
                         $.messager.alert("系统消息",data,"warning");
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