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
		<title>添加药品信息</title>
		<link href="${basePath }resource/css/style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="place">
		    <span>位置：</span>
		    <ul class="placeul">
			    <li>进货管理</li>
			    <li>进货</li>
		    </ul>
	    </div>
	    <form method="post" action="${basePath }sys/inventory/add" id="medicineForm">
		    <div class="formbody">
		    	<div class="formtitle"><span>商品信息</span></div>
			    <ul class="forminfo">
				    <li><label>药品名称</label>
                        <select name="m_id" id="m_id" class="dfinput">   
                            <option value="0">请选择商品</option>
                            <c:forEach items="${medicineList }" var="m" >
                                <option value="${m.m_id }">${m.m_name }</option> 
                            </c:forEach>
                        </select>  
                    </li> 
                	<li><label>供货商</label>
                        <select name="s_id" id="s_id" class="dfinput">   
                            <option value="0">请选择供货商</option>
                            <c:forEach items="${supplierList }" var="s" >
                                <option value="${s.s_id }">${s.s_name }</option> 
                            </c:forEach>
                        </select>  
                    </li> 
                    <li><label>数量</label><input id="num" name="num" type="number" class="dfinput" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/></li>
				    <li><label>&nbsp;</label><input id="addBtn" type="button" class="btn" value="添加"/><i><font><b>${addMessage }</b></font></i></li>
			    </ul>
		    </div>
	    </form>
	   	<script type="text/javascript" src="${basePath }resource/js/jquery.js"></script>
	   	<script type="text/javascript" src="${basePath }resource/My97DatePicker/WdatePicker.js"></script>
	   	<script type="text/javascript">
	   		$("#addBtn").on("click",function(){	
	   			var num = $("#num").val();
	   			var m_id = $("#m_id").val();
	   			var s_id = $("#s_id").val();
	   			if(m_id === 0){
	   				alert("请选择进货商品!");
	   				return;
	   			}
	   			if(s_id == 0){
	   				alert("请选择供货商!");
	   				return;
	   			}
	   			if(num === "" || num === 0 || num === "0"){
	   				alert("请输入进货数量!");
	   				return;
	   			}
	   			$("#medicineForm").submit();
	   		});	
	   	</script>
	</body>
</html>