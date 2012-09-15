<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>输入成绩</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/themes/gray/easyui.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/themes/icon.css" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.validate_pack.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/validate_regex.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/admin/userscore_add.js"></script>
	<script type="text/javascript">
		$(function(){
		    $("#ks").addClass("current");
		});
	</script>
  </head>
  
  <body id="top">
    <jsp:include page="../commons/head.jsp"></jsp:include>
<!-- Page title -->
	<div id="pagetitle">
		<div class="wrapper">
			<h1>
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
					<form id="addUserScoreForm" method="post">
					    <fieldset>
				    <legend>所需字段</legend>
			    		<p>
							<label class="required">账号：</label><br/>
							<input type="text" id="userAccount" name="userAccount" value="${ue.user.userAccount}" disabled="disabled" class="required half"/>
						</p>
						<p>
							<label class="required">姓名：</label><br/>
							<input type="text" id="userName" name="userName" value="${ue.user.userName}" disabled="disabled" class="required half"/>
						</p>
						<p>
							<label class="required">考试：</label><br/>
							<input type="text" id="examName" name="examName" value="${ue.exam.examName}" disabled="disabled" class="required half"/>
						</p>
						<p>
							<label class="required">成绩：</label><br/>
							<input type="text" id="ueGrade" name="ueGrade" class="required half"/>
						</p>
						<input type="hidden" id="ueId" name="ueId" value="${ue.ueId}"/>
						<input type="hidden" id="examId" name="examId" value="${ue.exam.examId}"/>
						<p class="box">
							<input type="submit" value="提交成绩" id="send" class="btn btn-green big"/>
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
