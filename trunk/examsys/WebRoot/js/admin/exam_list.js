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
		idField:'',
		columns:[[
			{field:'examName',title:'名称',width:100},
			{field:'examTime',title:'时长',width:80},
			{field:'userNum',title:'人数',width:100},
			{field:'opt',title:'操作',width:70,align:'left',
				formatter:function(value,rec){//rec为一个vlan对象
					return 	'<a href="javascript:;" onclick="importUser();">导入用户组</a>&nbsp;&nbsp;&nbsp;&nbsp;';
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