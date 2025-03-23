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
<link href="resource/css/style.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="resource/js/jquery.js"></script>
        <script type="text/javascript" src="resource/layer/layer.js"></script>
        <script type="text/javascript" src="resource/commons/hp_layer_helper-v0.1.js"></script>
        <script type="text/javascript" src="resource/js/tableExport/jquery.base64.js"></script>
        <script type="text/javascript" src="resource/js/tableExport/tableExport.js"></script>
        <script>


        </script>
    </head>
    <body>

    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li>查询统计</li>
            <li>客户信息查询</li>
        </ul>
    </div>

    <div class="rightinfo">
    	<div class="tools">
            <ul class="toolbar">
                <li class="click" onclick="$('#tb_doc_m').tableExport({ type: 'excel', separator: ';', escape: 'false' });"><span><img src="resource/images/t01.png"/></span>导出为Excel</li>
            </ul>
        </div>
        <table class="tablelist">
            <thead>
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>诊断</th>
                <th>备注</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${customerList }" var="customer">
	           <tr>
	                <td>${customer.c_id}</td>
	                <td>${customer.c_name}</td>
	                <td><c:if test="${customer.sex == 0}">女</c:if><c:if test="${customer.sex == 1}">男</c:if></td>
	                <td>${customer.diagnosis}</td>
	                <td>${customer.notes==''?'无':customer.notes}</td>
	            </tr>
			</c:forEach>
            </tbody>
        </table>

    </div>

    <script type="text/javascript">
        $('.tablelist tbody tr:odd').addClass('odd');
    </script>

    </body>

</html>