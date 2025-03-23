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
		<title>药品销售</title>
		<link href="${basePath }resource/css/style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="place">
		    <span>位置：</span>
		    <ul class="placeul">
			    <li>药品销售管理</li>
			    <li>销售退货</li>
		    </ul>
	    </div>
	    <form method="post" action="${basePath }sys/inventory/saleReturn" id="medicineForm">
		    <div class="formbody">
		    	<div class="formtitle"><span>商品信息</span></div>
			    <ul class="forminfo">
					<li><label>顾客id</label><input id="c_id" name="c_id" type="number" class="dfinput" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/></li>
				    <li><label>药品名称</label>
                        <select name="m_id" id="m_id" class="dfinput">   
                            <option value="0">请选择商品</option>
                            <c:forEach items="${medicineList }" var="m" >
                                <option value="${m.m_id }">${m.m_name }</option> 
                            </c:forEach>
                        </select>  
                    </li> 
                    <li><label>数量</label><input id="num" name="num" type="number" class="dfinput" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/></li>
				    <li><label>&nbsp;</label><input id="addBtn" type="button" class="btn" value="退货"/><i><font><b>${addMessage }</b></font></i></li>
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
	   			var c_id = $("#c_id").val();
	   			if(c_id == 0){
	   				alert("请选择顾客!");
	   				return;
	   			}
	   			if(m_id == 0){
	   				alert("请选择药品!");
	   				return;
	   			}
	   			if(num === "" || num === 0 || num === "0"){
	   				alert("请输入退货数量!");
	   				return;
	   			}
	   			$("#medicineForm").submit();
	   		});	
	   	</script>
	</body>
</html>