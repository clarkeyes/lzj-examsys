$(function(){
    $('#userGroupList').datagrid({
		title:'用户组列表',
		height:470,
		nowrap: false,
		striped: true,
		singleSelect:true,
		url:'../admin/userGroupList.action',
		sortName: '',
		sortOrder: 'asc',
		remoteSort: false,
		idField:'ugId',
		columns:[[
			{field:'ugName',title:'用户组名',width:100},
			{field:'userNum',title:'人数',width:100},
			{field:'opt',title:'操作',width:200,align:'left',
				formatter:function(value,rec){//rec为一个vlan对象
					return 	'<a href="javascript:;" onclick="deleteUserGroup('+rec.ugId+');">删除</a>&nbsp;'
					+'|&nbsp;<a href="javascript:;" onclick="orgUser('+rec.ugId+');">组织用户</a>&nbsp;';
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
				window.location="../admin/usergroup_add.jsp";
				window.event.returnValue=false;
			}
		}]
	
 	});
 
});
//删除用户组
function deleteUserGroup(ugId){
	$.messager.confirm("系统消息","确认删除？",function(bool)
	{
		if(bool){
			$.post(
				"../admin/deleteUg.action",
				{"ugId":ugId},
				function(data){
					if(data.result == "success"){
						$.messager.alert("系统消息","删除成功","info");
						$('#userGroupList').datagrid('reload');
						$('#userGroupList').datagrid('clearSelections');
					}else if(data.result != null){
						$.messager.alert("系统消息",data.result,"error");
					}
			});
		}
	});
}
//组织用户
function orgUser(ugId){
	window.location="../admin/usergroup_org.jsp?ugId="+ugId;
	window.event.returnValue=false;
}