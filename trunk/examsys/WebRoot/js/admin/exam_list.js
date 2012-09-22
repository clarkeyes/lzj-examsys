$(function(){
    $('#examList').datagrid({
		title:'考试列表',
		height:470,
		nowrap: false,
		striped: true,
		singleSelect:true,
		url:'../admin/examList.action',
		sortName: '',
		sortOrder: 'asc',
		remoteSort: false,
		idField:'examId',
		columns:[[
			{field:'examName',title:'名称',width:100},
			{field:'examTime',title:'时长',width:80},
			{field:'userNum',title:'人数',width:100},
			{field:'opt',title:'操作',width:250,align:'left',
				formatter:function(value,rec){//rec为一个vlan对象
					return 	'<a href="javascript:;" onclick="toImportUserGroup('+rec.examId+');">导入用户组</a>&nbsp;'
					+'|&nbsp;<a href="javascript:;" onclick="checkSocre('+rec.examId+');">查看成绩</a>&nbsp;'
					+'|&nbsp;<a href="javascript:;" onclick="deleteExam('+rec.examId+');">删除</a>&nbsp;';
				}
			}
		]],
		pagination:true,  //分页功能
		rownumbers:true,  //行号
		pageSize:10,      //设置每页有几条记录
		toolbar:[{
			id:'btnadd',
			text:'添加',
			iconCls:'icon-add ',
			handler:function(){
				window.location="../admin/toExamAdd.action";
				window.event.returnValue=false;
			}
		}]
	
 	});
 
});
//删除考试
function deleteExam(examId){
	$.messager.confirm("系统消息","确认删除？",function(bool)
	{
		if(bool){
			$.post(
				"../admin/deleteExam.action",
				{"examId":examId},
				function(data){
					if(data.result == "success"){
						$.messager.alert("系统消息","删除成功","info");
						$('#examList').datagrid('reload');
						$('#examList').datagrid('clearSelections');
					}else if(data.result != null){
						$.messager.alert("系统消息",data.result,"error");
					}
			});
		}
	});
}
//导入用户组
function toImportUserGroup(examId){
	window.location="../admin/toImportUserGroup.action?examId="+examId;
	window.event.returnValue=false;
}
//查看考试对应的用户成绩
function checkSocre(examId){
	window.location="../admin/userscore_list.jsp?examId="+examId;
	window.event.returnValue=false;
}
//查看考试内容
function examContent(examId){
	window.location="../admin/examContent.action?examId="+examId;
	window.event.returnValue=false;
}