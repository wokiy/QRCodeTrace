		var LODOP; //声明为全局变量  
		var curWwwPath = window.document.location.href;
        //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
        var pathName = window.document.location.pathname;
        var pos = curWwwPath.indexOf(pathName);
        //获取主机地址，如： http://localhost:8083
        var localhostPath = curWwwPath.substring(0, pos);
        //获取带"/"的项目名，如：/uimcardprj
        var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
        
	function newWindow(objId) {
		var productIdHidden = document.getElementById("productId_"+objId);
		var productIdValue = productIdHidden.value;
        // 新窗口的位置
        var awidth=250;   //窗口宽度,需要设置  
		var aheight=225;   //窗口高度,需要设置   
		var atop=(screen.availHeight - aheight)/2;    //窗口顶部位置,一般不需要改  
		var aleft=(screen.availWidth - awidth)/2;  //窗口放中央,一般不需要改
		var params="top=" + atop + ",left=" + aleft + ",width=" + awidth + ",height="   
        + aheight+",resizable=no"+",127.0.0.1=no";
      	//  alert(params);
        var urlPath = localhostPath + projectName + "/admin/Product_productQRCode?id=" + productIdValue
        // alert(urlPath);
		window.open(urlPath, "", params);
	}
	function getBatchProductId() {
		var pageRowValue = document.getElementById("pageRow").value;
		var totalRowValue = document.getElementById("totalRow").value;
		var len = document.getElementById("Rowlength").value;
		var batchProductId = "";
		var hiddenBatchProductId = document.getElementById("batchProductId");
		for(var i=1;i<=len;i++) {
			var productIdValue = document.getElementById("productId_"+i).value;
			
			if(i == len) {
				batchProductId += productIdValue;
			} else {
				batchProductId += productIdValue +",";
			}
		}
		hiddenBatchProductId.value = batchProductId;
		document.productIdForm.submit();
	}
