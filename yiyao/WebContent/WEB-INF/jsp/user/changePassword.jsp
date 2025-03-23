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
		<title>修改密码</title>
		<link href="${basePath }resource/css/style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="place">
		    <span>位置：</span>
		    <ul class="placeul">
			    <li>系统管理</li>
			    <li>修改密码</li>
		    </ul>
	    </div>
	    <form method="post" action="${basePath }sys/user/changePassword" id="userForm">
		    <div class="formbody">
		    	<div class="formtitle"><span>用户信息</span></div>
				    <input name="user_id" type="hidden" class="dfinput" value="${sessionScope.session_user.user_id}"/>
				    <input id="old_password1" type="hidden" class="dfinput" value="${sessionScope.session_user.password}"/>
			    <ul class="forminfo">
				    <li><label>旧密码</label><input id="old_password"type="password" class="dfinput" maxlength="50"/></li>
				    <li><label>新密码</label><input id="password" name="password" type="password" class="dfinput" maxlength="50"/></li>
				    <li><label>确认新密码</label><input id="password1" type="password" class="dfinput" maxlength="50"/></li>
				    <li><label>&nbsp;</label><input id="addBtn" name="addBtn" type="button" class="btn" value="添加"/><i><font><b>${changeMessage }</b></font></i></li>
			    </ul>
		    </div>
	    </form>
	   	<script type="text/javascript" src="${basePath }resource/js/jquery.js"></script>
	   	<script type="text/javascript">
	   		$("#addBtn").on("click",function(){	
	   			var old_password1 = $("#old_password1").val();
	   			var old_password = $("#old_password").val();
	   			var password = $("#password").val();
	   			var password1 = $("#password1").val();
	   			if(old_password === ""){
	   				alert("请输入旧密码!");
	   				return;
	   			}
	   			if(old_password != old_password1){
                    alert("旧密码有误!");
                    return;
                }
	   			if(password === ""){
	   				alert("请输入新密码!");
	   				return;
	   			}
	   			if(password1 === ""){
	   				alert("请确认新密码!");
	   				return;
	   			}
	   			if(password1 != password){
	   				alert("两次输入新密码不一致!");
	   				return;
	   			}
	   			$("#userForm").submit();
	   		});	
	   	</script>
	</body>
</html>