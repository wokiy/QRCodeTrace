					
					
				// 首次访问选中
				clickProduct(1);
				
				function clickProduct(objId) {
					var curWwwPath = window.document.location.href;
			        var pathName = window.document.location.pathname;
			        var pos = curWwwPath.indexOf(pathName);
			        var localhostPath = curWwwPath.substring(0, pos);
			        var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
					
					var objElement = document.getElementById(objId);
					var hiddenElement = document.getElementById("pic_"+objId);
					
					var hiddenValue = hiddenElement.value;
					var picElement = document.getElementById("pic");
					// 清除全部的li的style
					var ulElement = document.getElementById("productUl");
					var arr = ulElement.getElementsByTagName("li");
					for(var i=0;i<arr.length;i++) {
						clearStyle(i + 1);
					}
					// 设置当前选择的li的style
					objElement.style.borderRightColor = "rgb(160, 181, 46)";
					objElement.style.borderRightWidth = "0";
					objElement.style.borderRightStyle = "solid";
					picElement.src= projectName + "/" +hiddenValue;
					
				}
				
				function clearStyle(objId) {
					var objElement = document.getElementById(objId);
					objElement.style.borderRightColor = "";
					objElement.style.borderRightWidth = "";
					objElement.style.borderRightStyle = "";
				}