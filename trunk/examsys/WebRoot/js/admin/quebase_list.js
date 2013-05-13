$(function(){
    $('#queBaseList').datagrid({
		title:'题库列表',
		height:470,
		nowrap: false,
		striped: true,
		singleSelect:true,
		url:'../admin/queBaseList.action',
		sortName: '',
		sortOrder: 'asc',
		remoteSort: false,
		idField:'qbId',
		columns:[[
			{field:'qbName',title:'题库',width:100},
			{field:'radioNum',title:'单选(个)',width:100},
			{field:'checkNum',title:'多选(个)',width:100},
			{field:'judgeNum',title:'判断(个)',width:100},
			{field:'opt',title:'操作',width:250,align:'left',
				formatter:function(value,rec){//rec为一个对象
					return 	'<a href="javascript:;" onclick="toImportQue('+rec.qbId+');">导入题目</a>&nbsp;'
					+'|&nbsp;<a href="javascript:;" onclick="deleteQb('+rec.qbId+');">删除</a>&nbsp;';
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
				window.location="../admin/quebase_add.jsp";
				window.event.returnValue=false;
			}
		}]
	
 	});
 
});
//进入导入题目页面
function toImportQue(qbId){
	window.location="../admin/que_import.jsp?qbId="+qbId;
	window.event.returnValue=false;
}
function deleteQb(qbId){
	$.messager.confirm("系统消息","该操作会删除题库及其下的所有题目，确认删除？",function(bool)
	{
		if(bool){
			$.post(
				"../admin/deleteQb.action",
				{"qbId":qbId},
				function(data){
					if(data.result == "success"){
						$.messager.alert("系统消息","删除成功","info");
						$('#queBaseList').datagrid('reload');
						$('#queBaseList').datagrid('clearSelections');
					}else if(data.result != null){
						$.messager.alert("系统消息",data.result,"error");
					}
			});
		}
	});
}