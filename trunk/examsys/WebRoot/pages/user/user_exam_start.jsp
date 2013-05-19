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
	<script type="text/javascript">
		$(function(){
			$("#pks").addClass("current");
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
			
			<s:iterator value="listUserExams"  var="ueM">
			<s:if test="#ueM.ue.ueState==2||#ueM.ue.ueState==3">
				<h3 class="title-article">
					<span class="editarticle">
					<s:if test="#ueM.ue.ueState==2">
						开始考试请注意考场纪律
					</s:if>
					<s:elseif test="#ueM.ue.ueState==3">
						考试进行中
					</s:elseif>
					</span>
					<strong>
						考试名称：${ueM.ue.exam.examName  }
					</strong>
					<div class="pub-type">
						<span class="timestamp">考试时长：${ueM.ue.exam.examTime  }分钟</span>&nbsp;
						<span class="timestamp">卷面分值：${ueM.totalScore}分</span>
						<s:iterator value="#ueM.eqtList" var="eqtM">
							<span class="timestamp">${eqtM.typeName}(${eqtM.typeScore})分</span>
						</s:iterator>
					</div>
				</h3>
				
				<div class="wrapper-login" style=" text-align: center;margin: 20px 200px;">
					<input type="button" value="开始考试" id="send" class="btn btn-green big" onclick="startExam(${ueM.ue.ueId});"/>
				</div>
			</s:if>
			<s:elseif test="#ueM.ue.ueState==4||#ueM.ue.ueState==5">
				<h3 class="title-article">
					<span class="editarticle">
					<s:if test="#ueM.ue.ueState==4">
						已提交
					</s:if>
					<s:elseif test="#ueM.ue.ueState==5">
						判分完毕
					</s:elseif>
					<s:if test="#session.user.userRole==3">
						<span>
							<a onclick="checkAnswer(${ueM.ue.ueId},2);" href="javascript:void(0)";>查看答案</a>
						</span>
					</s:if>
					</span>
					<strong>
						考试名称：${ueM.ue.exam.examName  }
					</strong>
					<div class="pub-type">
						<span class="timestamp">考试时长：${ueM.ue.exam.examTime }分钟 </span>&nbsp;
						<span class="timestamp">卷面分值：${ueM.totalScore}分</span>
						<s:iterator value="#ueM.eqtList" var="eqtM">
							<span class="timestamp">${eqtM.typeName}(${eqtM.typeScore})分</span>
						</s:iterator>
					</div>
				</h3>
				<s:if test="#session.user.userRole==3">
					<div class="wrapper-login" style=" text-align: center;margin: 20px 200px;">
						<input type="button" value="重新考试" id="send" class="btn btn-green big" 
						onclick="restartExam(${ueM.ue.ueId},1);"/>
					</div>
				</s:if>
			</s:elseif>
			</s:iterator>
			
			
				 
			</div>
		</div>
		</div>
		<jsp:include page="../commons/foot.jsp"></jsp:include>
  </body>
</html>
