<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户组列表</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/themes/gray/easyui.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/themes/icon.css" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/admin/usergroup_org.js"></script>
	<script type="text/javascript">
		$(function(){
		    $("#yhz").addClass("current");
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
			<form id="operatorUsers">
				 <input type="hidden" id="ugId" name="ugId" value="${param.ugId}"/>
				 <div id="userIds"></div>
			</form>
		</div>
	</div>
	<!-- End of Page title -->
	<!-- Page content -->
	<div id="page">
		<!-- Wrapper -->
		<div class="wrapper" >
			<div class="page-content">
				<table>
			<tr>
				<td valign="top"><!--所有用户列表  -->
			  		<div class="searchbox">
						<h3 style="color:93BB3A">所有非组内用户</h3>
					</div>
					<div>
						<table id="notingroup" style="width:443px;"></table>
					</div>
				  </td>
				  <td style="width:80px;" align="middle" valign="center">
				  	<span onclick="orgAdd();" class="btn btn-green big" >&rArr;</span>
				  </td>
			      <td valign="top"><!--组内用户列表  -->
						<div class="searchbox">
							<h3 style="color:93BB3A">组内用户</h3>
						</div>
						<div>
							<table id="ingroup" style="width:443px;"></table>
						</div>
				  </td>
		  	</tr>
		  </table>
			</div>
			
		</div>
		</div>
		<jsp:include page="../commons/foot.jsp"></jsp:include>
  </body>
</html>
