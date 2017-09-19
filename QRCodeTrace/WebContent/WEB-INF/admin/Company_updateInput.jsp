<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>公司信息管理</title>
<c:set var="rootPath" value="${pageContext.request.contextPath}/admin" />
<script src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/ckeditor/samples/js/sample.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/ckeditor/samples/css/samples.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/ckeditor/samples/toolbarconfigurator/lib/codemirror/neo.css">
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
			<!-- <div class="right-nav">
				<ol class="breadcrumb">
                    <li><a href="#">首页</a></li>
                    <li><a href="#">我的书</a></li>
                    <li class="active">《图解CSS3》</li>
                </ol>
			</div> -->
			<div class="main" >
			<s:form action="Company_companyUpdate" method="post" theme="simple">
			 <s:token></s:token>
                <div style="width:100%; margin-top:10px; margin-left:20px" >
                    <h3><strong>公司基本信息管理</strong></h3>
                    <br/>
                    <table class="table table-bordered">
                        <tr>
                                <td style="width:10%">公司名</td>
                                <td><s:textfield name="name"></s:textfield>
                                <s:hidden name="id"></s:hidden>
                                </td>
                        </tr>
                            <tr>
                                <td>公司地址</td>
                                <td><s:textfield name="address"></s:textfield></td>
                            </tr>
                            <tr>
                                <td>公司电话</td>
                                <td><s:textfield name="phone"></s:textfield></td>
                            </tr>
                            <tr>
                                <td>公司传真</td>
                                <td><s:textfield name="fax"></s:textfield></td>
                            </tr>
                            <tr>
                                <td>公司邮箱</td>
                                <td><s:textfield name="email"></s:textfield></td>
                            </tr>
                            <tr>
                                <td>公司简介</td>
                                <td><s:textarea class="ckeditor" name="introduction" rows="10" cols="70"></s:textarea>  </td>
                            </tr>
                    </table>
                    <button class="btn btn-default">修改</button>
                </div>
                </s:form>
            </div>
		</div>
</div>
<!--
<div class="bottom" ></div>
-->
<div id="footer"><p>Copyright©  2016 来源:<a href="#" target="_blank">丁香苑C416</a></p></div>
<script>navList(12);</script>
</body>
</html>
