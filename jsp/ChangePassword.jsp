$(function() {
	$("#confirmPass").blur(function() {
		var newPass = $("#newPass").val();
		var confirmPass = $("#confirmPass").val();
		if(newPass!=confirmPass) {
			$("#confirmPass").text("两次输入的密码不同，请再次尝试");
		}
		else {
			$("#confirmPass").text("两次输入的密码不同，请再次尝试");
		}
	})
})
function check() {
	var userName = $("#userName").val();
	var oldPass = $("#oldPass").val();
	var newPass = $("#newPass").val();
	var confirmPass = $("#confirmPass").val();
	$.ajax({
		url:"<%=request.getContextPath()%>/changePasswordCheck",
		type:"POST",
		dataType:"text",
		data:
			{
			'userName':userName,
			'oldPass':oldPass,
			'newPass':newPass,
			'confirmPass':confirmPass
			},
		success:function(data) {
			var data = data.trim();
			
		},
		error:function() {
			alert("系统错误2");
			return false;
		}
	})
}
