<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
	<head>
		<title>考试-内容</title>
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/css/themes/gray/easyui.css" />
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/css/themes/icon.css" />
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/jquery.validate_pack.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/validate_regex.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/user/user_exam_content.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/float.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#customer").smartFloat();
				$("#pks").addClass("current");
			});
		</script>
	</head>

	<body id="top" >
			<style type="text/css">
#customer {
	position: absolute;
	height: 40px;
	width: 880px;
	z-index: 9999999;
}
</style>


		<jsp:include page="../commons/head.jsp"></jsp:include>
		<!-- Page title -->
		<div id="pagetitle">
			<div class="wrapper">
				<h1>
 				考试名称：${ueM.ue.exam.examName} &nbsp;&nbsp;&nbsp;&nbsp;
				</h1>
				<!-- Quick search box -->
				<form action="" method="get">

				</form>
			</div>
		</div>
		<!-- End of Page title -->
		<!-- Page content -->
		<div id="page"">
			<!-- Wrapper -->
			<div class="wrapper"  >
				<div class="page-content">
					<div id="customer">

						<div class="title-article box box-info" style="text-align: center">
								<span>总分：${ueM.totalScore}分</span>&nbsp;&nbsp;&nbsp;&nbsp;
								<span>考试时长：${ueM.ue.exam.examTime}分钟 </span>&nbsp;&nbsp;&nbsp;&nbsp;
								<span> <s:iterator value="ueM.eqtList" var="eqtM">
										<s:if test="#eqtM.typeName=='单选'">
											<a href="#single">${eqtM.typeName}(${eqtM.typeScore})分</a>&nbsp;&nbsp;
										</s:if>
										<s:elseif test="#eqtM.typeName=='多选'">
											<a href="#multiple">${eqtM.typeName}(${eqtM.typeScore})分</a>&nbsp;&nbsp;
										</s:elseif>
										<s:else>
											<a href="#judgment">${eqtM.typeName}(${eqtM.typeScore})分</a>&nbsp;&nbsp;
										</s:else>


									</s:iterator> </span> &nbsp;&nbsp;&nbsp;&nbsp;
								<span id="timer"></span>
								<s:hidden id="retime" name="ueM.remainTime"></s:hidden>
							</div>

					</div>
					<a name="single"></a>
					<div style="height: 100px; overflow: hidden;">
						&nbsp;
					</div>


					<div class="text-article">
						<div>
							<form id="commitUserAnswer" style="overflow: hidden">
								<input type="hidden" name="ueId" value="${ueM.ue.ueId}" />
								<s:iterator value="uqTypeList" var="uqType" status="st">
									<s:if test="#uqType.type==1">
										<div>

											<h3 class="box box-info">
												一、单项选择题（共${uqType.uqNum}题，每题${uqType.typeScore}分）
											</h3>
											<s:iterator value="#uqType.uqModelList" var="uqModel"
												status="singleSt">
												<s:if test="#singleSt.Even">
													<p id="puq_${uqModel.uq.uqId}" class="box timu">
														<input type="hidden"
															name="taList[${st.index}].uaList[${singleSt.index}].uqId"
															value="${uqModel.uq.uqId}" />
														${singleSt.count}、
														<span id="uq_${uqModel.uq.uqId}">${uqModel.uq.questions.quesDes}</span>
														<a href="javascript:void(0)"
															onclick="makeSign(${uqModel.uq.uqId});">标记</a>
														<br />
														<s:iterator value="#uqModel.opList" var="op">
															<input type="radio"
																name="taList[${st.index}].uaList[${singleSt.index}].anList[0]"
																id="answer_${op.optionId}" value="${op.optionOrder}" />
															<label for="answer_${op.optionId}">
																${op.optionDes}
															</label>
															<br />
														</s:iterator>
													</p>
												</s:if>
												<s:else>
													<p id="puq_${uqModel.uq.uqId}" class="timu">
														<input type="hidden"
															name="taList[${st.index}].uaList[${singleSt.index}].uqId"
															value="${uqModel.uq.uqId}" />
														${singleSt.count}、
														<span id="uq_${uqModel.uq.uqId}">${uqModel.uq.questions.quesDes}</span>
														<a href="javascript:void(0)"
															onclick="makeSign(${uqModel.uq.uqId});">标记</a>
														<br />
														<s:iterator value="#uqModel.opList" var="op">
															<input type="radio"
																name="taList[${st.index}].uaList[${singleSt.index}].anList[0]"
																id="answer_${op.optionId}" value="${op.optionOrder}" />
															<label for="answer_${op.optionId}">
																${op.optionDes}
															</label>
															<br />
														</s:iterator>
													</p>

												</s:else>
											</s:iterator>
										</div>
									</s:if>
									<s:elseif test="#uqType.type==2">
									<s:if test="#uqType.uqNum!=0">
										<div>
											<a name="multiple"></a>
											<div style="height: 60px; overflow: hidden;">
												&nbsp;
											</div>
											<h3 class="box box-info">
												二、多项选择题（共${uqType.uqNum}题，每题${uqType.typeScore}分）
											</h3>
											<s:iterator value="#uqType.uqModelList" var="uqModel"
												status="mulSt">
												<s:if test="#mulSt.Even">
													<p id="puq_${uqModel.uq.uqId}" class="box timu">
														<input type="hidden"
															name="taList[${st.index}].uaList[${mulSt.index}].uqId"
															value="${uqModel.uq.uqId}" />
														<span id="uq_${uqModel.uq.uqId}">${mulSt.count}、${uqModel.uq.questions.quesDes}</span>
														<a href="javascript:void(0)"
															onclick="makeSign(${uqModel.uq.uqId});">标记</a>
														<br />
														<s:iterator value="#uqModel.opList" var="op" status="anSt">
															<input type="checkbox"
																name="taList[${st.index}].uaList[${mulSt.index}].anList[${anSt.index}]"
																id="answer_${op.optionId}" value="${op.optionOrder}" />
															<label for="answer_${op.optionId}">
																${op.optionDes}
															</label>
															<br />
														</s:iterator>
													</p>
												</s:if>
												<s:else>
													<p id="puq_${uqModel.uq.uqId}" class="timu">
														<input type="hidden"
															name="taList[${st.index}].uaList[${mulSt.index}].uqId"
															value="${uqModel.uq.uqId}" />
														${mulSt.count}、
														<span id="uq_${uqModel.uq.uqId}">${uqModel.uq.questions.quesDes}</span>
														<a href="javascript:void(0)"
															onclick="makeSign(${uqModel.uq.uqId});">标记</a>
														<br />
														<s:iterator value="#uqModel.opList" var="op" status="anSt">
															<input type="checkbox"
																name="taList[${st.index}].uaList[${mulSt.index}].anList[${anSt.index}]"
																id="answer_${op.optionId}" value="${op.optionOrder}" />
															<label for="answer_${op.optionId}">
																${op.optionDes}
															</label>
															<br />
														</s:iterator>
													</p>

												</s:else>


											</s:iterator>
										</div>
										</s:if>
									</s:elseif>
									<s:elseif test="#uqType.type==3">
										<s:if test="#uqType.uqNum!=0">
										<div>
											<a name="judgment"></a>
											<div style="height: 60px; overflow: hidden;">
												&nbsp;
											</div>
											<h3 class="box box-info">
												三、判断题（共${uqType.uqNum}题，每题${uqType.typeScore}分）
											</h3>
											<s:iterator value="#uqType.uqModelList" var="uqModel"
												status="judgeSt">
												<s:if test="#judgeSt.Even">
													<p id="puq_${uqModel.uq.uqId}" class="box timu">
														<input type="hidden"
															name="taList[${st.index}].uaList[${judgeSt.index}].uqId"
															value="${uqModel.uq.uqId}" />
														${judgeSt.count}、
														<span id="uq_${uqModel.uq.uqId}">${uqModel.uq.questions.quesDes}</span>
														<a href="javascript:void(0)"
															onclick="makeSign(${uqModel.uq.uqId});">标记</a>
														<br />
														<input type="radio"
															name="taList[${st.index}].uaList[${judgeSt.index}].anList[0]"
															id="judge1_${judgeSt.index}" value="1" />
														<label for="judge1_${judgeSt.index}">
															对
														</label>
														<br />
														<input type="radio"
															name="taList[${st.index}].uaList[${judgeSt.index}].anList[0]"
															id="judge2_${judgeSt.index}" value="0" />
														<label for="judge2_${judgeSt.index}">
															错
														</label>
														<br />
													</p>
												</s:if>
												<s:else>
													<p id="puq_${uqModel.uq.uqId}" class="timu">
														<input type="hidden"
															name="taList[${st.index}].uaList[${judgeSt.index}].uqId"
															value="${uqModel.uq.uqId}" />
														${judgeSt.count}、
														<span id="uq_${uqModel.uq.uqId}">${uqModel.uq.questions.quesDes}</span>
														<a href="javascript:void(0)"
															onclick="makeSign(${uqModel.uq.uqId});">标记</a>
														<br />
														<input type="radio"
															name="taList[${st.index}].uaList[${judgeSt.index}].anList[0]"
															id="judge1_${judgeSt.index}" value="1" />
														<label for="judge1_${judgeSt.index}">
															对
														</label>
														<br />
														<input type="radio"
															name="taList[${st.index}].uaList[${judgeSt.index}].anList[0]"
															id="judge2_${judgeSt.index}" value="0" />
														<label for="judge2_${judgeSt.index}">
															错
														</label>
														<br />
													</p>
												</s:else>
												
											</s:iterator>
										</div>
										</s:if>
									</s:elseif>
								</s:iterator>
								<div style="text-align: center; margin-top: 25px">
									<input type="submit" value="交卷" id="send" class="btn btn-green"
										style="width: 150px; font-size: 15px" />
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
