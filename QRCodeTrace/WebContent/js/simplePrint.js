var LODOP; //声明为全局变量  
var curWwwPath = window.document.location.href;
//获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
var pathName = window.document.location.pathname;
var pos = curWwwPath.indexOf(pathName);
//获取主机地址，如： http://localhost:8083
var localhostPath = curWwwPath.substring(0, pos);
//获取带"/"的项目名，如：/uimcardprj
var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);

function prn_Preview() {		
	CreatePrintPage();
  	LODOP.PREVIEW();		
};

function prn_Design() {		
	CreatePrintPage();
	LODOP.PRINT_DESIGN();		
};
function CreatePrintPage() {
	var productIdHidden = document.getElementById("productId");
	var productIdValue = productIdHidden.value;
	
    var urlPath = localhostPath + projectName + "/Product_qrCodeProductInfoShow?id=" + productIdValue;
	LODOP.ADD_PRINT_BARCODE(130,434,168,146,"QRCode",urlPath);
	LODOP.SET_PRINT_STYLEA(0,"GroundColor","#FFFFFF");
};	
function prn_BatchPreview() {
	CreateBatchPrintPage();
  	LODOP.PRINT_DESIGN();
}
function CreateBatchPrintPage() {
	
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
	var arr= new Array(); 
	var productIdString = document.getElementById("batchProductId").value;
	arr = productIdString.split(",");
	var standarX = 800;
	
	var x = 200;
	var y = 200;
	for(var i=0;i<arr.length;i++) {
		var urlPath = localhostPath + projectName + "/Product_qrCodeProductInfoShow?id=" + arr[i];
		var count = parseInt(i*x/standarX);
		// ADD_PRINT_BARCODE(top,left,height,width)
		LODOP.ADD_PRINT_BARCODE(count*y,(i*x)-(standarX*count),150,150,"QRCode",urlPath);
		LODOP.SET_PRINT_STYLEA(0,"GroundColor","#FFFFFF");
	}
}
