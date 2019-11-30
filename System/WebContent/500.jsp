<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%response.setStatus(HttpServletResponse.SC_OK);%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>500</title>
<style type="text/css">
	img{
		display: block;
	    margin: 0 auto;
    }
</style>
</head>
<body>
<a href="index.jsp">
	<img alt="404" src="<c:url value="/image/500.gif"></c:url>">
</a>
</body>
</html>
