		function inputTraceCode(code) {
			var traceCodeValue = document.getElementById("traceCode").value;
			var string = traceCodeValue + code;
			document.getElementById("traceCode").value = "" +string;
		}
		
		function clearTraceCode() {
			document.getElementById("traceCode").value = "";
		}
		
		function deleteTraceCode() {
			var traceCodeValue = document.getElementById("traceCode").value;
			var newValue = traceCodeValue.substring(0,traceCodeValue.length-1);
			document.getElementById("traceCode").value = newValue;
		}
