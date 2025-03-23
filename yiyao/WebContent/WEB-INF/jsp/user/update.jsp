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
		<title>修改用户</title>
		<link href="${basePath }resource/css/style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="place">
		    <span>位置：</span>
		    <ul class="placeul">
			    <li>系统管理</li>
			    <li>修改用户</li>
		    </ul>
	    </div>
	    <form method="post" action="${basePath }sys/user/update" id="userForm">
		    <div class="formbody">
		    	<div class="formtitle"><span>用户信息</span></div>
			    <ul class="forminfo">
				    <li><label>编号</label><input id="user_id" name="user_id" type="tel" class="dfinput" value="${user.user_id }" readonly="readonly"/><i>不可修改</i></li>
				    <li><label>账号</label><input id="account" name="account" type="text" class="dfinput" value="${user.account }" readonly="readonly"/><i>不可修改</i></li>
				    <li><label>姓名</label><input onkeyup="value=value.replace(/[\d]/g,'')" id="user_name" name="user_name" type="text" class="dfinput" maxlength="10" value="${user.user_name }"/><i>姓名不能超过10个字符</i></li>
				    <li><label>资格认证</label><cite><input id="type" name="type" type="radio" value="1"   checked="checked" />医生&nbsp;&nbsp;&nbsp;&nbsp;<input id="type" name="type" type="radio" value="0" />管理员</cite></li>
				    <li><label>&nbsp;</label><input id="updateBtn" name="updateBtn" type="button" class="btn" value="确认修改"/></li>
			    </ul>
		    </div>
	    </form>
	   	<script type="text/javascript" src="${basePath }resource/js/jquery.js"></script>
	   	<script type="text/javascript">
	   		$("#updateBtn").on("click",function(){	
	   			var user_name = $("#user_name").val();
	   			if(user_name === ""){
	   				alert("请输入姓名!");
	   				return;
	   			}
	   			$("#userForm").submit();
	   		});	
	   	</script>
	</body>
</html>