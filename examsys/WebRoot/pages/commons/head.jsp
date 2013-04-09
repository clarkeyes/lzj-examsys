<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/custom.css">
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/local/easyui-lang-zh_CN.js"></script>
		<!-- Internet Explorer Fixes -->
		<!--[if IE]>
		<link rel="stylesheet" type="text/css" media="all" href="/vmmaster/css/ie.css"/>
		<![endif]-->

		<!--[if lt IE 8]>
        <script src="http://ie7-js.googlecode.com/svn/version/2.0(beta3)/IE8.js" type="text/javascript"></script>
        <script type="text/javascript">
		    window.onload=function (){
				document.getElementById("title_img").src="/vmmaster/img/logo_ie.png";
			}
        </script>
        <![endif]-->

		<script type="text/javascript">
<!--
	$("#head h1").show("slow");
//-->
$(document).ready(function(){
	$("#admin-menu").hide();
	//用户退出登录
	 $('#loginOut').click(function() {
	     $.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {
	
	         if (r) {
	             location.href = '/examsys/logout.action';
	         }
	     });
	 });
	 //欢迎用户
 	$.post(
 		"/examsys/head.action",
 		function(data){
 			if(data.userName!=null){
 				$("#headUserName").html(data.userName);
 			}
 			if(data.userRole==0||data.userRole==2){//管理员
 				/*var menu='<li id="ks"><a href="<%=request.getContextPath()%>/pages/admin/exam_list.jsp">考试</a></li>'
 				+'<li id="yhgl"><a href="<%=request.getContextPath()%>/pages/admin/user_list.jsp">用户管理</a></li>'
 				+'<li id="yhz"><a href="<%=request.getContextPath()%>/pages/admin/usergroup_list.jsp">用户组</a></li>';
 				$("#admin-menu").html(menu);*/
 				$("#admin-menu").show();
 			}
 			$("#userRole-hidden").val(data.userRole);
 		}
 	);
 });
</script>
	</head>
	<body>
		<!-- Header -->
		<div class="header" id="top">
			<input type="hidden" id="userRole-hidden"/>
			<div class="wrapper" style="position:relative;">
				<!-- Title/Logo - can use text instead of image -->
				<div id="title">
					西宁支队执勤岗位练兵网上考试系统
					<!--<span>VEGAGRID</span> demo-->
				</div>
				<!-- Top navigation -->
				<div id="topnav">
					欢迎您
					<b id="headUserName"></b>
					<span>|</span>
					<a href="<%=request.getContextPath()%>/pages/user/user_pwd.jsp">修改密码</a>
					<span>|</span>
					<a href="#" id="loginOut">退出</a>
					<br />
					<small> </small>
				</div>
				<!-- End of Top navigation -->
				<!-- Main navigation -->
				<!-- 管理员 -->
					<div id="menu" class="page-content">
						<ul class="sf-menu" id="admin-menu">
							<li id="ks"><a href="<%=request.getContextPath()%>/pages/admin/exam_list.jsp">考试</a></li>
							<li id="yhgl"><a href="<%=request.getContextPath()%>/pages/admin/user_list.jsp">用户管理</a></li>
							<li id="yhz"><a href="<%=request.getContextPath()%>/pages/admin/usergroup_list.jsp">用户组</a></li>
						</ul>
					</div>
				
				<!-- End of Main navigation -->
				<!-- Aside links -->
				<aside>
				</aside>
				<!-- End of Aside links -->
			</div>
		</div>

	</body>
</html>




