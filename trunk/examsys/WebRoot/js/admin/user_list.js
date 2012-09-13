$(function(){
    $('#userList').datagrid({
		title:'用户列表',
		height:470,
		nowrap: false,
		striped: true,
		singleSelect:true,
		url:'',
		sortName: '',
		sortOrder: 'asc',
		remoteSort: false,
		idField:'',
		columns:[[
			{field:'account',title:'账号',width:100},
			{field:'name',title:'姓名',width:100},
			{field:'state',title:'状态',width:100},
			{field:'score',title:'成绩',width:100},
			{field:'opt',title:'操作',width:70,align:'left',
				formatter:function(value,rec){//rec为一个vlan对象
					return 	'<a href="javascript:;" onclick="inputScore();">输入成绩</a>&nbsp;&nbsp;&nbsp;&nbsp;';
				}
			}
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
		}]
	
 	});
 
});