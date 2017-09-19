<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<c:set var="rootPath" value="${pageContext.request.contextPath}/admin" />
	<s:hidden id="permission" value="%{#session.permissionMsg}"></s:hidden>
    <ul class="nav nav-tabs">
    	<li><a href="${rootPath}/Project_projectInfoShow">商品项目</a></li>
        <li class="active"><a href="${rootPath}/Product_productInfoShow">基本信息</a></li>
        <li><a href="${rootPath}/Product_materialInfoShow">原料信息</a></li>
        <li><a href="${rootPath}/Product_processInfoShow">加工信息</a></li>
        <li><a href="${rootPath}/Product_transportInfoShow">运输信息</a></li>
        <li><a href="${rootPath}/Product_sellInfoShow">销售信息</a></li>
    </ul>
</body>
</html>