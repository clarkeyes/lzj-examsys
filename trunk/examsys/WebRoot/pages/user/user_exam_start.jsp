<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>考试</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/themes/gray/easyui.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/themes/icon.css" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/user/user_exam_start.js"></script>
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
			
			<s:iterator value="listUserExams"  var="lue">
			
			<input type="hidden" name="ueId" value="${lue.ueId}"/>
			<h3 class="title-article">
					<span class="editarticle">
					请注意考场纪律
					</span>
					<strong>
						考试名称：${lue.exam.examName  }
					</strong>
					<div class="pub-type">
						<span class="timestamp">考试时长：${lue.exam.examTime  }分钟 </span>
					</div>
				</h3>
				
				<div class="wrapper-login" style=" text-align: center;">
				<p>
					<input type="button" value="开始考试" id="send" class="btn btn-green big" onclick="startExam(${lue.ueId});"/>
				</p>
				</div>
			</s:iterator>
			
			
				 
			</div>
		</div>
		</div>
		<jsp:include page="../commons/foot.jsp"></jsp:include>
  </body>
</html>
