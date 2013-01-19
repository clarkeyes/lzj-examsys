<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>导入用户</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/themes/gray/easyui.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/themes/icon.css" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.validate_pack.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/validate_regex.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/local/ajaxfileupload.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/admin/user_import.js"></script>
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
			<h1>用户导入
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
					<form id="importUsersForm" method="post">
					    <fieldset>
				    <legend>所需字段</legend>
			    		<p>
							<label class="required">用户表格：</label><br/>
							<input type="file" name="userFile" id="userFile" class="half"/>
						</p>
						<div class="small">说明：Excel文件，文件首行为标题行，需包括账号，姓名。
						<br><br>
						<img src="../../img/userdata.jpg">
						</div>
						<p class="box">
							<input type="submit" value="导入" id="send" class="btn btn-green big"/>
						</p>
						</fieldset>
					 <div id="loading" class="datagrid-mask-msg"></div>   
					</form>
				</section>
			</div>
			
		</div>
		</div>
		<jsp:include page="../commons/foot.jsp"></jsp:include>
  </body>
</html>
