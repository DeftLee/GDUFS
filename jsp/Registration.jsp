$(function(){
	$("#confirm").blur(function(){
		var password=$("#password").val();
		var confirm=$("#confirm").val();
		if(password!=confirm) {
			$("#PassInfo").text("* 两次输入密码不同");
		}
		else {
			$("#PassInfo").text("");
		}
	});
	$("#email").blur(function() {
		var email=$("#email").val();
		var reg = new RegExp("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])");
		if(!reg.test(email)) {
			$("#emailInfo").text("* 请输入正确的邮箱格式");
		}
		else {
			$("#emailInfo").text("");
		}
	});
	$("#teamType").blur(function() {
		if($(this).val()=="") {
			$("#typeInfo").text("* 请选择所属类型");
		}
		else {
			$("#typeInfo").text("");
		}
	});
	$("#depart").blur(function() {
		if($(this).val()) {
			$("#departInfo").text("* 请选择球队学院");
		}
		else {
			$("#departInfo").text("");
		}
	});
	$("#userName").blur(nameCheck);
	
	/*$("#depart").blur(function() {
		if($(this).val()) {
			$("#departInfo").text("");
		}
	});
	$("#teamType").blur(function() {
		if($(this).val()) {
			$("#typeInfo").text("");
		}
	});
	$("#userName").change(function() {
		$("#userNameInfo").text("");
	});*/
})
function nameCheck() {
	var userName=$("#userName").val();	
	$.ajax({
		url:"<%=request.getContextPath()%>/registrationCheckName",
		type:"POST",
		dataType:"text",
		data:
			{
			'userName':userName
			},
		success:function(data){
			var data = data.trim();
			if(data=="active") {
				$("#userNameInfo").text("* 此用户名已经被注册,请换个用户名");
			}
			else if(data=="notActive") {
				$("#userNameInfo").text("* 此用户名被注册但未激活，请查看邮件激活");
			}
			else if(data=="success") {$("#userNameInfo").text("");			
}
			else {
				alert("Error1";
			}
		},
		error:function(){
			alert("Error2");
		}
	})
}
