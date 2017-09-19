<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>二维码</title>
<c:set var="rootPath" value="${pageContext.request.contextPath}/admin" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<script language="javascript" src="${pageContext.request.contextPath}/js/LodopFuncs.js"></script>
<object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0> 
	<embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0></embed>
</object> 

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/menu.js"></script>
</head>
<body>
	<div align="center">
		<img src="${pageContext.request.contextPath}/QRCodes/<s:property value='#request.productId'/>.png" align="middle" />
		<s:hidden id="productId" value="%{#request.productId}"></s:hidden>
		<br/>
		<a href="${rootPath}/Product_productQRCodeDownload?id=<s:property value='#request.productId'/>"><button class="btn btn-default">下载</button></a>
		<input class="btn btn-default" type="button" value="打印设计" name="B3"  onclick="prn_Design()"> 
		
	</div>
</body>
<script src="${pageContext.request.contextPath}/js/simplePrint.js" type="text/javascript"></script>
</html>