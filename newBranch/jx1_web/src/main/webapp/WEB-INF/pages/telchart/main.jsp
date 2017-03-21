<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../base.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>模块介绍</title>
  	<link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx}/skin/default/css/main.css" media="all"/>
</head>

<body>
<form>
<div class="textbox"></div>

	<div class="modelDiv">

        <table class="modelTable" cellspacing="1">
        	<tr>
        		<td colspan="2" class="modelTitle">电子报表模块介绍</td>
        	</tr>
        	<tr>
        		<td colspan="2" class="subModelTitle">电子报表模块管理</td>
        	</tr>
        	<tr>
				<td class="model_intro_left">电子报表生成过程：</td>
				<td class="model_intro_right">电子报表前世今生</td>
        	</tr>        	
			<tr>
				<td class="model_intro_left">电子报表</td>
				<td class="model_intro_right">对人员角色进行权限分配, 实现用户权限批量设置, 支持细粒度权限控制分配(菜单、按钮、状态、功能点)。</td>
        	</tr>        	
			<tr>
				<td class="model_intro_left" width="169">部门管理：</td>
				<td class="model_intro_right" width="81%">对企业部门进行维护和管理。</td>
			</tr>
			<tr>
				<td class="model_intro_left" width="169">用户管理：</td>
				<td class="model_intro_right" width="81%">可对系统操作用户进行维护管理, 维护信息包括用户账号、所属部门、功能权限等, 并支持对特殊用户账号锁定禁用操作。
				<br/>管辖部门管辖人员：实现对特定部门, 特定人员分管关系。
				</td>
			</tr>  
			
			<tfoot>
				<tr>
					<td colspan="2" class="tableFooter"></td>
				</tr>
			</tfoot>
        </table>
 
	</div>
</form>
</body>

</html>