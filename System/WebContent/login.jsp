<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>管理员登录</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" /> 
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    
    <script type="text/javascript">
    window.onload=function(){
    	var imgcode= document.getElementById("vcode");
    	imgcode.onclick=function(){
    		var date=new Date().getTime();
    		imgcode.src="/System/Code?"+date;
    	}
    }
    </script>
    <script>
        
        $(function () {
          
           $("#verifycode").blur(function () {
              
               var username = $(this).val();            
               $.get("CheckcodeServlet",{username:username},function (data) {
            	   
                   var span = $("#show");
                   if(data.userExsit){
                       //用户名存在
                       span.css("color","green");
                       span.html(data.msg);
                       $("#btn").attr("disabled", false);
                   }else{
                       //用户名不存在
                       span.css("color","red");
                       span.html(data.msg);
                       $("#btn").attr("disabled", true);
                   }
               });

           }); 
        });

    </script>
   
  </head>
  <body>
  	<div class="container" style="width: 400px;">
  		<h3 style="text-align: center;">管理员登录</h3>
        <form action="Login" method="post">
	      <div class="form-group">
	        <label for="user">用户名：</label>
	        <input type="text" name="user" class="form-control" id="user" placeholder="请输入用户名"/>
	      </div>
	      
	      <div class="form-group">
	        <label for="password">密码：</label>
	        <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
	      </div>
	      
	      <div class="form-inline">
	        <label for="vcode">验证码：</label>
	        <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码" style="width: 120px;"/>
	        <a href="javascript:refreshCode()"><img src="${pageContext.request.contextPath}/Code" title="看不清点击刷新" id="vcode"/></a>
	        <span id="show"></span>
	      </div>
	      <hr/>
	      <div class="form-group" style="text-align: center;">
	        <input class="btn btn btn-primary" type="submit" id="btn" value="登录">
		  </div>
	  	</form>
		
		<!-- 出错显示的信息框 -->
	  	<div class="alert alert-warning alert-dismissible" role="alert">
		  <button type="button" class="close" data-dismiss="alert" >
		  	<span>&times;</span>
		  </button>
		   <strong> 
		   ${requestScope.user_error}
		   ${requestScope.mima_error}
		   ${requestScope.yz_error}
		   ${requestScope.login_error}			 
		   </strong>
		</div>
  	</div>
  </body>
 
</html>