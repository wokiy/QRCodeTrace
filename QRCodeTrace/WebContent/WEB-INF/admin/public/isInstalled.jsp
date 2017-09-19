<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/simplePrint.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/LodopFuncs.js"></script>
	<button class="btn btn-default" onclick="CheckIsInstall()">开启打印功能</button>
</body>
<script language="javascript" type="text/javascript">    
	function CheckIsInstall() {	 
		try{ 
		     var LODOP=getLodop(); 
		     if(LODOP == null || LODOP == "undefined" ) {
					alert("没安装");
			  } else {
				  	alert("安装了");
			  }
		 }catch(err){ 
 		 } 
	}; 
</script> 

</html>