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
	<body style="background-color: #fff">
		

		<!-- Page content -->
		<div id="page" >
			<!-- Wrapper -->
			<div class="wrapper" style="position:relative; background: url('img/zsjs.jpg') no-repeat;height: 652px;width: 890px;">
				<!-- Login form -->
				<div style="position: absolute;top: 280px;left:400px;width: 310px">
				<div  id="message">
				</div>
				<form id="loginForm" name="loginForm" method="post">

					<div>
						<label class="required" style="font-size: 14px">
							&nbsp;用户名:
						</label>
						<label class="error" id="userNameError"></label>
						<br />
						<input  type="text" name="loginuser.userAccount" id="userAccount"
							class="full" />
					</div>
					<div>
						<label class="required" style="font-size: 14px">
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
					<table style="text-align: center;">
						<tr>
							<td>
								<div  id="sub" style="position:relative; font-size:14px;font-weight:bold; cursor: pointer;background: url('img/bgbtn.png') no-repeat;width: 80px;height: 37px">
									<span style="position:relative;top:9px" >登录</span>
								</div>
							</td>
							<td style="width: 10px;">&nbsp;
								
							</td>
							<td>
								<div id="res" style="position:relative; font-size:14px;font-weight:bold; cursor: pointer;background: url('img/bgbtn.png') no-repeat;width: 80px;height: 37px" >
									<span style="position:relative;top:9px" >重置</span>
								</div>
							</td>
						</tr>
					</table>
					<div class="clear">
						&nbsp;
					</div>
				</form>
				</div>

				<!-- End of login form -->

			</div>
			<!-- End of Wrapper -->
		</div>
	</body>
</html>