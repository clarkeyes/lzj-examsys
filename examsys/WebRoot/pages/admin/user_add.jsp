<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加用户</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/themes/gray/easyui.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/themes/icon.css" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.validate_pack.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/validate_regex.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/admin/user_add.js"></script>
	<script type="text/javascript">
		$(function(){
		    $("#yhgl").addClass("current");
		});
	</script>
  </head>
  
  <body id="top">
    <jsp:include page="../commons/head.jsp"></jsp:include>
<!-- Page title -->
	<div id="pagetitle">
		<div class="wrapper">
			<h1>添加用户
			</h1>
			<!-- Quick search box -->
			<form action="" method="get">
				 
			</form>
		</div>
	</div>
	<!-- End of Page title -->
	<!-- Page content -->
	<div id="page">
		<!-- Wrapper -->
		<div class="wrapper" >
			<div class="page-content">
				<section class="column width6 first">
					<span class="msg" id="message">
					</span>
					<form id="addUserForm" method="post">
					    <fieldset>
				    <legend>所需字段</legend>
				    	<p>
							<label class="required">账号:</label><br/>
							<input type="text" id="userAccount" name="user.userAccount" class="required half"/>
						</p>
						<p>
							<label class="required">姓名:</label><br/>
							<input type="text" id="userName" name="user.userName" class="required half"/>
						</p>
						<p>
							<label class="required">密码:</label><br/>
							<input type="password" id="userPassword" name="user.userPassword" class="required half"/>
						</p>
						<p>
							<label class="required">确认密码:</label><br/>
							<input type="password" id="rePassword" name="rePassword" class="required half"/>
						</p>
						<p>
							<label class="required">角色:</label><br/>
							<select id="userRole" name="user.userRole" class="required half">
								<option value="">请选择</option>
								<option value="3">测试用户</option>
								<option value="1">普通用户</option>
							</select>
						</p>
						<p class="box">
							<input type="submit" value="添加" id="" class="btn btn-green big"/>
						</p>
						</fieldset>
					    
					</form>
				</section>
			</div>
			
		</div>
		</div>
		<jsp:include page="../commons/foot.jsp"></jsp:include>
  </body>
</html>
