$(function(){
	$.post(
 		"/examsys/head.action",
 		function(data){
 			if(2==data.userRole){
				$('#userScoreList').datagrid({
					title:'用户成绩列表',
					height:470,
					nowrap: false,
					striped: true,
					singleSelect:false,
					url:'../admin/userScoreList.action',
					sortName: '',
					sortOrder: 'asc',
					remoteSort: false,
					idField:'ueId',
					frozenColumns:[[
						{field:'ueId',checkbox:true,ailgn:'center'}
					]],
					columns:[[
						{field:'userAccount',title:'账号',width:100},
						{field:'userName',title:'姓名',width:100},
						{field:'ueState',title:'状态',width:100},
						{field:'ueGrade',title:'成绩',width:100},
						{field:'opt',title:'操作',width:200,align:'left',
							formatter:function(value,rec){//rec为一个vlan对象
								return 	'<a href="javascript:;" onclick="inputGrade('+rec.ueId+');">输入成绩</a>&nbsp;';
								
							}
						}
					]],
					queryParams:{"examId":$("#examId").val()},//查询条件
					pagination:true,  //分页功能
					rownumbers:true,  //行号
					pageSize:10,      //设置每页有几条记录
					toolbar:[{
						id:'btnadd',
						text:'开启考试',
						iconCls:'icon-ok',
						handler:function(){
							var row = $('#userScoreList').datagrid('getSelected');
							if(row)
							{
								$.messager.confirm("系统消息","确认为选中用户开启考试？",function(bool)
								{
									if(bool)
									{
										insertSelectId();
										$.post(
											"../admin/startUserExam.action",
											$("#ueIdForm").serialize(),
											function(data){
												if(data.result == "success"){
													$.messager.alert("系统消息","开启考试成功","info");
													$('#userScoreList').datagrid('reload');
													$('#userScoreList').datagrid('clearSelections');
												}else if(null!=data.result){
													$.messager.alert("系统消息",data.result,"warning");
												}
										});
										$('#userScoreList').parent().find("div .datagrid-header-check").children("input[type='checkbox']").eq(0).attr("checked", false);
									}
								});
							}else{
								$.messager.alert("系统消息","请先选择开启的用户","warning");
								$('#userScoreList').parent().find("div .datagrid-header-check").children("input[type='checkbox']").eq(0).attr("checked", false);
							}
						}
					}]
			 	});
			}else{
				$('#userScoreList').datagrid({
					title:'用户成绩列表',
					height:470,
					nowrap: false,
					striped: true,
					singleSelect:false,
					url:'../admin/userScoreList.action',
					sortName: '',
					sortOrder: 'asc',
					remoteSort: false,
					idField:'ueId',
					frozenColumns:[[
						{field:'ueId',checkbox:true,ailgn:'center'}
					]],
					columns:[[
						{field:'userAccount',title:'账号',width:100},
						{field:'userName',title:'姓名',width:100},
						{field:'ueState',title:'状态',width:100},
						{field:'ueGrade',title:'成绩',width:100}
					]],
					queryParams:{"examId":$("#examId").val()},//查询条件
					pagination:true,  //分页功能
					rownumbers:true,  //行号
					pageSize:10,      //设置每页有几条记录
					toolbar:[{
						id:'btnadd',
						text:'开启考试',
						iconCls:'icon-ok',
						handler:function(){
							var row = $('#userScoreList').datagrid('getSelected');
							if(row)
							{
								$.messager.confirm("系统消息","确认为选中用户开启考试？",function(bool)
								{
									if(bool)
									{
										insertSelectId();
										$.post(
											"../admin/startUserExam.action",
											$("#ueIdForm").serialize(),
											function(data){
												if(data.result == "success"){
													$.messager.alert("系统消息","开启考试成功","info");
													$('#userScoreList').datagrid('reload');
													$('#userScoreList').datagrid('clearSelections');
												}else if(null!=data.result){
													$.messager.alert("系统消息",data.result,"warning");
												}
										});
										$('#userScoreList').parent().find("div .datagrid-header-check").children("input[type='checkbox']").eq(0).attr("checked", false);
									}
								});
							}else{
								$.messager.alert("系统消息","请先选择开启的用户","warning");
								$('#userScoreList').parent().find("div .datagrid-header-check").children("input[type='checkbox']").eq(0).attr("checked", false);
							}
						}
					}]
			 	});
			}
		    
 		}
 	);
	
 
});
//输入用户考试成绩
function inputGrade(ueId){
	window.location="../admin/toUserScoreAdd.action?ueId="+ueId;
	window.event.returnValue=false;
}
//form中插入隐藏id
function insertSelectId(){
	var rows = $("#userScoreList").datagrid("getSelections");
	var size = rows.length;
	var param = "";
	for(var i = 0;i <size;i++)
	{
		param=param+'<input type="hidden" name="ueIdList['+i+']" value="'+rows[i].ueId+'"/>';
	}
	$("#ueIdForm").html(param);
}