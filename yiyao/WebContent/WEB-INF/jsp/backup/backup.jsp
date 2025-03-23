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
		<link href="${basePath }resource/css/style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="place">
		    <span>位置：</span>
		    <ul class="placeul">
			    <li>系统管理</li>
			    <li>数据备份</li>
		    </ul>
	    </div>
	    <form method="post" action="${basePath }sys/backup/backup" id="backupForm">
		    <div class="formbody">
		    	<div class="formtitle"><span>备份信息</span></div>
			    <ul class="forminfo">
				    <li><label>保存路径</label><input id="url" name="url" type="text" class="dfinput" value="d:/yiyaoBackup/"/><i>修改请注意格式!例:C:/Users/administrator/Desktop/</li>
				    <li><label>&nbsp;</label><input id="btn" type="button" class="btn" value="备份"/><i><font><b>${message }</b></font></i></li>
			    </ul>
		    </div>
	    </form>
	   	<script type="text/javascript" src="${basePath }resource/js/jquery.js"></script>
	   	<script type="text/javascript">
	   		$("#btn").on("click",function(){	
	   			var url = $("#url").val();
	   			if(url === ""){
	   				alert("请选择保存路径!");
	   				return;
	   			}
	   			$("#backupForm").submit();
	   		});	
	   	</script>
	</body>
</html>