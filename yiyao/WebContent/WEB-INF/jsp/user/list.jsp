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
    </head>
    <body>

    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li>系统管理</li>
            <li>店员管理</li>
        </ul>
    </div>

    <div class="rightinfo">

        <table class="tablelist">
            <thead>
            <tr>
                <th>编码</th>
                <th>账号</th>
                <th>姓名</th>
                <th>身份</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${userList }" var="user">
	           <tr>
	                <td>${user.user_id}</td>
	                <td>${user.account}</td>
	                <td>${user.user_name}</td>
	                <td><c:if test="${user.type == 1}">医生</c:if></td>
	                <td><a href="sys/user/update/${user.user_id}" class="tablelink"> 修改</a><a href="sys/user/delete/${user.user_id}" class="tablelink" onClick="return confirm('确定删除?');"> 删除</a></td>
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