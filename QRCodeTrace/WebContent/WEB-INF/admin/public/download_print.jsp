<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
  <div style="display: inline;">
	<span style="margin-left:24em">
     <s:if test="#request.productList != null || #request.productList.size >0">
     	<s:form action="Product_productQRCodeBatchDownload" method="post" name="productIdForm" theme="simple" style="display:inline-block" onsubmit="getBatchProductId()">
     		<s:hidden id="batchProductId" name="batchProductId"></s:hidden>
     		<s:hidden name="pageNo" value="%{#request.pageNo}"></s:hidden>
     		<s:hidden id="pageRow" value="%{#request.pageRow}"></s:hidden>
     		<s:hidden id="totalRow" value="%{#request.totalRow}"></s:hidden>
      	<button class="btn btn-default">批量下载</button>
      </s:form>
      <button type="button" class="btn btn-default" onclick="prn_BatchPreview()">批量打印</button>
      <a href="${pageContext.request.contextPath}/software/CLodopPrint_Setup_for_Win32NT.exe" onclick="return confirm('打印功能会使网站加载变慢,确定下载打印环境吗')"><button type="button" class="btn btn-default">打印需要安装环境</button></a>
      </s:if>
   </span>
  </div>
</body>
</html>