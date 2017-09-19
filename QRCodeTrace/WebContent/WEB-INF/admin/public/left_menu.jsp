<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<c:set var="rootPath" value="${pageContext.request.contextPath}/admin" />
	<div class="left_menu">
	<ul id="nav_dot">
        <li>
          <h4 class="M1"><span></span><a href='${rootPath}/Product_productInfoShow'>产品信息管理</a></h4>
		  <!-- <div class="list-item none">
            <a href=''>基本信息</a>
            <a href=''>原料信息</a>
            <a href=''>加工信息</a>
            <a href=''>运输信息</a>
            <a href=''>销售信息</a>
          </div> -->
        </li>
        <li>
          <h4 class="M2"><span></span>公司信息管理</h4>
          <div class="list-item none">
            <a href='${rootPath}/Company_updateInput'>基本信息</a>
            <a href='${rootPath}/Comment_commentInfoShow'>留言管理</a>
            <a href='${rootPath}/News_newsInfoShow'>新闻动态</a>  
            <a href='${rootPath}/Company_frontendInfoShow'>前台管理</a>     
           </div>
        </li>
        <li>
          <h4 class="M3" ><span></span><a href='${rootPath}/User_userInfoShow'>用户管理</a></h4>
        </li>
    </ul>
	</div>
</body>
</html>