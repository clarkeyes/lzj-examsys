function startExam(ueId){
	$.messager.confirm("系统消息","确认开始考试？",function(bool)
	{
		if(bool){
			window.location="../user/userExamContent.action?ueId="+ueId;
			window.event.returnValue=false;
		}
	});
	
}