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
            <li>库存管理</li>
            <li>库存信息设置</li>
        </ul>
    </div>

    <div class="rightinfo">
        <table class="tablelist">
            <thead>
            <tr>
                <th>编号</th>
                <th>药品名</th>
                <th>厂商</th>
                <th>批号</th>
                <th>备注</th>
                <th>库存数量</th>
                <th>库存上限</th>
                <th>库存下限</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${inventoryList }" var="inventory">
	            <tr>
	                <td>${inventory.m_id }</td>
	                <td>${inventory.medicine.m_name }</td>
	                <td>${inventory.medicine.manufacturer }</td>
	                <td>${inventory.medicine.batch }</td>
	                <td>${inventory.medicine.notes }</td>
	                <td>${inventory.num }</td>
	                <td>${inventory.max_num }</td>
	                <td>${inventory.min_num }</td>
	                <td><a href="javascript:void(0)" class="tablelink inventoryUpdate" inventoryID="${inventory.m_id }"> 修改</a></td>
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