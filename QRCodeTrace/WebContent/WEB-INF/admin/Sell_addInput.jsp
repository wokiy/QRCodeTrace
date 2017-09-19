<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>销售添加</title>
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
			 <s:form name="sell_form" action="Sell_sellSave" method="post" theme="simple" onsubmit="return checkAll()">
			 <s:token></s:token>
                <div >
                    <div style="margin:10px">
                        <h3>销售添加列表</h3>
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
                            <td>销售企业名称</td>
                            <td><s:textfield name="companyName"></s:textfield>
                           		 <s:hidden name="pro_id" value="%{#request.pro_id}"></s:hidden>
                            </td>
                        </tr>
                        <tr>
                            <td>经营许可证号</td>
                            <td><s:textfield name="license"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>法人代表</td>
                            <td><s:textfield name="logalPerson"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>直接负责人姓名</td>
                            <td><s:textfield name="inChargePerson"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>直接负责人电话</td>
                            <td><s:textfield name="inChargePhone"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>进货日期</td>
                            <td><s:textfield id="dateValue" name="purchaseDate" onclick="WdatePicker()" onblur="checkDate();"></s:textfield>
                            <span id="tip"></span>
                            </td>
                        </tr>
                        <tr>
                            <td>进货数量</td>
                            <td><s:textfield name="purchaseCount"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>产品进货后检验情况</td>
                            <td><s:textfield name="examination"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>检验人</td>
                            <td><s:textfield name="examPerson"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>存货冷库消毒情况</td>
                            <td><s:textfield name="disinfection"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>存货冷库温度/℃</td>
                            <td><s:textfield name="temperature"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>存货冷库相对湿度/%</td>
                            <td><s:textfield name="humidity"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>存货负责人</td>
                            <td><s:textfield name="stockPerson"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>存货负责人联系电话</td>
                            <td><s:textfield name="stockPhone"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>营养标签</td>
                            <td><s:textfield name="nutrition"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>过敏提示</td>
                            <td><s:textfield name="allergy"></s:textfield></td>
                        </tr>
                    </tbody>
                    </table>
                </div>
				<div style="margin-left:30px">
                    <button class="btn btn-default">添加</button>   
                    <a href="${rootPath}/Product_sellInfoShow"><button class="btn btn-default" type="button">返回</button></a>         
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
