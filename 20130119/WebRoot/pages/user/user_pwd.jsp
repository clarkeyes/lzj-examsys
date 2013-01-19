<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>密码修改</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/themes/gray/easyui.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/themes/icon.css" />
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.validate_pack.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/validate_regex.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/user/validateUserPwd.js"></script>
		
  </head>
  
  <body >
		<jsp:include page="../commons/head.jsp"></jsp:include>

		<!-- Page title -->
	<div id="pagetitle">
		<div class="wrapper">
			<h1>
				密码修改
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
		<section class="column width6 first">
			<form method="post" id="editUserPwdForm">
			  <fieldset>
			<legend>所需字段</legend>
			  <h3 id="message">${result}</h3>
			<p>
					<label class="required">当前密码:</label><br/>
					<input type="password" id="oldPassword" name="oldPassword" class="half"/>
				</p>
				<p>
					<label class="required">新密码:</label><br/>
					<input type="password" id="newPassword" name="newPassword" class="half"/>
				</p> 
				<p>
					<label class="required">确认密码:</label><br/>
					<input type="password" id="rePassword" name="rePassword" class="half"/>
				</p> 
				<p class="box">
					<input type="submit" value="提交" id="send" class="btn btn-green big"/>
				</p>
					</form>
					</section>
		</div>
		</div>
		<jsp:include page="../commons/foot.jsp"></jsp:include>
  </body>
</html>
