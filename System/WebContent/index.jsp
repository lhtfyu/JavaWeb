<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>首页</title>
  
  	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" /> 
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    
    <script type="text/javascript">
    </script>
  </head>
 <body>
  <div align="center">
  	<p> 
		${loginuser.name},欢迎您	  
	 </p>
  	<a href="${pageContext.request.contextPath}/UserByPage" style="text-decoration:none;font-size:33px">
  	查询所有用户信息
	</a>
  </div>
 </body>
</html>