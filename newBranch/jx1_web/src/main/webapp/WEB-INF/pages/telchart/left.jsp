<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../baselist.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx}/skin/default/css/left.css" media="all"/>
</head>
 
<body id="left_frame">
<div class="PositionFrame_black" id="PositionFrame"></div>
 
 
<!-- begin1  -->
<div id="sidebar" class="sidebar">
	<div class="sidebar_t">
		<div class="sidebar_t_l"></div>
		<div class="sidebar_t_c"></div>
		<div class="sidebar_t_r"></div>
	</div>
        <div class="panel">
        <div class="panel_icon"><img src="${ctx}/skin/default/images/icon/user1_lock.png"/></div>
        <div class="panel-header">
        <div class="panel-title">电子报表</div>
        <div class="panel-content">
			  <ul>
				<li><a href="${ctx}/sysadmin/deptAction_list" onclick="linkHighlighted(this)" target="main" id="aa_1">电子报表入门</a></li>
				<li><a href="${ctx}/sysadmin/userAction_list" onclick="linkHighlighted(this)" target="main" id="aa_1">电子报表生成</a></li>
				<li><a href="${ctx}/sysadmin/roleAction_list" onclick="linkHighlighted(this)" target="main" id="aa_1">电子报表管理</a></li>
				<li><a href="${ctx}/sysadmin/moduleAction_list" onclick="linkHighlighted(this)" target="main" id="aa_1">电子报表分发</a></li>
			</ul>   
			<!-- 引入动态的菜单生成 -->
			<%-- <%@include file="../leftmenu.jsp" %>   --%>
        </div>
        </div>
    </div>
    <div class="sidebar_t">
		<div class="sidebar_b_l"></div>
		<div class="sidebar_t_c"></div>
		<div class="sidebar_b_r"></div>
	</div>  
</div>	


</body>
</html>
