<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>修改密码</title>
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
</head>
<body class="light-gray-bg">
	<br />
	<br />
	<br />
	<br />
	<div class="templatemo-content-widget templatemo-login-widget white-bg" style="padding:0px">
		<div class="panel panel-info">
			<div class="panel-headding" style="background:#428bca;height:46px;line-height:46px;text-align:center">
				<h1><strong>修改密码</strong></h1>
			</div>
			<div class="panel-body">
				<form role="form" id="Form" method="post" action="changePasswordDo" class="form-horizontal">
					<div class="form-group">
						<span class="col-md-3">球队名称</span>
						<div class="col-md-9">
							<input class="form-control" type="text" name="userName" id="userName" required="required" placeholder="球队名称" />
						</div>
					</div>
					<p id="userNameInfo" style="color:red;font-size:13px;text-align:center"></p>
					<div class="form-group">
						<span class="col-md-3">原密码</span>
						<div class="col-md-9">	
							<input class="form-control" type="text" name="oldPass" id="oldPass" required="required" placeholder="原密码" />
						</div>
					</div>
					<p id="oldPassInfo" style="color:red;font-size:13px;text-align:center"></p>
					<div class="form-group">
						<span class="col-md-3">新密码</span>
						<div class="col-md-9">	
							<input class="form-control" type="text" name="newPass" id="newPass" required="required" placeholder="新密码" />
						</div>
					</div>
					<p id="newPassInfo" style="color:red;font-size:13px;text-align:center"></p>
					<div class="form-group">
						<span class="col-md-3">确认密码</span>
						<div class="col-md-9">	
							<input class="form-control" type="text" name="confirmPass" id="confirmPass" required="required" placeholder="确认密码" />
						</div>
					</div>
					<p id="confirmPassInfo" style="color:red;font-size:13px;text-align:center"></p>
					<br />
					<div class="form-group">
						<div class="col-lg-2 col-md-2 "></div>                        
	                    <div class="col-lg-3 col-md-3 ">
	                    	<button type="submit" class="btn btn-primary">修改</button> 
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
</html>