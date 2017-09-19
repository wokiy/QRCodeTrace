<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户管理</title>
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
			<s:form action="User_userUpdate" method="post" enctype="multipart/form-data" theme="simple" onsubmit="return checkUpdateAll()">
			 <s:token></s:token>
                <div >
                    <div style="margin:10px">
                        <h3><strong>用户添加列表</strong></h3>
                        <br/>
                    </div>
                    <table class="table" style="margin-left:10px; width:45%">            
                       <tr>
                            <td style="width:20%">用户名</td>
                            <td><s:text name="userName"></s:text>
                            	<s:hidden name="userName"></s:hidden>
                            </td>
                        </tr>
                        <tr>
                            <td>密码</td>
                            <td><s:textfield id="userPassword" name="password" onfocus="userPasswordTip()" onblur="checkUserPassword()"></s:textfield><span id="userPasswordTip"></span> </td>
                        </tr>
                        <tr>
                            <td>权限</td>
                            <s:set name="roleList" value="#{'-1':'-----请选择权限-----','1':'material','2':'process','3':'transport','4':'sell','5':'all'}"></s:set>
                            <td><s:select id="userRole" name="role" list="#roleList" onblur="checkUserRole()">
                            </s:select><span id="userRoleTip"></span> </td>
                        </tr>
                        <tr>
                            <td>法人代表</td>
                            <td><s:textfield name="realName"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>公司地址</td>
                            <td><s:textfield name="address"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>身份证</td>
                            <td><s:textfield id="idCard" name="idCard" onblur="checkIdCard()"></s:textfield><span id="idCardTip"></span></td>
                        </tr>
                        <tr>
                            <td>执照编码</td>
                            <td><s:textfield name="licenseNumber"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>执照图片</td>
                            <td>
                            	<s:if test="#userInfo.licensePic !=null && #userInfo.licensePic != ''">
                            	<img width="80" height="80" src="${pageContext.request.contextPath}/<s:property value='#userInfo.licensePic'/>">
                            	</s:if>
                            	<s:file name="licensePicImage"></s:file>
                             </td>
                        </tr>
                        <tr>
                            <td>联系方式</td>
                            <td><s:textfield name="phone"></s:textfield></td>
                        </tr>
                        <tr>
                            <td>电子邮箱</td>
                            <td><s:textfield id="email" name="email" onblur="checkEmail()"></s:textfield><span id="emailTip"></span></td>
                        </tr>
                    </table>
                </div>
				<div style="margin-left:30px">
                    <button class="btn btn-default">保存修改</button>
                    <a href="javascript:history.go(-1)"><button type="button" class="btn btn-default">返回</button></a>            
                </div>
                </s:form>
			</div>
		</div>
</div>
<!--
<div class="bottom" ></div>
-->
<div id="footer"><p>Copyright©  2016 来源:<a href="#" target="_blank">丁香苑C416</a></p></div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/checkUser.js"></script>
<script>navList(12);</script>
</body>
</html>
