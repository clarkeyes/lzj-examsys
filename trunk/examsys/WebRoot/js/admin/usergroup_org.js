$(function(){
         //生成用户列表
    $('#ingroup').datagrid({
		title:'组内用户',  //表格标题
		height:470,
		nowrap: false,  //是否只显示一行，即文本过多是否省略部分。
		striped: true,
		singleSelect:false,						
		url:'../admin/inGroupUser.action',
		sortName: 'userId',
		sortOrder: 'asc',
		remoteSort: false,
		idField:'userId',
		frozenColumns:[[
	                {field:'userId',checkbox:true,ailgn:'center'}
				]],
		columns:[[
			{field:'userAccount',title:'账号',width:160},
			{field:'userName',title:'姓名',width:100}
		]],
		pagination:true,  //分页功能
		rownumbers:true,  //行号
		pageSize:10,      //设置每页有几条记录
		pageNumber:1,
		queryParams:{"ugId":$("#ugId").val()},//查询条件
		toolbar:[{
				id:'btndelete',
				text:'移除',
				iconCls:'icon_remove',
				handler:function()
				{
					var row = $('#ingroup').datagrid('getSelected');
					if(row)
					{
						$.messager.confirm("系统消息","确认批量移除组内用户？",function(bool)
						{
						if(bool)
						{
							var rows = $("#ingroup").datagrid("getSelections");
							orgUserId(rows);
							$.post(
								"../admin/removeUsers.action",
								$("#operatorUsers").serialize(),
								function(data){
									if(data.result == "success"){
										$.messager.alert("系统消息","移除成功","info");
										$('#ingroup').datagrid('reload');
										$('#notingroup').datagrid('reload');
										$('#ingroup').datagrid('clearSelections');
									}else if(null!=data.result){
										$.messager.alert("系统消息",data.result,"warning");
									}
							});
						}
					});
					}else{
						$.messager.alert("系统消息","请先选择用户","warning");
					}
					$('#ingroup').parent().find("div .datagrid-header-check").children("input[type='checkbox']").eq(0).attr("checked", false);
				}
			}]
 	});

});
		  		   
$(function(){
          //生成用户列表
    $('#notingroup').datagrid({
		title:'所有非组内普通用户列表',  //表格标题
		height:470,
		nowrap: false,  //是否只显示一行，即文本过多是否省略部分。
		striped: true,
		singleSelect:false,
		url:'../admin/notInGroupUsers.action',
		sortName: 'userId',
		sortOrder: 'asc',
		remoteSort: false,
		idField:'userId',
		frozenColumns:[[
	                {field:'userId',checkbox:true,ailgn:'center'}
				]],
		columns:[[
			{field:'userAccount',title:'账号',width:160},
			{field:'userName',title:'姓名',width:100}
		]],
		pagination:true,  //分页功能
		rownumbers:true,  //行号
		pageSize:10,      //设置每页有几条记录
		pageNumber:1,
		queryParams:{"ugId":$("#ugId").val()},//查询条件
		toolbar:[{
			id:'btnadd',
			text:'添加至用户组',
			iconCls:'icon_addto',
			handler:function(){
				orgAdd();
			}
		}]
 	});

});
//组织用户id
function orgUserId(rows){
	var size = rows.length;
	var param = "";
	for(var i = 0;i <size;i++)
	{
		param=param+'<input type="hidden" name="userIdList['+i+']" value="'+rows[i].userId+'"/>';
	}
	$("#userIds").html(param);
} 
//向用户组中添加用户
function orgAdd(){
	var row = $('#notingroup').datagrid('getSelected');
	if(row)
	{
		$.messager.confirm("系统消息","确认添加用户至用户组中？",function(bool)
		{
		if(bool)
		{
			var rows = $("#notingroup").datagrid("getSelections");
			orgUserId(rows);
			$.post(
				"../admin/addUsersToUg.action",
				$("#operatorUsers").serialize(),
				function(data){
					if(data.result == "success"){
						$.messager.alert("系统消息","添加成功","info");
						$('#ingroup').datagrid('reload');
						$('#notingroup').datagrid('reload');
						$('#notingroup').datagrid('clearSelections');
					}else if(null!=data.result){
						$.messager.alert("系统消息",data.result,"warning");
					}
			});
		}
	});
	}else{
		$.messager.alert("系统消息","请先选择用户","warning");
	}
	$('#notingroup').parent().find("div .datagrid-header-check").children("input[type='checkbox']").eq(0).attr("checked", false);
}