<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>用户登录</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/login.css" />
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/login/validateLogin.js"></script>
		<script type="text/javascript"></script>
  		<!--[if lt IE 8]>
        <script type="text/javascript">
		    window.onload=function (){
				document.getElementById("title_img").src="img/logo_ie.png";
			}
        </script>
        <![endif]-->

	</head>
	<body>
		<!-- Header -->
		<div class="header" id="top">
			<div class="wrapper-login">
				<!-- Title/Logo - can use text instead of image -->
				<div id="title">
					<!--<span>VEGAGRID</span> demo-->
				</div>
				<!-- Main navigation -->
				<nav id="menu">
				<ul class="sf-menu">
					<li class="current">
						<a href="#">青海省公安消防总队副团职干部双考选拔理论考试系统</a>
					</li>
				</ul>
				</nav>
				<!-- End of Main navigation -->
				<!-- Aside links -->
				<div style="margin-left: 205px; margin-top: 5px;">
				</div>
				<!-- End of Aside links -->
			</div>
		</div>
		<!-- End of Header -->
		<!-- Page title -->
		<div id="pagetitle">
			
		</div>
		<!-- End of Page title -->

		<!-- Page content -->
		<div id="page">
			<!-- Wrapper -->
			<div class="wrapper-login">
				<!-- Login form -->
				<section class="full">

				<h6>&nbsp;</h6>
				
				<div class="box box-info" id="message">
				<span style="margin-left:-20px;margin-top:5px;"><img src="img/information.png"/></span><span style="margin-left:10px;">请输入用户名和密码</span>
				</div>
				<form id="loginForm" name="loginForm" method="post">

					<div>
						<label class="required" style="font-size: 12px">
							&nbsp;用户名:
						</label>
						<label class="error" id="userNameError"></label>
						<br />
						<input type="text" name="loginuser.userAccount" id="userAccount"
							class="full" />
					</div>
					<div>
						<label class="required" style="font-size: 12px">
							&nbsp;密码:
						</label>
						<label class="error" id="passwordError"></label>
						<br />
						<input type="password" name="loginuser.userPassword"
							id="userPassword" class="full" />
					</div>
					<div class="clear">
						&nbsp;
					</div>
					<table style="text-align: center">
						<tr>
							<td>
								<div class="btn btn-green big" id="sub" style="background-color: #6AB620">
									登录
								</div>
							</td>
							<td style="width: 10px;">&nbsp;
								
							</td>
							<td>
								<div class="btn btn-green big" id="res">
									重置
								</div>
							</td>
						</tr>
					</table>
					<div class="clear">
						&nbsp;
					</div>
				</form>

				</section>
				<!-- End of login form -->

			</div>
			<!-- End of Wrapper -->
		</div>
		<!-- Page footer -->
		<div class="footer" id="bottom">
			<div class="wrapper-login">
				<p align="center">
					青海省公安消防部队选拔考试系统
				</p>
			</div>
		</div>
		<!-- End of Page footer -->
	</body>
</html>