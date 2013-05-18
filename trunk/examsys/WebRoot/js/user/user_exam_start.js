function startExam(ueId){
	$.messager.confirm("系统消息","确认开始考试？",function(bool)
	{
		if(bool){
			window.location="../user/userExamContent.action?ueId="+ueId;
			window.event.returnValue=false;
		}
	});
	
}
//重考
function restartExam(ueId,reStart){
	$.messager.confirm("系统消息","确认重新考试？",function(bool)
	{
		if(bool){
			window.location="../user/userExamContent.action?ueId="+ueId+"&reStart="+reStart;
			window.event.returnValue=false;
		}
	});
	
}
//查看答案
function checkAnswer(ueId,reStart){
	window.location="../user/checkAnswer.action?ueId="+ueId+"&reStart="+reStart;
	window.event.returnValue=false;
}