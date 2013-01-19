<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/left.css"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  		<div class="holder">
	    	<h2 class="title">课程中心</h2>
	    	<ul class="nostart">
	    		<li id="t_course"><a href="<%=request.getContextPath()%>/pages/course/t_course_list.jsp">课程</a></li>
	    		<li id="t_work"><a href="<%=request.getContextPath()%>/pages/work/t_work_list.jsp">作业</a></li>
	    		<li id="t_test"><a href="<%=request.getContextPath()%>/pages/test/t_test_list.jsp">测试</a></li>
	    		<li id="t_topic"><a href="<%=request.getContextPath()%>/pages/topic/t_topic_list.jsp">题库</a></li>
	    	</ul>
	    </div>
	    <div class="holder">
	    	<h2 class="title">报表中心</h2>
	    	<ul class="nostart">
	    		<li id="t_stuReport"><a href="<%=request.getContextPath()%>/pages/report/t_stuReport_content.jsp">学生报表</a></li>
	    		<li id="t_clasReport"><a href="<%=request.getContextPath()%>/pages/report/t_clasReport_content.jsp">班级报表</a></li>
	    	</ul>
	    </div>
	    <div class="holder">
	    	<h2 class="title">交流中心</h2>
	    	<ul class="nostart">
	    		<li id="t_inform"><a href="<%=request.getContextPath()%>/pages/inform/t_inform_list.jsp">通知</a></li>
	    		<li id="t_bbs"><a href="<%=request.getContextPath()%>/pages/bbs/t_bbs_list.jsp">讨论区</a></li>
	    	</ul>
	    </div>	


  </body>
</html>
