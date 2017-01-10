<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>球员管理</title>
	<link href="static/css/font-face.css" rel="stylesheet">
	<link href="static/css/font-awesome.min.css" rel="stylesheet">
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/templatemo-style.css" rel="stylesheet">
    <script type="text/javascript" src="static/js/jquery-1.11.2.min.js"></script> 
	<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="static/js/templatemo-script.js"></script>
    <style>
    	td {
    		min-width:90px;
    	}
    </style>
</head>
<body>
	<div class="templatemo-flex-row">
		<div class="templatemo-sidebar">
			<header class="templatemo-site-header">
				<div class="square"></div>
				<h1>球员管理</h1>
			</header>
			<div class="profile-photo-container">
				<img src="static/images/logo.jpg" alt="Profile Photo" class="img-responsive"> 
			</div>
			<div class="mobile-menu-icon">
				<i class="fa fa-bars"></i>
        	</div>
        	<nav class="templatemo-left-nav">
        		<ul>
					<li><a href="tomainpage"><i class="fa fa-home fa-fw"></i>球队主页</a></li>
					<li><a href="toPlayerManage" class="active"><i class="fa fa-bar-chart fa-fw"></i>球员管理</a></li>
					<li><a href=""><i class="fa fa-database fa-fw"></i></a></li>
					<li><a href=""><i class="fa fa-map-marker fa-fw"></i></a></li>
        		</ul>
        	</nav>
		</div>
		<div class="templatemo-content col-1 light-gray-bg">
			<div class="templatemo-top-nav-container">
				<div class="row">
					<div class="col-lg-2 col-md-2"></div>
					<nav class="templatemo-top-nav col-lg-8 col-md-8">
						<ul class="text-uppercase">
							<li><a href="tomainpage">回到主页</a></li>
							<li><a href="toLogout">退出登录</a></li>
							<li><a href="#">当前用户：${userName}</a></li>
						</ul>
					</nav>
					<div class="col-lg-2 col-md-2"></div>
				</div>
			</div>
			<div class="templatemo-content-container">
				<div class="panel-heading">
					<h2 class="text-uppercase" style="text-align:center">
						<strong>本队球员一览</strong>
					</h2>
				</div>
				
				<div class="templatemo-content-widget no-padding">
					<div class="panel panel-default table-responsive">
						<table class="table table-striped table-bordered templatemo-user-table">
							<thead>
								<tr>
									<th>号码</th>
									<th>学号</th>
									<th>姓名</th>
									<th>年级</th>
									<th>学院</th>
									<th>位置</th>
									<th>角色</th>
									<th>修改</th>
									<th>移除</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="x" items="${playerList}">
									<tr>
										<td>${x.number}</td>
										<td>${x.id}</td>
										<td>${x.name}</td>
										<td>${x.grade}</td>
										<td>${x.depart}</td>
										<td>${x.position}</td>
										<td>${x.role}</td>
										<form method="post" action="">
											<input type="hidden" value=${x.id} name="id">
											<td><button class="btn btn-success">修改</button></td>
										</form>
										<form method="post" action="">
											<input type="hidden" value=${x.id} name="id">
											<td><button class="btn btn-success">移除</button></td>
										</form>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>