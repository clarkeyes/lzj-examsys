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
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.validate_pack.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/validate_regex.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/user/user_exam_content.js"></script>
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
						<s:if test="ue.ueState==3">
							考试进行中
						</s:if>
						<s:elseif test="ue.ueState==4">
							已提交
						</s:elseif>
					</span>
					<strong>
						考试名称：${ue.exam.examName}
					</strong>
					<div class="pub-type">
						<span class="timestamp">考试时长：${ue.exam.examTime}分钟 </span>
					</div>
				</h3>
				<div class="text-article">
					<div>
						<form id="commitUserAnswer">
							<input type="hidden" name="ueId" value="${ue.ueId}"/>
							<s:iterator value="uqTypeList" var="uqType" status="st">
								<s:if test="#uqType.type==1">
									<div>
										<h3>单项选择题（共${uqType.uqNum}题，每题${uqType.typeScore}分）</h3>
										<s:iterator value="#uqType.uqModelList" var="uqModel" status="singleSt">
											<p>
												<input type="hidden" name="taList[${st.index}].uaList[${singleSt.index}].uqId" value="${uqModel.uq.uqId}"/>
												试题${singleSt.count}：<span>${uqModel.uq.examQuestion.questions.quesDes}</span><br/>
												<s:iterator value="#uqModel.opList" var="op">
													<input type="radio" name="taList[${st.index}].uaList[${singleSt.index}].anList[0]" id="answer" value="${op.optionOrder}"/>
													<label>${op.optionDes}</label><br/>
												</s:iterator>
											</p>
										</s:iterator>
									</div>
								</s:if>
								<s:elseif test="#uqType.type==2">
									<div>
										<h3>多项选择题（共${uqType.uqNum}题，每题${uqType.typeScore}分）</h3>
										<s:iterator value="#uqType.uqModelList" var="uqModel" status="mulSt">
											<p>
												<input type="hidden" name="taList[${st.index}].uaList[${mulSt.index}].uqId" value="${uqModel.uq.uqId}"/>
												试题${mulSt.count}：<span>${uqModel.uq.examQuestion.questions.quesDes}</span><br/>
												<s:iterator value="#uqModel.opList" var="op" status="anSt">
													<input type="checkbox" name="taList[${st.index}].uaList[${mulSt.index}].anList[${anSt.index}]" id="answer" value="${op.optionOrder}"/>
													<label>${op.optionDes}</label><br/>
												</s:iterator>
											</p>
										</s:iterator>
									</div>
								</s:elseif>
								<s:elseif test="#uqType.type==3">
									<div>
										<h3>判断题（共${uqType.uqNum}题，每题${uqType.typeScore}分）</h3>
										<s:iterator value="#uqType.uqModelList" var="uqModel" status="judgeSt">
											<p>
												<input type="hidden" name="taList[${st.index}].uaList[${judgeSt.index}].uqId" value="${uqModel.uq.uqId}"/>
												试题${judgeSt.count}：<span>${uqModel.uq.examQuestion.questions.quesDes}</span><br/>
												<input type="radio" name="taList[${st.index}].uaList[${judgeSt.index}].anList[0]" id="answer" value="1"/>
												<label>对</label><br/>
												<input type="radio" name="taList[${st.index}].uaList[${judgeSt.index}].anList[0]" id="answer" value="0"/>
												<label>错</label><br/>
											</p>
										</s:iterator>
									</div>
								</s:elseif>
							</s:iterator>
							<div style="text-align: center;margin-top: 25px">
								<input type="submit" value="交卷" id="send" style="width: 200px;height: 60px;font-size:15px" />
							</div>
							
						</form>
					</div>
				</div>
			</div>
		</div>
		</div>
		<jsp:include page="../commons/foot.jsp"></jsp:include>
  </body>
</html>
