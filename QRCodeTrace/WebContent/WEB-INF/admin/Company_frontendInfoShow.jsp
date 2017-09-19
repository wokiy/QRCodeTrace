<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                <div >
                    <div style="margin-left: 10px">
                        <h3><strong>前台图片</strong></h3>
                        <br/>
                    </div>
                    <table class="table" style="margin-left:10px;">            
                    <thead>
                        <tr>
                            <th>描述</th>
                            <th>图片</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                       <s:if test="#request.companyInfo != null">
                        <tr>
                           <td>主图片:</td>
                           <td><img width="60px" height="40px" src="${pageContext.request.contextPath}/<s:property value='#companyInfo.mainPic'/>"></td>
                           <td>
                           <s:form action="Company_imgChange" theme="simple" method="post" enctype="multipart/form-data">
                           	<a style="display:inline-block; width:100px; height:40px;position:relative; overflow:hidden;">修改图片
                           		<s:hidden name="sourcefile" value="mainpic"></s:hidden>
                           		<input name="frontendImage" style="position:absolute; right:0; top:0; font-size:100px; opacity:0; filter:alpha(opacity=0);" type="file" class="btn btn-default" onchange="this.form.submit();"/>
                           	</a>
                           	</s:form>
                           </td>
                        </tr>
                        <tr>
                           <td>公司环境1:</td>
                           <td><img width="60px" height="40px" src="${pageContext.request.contextPath}/<s:property value='#companyInfo.enviromentPic1'/>"></td>
                           <td>
                           	<s:form action="Company_imgChange" theme="simple" method="post" enctype="multipart/form-data">
                           		<a style="display:inline-block; width:100px; height:40px;position:relative; overflow:hidden;">修改图片
                           		<s:hidden name="sourcefile" value="pix1"></s:hidden>
                           		<input name="frontendImage" style="position:absolute; right:0; top:0; font-size:100px; opacity:0; filter:alpha(opacity=0);" type="file" class="btn btn-default" onchange="this.form.submit();"/>
                           		</a>
                           	</s:form>
                           </td>
                        </tr>
                        <tr>
                           <td>公司环境2:</td>
                           <td><img width="60px" height="40px" src="${pageContext.request.contextPath}/<s:property value='#companyInfo.enviromentPic2'/>"></td>
                           <td>
                           	<s:form action="Company_imgChange" theme="simple" method="post" enctype="multipart/form-data">
                           		<a style="display:inline-block; width:100px; height:40px;position:relative; overflow:hidden;">修改图片
                           		<s:hidden name="sourcefile" value="pix2"></s:hidden>
                           		<input name="frontendImage" style="position:absolute; right:0; top:0; font-size:100px; opacity:0; filter:alpha(opacity=0);" type="file" class="btn btn-default" onchange="this.form.submit();"/>
                           		</a>
                           	</s:form>
                           </td>
                        </tr>
                        <tr>
                           <td>公司环境3:</td>
                           <td><img width="60px" height="40px" src="${pageContext.request.contextPath}/<s:property value='#companyInfo.enviromentPic3'/>"></td>
                           <td>
                           	<s:form action="Company_imgChange" theme="simple" method="post" enctype="multipart/form-data">
                           		<a style="display:inline-block; width:100px; height:40px;position:relative; overflow:hidden;">修改图片
                           		<s:hidden name="sourcefile" value="pix3"></s:hidden>
                           		<input name="frontendImage" style="position:absolute; right:0; top:0; font-size:100px; opacity:0; filter:alpha(opacity=0);" type="file" class="btn btn-default" onchange="this.form.submit();"/>
                           		</a>
                           	</s:form>
                           </td>
                        </tr>
                        <tr>
                           <td>公司环境4:</td>
                           <td><img width="60px" height="40px" src="${pageContext.request.contextPath}/<s:property value='#companyInfo.enviromentPic4'/>"></td>
                           <td>
                           	<s:form action="Company_imgChange" theme="simple" method="post" enctype="multipart/form-data">
                           		<a style="display:inline-block; width:100px; height:40px;position:relative; overflow:hidden;">修改图片
                           		<s:hidden name="sourcefile" value="pix4"></s:hidden>
                           		<input name="frontendImage" style="position:absolute; right:0; top:0; font-size:100px; opacity:0; filter:alpha(opacity=0);" type="file" class="btn btn-default" onchange="this.form.submit();"/>
                           		</a>
                           	</s:form>
                           </td>
                        </tr>
                        <tr>
                           <td>公司环境5:</td>
                           <td><img width="60px" height="40px" src="${pageContext.request.contextPath}/<s:property value='#companyInfo.enviromentPic5'/>"></td>
                           <td>
                           	<s:form action="Company_imgChange" theme="simple" method="post" enctype="multipart/form-data">
                           		<a style="display:inline-block; width:100px; height:40px;position:relative; overflow:hidden;">修改图片
                           		<s:hidden name="sourcefile" value="pix5"></s:hidden>
                           		<input name="frontendImage" style="position:absolute; right:0; top:0; font-size:100px; opacity:0; filter:alpha(opacity=0);" type="file" class="btn btn-default" onchange="this.form.submit();"/>
                           		</a>
                           	</s:form>
                           </td>
                        </tr>
                        <tr>
                           <td>公司环境6:</td>
                           <td><img width="60px" height="40px" src="${pageContext.request.contextPath}/<s:property value='#companyInfo.enviromentPic6'/>"></td>
                           <td>
                           	<s:form action="Company_imgChange" theme="simple" method="post" enctype="multipart/form-data">
                           		<a style="display:inline-block; width:100px; height:40px;position:relative; overflow:hidden;">修改图片
                           		<s:hidden name="sourcefile" value="pix6"></s:hidden>
                           		<input name="frontendImage" style="position:absolute; right:0; top:0; font-size:100px; opacity:0; filter:alpha(opacity=0);" type="file" class="btn btn-default" onchange="this.form.submit();"/>
                           		</a>
                           	</s:form>
                           </td>
                        </tr>
                        <tr>
                           <td>公司环境7:</td>
                           <td><img width="60px" height="40px" src="${pageContext.request.contextPath}/<s:property value='#companyInfo.enviromentPic7'/>"></td>
                           <td>
                           	<s:form action="Company_imgChange" theme="simple" method="post" enctype="multipart/form-data">
                           		<a style="display:inline-block; width:100px; height:40px;position:relative; overflow:hidden;">修改图片
                           		<s:hidden name="sourcefile" value="pix7"></s:hidden>
                           		<input name="frontendImage" style="position:absolute; right:0; top:0; font-size:100px; opacity:0; filter:alpha(opacity=0);" type="file" class="btn btn-default" onchange="this.form.submit();"/>
                           		</a>
                           	</s:form>
                           </td>
                        </tr>
                        <tr>
                           <td>公司环境8:</td>
                           <td><img width="60px" height="40px" src="${pageContext.request.contextPath}/<s:property value='#companyInfo.enviromentPic8'/>"></td>
                           <td>
                           	<s:form action="Company_imgChange" theme="simple" method="post" enctype="multipart/form-data">
                           		<a style="display:inline-block; width:100px; height:40px;position:relative; overflow:hidden;">修改图片
                           		<s:hidden name="sourcefile" value="pix8"></s:hidden>
                           		<input name="frontendImage" style="position:absolute; right:0; top:0; font-size:100px; opacity:0; filter:alpha(opacity=0);" type="file" class="btn btn-default" onchange="this.form.submit();"/>
                           		</a>
                           	</s:form>
                           </td>
                        </tr>
                     </s:if>
                     <s:else>
                     	对不起,暂时没有数据
                     </s:else>
                    </tbody>
                    </table>
                </div>
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
</html>
