		// 检查用户名  用户密码  用户权限是否为空
		// alert("haha");
		var userName = document.getElementById("userName");
		var userNameTipSpan = document.getElementById("userNameTip");
		
		var userRole = document.getElementById("userRole");
		var userRoleTipSpan = document.getElementById("userRoleTip");
		
		var userPassword = document.getElementById("userPassword");
		var userPasswordTipSpan = document.getElementById("userPasswordTip");
		
		function userPasswordTip() {
			userPasswordTipSpan.innerHTML = "";
		}
		
		function userNameTip() {
			userNameTipSpan.innerHTML = "";
    	}
		
		
		function checkUserPassword() {
			// alert("hehe")
			userPasswordTipSpan.innerHTML = "";
			var userPasswordValue = userPassword.value;
			if(userPasswordValue == null || userPasswordValue==""){
				userPasswordTipSpan.innerHTML = "密码不能为空".fontcolor("red");
				return false;
			} else {
				return true;
			}
		}
    	
    	function checkUserName() {
    		// alert("hk");
    		userNameTipSpan.innerHTML = "";
    		var userNameValue = userName.value;
    		// alert(userNameTip);
    		if(userNameValue == null || userNameValue == "") {
    			userNameTipSpan.innerHTML = "用户名不能为空".fontcolor("red");
    			return false;
    		} else {
    			return true;
    		}
    	}
    	
    	function checkUserRole() {
    		userRoleTipSpan.innerHTML = "";
    		var userRoleValue = userRole.value;
    		if(userRoleValue < 1 ) {
    			userRoleTipSpan.innerHTML = "权限不能为空".fontcolor("red");
    			return false;
    		} else {
    			return true;
    		}
    	}
    	
    	function checkIdCard() {
    		var idCardValue = document.getElementById("idCard").value;
    		var idCardReg = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
    		if(!idCardReg.test(idCardValue)) {
    			document.getElementById("idCardTip").innerHTML = "身份证格式错误".fontcolor("red");
    			return false;
    		} else {
    			document.getElementById("idCardTip").innerHTML = "";
    			return true;
    		}
    	}
    	
    	function checkEmail() {
    		var emailValue = document.getElementById("email").value;
    		var emailReg = /^(\w)+(\.\w+)*@(\w)+((\.\w{2,3}){1,3})$/;
    		if(!emailReg.test(emailValue)) {
    			document.getElementById("emailTip").innerHTML = "邮箱格式错误".fontcolor("red");
    			return false;
    		} else {
    			document.getElementById("emailTip").innerHTML = "";
    			return true;
    		}
    	}
    	
    	function checkAll() {
    		var userNameResult = checkUserName();
    		var userPasswordResult = checkUserPassword();
    		var userRoleResult = checkUserRole();
    		var checkIdCardResult = checkIdCard();
    		var checkEmailResult = checkEmail();
    		if(userNameResult && userPasswordResult && userRoleResult && checkIdCardResult && checkEmailResult) {
    			return true;
    		} else {
    			alert("请按要求输入");
    			return false;
    		}
    	}
    	
       	function checkUpdateAll() {
    		var userPasswordResult = checkUserPassword();
    		var userRoleResult = checkUserRole();
    		var checkIdCardResult = checkIdCard();
    		var checkEmailResult = checkEmail();
    		// alert("hehe");
    		if(userPasswordResult && userRoleResult && checkIdCardResult && checkEmailResult) {
    			return true;
    		} else {
    			alert("请按要求输入");
    			return false;
    		}
    	}
    	