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
			    <li>数据恢复</li>
		    </ul>
	    </div>
	    <form method="post" action="${basePath }sys/backup/restore" id="restoreForm" >
		    <div class="formbody">
		    	<div class="formtitle"><span>恢复信息</span></div>
			    <ul class="forminfo">
				    <li><label>选择文件</label><input id="url" name="url" type="text" class="dfinput" value="d:\\yiyaoBackup\\"/><i>修改请注意格式!例:C:/Users/administrator/Desktop/</i></li>
				    <li><label>&nbsp;</label><input id="btn" type="button" class="btn" value="恢复"/><i><font><b>${message }</b></font></i></li>
			    </ul>
		    </div>
	    </form>
	   	<script type="text/javascript" src="${basePath }resource/js/jquery.js"></script>
	   	<script type="text/javascript">
	   		$("#btn").on("click",function(){	
	   			var url = $("#url").val();
	   			/* if(url.length!=0){
	                var reg = ".*\\.(sql)";
	                var r = url.match(reg);
	                if(r == null){
	                alert("对不起，格式不正确，请重新上传");
	                return;
	                }
	            }else{
                    alert("请选择文件路径!");
                    return;
	            } */
	   			if(url === ""){
                    alert("请选择保存路径!");
                    return;
                }
	   			$("#restoreForm").submit();
	   			});	
	   	</script>
	</body>
</html>