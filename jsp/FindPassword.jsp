function check() {
		var userName=$("#userName").val();
		var email=$("#email").val();
		$.ajax({
			url:"<%=request.getContextPath()%>/findPasswordCheck",
			type:"POST",
			dataType:"text",
			data:
				{
				'userName':userName,
				'email':email
				},
			success:function(data) {
				var data = data.trim();
				if(data=="notActive") {
					$("#userNameInfo").text("该帐号未激活，无法进行操作。");
					return false;
				}
				else if(data="notExist") {
					$("#userNameInfo").text("该用户名不存在。");
					return false;
				}
				else if(data=="wrong") {
					$("#emailInfo").text("该邮箱不是注册时的邮箱。");
					return false;
				}
				else if(data=="right") {
					return true;
				}
				else {
					alert("系统错误1");
					return false;
				}
			},
			error:function() {
				alert("系统错误2");
				return false;
			}
		})
	}
