	var comment = document.getElementById("message");
	var username = document.getElementById("name");
	
	function checkComment() {
		var nameResult = checkUsername();
		var contentResult = checkContent();
		
		if(contentResult && nameResult) {
			return true;
			document.commentForm.submit();
		} else {
			return false;
		}
	}
	
	function checkUsername() {
		var name = username.value;
		if(name == null || name=="") {
			return false;
		} else {
			return true;
		}
	}
	
	function checkContent() {
		var commentContent = comment.value;
		if(commentContent == null || commentContent == "") {
			return false;
		} else {
			return true;
		}
	}