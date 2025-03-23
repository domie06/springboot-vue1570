<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt"  prefix="fmt"%>
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
		<title>修改客户信息</title>
		<link href="${basePath }resource/css/style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="place">
		    <span>位置：</span>
		    <ul class="placeul">
			    <li>基础信息管理</li>
			    <li>修改客户信息</li>
		    </ul>
	    </div>
	    <form method="post" action="${basePath }sys/customer/update" id="customerForm">
		    <div class="formbody">
		    	<div class="formtitle"><span>药品信息</span></div>
                    <input name="c_id" type="hidden" value="${customer.c_id }" class="dfinput"/>
			    <ul class="forminfo">
				    <li><label>姓名</label><input id="c_name" name="c_name" type="text" class="dfinput" value="${customer.c_name}"/></li>
				    <li>
				    	<label>性别</label>
					    <cite>
						    <input name="sex" type="radio" value="1" <c:if test="${customer.sex == 1}"> checked="checked" </c:if>/>男&nbsp;&nbsp;&nbsp;&nbsp;
						    <input name="sex" type="radio" value="0"  <c:if test="${customer.sex == 0}"> checked="checked" </c:if> />女
					    </cite>
				    </li>
				    <li><label>申请要求</label><input id="diagnosis" name="diagnosis" type="text" class="dfinput"  value="${customer.diagnosis}"/></li>
				    <li><label>申请要求</label><input id="notes" name="notes" type="text" class="dfinput"  value="${customer.notes}"/></li>
				    <li><label>&nbsp;</label><input id="updateBtn" type="button" class="btn" value="确认修改"/></li>
			    </ul>
		    </div>
	    </form>
	   	<script type="text/javascript" src="${basePath }resource/js/jquery.js"></script>
	   	<script type="text/javascript">
	   		$("#updateBtn").on("click",function(){	
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