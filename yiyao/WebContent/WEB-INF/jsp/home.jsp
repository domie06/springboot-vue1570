<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	pageContext.setAttribute("path", path);
	pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE HTML>
<html>
	<head>
		<base href="${basePath}">
		<meta charset="UTF-8">
		<title>后台管理系统</title>

    <!-- 基础定义的样式  -->

    <!-- 后台框架页面样式 -->
    <link rel="stylesheet" href="resource/css2/admin.css" type="text/css"/>
    <!-- 引入字体图表 -->
    <link href="resource/css/Font-Awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <!-- Jquery支持 -->
    <script type="text/javascript" src="resource/js/jquery.js"></script>  
    <!-- Layer支持 -->
    <script type="text/javascript" src="resource/layer/layer.js"></script>
    <!-- 后台框架控制 -->
    <script type="text/javascript" src="resource/js/admin.js"></script>

</head>

<body>
<div class="backAdmin">
    <div class="top">
        <!-- logo  -->
        <div class="topleft">
            <a href="sys/content" target="rightFrame"><img src="resource/images/logo.png" title="系统首页"/></a>
        </div>

        <!-- 首页导航
        <ul class="nav">
            <li><a href="default.html" target="rightFrame" class="selected"><img src="resource/images/icon01.png" title="工作台"/>
                <h2>工作台</h2></a>
            </li>
            <li><a href="javascript:;" target="rightFrame">
                <img src="resource/images/icon02.png" title="模型管理"/>
                <h2>模型管理</h2>
            </a>
            </li>
            <li><a href="imglist.html" target="rightFrame"><img src="resource/images/icon03.png" title="模块设计"/>
                <h2>模块设计</h2></a>
            </li>
            <li><a href="tools.html" target="rightFrame"><img src="resource/images/icon04.png" title="常用工具"/>
                <h2>常用工具</h2></a>
            </li>
            <li><a href="computer.html" target="rightFrame"><img src="resource/images/icon05.png" title="文件管理"/>
                <h2>文件管理</h2></a>
            </li>
            <li><a href="tab.html" target="rightFrame"><img src="resource/images/icon06.png" title="系统设置"/>
                <h2>系统设置</h2></a>
            </li>
        </ul>
        -->

        <div class="topright">
            <ul>
                <li><a href="sys/loginOut" id="loginOut">安全退出</a></li>
            </ul>

            <div class="user">
                <img src="resource/images/i07.png"  alt="用户头像"/>
                <span>${sessionScope.session_user.user_name }</span>
                <!-- 
                <b>5</b>
                 -->
            </div>

        </div>
    </div>

    <div class="left">
        <div class="lefttop">
            <i class="icon-cloud icon-large pull-left icon-border"></i>
            <span>信息导航</span>
        </div>

        <dl class="leftmenu">
<!-- 菜单开始 -->
		
                    <c:if test="${sessionScope.session_user.type == 0}">
			<dd>
                <div class="title">
                    <i class="icon-gears icon-large pull-left icon-border"></i>
                    <span>基础信息管理</span>
                </div>
                <ul class="menuson">
                    <li>
                            <i class="icon-table"></i>
                            <a href="sys/medicine/list" target="rightFrame">药品信息</a>
                    </li>
                    <li>
                            <i class="icon-table"></i>
                            <a href="sys/customer/list" target="rightFrame">客户信息</a>
                    </li>
                    <li>
                            <i class="icon-table"></i>
                            <a href="sys/supplier/list" target="rightFrame">供货商信息</a>
                     </li>
                </ul>
            </dd>
            
            <dd>
                <div class="title">
                    <i class="icon-calendar icon-large pull-left icon-border"></i>
                    <span>进货管理</span>
                </div>
                <ul class="menuson">
                        <li>
                            <i class="icon-list"></i>
                            <a href="sys/log/purchaseList" target="rightFrame">进货单</a>
                        </li>
                        <li>
                            <i class="icon-list"></i>
                            <a href="sys/inventory/add" target="rightFrame">进货</a>
                        </li>
                        <li>
                            <i class="icon-list"></i>
                            <a href="sys/inventory/return" target="rightFrame">退货</a>
                        </li>
                </ul>
            </dd>
            <dd>
                <div class="title">
                    <i class="icon-user-md icon-large pull-left icon-border"></i>
                    <span>库存管理</span>
                </div>
                <ul class="menuson">
                    <li>
	                    <i class="icon-list"></i>
	                    <a href="sys/medicineType/list" target="rightFrame">药品盘点</a>
                    </li>
                    <li>
	                    <i class="icon-list"></i>
	                    <a href="sys/inventory/list" target="rightFrame">库存药品价格调整</a>
                    </li>
                </ul>
            </dd>

            <dd>
                <div class="title">
                    <i class="icon-edit icon-large pull-left icon-border"></i>
                    <span>查询统计</span>
                </div>
                <ul class="menuson">
                    <li>
	                    <i class="icon-list"></i>
	                    <a href="sys/medicine/list2" target="rightFrame">药品信息查询</a>
                    </li>
                    <li>
	                    <i class="icon-list"></i>
	                    <a href="sys/customer/list2" target="rightFrame">客户信息查询</a>
                    </li>
                    <li>
	                    <i class="icon-list"></i>
	                    <a href="sys/supplier/list2" target="rightFrame">供货商信息查询</a>
                    </li>
                    <li>
	                    <i class="icon-list"></i>
	                    <a href="sys/log/saleList" target="rightFrame">销售查询</a>
                    </li>
                    <li>
	                    <i class="icon-list"></i>
	                    <a href="sys/log/returnSaleList" target="rightFrame">销售退货查询</a>
                    </li>
                    <li>
	                    <i class="icon-list"></i>
	                    <a href="sys/log/inbound" target="rightFrame">入库查询</a>
                    </li>
                    <li>
	                    <i class="icon-list"></i>
	                    <a href="sys/log/outbound" target="rightFrame">入库退货查询</a>
                    </li>
                    <li>
	                    <i class="icon-list"></i>
	                    <a href="sys/log/saleChart" target="rightFrame">销售排行统计</a>
                    </li>
                </ul>
            </dd>
            <dd>
                <div class="title">
                    <i class="icon-calendar icon-large pull-left icon-border"></i>
                    <span>系统管理</span>
                </div>
                <ul class="menuson">
                    <li>
                        <i class="icon-home"></i>
                        <a href="sys/user/add" target="rightFrame">用户注册</a>
                    </li>
                    
                    <li>
                        <i class="icon-table"></i>
                        <a href="sys/user/changePassword" target="rightFrame">修改密码</a>
                    </li>
                    <li>
                            <i class="icon-table"></i>
                            <a href="sys/user/list" target="rightFrame">医生管理</a>
                    </li>
                    <li>
                        <i class="icon-list"></i>
                        <a href="sys/backup/toBackup" target="rightFrame">数据备份</a>
                    </li>
                </ul>
                
            </dd>
            </c:if>
            <c:if test="${sessionScope.session_user.type == 1}">
            <dd>
                <div class="title">
                    <i class="icon-calendar icon-large pull-left icon-border"></i>
                    <span>药品销售管理</span>
                </div>
                <ul class="menuson">
                    <li>
                        <i class="icon-list"></i>
                        <a href="sys/inventory/sale" target="rightFrame">药品销售</a>
                    </li>
                    <li>
                        <i class="icon-list"></i>
                        <a href="sys/inventory/saleReturn" target="rightFrame">销售退货</a>
                    </li>
                    <li>
                        <i class="icon-list"></i>
                        <a href="sys/customer/add2" target="rightFrame">添加顾客</a>
                    </li>
                </ul>
                
            </dd>
            </c:if>
<!-- 菜单结束 -->
        </dl>


    </div>
    <div class="right">
        <div class="inner">
            <!-- 设置iframe -->
            <iframe id="rightFrame" name="rightFrame" class="mainIframe" scrolling="no" frameborder="0" src="sys/content"
                    onload="initIframe()"></iframe>
        </div>
    </div>
    <div class="bottom">
        <span>仅供学习交流，请勿用于任何商业用途</span>
        <i> 版权所有 @</i>
    </div>
</div>

<script type="text/javascript">
$(function(){//跟window.onload的区别?
		$("#loginOut").on("click",function(){
			/* if(window.confirm("您确定要退出该系统吗?")){
				window.location.href = "sys/loginOut";
			} */
			//询问框
			layer.confirm('您确定要退出该系统吗?', {
			  btn: ['狠心一下','继续光顾'] 
			}, function(){
			 window.location.href = "${basePath}/sys/loginOut";
			}, function(){
			  
			});
		});

});
</script>

</body>
</html>