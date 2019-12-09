<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>bookStore注册页面</title>
<%--导入css --%>
<link rel="stylesheet" href="css/main.css" type="text/css" />
<script src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	function changeImage() {

		document.getElementById("img").src = "${pageContext.request.contextPath}/VerificationCodeServlet?time="
				+ new Date().getTime();
	}
	 function check(form) {
             document.myform.submit();
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
           
           $("#repassword").blur(function () {
        	   var repassword= $(this).val();
        	   var password = $("#password");
        	   var span = $("#mima");
        	   if(repassword!=password.val()){
        		   span.css("color","red");
                   span.html("密码不一致");
        	   }else{
        		   span.css("color","green");
                   span.html("密码一致");
        	   }
           });
           
           $("#email").blur(function () {
        	   var email= $(this).val();
        	   var span = $("#em");
        	  if(!email.match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)){
        		  span.css("color","red");
                  span.html("邮箱格式错误");
        	  }else{
        		  span.css("color","green");
                  span.html("邮箱格式正确");
        	  }
           });
           
           $("#phone").blur(function () {
        	   var email= $(this).val();
        	   var span = $("#ph");
        	  if(!email.match(/^1[34578]\d{9}$/)){
        		  span.css("color","red");
                  span.html("手机号码错误");
        	  }else{
        		  span.css("color","green");
                  span.html("手机号码正确");
        	  }
           });
           
           $("#password").blur(function () {
        	   var password= $(this);
        	   var span = $("#mi");
        	  if(password.val().length<6){
        		  span.css("color","red");
                  span.html("密码设置至少6位");
        	  }else{
        		  span.html(""); 
        	  }
           });
           
           $("#username").blur(function () {
        	   var username= $(this);
        	   var span = $("#un");
        	  if(username.val().length<6){
        		  span.css("color","red");
                  span.html("会员名设置至少6位");
        	  }else{
        		  span.html(""); 
        	  }
           });
           
        });

    </script>
</head>


<body class="main">
	<%@include file="head.jsp"%>
	<%--导入头 --%>
	<%@include file="menu_search.jsp"%><%--导入导航条与搜索 --%>

	<div id="divcontent">
		<form action="${pageContext.request.contextPath}/UserServlet?method=register"
			method="post">
			<table width="850px" border="0" cellspacing="0">
				<tr>
					<td style="padding:30px">
						<h1>新会员注册</h1>
						
						<table width="70%" border="0" cellspacing="2" class="upline">
							<tr>
								<td style="text-align:right; width:20%">会员邮箱：</td>
								<td style="width:40%">
								<input type="text" class="textinput"
									name="email"  id="email"/></td>
								<td><font id="em"></font></td>
							</tr>
							<tr>
								<td style="text-align:right">会员名：</td>
								<td>
									<input type="text" class="textinput" name="username" id="username"/>
								</td>
								<td><font id="un"></font></td>
							</tr>
							<tr>
								<td style="text-align:right">密码：</td>
								<td><input type="password" class="textinput"
									name="password" id="password" /></td>
								<td><font id="mi"></font></td>
							</tr>
							<tr>
								<td style="text-align:right">重复密码：</td>
								<td><input type="password" class="textinput"
									name="repassword" id="repassword""/></td>
								<td>&nbsp;<span id="mima" id="remi"></span></td>
							</tr>
							<tr>
								<td style="text-align:right">性别：</td>
								<td colspan="2">&nbsp;&nbsp;<input type="radio"
									name="gender" value="男" checked="checked" /> 男
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"
									name="gender" value="女" /> 女</td>
							</tr>
							<tr>
								<td style="text-align:right">联系电话：</td>
								<td colspan="2"><input type="text" class="textinput"
									style="width:350px" name="telephone" id="phone"/><font id="ph"></font>
								</td>
							</tr>
							<tr>
								<td style="text-align:right">个人介绍：</td>
								<td colspan="2"><textarea class="textarea" name="introduce"></textarea>
								</td>
							</tr>

						</table>



						<h1>注册校验</h1>
						<table width="80%" border="0" cellspacing="2" class="upline">
							<tr>
								<td style="text-align:right; width:20%">输入校验码：</td>
								<td style="width:50%"><input type="text" class="textinput" id="verifycode"/>
								<span id="show"></span>
								</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td style="text-align:right;width:20%;">&nbsp;</td>
								<td colspan="2" style="width:50%"><img
									src="${pageContext.request.contextPath}/VerificationCodeServlet" width="180"
									height="30" class="textinput" style="height:30px;" id="img" />&nbsp;&nbsp;
									<a href="javascript:void(0);" onclick="changeImage()">看不清换一张</a>
								</td>
							</tr>
						</table>



						<table width="70%" border="0" cellspacing="0">
							<tr>
								<td style="padding-top:20px; text-align:center"><input
									type="image" src="images/signup.gif" name="submit" id="btn" onclick="check(this.form)" border="0">
								</td>
							</tr>
						</table></td>
				</tr>
			</table>
		</form>
	</div>



	<div id="divfoot">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td rowspan="2" style="width:10%"><img
					src="images/bottomlogo.gif" width="195" height="50"
					style="margin-left:175px" /></td>
				<td style="padding-top:5px; padding-left:50px"><a href="#"><font
						color="#747556"><b>CONTACT US</b> </font> </a></td>
			</tr>
			<tr>
				<td style="padding-left:50px"><font color="#CCCCCC"><b>COPYRIGHT
							2008 &copy; eShop All Rights RESERVED.</b> </font></td>
			</tr>
		</table>
	</div>


</body>
</html>
