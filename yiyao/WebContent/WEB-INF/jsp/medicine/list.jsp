<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jstl/fmt_rt"  prefix="fmt"%>
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
        <script>


        </script>
    </head>
    <body>

    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li>药品管理</li>
            <li>药品信息管理</li>
        </ul>
    </div>

    <div class="rightinfo">
         <div class="tools">
         <c:if test="${sessionScope.session_user.type == 0}">
            <ul class="toolbar">
                <li class="click" onclick="javaScript:window.location.href='sys/medicine/add'"><span><img src="resource/images/t01.png"/></span>添加</li>
            </ul>
          </c:if>
            <table>
	            <tr align="center">
	                <td width="10%"><div style="font-size:15px;font-weight: bold">关键字查询</div></td>
	                <td width="30%"><input type="text" id="getKey" class="dfinput" value="${key }"></td>
	                <td width="20%"><input type="button" value="查询" class="btn" onclick="queryKey()";></td>
	                <td width="10%"><input type="button" value="清空" class="btn" onclick="cleanKey()";></td>
	                <td width="15%"><div style="color: red">*可输入药品名称或药品类别</div></td>
	            </tr>
	    	</table>
        </div>
        <table class="tablelist">
            <thead>
            <tr>
                <th>编码</th>
                <th>名称</th>
                <th>厂商</th>
                <th>类别</th>
                <th>单位</th>
                <th>有效期</th>
                <th>批号</th>
                <th>进货价</th>
                <th>销售价</th>
                <th>备注</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${medicineList }" var="medicine">
	           <tr>
	                <td>${medicine.m_id}</td>
	                <td>${medicine.m_name}</td>
	                <td>${medicine.manufacturer}</td>
	                <td>${medicine.medicineType.mt_name}</td>
	                <td>${medicine.untis}</td>
	                <td><fmt:formatDate value="${medicine.pov}" pattern="yyyy年MM月dd日 "/></td>
	                <td>${medicine.batch}</td>
	                <td>${medicine.inprice}</td>
	                <td>${medicine.outprice}</td>
	                <td>${medicine.notes}</td>
	                <td><a href="sys/medicine/update/${medicine.m_id}" class="tablelink"> 修改</a><a href="sys/medicine/delete/${medicine.m_id}" class="tablelink" onClick="return confirm('确定删除?');"> 删除</a></td>
	            </tr>
			</c:forEach>
            </tbody>
        </table>

    </div>

    <script type="text/javascript">
        $('.tablelist tbody tr:odd').addClass('odd');
    </script>

	<script type="text/javascript">
	    function queryKey() {
	        
	        location.href="sys/medicine/list/?key="+$("#getKey").val();
	    }
	    
	    function cleanKey() {
	        $("#key").val(null);
	        location.href="sys/medicine/list";
	    }
    </script>
    </body>

</html>