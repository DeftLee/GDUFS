<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link href='http://fonts.useso.com/css?family=Open+Sans:400,300,400italic,700' rel='stylesheet' type='text/css'>
	<link href="static/css/font-awesome.min.css" rel="stylesheet">
	<link href="static/css/font-face.css" rel="stylesheet">
	<link href="static/css/bootstrap.min.css" rel="stylesheet">
	<link href="static/css/templatemo-style.css" rel="stylesheet">
	<style>
		span {font-size:16px;text-align:left;height:34px;line-height:34px}
		body {  
			background: url("static/images/bk5.jpg") center center;
			background-size: cover;
			position: relative;
		}
	</style>
	<script src="static/js/jquery-1.11.2.min.js"></script>
<title>Registration</title>
</head>
<body class="light-gray-bg">
	<br />
	<br />
	<div class="templatemo-content-widget templatemo-login-widget white-bg" style="padding:0px">
		<div class="panel panel-info">
			<div class="panel-headding" style="background:#428bca;height:46px;line-height:46px;text-align:center">
				<h1><strong>球队注册</strong></h1>
			</div>
        	<div class="panel-body">
				<form role="form" id="defaultForm" method="post" action="registrationDO" class="form-horizontal" onsubmit="return regist()">
                	<div class="form-group">						
						<span class="col-md-3">球队名称</span>	
						<div class="col-md-9">						
                            <input class="form-control" name="userName" id="userName" required="required" placeholder="球队名称"/>                                
                        </div>                                                                                  
                  	</div>
                  	<p id="userNameInfo" style="color:red;font-size:13px;text-align:center"></p>
                  	<div class="form-group">
                  		<span class="col-md-3">密码</span>
                        <div class="col-md-9">
                        	<input type="password" class="form-control" name="password"  id="password" required="required" maxlength="12" placeholder="输入密码"/>                              
                        </div> 
                    </div>
                    <p id="paInfo" style="color:red;font-size:13px;text-align:center"></p>
                    <div class="form-group">
                  		<span class="col-md-3">确认密码</span>
                        <div class="col-md-9">
                        	<input type="password" class="form-control" name="confirm"  id="confirm" required="required" maxlength="18" placeholder="确认密码"/>                              
                        </div>
                    </div>
                    <p id="PassInfo" style="color:red;font-size:13px;text-align:center"></p>
                  	<div class="form-group">
                  		<span class="col-md-3">邮箱</span>
                        <div class="col-md-9">
                        	<input type="email" class="form-control" name="email" id="email" required="required" placeholder="输入邮箱"/>
                        </div>
                  	</div>
                  	<p id="emailInfo" style="color:red;font-size:13px;text-align:center"></p>
                  	<div class="form-group">
                  		<span class="col-md-3">所属学院</span>
                        <div class="col-md-9">
                        	<select class="form-control" name="depart" id="depart">
                        		<option value="">请选择所属学院</option>
                        		<option value="信息学院">信息学院</option>
                        		<option value="经贸学院">经贸学院</option>
                        		<option value="金融学院">金融学院</option>
                        		<option value="英文学院">英文学院</option>
                        		<option value="中文学院">中文学院</option>
                        		<option value="会计学院">会计学院</option>
                        		<option value="政管学院">政管学院</option>
                        		<option value="法学院">法学院</option>
                        		<option value="艺术学院">艺术学院</option>
                        	</select>
                        </div>
                    </div>
                    <p id="departInfo" style="color:red;font-size:13px;text-align:center"></p>
                  	<div class="form-group">
                  		<span class="col-md-3">球队类型</span>
                        <div class="col-md-9">
                        	<select class="form-control" name="teamType" id="teamType">
                        		<option value="">请选择球队类型</option>
                        		<option value="class">班队</option>
                        		<option value="depart">院队</option>
                        		<option value="free">自由组队</option>
                        	</select>
                        </div>
                  	</div>
                  	<p id="typeInfo" style="color:red;font-size:13px;text-align:center"></p>
                  	<br />
                  	<div class="form-group">
                  		<div class="col-lg-2 col-md-2 "></div>                        
	                    <div class="col-lg-3 col-md-3 ">
	                    	<button type="submit" class="btn btn-primary ">注册</button> 
	                    </div>
	                    <div class="col-lg-2 col-md-2 "></div>
	                   	<div class="col-lg-3 col-md-3 ">
	                    	<a href="/graduation"><button id="register_login_btn" type="button" class="btn btn-primary">返回</button></a>
	                    </div>
	                    <div class="col-lg-2 col-md-2 "></div>
	                </div>
				</form>
			</div>
		</div>
	</div>
</body>
<script>
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
	$("#depart").blur(function() {
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
	});
})
function regist() {
	var userName=$("#userName").val();	
	var teamType=$("#teamType").val();
	var depart=$("#depart").val();
	var email=$("#email").val();
	var password=$("#password").val();
	var confirm=$("#confirm").val();
	if(teamType!=""&&depart!="") {
		$.ajax({
			url:"<%=request.getContextPath()%>/registrationCheck",
			type:"POST",
			dataType:"text",
			data:
				{
				'userName':userName,
				'password':password,
				'teamType':teamType,
				'email':email,
				'depart':depart,
				'confirm':confirm
				},
				success:function(data){
					var data = data.trim();
					if(data=="different") {
						$("#PassInfo").text("* 两次输入密码不同");
						return false;
					}
					else if(data=="active") {
						$("#userNameInfo").text("* 此用户名已经被注册,请换个用户名");
						return false;
					}
					else if(data=="notActive") {
						$("#userNameInfo").text("* 此用户名被注册但未激活，请查看邮件激活");
						return false;
					}
					else if(data=="success") {
						return true;
					}
					else {
						return false;
					}
				},
				error:function(){
					return false;
				}
		})
    }
    else if(depart=="") {
    	$("#departInfo").text("* 请选择球队学院");
    	return false;
    }
    else{
    	$("#typeInfo").text("* 请选择所属类型");
    	return false;
    }
}
</script>
</html>