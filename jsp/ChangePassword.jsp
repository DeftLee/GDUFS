$(function() {
	$("#confirmPass").blur(function() {
		var newPass = $("#newPass").val();
		var confirmPass = $("#confirmPass").val();
		if(newPass!=confirmPass) {
			$("#confirmPass").text("两次输入的密码不同，请再次尝试");
		}
		else {
			$("#confirmPass").text("");
		}
	});
	
})
function checkName() {
	var userName = $("#userName").val();
	var oldPass = $("#oldPass").val();
	$.ajax({
		url:"<%=request.getContextPath()%>/changePasswordCheckName",
		type:"POST",
		dataType:"text",
		data:
			{
			'userName':userName
			},
		success:function(data) {
			var data = data.trim();
			if(data=="active") {
				$("#userNameInfo").text("");
			}
			else if(data=="notActive") {
				$("#userNameInfo").text("该用户名未激活，不能进行该操作");
			}
			else if(data=="notExist") {
				$("#userNameInfo").text("该用户名不存在，请再试一次");
			}
			else {
				alert("系统错误1");
			}
		},
		error:function() {
			alert("系统错误2");
		}
	})
}
