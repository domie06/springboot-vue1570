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
		<title>添加用户</title>
		<link href="${basePath }resource/css/style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="place">
		    <span>位置：</span>
		    <ul class="placeul">
			    <li>系统管理</li>
			    <li>用户注册</li>
		    </ul>
	    </div>
	    <form method="post" action="${basePath }sys/user/add" id="userForm">
		    <div class="formbody">
		    	<div class="formtitle"><span>用户信息</span></div>
			    <ul class="forminfo">
				    <li><label>账号</label><input id="account" name="account" type="text" class="dfinput" maxlength="50"  onchange="checkAccount();"/><i><font id="accountMessage"></font></i></li>
				    <li><label>密码</label><input id="password" name="password" type="password" class="dfinput" maxlength="50"/></li>
				    <li><label>确认密码</label><input id="password1" type="password" class="dfinput" maxlength="50"/></li>
				    <li><label>姓名</label><input onkeyup="value=value.replace(/[\d]/g,'')" id="user_name" name="user_name" type="text" class="dfinput" maxlength="10"/><i>姓名不能超过10个字符</i></li>
				    <li><label>类别</label><cite><input id="type" name="type" type="radio" value="1" checked="checked" />医生&nbsp;&nbsp;&nbsp;&nbsp;<input id="type" name="type" type="radio" value="0" />管理员</cite></li>
				    <li><label>&nbsp;</label><input id="addBtn" name="addBtn" type="button" class="btn" value="添加"/><i><font><b>${addMessage }</b></font></i></li>
			    </ul>
		    </div>
	    </form>
	   	<script type="text/javascript" src="${basePath }resource/js/jquery.js"></script>
	   	<script type="text/javascript">
	   		$("#addBtn").on("click",function(){	
	   			var account = $("#account").val();
	   			var password = $("#password").val();
	   			var password1 = $("#password1").val();
	   			var user_name = $("#user_name").val();
	   			if(account === ""){
	   				alert("请输入账号!");
	   				return;
	   			}
	   			if(password === ""){
	   				alert("请输入密码!");
	   				return;
	   			}
	   			if(password1 === ""){
	   				alert("请确认密码!");
	   				return;
	   			}
	   			if(password1 != password){
	   				alert("两次输入密码不一致!");
	   				return;
	   			}
	   			if(user_name === ""){
	   				alert("请输入姓名!");
	   				return;
	   			}
	   			$("#userForm").submit();
	   		});	
	   	</script>
        <script type="text/javascript">
        function checkAccount() {
        	var account = $("#account").val();
        	$.post("checkAccount",{account:account},function(data){
                if(data.flag==="success"){
                	$("#accountMessage").attr("color","green").html("该账号可以使用");
                    
                }else{
                	$("#accountMessage").attr("color","red").html("该账号已被使用,请重新输入新账号");
                	$("#account").val("").focus();
                }
          }); 
		}
        </script>
	</body>
</html>