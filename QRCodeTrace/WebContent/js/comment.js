	var comment = document.getElementById("message");
	var username = document.getElementById("name");
	var qrcode = document.getElementById("website");
	
	var NameTipSpan = document.getElementById("nameTip");
	var codeTipSpan = document.getElementById("codeTip");
	var commentTipSpan = document.getElementById("commentTip");

	function checkComment() {
		var nameResult = checkUsername();
		var codeResult = checkCodeTest();
		var contentResult = checkContent();
		
		if(contentResult && nameResult && codeResult) {
			return true;
			document.commentForm.submit();
		} else {
			return false;
		}
	}
	
	function checkUsername() {
		var name = username.value;
		if(name == null || name=="") {
			var NameTipSpan = document.getElementById("nameTip");
			NameTipSpan.innerHTML = "用户名不能为空".fontcolor("red");
			return false;
		} else {
			return true;
		}
	}
	
	function checkContent() {
		var commentContent = comment.value;
		if(commentContent == null || commentContent == "") {
			var commentTipSpan = document.getElementById("commentTip");
			commentTipSpan.innerHTML = "内容不能为空".fontcolor("red");
			return false;
		} else {
			return true;
		}
	}
	
	function checkCodeTest() {
		var qrcodeContent = qrcode.value;
		if(qrcodeContent == null || qrcodeContent == "") {
			var codeTipSpan = document.getElementById("codeTip");
			codeTipSpan.innerHTML = "追溯码不能为空".fontcolor("red");
			return false;
		} else {
			return true;
		}
	}