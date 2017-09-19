<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>运输详细</title>
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
			<s:form action="Transport_transportUpdate" method="post" theme="simple" onsubmit="return checkAll()">
			 <s:token></s:token>
                <div >
                    <div style="margin:10px">
                        <h3>运输详细列表</h3>
                    </div>
                    <table class="table" style="margin-left:10px; width:100% ">            
                    <thead>
                        <tr>
                            <th style="width:30%">类别</th>
                            <th>内容</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>运输企业名称</td>
                            <td><s:textfield name="companyName"></s:textfield>
                            	<s:hidden name="id"></s:hidden>
                            	<!-- 从material取出product 再从product取出id -->
                            	<s:hidden name="product.id"></s:hidden>
                            </td>
                        </tr>
                        <tr>
                            <td>法人代表</td>
                            <td><s:textfield name="legalPerson"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>运输车辆类型</td>
                            <td><s:textfield name="carType"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>运输车设定温度/℃</td>
                            <td><s:textfield name="temperature"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>运输车相对湿度/%</td>
                            <td><s:textfield name="humidity"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>运输货柜消毒情况</td>
                            <td><s:textfield name="disinfection"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>货物种类</td>
                            <td><s:textfield name="goodsType"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>货物数量</td>
                            <td><s:textfield name="goodsCount"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>运输货来源地</td>
                            <td><s:textfield name="placeFrom"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>运输货目的地地</td>
                            <td><s:textfield name="placeTo"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>运输出发时间</td>
                            <td><s:textfield id="dateValue" name="departureTime" onclick="WdatePicker()" onblur="checkDate();">
                            <s:param name="value"><s:date name="departureTime" format="yyyy-MM-dd"/></s:param>
                            </s:textfield><span id="tip"></span></td>
                        </tr>
                        <tr>
                            <td>运输到达时间</td>
                            <td><s:textfield id="dateValue2" name="arrivalTime" onclick="WdatePicker()" onblur="checkDate2();">
                            <s:param name="value"><s:date name="arrivalTime" format="yyyy-MM-dd"/></s:param>
                            </s:textfield><span id="tip2"></span></td>
                        </tr>
                        <tr>
                            <td>运输负责人姓名</td>
                            <td><s:textfield name="personInCharge"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>运输负责人电话</td>
                            <td><s:textfield name="phone"></s:textfield></td>
                        </tr>
                    </tbody>
                    </table>
                </div>
				<div style="margin-left:30px;margin-top:0px">
                    <s:submit class="btn btn-default" value="修改"></s:submit>
					<a href="${rootPath}/Transport_transportDelete?id=<s:property value='id'/>"><input class="btn btn-default" type="button" value="删除"/></a>
                    <a href="${rootPath}/Product_transportInfoShow"><input class="btn btn-default" type="button" value="返回"/></a>         
                </div>
                </s:form>
			</div>
		</div>
</div>
<!--
<div class="bottom" ></div>
-->
<div id="footer"><p>Copyright©  2016 来源:<a href="#" target="_blank">丁香苑C416</a></p></div>
<script type="text/javascript" src="${pageContext.request.contextPath}/dateWidget/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/check.js"></script>
<script>navList(12);</script>
</body>
</html>
