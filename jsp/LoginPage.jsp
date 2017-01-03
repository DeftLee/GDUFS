<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Login</title>
<head>
	<script type="text/javascript" src="static/js/login.js"></script> 
	<script type="text/javascript" src="static/js/jquery-1.11.2.min.js"></script> 
	<script type="text/javascript" src="static/js/bootstrap.min.js"></script> 
	<link href="static/css/font-face.css" rel="stylesheet">
	<link href="static/css/font-awesome.min.css" rel="stylesheet">
	<link href="static/css/bootstrap.min.css" rel="stylesheet">
	<link href="static/css/templatemo-style.css" rel="stylesheet">
	<link href="static/css/login.css" rel="stylesheet">
</head>

<body class="light-gray-bg">
<section class="hero">
	<div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1">
                <div class="hero-content text-center">
                    <h1 style="font-size:60px">广外足球综合管理系统</h1>
                    <a href="#" class="btn btn-primary btn-lg btn-large btn-margin-right"  role="button" data-toggle="modal" data-target="#login-modal">登录</a> 
                    <a href="#" class="btn btn-primary btn-lg btn-large btn-margin-right">联系我们</a>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- BEGIN # MODAL LOGIN -->
<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display:none;">
    <div class=" modal-dialog">
		<div class="templatemo-content-widget templatemo-login-widget white-bg ">				
			<header class="text-center">
	          	<div class="square"></div>
	          	<h1>&nbsp;用户登录</h1>
	        </header>                
               <!-- Begin # DIV Form -->
               <div  class=" templatemo-login-form" >              
                   <!-- Begin # Login Form -->
                   <form  class="templatemo-login-form" method="post" onSubmit="return check()" >                      
						<p id="message" style="font-size:15px;color:red"> </p>	
			    		<div class="form-group">
                               <div class="input-group">
                                   <div class="input-group-addon"><i class="fa fa-user fa-fw"></i></div>                   
                                   <input  id="login_username" name="login_username" type="text" class="form-control" placeholder="用户名" required="required"> 
                                   <br>          
                                </div>  
			    		<br>
                           <div class="form-group">
                               <div class="input-group">
                                <div class="input-group-addon"><i class="fa fa-key fa-fw"></i></div>                    
                                   <input id="login_password" name="login_password" type="password" class="form-control" placeholder="密码"  required="required">                                          
                               </div>  
                           </div> 
                           <br>
                           <div class="form-group">
                               <div class="input-group">
                                <div class="input-group-addon"><i class="fa fa-users fa-fw"></i></div>                    
                                	<select class="form-control" name="select" id="userType">
                                		<option value="">请选择账号类型</option>
                                		<option value="1">主办方</option>
                                		<option value="2">球队</option>
                                	</select>
                               </div>  
                           </div>
			    		<div class="form-group">
                               <div class="checkbox squaredTwo">
                                   <input type="checkbox" id="c1" name="cc" />
                                   <label for="c1"><span></span>记住密码</label>
                                   <br>
                                   <br>
                               </div>                  
                           </div>              
                           <div class="form-group">
                               <button type="submit" class="templatemo-blue-button width-100"><span style="font-size:16px">登录</span></button>                                  
                                   <div>
                                       <a href=""><button id="login_lost_btn" type="button" class="col-lg-6 col-md-6 btn btn-link">忘记密码?</button></a>
                                       <a href="toRegistration"><button id="login_register_btn" type="button" class="col-lg-6 col-md-6 btn btn-link">注册</button></a>
                                   </div>
                           </div>                        
       		    	</div>
                   </form>
                   <!-- End # Login Form -->                 
         	</div>
        <!-- End # DIV Form -->            
		</div>
	</div>
</div>
    <!-- END # MODAL LOGIN -->
<script>
    function check(){
    	var userName=document.getElementById("login_username").value;
    	var password=document.getElementById("login_password").value;
    	var userType=document.getElementById("userType").value;
    	var message=document.getElementById("message");
	    if(userType!="") {
    		$.ajax({
				url:"<%=request.getContextPath()%>/login",
				type:"POST",
				dataType:"text",
				data:
					{
					'useruame':userName,
					'password':password,
					'userType':userType
					},
					success:function(data){
						//alert(data);
						if(data=="1"){
							window.location.href="tomainpage";
							return false;						
						}
						else if(data=="2") {
							$("#message").text("* 用户名或密码错误");
							return false;						
						}
						else if(data=="4") {
							$("#message").text("* 该账号未激活，请检查邮件激活账号");
							return false;
						} 
						else  {
							$("#message").text("* 系统错误");
						}
					},
					error:function(){
					}
			});
	    	return false;
	    }
	    else {
	    	$("#message").text("* 请选择账号类型");
	    	return false;
	    }
    }
</script>
</body>
</html>