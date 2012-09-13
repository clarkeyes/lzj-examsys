<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>考试列表</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/themes/gray/easyui.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/themes/icon.css" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
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
					<form id="addVlanForm"action="vlanAdd.action" method="post">
					    <fieldset>
				    <legend>所需字段</legend>
				    	<label class="required" style="color:93BB3A" id="classMsg">类别比例</label>
			    		<p>
							<label class="required">政治理论:</label><br/>
							<input type="text" id="" name="" value="" class="required minInput"/>%
						</p>
						<p>
							<label class="required">公安工作与部队建设：</label><br/>
							<input type="text" id="" name="" value="" class="required minInput"/>%
						</p>
						<p>
							<label class="required">法律法规：</label><br/>
							<input type="text" id="" name="" value="" class="required minInput"/>%
						</p>
						<label class="required" style="color:93BB3A" id="classMsg">题型</label>
						<p>
							<label class="required">单项选择题：</label><br/>
							<input type="text" id="" name="" value="" class="required minInput"/>个
							<input type="text" id="" name="" value="" class="required minInput"/>分
						</p>
						<p>
							<label class="required">多项选择题：</label><br/>
							<input type="text" id="" name="" value="" class="required minInput"/>个
							<input type="text" id="" name="" value="" class="required minInput"/>分
						</p>
						<p>
							<label class="required">判断题：</label><br/>
							<input type="text" id="" name="" value="" class="required minInput"/>个
							<input type="text" id="" name="" value="" class="required minInput"/>分
						</p>
						<p class="box">
							<input type="button" value="生成试卷" id="send" class="btn btn-green big"/>
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
