<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>原料添加</title>
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
			<!-- <div class="right-nav">
				<ol class="breadcrumb">
                    <li><a href="#">首页</a></li>
                    <li><a href="#">我的书</a></li>
                    <li class="active">《图解CSS3》</li>
                </ol>
			</div> -->
			<div class="main" >
			 <s:form name="material_form" action="admin/Material_materialSave" method="post" theme="simple" >
			 <s:token></s:token>
                <div >
                    <div style="margin:10px">
                        <h3>原料添加列表</h3>
                    </div>
                    <table class="table" style="margin-left:10px; width:70% ">            
                    <thead>
                        <tr>
                            <th>类别</th>
                            <th>内容</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>种植企业名称</td>
                            <td><s:textfield name="companyName"></s:textfield>
                           		 <s:hidden name="pro_id" value="%{#request.pro_id}"></s:hidden>
                            </td>
                        </tr>
                        <tr>
                            <td>农产品品质</td>
                            <td><s:textfield name="qulity"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>产地总金属检测结果</td>
                            <td><s:textfield name="heavyMetal"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>施肥情况</td>
                            <td><s:textfield name="fertilization"></s:textfield></td>
                        </tr>
                         <tr>
                            <td>施药情况</td>
                            <td><s:textfield name="medicine"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>农药残留检测结果</td>
                            <td><s:textfield name="pesticide"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>亚硝酸盐检测结果</td>
                            <td><s:textfield name="nitrate"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>微生物检测结果</td>
                            <td><s:textfield name="animalcule"></s:textfield></td>
                        </tr>
                    </tbody>
                    </table>
                </div>
				<div style="margin-left:30px">
                  	<button class="btn btn-default">添加</button>
                    <a href="${rootPath}/Product_materialInfoShow"><button class="btn btn-default" type="button">返回</button></a>         
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
