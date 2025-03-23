<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
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
            $(function () {
                //绑定添加事件
                $(".inventoryUpdate").click(function () {
                    top.layer.open({
                        type: 2,
                        area: ['700px', '530px'],
                        fix: false, //不固定
                        maxmin: true,
                        content: 'sys/inventory/update/'+$(this).attr('inventoryID'),
                        end: function () {
                            location.reload();
                        }
                    })
                })

            });


        </script>

    </head>
    <body>

    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li>查询统计</li>
            <li>销售退货查询</li>
        </ul>
    </div>

    <div class="rightinfo">
    	<div class="tools">
            <ul class="toolbar">
                <li class="click" onclick="$('#tb_doc_m').tableExport({ type: 'excel', separator: ';', escape: 'false' });"><span><img src="resource/images/t01.png"/></span>导出为Excel</li>
            </ul>
        </div>
        <table class="tablelist"  id="tb_doc_m">
            <thead>
            <tr>
                <th>序号</th>
                <th>顾客</th>
                <th>药品名</th>
                <th>退货数量</th>
                <th>医生</th>
                <th>销售时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${logList }" var="log" varStatus="status">
	            <tr>
	                <td>${status.index + 1 }</td>
	                <td>${log.c_name }</td>
	                <td>${log.m_name }</td>
	                <td>${log.m_num }</td>
	                <td>${log.user_name }</td>
	                <td><fmt:formatDate value="${log.l_date }" type="both"/></td>
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