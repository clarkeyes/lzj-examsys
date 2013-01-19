$(function(){
    $('#userList').datagrid({
		title:'用户列表',
		height:470,
		nowrap: false,
		striped: true,
		singleSelect:false,
		url:'../admin/userList.action',
		sortName: '',
		sortOrder: 'asc',
		remoteSort: false,
		idField:'userId',
		frozenColumns:[[
			{field:'userId',checkbox:true,ailgn:'center'}
		]],
		columns:[[
			{field:'userAccount',title:'账号',width:100},
			{field:'userName',title:'姓名',width:100}
		]],
		pagination:true,  //分页功能
		rownumbers:true,  //行号
		pageSize:10,      //设置每页有几条记录
		toolbar:[{
			id:'btnadd',
			text:'导入用户',
			iconCls:'icon-add ',
			handler:function(){
				window.location="user_import.jsp";
				window.event.returnValue=false;
			}
		},'-',{
			id:'btnadd',
			text:'删除',
			iconCls:'icon_delete',
			handler:function(){
				var row = $('#userList').datagrid('getSelected');
				if(row)
				{
					$.messager.confirm("系统消息","确认删除选中用户？",function(bool)
					{
						if(bool)
						{
							insertSelectId();
							$.post(
								"../admin/deleteUsers.action",
								$("#userIdForm").serialize(),
								function(data){
									if(data.result == "success"){
										$.messager.alert("系统消息","删除成功","info");
										$('#userList').datagrid('reload');
										$('#userList').datagrid('clearSelections');
									}else if(null!=data.result){
										$.messager.alert("系统消息",data.result,"warning");
									}
							});
							$('#userList').parent().find("div .datagrid-header-check").children("input[type='checkbox']").eq(0).attr("checked", false);
						}
					});
				}else{
					$.messager.alert("系统消息","请先选择删除的用户","warning");
					$('#userList').parent().find("div .datagrid-header-check").children("input[type='checkbox']").eq(0).attr("checked", false);
				}
			}
		}]
	
 	});
 
});
//form中插入隐藏id
function insertSelectId(){
	var rows = $("#userList").datagrid("getSelections");
	var size = rows.length;
	var param = "";
	for(var i = 0;i <size;i++)
	{
		param=param+'<input type="hidden" name="userIdList['+i+']" value="'+rows[i].userId+'"/>';
	}
	$("#userIdForm").html(param);
}