<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	pageContext.setAttribute("path", path);
	pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE HTML>
<html>
	<head>
		<base href="basePath">
		<meta charset="UTF-8">
		<title>添加客户信息</title>
		<link href="${basePath }resource/css/style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="place">
		    <span>位置：</span>
		    <ul class="placeul">
			    <li>药品销售管理</li>
			    <li>增加顾客</li>
		    </ul>
	    </div>
	    <form method="post" action="${basePath }sys/customer/add" id="customerForm">
		    <div class="formbody">
		    	<div class="formtitle"><span>客户信息</span></div>
			    <ul class="forminfo">
				    <li><label>姓名</label><input id="c_name" name="c_name" type="text" class="dfinput"/></li>
				    <li><label>性别</label><cite><input id="sex" name="sex" type="radio" value="1" checked="checked" />男&nbsp;&nbsp;&nbsp;&nbsp;<input id="sex" name="sex" type="radio" value="0" />女</cite></li>
				    <li><label>诊断</label><input id="diagnosis" name="diagnosis" type="text" class="dfinput"/></li>
				    <li><label>备注</label><input id="notes" name="notes" type="text" class="dfinput"/><i>可以为空</i></li>
				    <li><label>&nbsp;</label><input id="addBtn" type="button" class="btn" value="添加"/><i><font><b>${addMessage }</b></font></i></li>
			    </ul>
		    </div>
	    </form>
	   	<script type="text/javascript" src="${basePath }resource/js/jquery.js"></script>
	   	<script type="text/javascript">
	   		$("#addBtn").on("click",function(){	
	   			var c_name = $("#c_name").val();
	   			var diagnosis = $("#diagnosis").val();
	   			if(c_name === ""){
	   				alert("请输入姓名!");
	   				return;
	   			}
	   			if(diagnosis === ""){
	   				alert("请输入诊断信息!");
	   				return;
	   			}
	   			$("#customerForm").submit();
	   		});	
	   	</script>
	</body>
</html>