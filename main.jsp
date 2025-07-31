<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model2.User" %>
<%
User loginUser = (User)session.getAttribute("loginUser");

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<p>

<%=loginUser.getName() %>さん、ログイン中
</p>
</body>
</html>