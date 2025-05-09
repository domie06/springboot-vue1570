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
		<title>进货药品信息</title>
		<link href="${basePath }resource/css/style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="place">
		    <span>位置：</span>
		    <ul class="placeul">
			    <li>药品信息管理</li>
			    <li>添加药品信息</li>
		    </ul>
	    </div>
	    <form method="post" action="${basePath }sys/medicine/add" id="medicineForm">
		    <div class="formbody">
		    	<div class="formtitle"><span>用户信息</span></div>
			    <ul class="forminfo">
				    <li><label>名称</label><input id="m_name" name="m_name" type="text" class="dfinput"/></li>
				    <li><label>厂商</label><input id="manufacturer" name="manufacturer" type="text" class="dfinput"/></li>
				    <li><label>类别</label>
                        <select name="mt_id" id="mt_id" class="dfinput">   
                            <option value="0">请选择类别</option>
                            <c:forEach items="${medicineTypeList }" var="mt" >
                                <option value="${mt.mt_id }">${mt.mt_name }</option> 
                            </c:forEach>
                        </select>  
                    </li> 
				    <li><label>单位</label><input id="untis" name="untis" type="text" class="dfinput"/></li>
				    <li><label>有效期</label><input id="pov" name="pov" type="date" class="dfinput" readonly="readonly" onclick="WdatePicker();"/></li>
				    <li><label>批号</label><input id="batch" name="batch" type="text" class="dfinput"/></li>
				    <li><label>进货价</label><input id="inprice" name="inprice" type="tel" class="dfinput" onkeyup="value=value.replace(/[^\d.]/g,'')" maxlength="11"/></li>
				    <li><label>销售价</label><input id="outprice" name="outprice" type="tel" class="dfinput" onkeyup="value=value.replace(/[^\d.]/g,'')" maxlength="11"/></li>
				    <li><label>备注</label><input id="notes" name="notes" type="text" class="dfinput" /></li>
				    <li><label>&nbsp;</label><input id="addBtn" type="button" class="btn" value="添加"/></li>
			    </ul>
		    </div>
	    </form>
	   	<script type="text/javascript" src="${basePath }resource/js/jquery.js"></script>
	   	<script type="text/javascript" src="${basePath }resource/My97DatePicker/WdatePicker.js"></script>
	   	<script type="text/javascript">
	   		$("#addBtn").on("click",function(){	
	   			var m_name = $("#m_name").val();
	   			var manufacturer = $("#manufacturer").val();
	   			var mt_id = $("#mt_id").val();
	   			var untis = $("#untis").val();
	   			var pov = $("#pov").val();
	   			var batch = $("#batch").val();
	   			var inprice = $("#inprice").val();
	   			var outprice = $("#outprice").val();
	   			var notes = $("#notes").val();
	   			if(m_name === ""){
	   				alert("请输入名称!");
	   				return;
	   			}
	   			if(manufacturer === ""){
	   				alert("请输入厂商!");
	   				return;
	   			}
	   			if(mt_id == 0){
	   				alert("请选择类别!");
	   				return;
	   			}
	   			if(untis === ""){
	   				alert("请输入单位!");
	   				return;
	   			}
	   			if(pov === ""){
	   				alert("请输入有效期!");
	   				return;
	   			}
	   			if(batch === ""){
	   				alert("请输入批号!");
	   				return;
	   			}
	   			if(inprice === ""){
	   				alert("请输入进货价!");
	   				return;
	   			}
	   			if(outprice === ""){
	   				alert("请输入销售价!");
	   				return;
	   			}
	   			if(notes === ""){
	   				alert("请输入备注!");
	   				return;
	   			}
	   			$("#medicineForm").submit();
	   		});	
	   	</script>
	</body>
</html>