<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>考试-内容</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/themes/gray/easyui.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/themes/icon.css" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
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
				 <h3 class="title-article">
					<span class="editarticle">
						未完成
					</span>
					<strong>
						基础语言测试
					</strong>
					<div class="pub-type">
						<span class="timestamp">时长：90分钟 </span>
					</div>
				</h3>
				<div class="text-article">
					<div>
						<form action="">
							<div>
								<h3>单项选择题</h3>
								<p>
									试题1：<span>基础语言类型分为几种？</span><a href="">标记</a><br/>
									<input type="radio" name="_answer" id="_answer0" value="8"/>
									<label>A.2</label><br/>
									<input type="radio" name="_answer" id="_answer1" value="4"/>
									<label>B.4</label><br/>
									<input type="radio" name="_answer" id="_answer2" value="2"/>
									<label>C.6</label><br/>
									<input type="radio" name="_answer" id="_answer3" value="1"/>
									<label>D.8</label>
								</p>
							</div>
							<div>
								<h3>多项选择题</h3>
								<p>
									试题1：<span>基础语言类型分为几种？</span><a href="">标记</a><br/>
									<input type="checkbox" name="answer1" id="_answer0" value="8"/>
									<label>A.2</label><br/>
									<input type="checkbox" name="answer2" id="_answer1" value="4"/>
									<label>B.4</label><br/>
									<input type="checkbox" name="answer3" id="_answer2" value="2"/>
									<label>C.6</label><br/>
									<input type="checkbox" name="answer4" id="_answer3" value="1"/>
									<label>D.8</label>
								</p>
							</div>
							<div>
								<h3>判断题</h3>
								<p>
									试题2：<span>浮点型分为float和double两种</span><a href="">标记</a><br/>
									<input type="radio" name="id_answer" id="id_answer0" value="1"/>
									<label>对</label><br/>
									<input type="radio" name="id_answer" id="id_answer1" value="0"/>
									<label>错</label>
								</p>
							</div>
							<p>
								<input type="button" value="交卷" id="send" class="btn btn-green big"/>
							</p>
							
						</form>
					</div>
				</div>
			</div>
		</div>
		</div>
		<jsp:include page="../commons/foot.jsp"></jsp:include>
  </body>
</html>
