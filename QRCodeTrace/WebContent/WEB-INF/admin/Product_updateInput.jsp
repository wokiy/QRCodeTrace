<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>公司信息管理</title>
<c:set var="rootPath" value="${pageContext.request.contextPath}/admin" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/menu.js"></script>
</head>

<body>
<!--
<div class="top"></div>
-->
<div id="header">
	<div class="logo">二维码追溯系统管理平台</div>
	<div class="navigation">
		<ul>
		 	<li>欢迎您！</li>
			<li>admin</li>
			<li><a href="${rootPath}/User_loginOut">退出</a></li>
		</ul>
	</div>
</div>
<div id="content">
	<c:import url="public/left_menu.jsp"></c:import>
		<div class="m-right">
			<div class="main" >
			<s:form action="Product_productUpdate" method="post" theme="simple" onsubmit="return checkProductResult()" enctype="multipart/form-data">
			 <s:token></s:token>
                <div style="width:100%; margin-top:10px; margin-left:10px" >
                    <h3><strong>产品信息添加</strong></h3>
                    <br/>
                    <table class="table table-bordered">
                        <tbody>
                        	<tr><td style="width:10%">产品追溯码</td>
                        		<td><s:text name="id"></s:text><s:hidden name="id"></s:hidden></td>
                        	</tr>
                        	<tr><td style="width:10%">产品名称</td>
                        		<td><s:text name="name"></s:text><s:hidden name="name"></s:hidden></td>
                        	</tr>
                            <tr style="height:350px">
                                <td>图片</td>
                                <td><s:if test="#productInfo.pic!=null && #productInfo.pic !=''">
                                	<img width="60px" height="40px" src="${pageContext.request.contextPath}/<s:property value='#productInfo.pic'/>">
                                	<s:hidden name="pic"></s:hidden>
                                </s:if>
                                <s:file name="productImage"><span style="color:red"><s:property value="%{#session.msg}"/></span></s:file></td>
                                <s:fielderror style="color:red"></s:fielderror>
                            </tr>
                        </tbody>
                    </table>
                    <button class="btn btn-default">修改</button>
                    <a href="javascript:history.go(-1)"><button class="btn btn-default" type="button">返回</button></a>
                </div>
                </s:form>
            </div>
		</div>
</div>
<!--
<div class="bottom" ></div>
-->
<div id="footer"><p>Copyright©  2016 来源:<a href="#" target="_blank">丁香苑C416</a></p></div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/check.js"></script>
<script>navList(12);</script>
</body>
<%pageContext.getSession().removeAttribute("msg"); %>
</html>
