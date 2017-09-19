			
		// 验证是否填写了页数
		var pageNoWidget = document.getElementById("pageNo");
		function checkPage() {
			// alert("hehe");
			var pageNoValue = pageNoWidget.value;
			var reg = /^[0-9]+$/i;
			if(!reg.test(pageNoValue)) {
				pageNoWidget.value = "";
				return false;
			} else {
				if(parseInt(pageNoValue) >=4294967295) {
					pageNoWidget.value = "";
					return false;
				}
				return true;
			}
		}

		// 验证产品是否选择了名称
		var productNameWidget = document.getElementById("productName");
		var productNameTipSpan = document.getElementById("productNameTip");
		
		function checkProductName() {
			productNameTipSpan.innerHTML = "";
			productNameWidgetValue = productNameWidget.value;
			if(productNameWidgetValue == -1) {
				productNameTipSpan.innerHTML = "请选择产品名称".fontcolor("red");
				return false;
			} else {
				return true;
			}
		}
		
		function checkProductResult() {
			var productNameResult = checkProductName();
			if(productNameResult) {
				return true;
			} else {
				alert("请选择产品名称");
				return false;
			}
		}

		// 验证商品项目代码
		var projectCode = document.getElementById("projectId");
		var projectCodeSpan = document.getElementById("projectIdTip");
		
		function projectCodeTip() {
			projectCodeSpan.innerHTML = "请输入5位非0开头的数字";
		}
		
		function checkProjectCode() {
			projectCodeSpan.innerHTML = "";
			projectCodeValue = projectCode.value;
			var reg = /^[1-9][0-9]{4}$/i;
			if(!reg.test(projectCodeValue)) {
				projectCodeSpan.innerHTML = "格式错误".fontcolor("red");
				return false;
			} else {
				return true;
			}
		}
		
		function checkProjectResult() {
			var projectResult= checkProjectCode();
			if(projectResult) {
				return true;
			} else {
				alert("请按格式输入");
				return false;
			}
		}
		
		
		// 验证时间
		var dateValue2 = document.getElementById("dateValue2");
		var tipSpan2 = document.getElementById("tip2");
		
		var tipSpan = document.getElementById("tip");
    	var dateValue = document.getElementById("dateValue");
    	
    	function dateTip2() {
    		tipSpan2.innerHTML = "格式:yyyy-MM-dd".fontcolor("black");
    	}
    	function dateTip() {
    		tipSpan.innerHTML = "格式:yyyy-MM-dd".fontcolor("black");
    	}
    	
    	function checkDate() {
    		tipSpan.innerHTML = "";
    		var dateContent = dateValue.value;
    		var reg = /^[1-9][0-9]{3}[-][0-1][1-9][-][0-3][1-9]$/i
    		if(!reg.test(dateContent)) {
    			//如果文本内容不符合正则表达式并且文本内容不为空(为空时要提示)
    			tipSpan.innerHTML = "格式错误".fontcolor("red");
    			return false;
    		} else {
    			return true;
    		}
    	}
    	
    	function checkDate2() {
    		tipSpan2.innerHTML = "";
    		var date2Value = dateValue2.value;
    		var reg = /^[1-9][0-9]{3}[-][0-1][1-9][-][0-3][1-9]$/i
    		if(!reg.test(date2Value)) {
    			//如果文本内容不符合正则表达式并且文本内容不为空(为空时要提示)
    			tipSpan2.innerHTML = "格式错误".fontcolor("red");
    			return false;
    		} else {
    			return true;
    		}
    	}
    	
    	function checkAll() {
			//根据各个检测的方法的返回值判定
			var date = checkDate();
			if(dateValue2 !=null) {
			   var dateResult2 = checkDate2();
			} else {
				dateResult2 = true;
			}
			if(date && dateResult2) {
				return true;
			}else {
				alert("请按格式输入");
				return false;
			}
		}
