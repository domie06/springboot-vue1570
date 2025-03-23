<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
 	String path = request.getContextPath();
 	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 	pageContext.setAttribute("path", path);
 	pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${basePath}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提交表单功能</title>
<link href="resource/css/style.css" rel="stylesheet" type="text/css" />

</head>
<body style="overflow-x:hidden ">
<div class="formbody">
    
    <div class="formtitle"><span>库存信息</span></div>
    <form action="" method="post" id="inventoryForm">
        <input type="hidden" id="m_id"  class="dfinput" value="${inventory.m_id }">
    <ul class="forminfo">
    <li>
        <label>库存数量</label>
        <input type="text" name="num" id="num" class="dfinput" value="${inventory.num }" onkeyup="this.value=this.value.replace(/\D/g,'')">
    </li>
    <li>
        <label>库存上限</label>
        <input type="text" name="max_num" id="max_num" class="dfinput" value="${inventory.max_num }" onkeyup="this.value=this.value.replace(/\D/g,'')">
    </li>
    <li>
        <label>库存下限</label>
        <input type="text" name="min_num" id="min_num" class="dfinput" value="${inventory.min_num }" onkeyup="this.value=this.value.replace(/\D/g,'')">
    </li>
    <li><label>&nbsp;</label><input type="button" class="btn" id="updateMtBtn" value="确认修改"/></li>
    </ul>
    </form>
    
    </div>
    
    <!-- 引入JQuery -->
    <script type="text/javascript" src="resource/js/jquery.js"></script>
    <!-- 引入role.js -->
    <script type="text/javascript">
	    $("#updateMtBtn").on("click",function(){
	        //有验证
	        var m_id = $("#m_id").val();
	        var num = $("#num").val();
	        if(num===""){
	        	top.layer.alert("库存数量不能为空", {title: "错误提示", icon: 5});
	        	return;
        	}
	        var max_num = $("#max_num").val();
	        if(max_num===""){
	        	top.layer.alert("库存上限不能为空", {title: "错误提示", icon: 5});
	        	return;
        	}
	        var min_num = $("#min_num").val();
	        if(min_num===""){
	        	top.layer.alert("库存下限不能为空", {title: "错误提示", icon: 5});
	        	return;
        	}
	        $.post("sys/inventory/update",{
	        	m_id:m_id,
	        	num:num,
	        	max_num:max_num,
	        	min_num:min_num
	        	},function(data){
                if(data.flag==="success"){
                    parent.layer.closeAll();
                    
                }else{
                    top.layer.alert(data.message, {title: "错误提示", icon: 5});
                }
          }); 
	    });
    </script>
</body>
</html>