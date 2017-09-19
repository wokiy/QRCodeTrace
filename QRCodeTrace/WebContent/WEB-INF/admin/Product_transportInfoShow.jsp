<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>产品信息管理</title>
<c:set var="rootPath" value="${pageContext.request.contextPath}/admin" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/LodopFuncs.js"></script>
<object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0> 
	<embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0></embed>
</object> 
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
                <div >
                <s:hidden id="permission" value="%{#session.permissionMsg}"></s:hidden>
                    <ul class="nav nav-tabs">
                    	<li><a href="${rootPath}/Project_projectInfoShow">商品项目</a></li>
                        <li><a href="${rootPath}/Product_productInfoShow">基本信息</a></li>
                        <li><a href="${rootPath}/Product_materialInfoShow">原料信息</a></li>
                        <li><a href="${rootPath}/Product_processInfoShow">加工信息</a></li>
                        <li class="active"><a href="${rootPath}/Product_transportInfoShow">运输信息</a></li>
                        <li><a href="${rootPath}/Product_sellInfoShow">销售信息</a></li>
                    </ul>
                    <div style="margin:10px">
                        <s:form action="Product_transportProductSearch" theme="simple" style="display:inline-block">
	                        <input name="name" type="text" placeholder="请输入产品名称或追溯码">
	                        <button class="btn btn-default">搜索</button>
                        </s:form>
                       <c:import url="public/download_print.jsp"></c:import>
                    </div>
                    <table class="table" style="margin-left:10px">            
                    <thead>
                        <tr>
                            <th style="width:40%">产品追溯码</th>
                            <th style="width:15%">产品名称</th>
                            <th style="width:20%">产品图片</th>
                            <th style="width:25%">操作</th>
                        </tr>
                    </thead>
                    <tbody>
                      <s:if test="#request.productList != null">
                    <s:iterator var="product" value="%{#request.productList}" status="st">
                        <tr>
                            <td><s:property value="#product.id"/></td>
                            <td><s:property value="#product.name"/></td>
                            <td><img width="60px" height="40px" src="${pageContext.request.contextPath}/<s:property value='#product.pic'/>"></td>
                            <td>
                            <s:url var="urlAdd" action="Transport_addInput">
                            	<s:param name="pro_id" value="%{#product.id}"></s:param>
                            </s:url>
                            <s:url var="urlDesc" action="Transport_updateInput">
                            	<s:param name="pro_id" value="%{#product.id}"></s:param>
                            </s:url>
                            	<s:if test="#product.transport == null">
                            		<a href="<s:property value='%{#urlAdd}'/>"><button class="btn btn-default">添加</button></a>
                            	</s:if>
                            	<s:else>
                            		<a href="<s:property value='%{#urlDesc}'/>"><button class="btn btn-default">详细</button></a>
                            	</s:else>
                            	 <input type="hidden" id="productId_<s:property value='#st.count'/>" value="<s:property value='#product.id'/>"/>
	                            <button id="<s:property value='#st.count'/>" class="btn btn-default" type="button" onclick="newWindow(this.id)">生成二维码</button>
	                            <s:if test="#st.last">
	                            	<s:hidden id="Rowlength" value="%{#st.count}"></s:hidden>
	                            </s:if>
                            </td>
                        </tr>
                     </s:iterator>
                     </s:if>
                     <s:else>
                     	对不起,暂时没有数据
                     </s:else>
                    </tbody>
                    </table>
                </div>
                	<s:if test="#request.pageRow >= #request.totalRow"></s:if>
                    <s:elseif test="#request.pageNo <= 1 || #request.pageNo==null">
	                   <a href="${rootPath}/Product_transportInfoShow?pageNo=<s:property value='#pageNo + 1'/>" style="margin-left:300px" ><button class="btn btn-default" type="button">下一页</button></a>
                       <a href="${rootPath}/Product_transportInfoShow?pageNo=<s:property value='#totalPage'/>"><button class="btn btn-default" type="button">末页</button></a>
                       <span><s:property value="#request.totalRow"/></span>条产品信息
                       &nbsp;&nbsp;1/<s:property value="#request.totalPage"/>
                        <span>
	                        <s:form action="Product_transportInfoShow" style="display:inline-block" theme="simple" onsubmit="return checkPage()">
	                    	跳到<input id="pageNo" name="pageNo" style="height:31px;width:40px;" type="text">页
	                   		<button class="btn btn-default">确定</button>
	                   		</s:form>
                   		</span>
                    </s:elseif>
                    <s:elseif test="#request.pageNo >= #request.totalPage">
                        <a href="${rootPath}/Product_transportInfoShow?pageNo=<s:property value='1'/>" style="margin-left:300px"><button class="btn btn-default" type="button">首页</button></a>
	                    <a href="${rootPath}/Product_transportInfoShow?pageNo=<s:property value='#totalPage-1'/>"><button class="btn btn-default" type="button">上一页</button></a>
	                    <span><s:property value="#request.totalRow"/></span>条产品信息
	                    &nbsp;&nbsp;<s:property value="#request.totalPage"/>/<s:property value="#request.totalPage"/>
                        <span>
	                        <s:form action="Product_transportInfoShow" style="display:inline-block" theme="simple" onsubmit="return checkPage()">
	                    	跳到<input id="pageNo" name="pageNo" style="height:31px;width:40px;" type="text">页
	                   		<button class="btn btn-default">确定</button>
	                   		</s:form>
                   		</span>
	                </s:elseif>
	                <s:else>
	                	<a href="${rootPath}/Product_transportInfoShow?pageNo=<s:property value='1'/>" style="margin-left:300px"><button class="btn btn-default" type="button">首页</button></a>
	                    <a href="${rootPath}/Product_transportInfoShow?pageNo=<s:property value='#pageNo - 1'/>"><button class="btn btn-default" type="button">上一页</button></a>
	                    <a href="${rootPath}/Product_transportInfoShow?pageNo=<s:property value='#pageNo + 1'/>"><button class="btn btn-default" type="button">下一页</button></a>
                        <a href="${rootPath}/Product_transportInfoShow?pageNo=<s:property value='#totalPage'/>"><button class="btn btn-default" type="button">末页</button></a>
                        <span><s:property value="#request.totalRow"/></span>条产品信息
                        &nbsp;&nbsp;<s:property value="#request.pageNo"/>/<s:property value="#request.totalPage"/>
                        <span>
	                        <s:form action="Product_transportInfoShow" style="display:inline-block" theme="simple" onsubmit="return checkPage()">
	                    	跳到<input id="pageNo" name="pageNo" style="height:31px;width:40px;" type="text">页
	                   			<button class="btn btn-default">确定</button>
	                   		</s:form>
                   		</span>
	                </s:else>
			</div>
		</div>
</div>
<!--
<div class="bottom" ></div>
-->
<div id="footer"><p>Copyright©  2016 来源:<a href="#" target="_blank">丁香苑C416</a></p></div>
<% pageContext.getSession().removeAttribute("permissionMsg");
   pageContext.getSession().setAttribute("mark", "uuid");
%>
<script src="${pageContext.request.contextPath}/js/simplePrint.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/permissionTip.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/check.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/qrcode.js"></script>
<script>navList(12);</script>
</body>
</html>
