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
<h1>どこつぶへログイン</h1>

<% if (loginUser != null) { %>
	<p>ログインに成功しました。</p>
	
	<p>ようこそ<%= loginUser.getName() %></p>
	<a href="Main">つぶやき投稿・閲覧へ</a>
	
<% } else { %>
	<p>ログインに失敗しました。</p>
	<a href="index.jsp">トップへ</a>

<% } %>
</body>
</html>